<%--
  Created by IntelliJ IDEA.
  User: EYlee
  Date: 8/5/15
  Time: 8:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <form action="fileprocess.do" method="post" enctype="multipart/form-data">
        username:<input name="username"><br>
        photo:<input type="file" name="file1"><br>
        <input type="submit" value="提交">

    </form>

</body>
</html>
