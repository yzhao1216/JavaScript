<%--
  Created by IntelliJ IDEA.
  User: EYlee
  Date: 8/5/15
  Time: 6:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script src="js/jquery-1.4.3.js"></script>
    <script>
        //页面加载就执行
        $(function(){
            //找到连接，再绑定点击事件函数
            $('a.s1').click(f1);
        });
        function f1(){
            var flight = $(this).parent().siblings().eq(0).text();
            $(this).next().load('getPrice.do','flight='+flight);
        }
    </script>
</head>
<body>
    <table border="1" width="100%" cellpadding="0" cellspacing="0">
        <tr>
            <td>航班号</td>
            <td>机型</td>
            <td>经济舱票价</td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td>CA3910</td>
            <td><a href="#">747</a></td>
            <td>$3000</td>
            <td><a href="javascript:;" class="s1">查看票价</a>
            <div></div>
            </td>
        </tr>
        <tr>
            <td>HU3948</td>
            <td><a href="#">787</a></td>
            <td>$3000</td>
            <td><a href="javascript:;" class="s1">查看票价</a>
            <div></div>
            </td>
        </tr>
    </table>

</body>
</html>
