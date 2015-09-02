package web;

import bean.Stock;
import net.sf.json.JSONArray;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by EYlee on 8/5/15.
 */
@WebServlet(name = "ActionServlet")
public class ActionServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String uri = request.getRequestURI();
        String action = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
        if (action.equals("/getPrice")) {
            String flight = request.getParameter("flight");
            if ("CA3910".equals(flight)) {
                out.println("头等舱：￥3200<br>商务舱：￥4004");
            } else if ("HU3948".equals(flight)) {
                out.println("头等舱：￥1200<br>商务舱：￥5004");
            }
        } else if (action.equals("/getStock")) {
            List<Stock> stocks = new ArrayList<Stock>();
            Random r = new Random();

            for (int i = 0; i < 8; i++) {
                Stock s = new Stock();
                s.setCode("60003" + r.nextInt(10));
                s.setName("山东" + r.nextInt(10));
                s.setPrice(getPrice(r));
                stocks.add(s);

            }
            //fromObjec 也可以传数组
            JSONArray array = JSONArray.fromObject(stocks);
            String str = array.toString();
            out.println(str);
        }else if(action.equals("/fileprocess")){
//            String name = request.getParameter("username");
//            System.out.println(name);
            //stepq 创建一个Disk对象，用来为解析器提供解析时的缺省的配置
            DiskFileItemFactory dfif = new DiskFileItemFactory();
            //2 创建解析器
            ServletFileUpload sfu = new ServletFileUpload(dfif);
            //3使用解析器解析
            try {
                /*
                解析器会将解析之后的结果封装到FileItem对象里面（一个表单域对应一个FileItem对象）
                 */
                List<FileItem> items = sfu.parseRequest(request);
                for (int i = 0; i < items.size(); i++) {
                    FileItem item = items.get(i);
                    if(item.isFormField()){
                        //普通表单域
                        String name = item.getFieldName();
                        String value = item.getString();
                        System.out.println(name+":"+value);
                    }else {
                        //上传文件域

                        ServletContext sctx = getServletContext();
                        //getRealPath 依据逻辑路径获得实际部署时的物理路径
                        String path = sctx.getRealPath("upload");
//                        System.out.println(path);
                        //获得上传文件的名称
                        String fileName = item.getName();
                        File file = new File(path+File.separator+fileName);
                        item.write(file);

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        out.close();
    }
    private double getPrice(Random r) {

        double price = 0;
        BigDecimal b = new BigDecimal(r.nextDouble() * 100);
        price = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return price;
    }



}
