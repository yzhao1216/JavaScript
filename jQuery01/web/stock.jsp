<%--
  Created by IntelliJ IDEA.
  User: EYlee
  Date: 8/3/15
  Time: 2:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <style>
        #d1 {
            width: 400px;
            height: 300px;
            background-color: aqua;

        }

        #d2 {
            color: brown;
            background-color: antiquewhite;
            height: 30px;
        }
    </style>

    <script src="js/jquery-1.4.3.js"></script>
    <script>
        $(function(){
            setInterval(quoto, 5000);
        });


        /*
         异步性服务器发送请求，服务器送回json字符创（描述股票信息）
         将json字符串转换成js数组，然后遍历该数组，更新表格
         */
        function quoto() {
            $.post('getStock.do',function(data){
                //function(data)是回调函数
                //如果返回的是json字符串，该函数会自动将json字符串转换成js对象。js数组
                $('#tb1').empty();
                for(var i = 0;i<data.length;i++){
                    var s = data[i];
                    $('#tb1').append('<tr><td>'+ s.code+'</td><td>'+ s.name+'</td><td>'+ s.price+'</td></tr>');
                }
            },'json');
        }


    </script>
</head>
<body >
<div id="d1">
    <div id="d2">股票行情</div>
    <div id="d3">
        <table width="100%">
            <thead>
            <tr>
                <td>代码</td>
                <td>名称</td>
                <td>报价</td>
            </tr>
            </thead>
            <tbody id="tb1">


            </tbody>
        </table>
    </div>


</div>

</body>
</html>
