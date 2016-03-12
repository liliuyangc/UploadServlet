<%--
  Created by IntelliJ IDEA.
  User: liuyang
  Date: 2016/3/12
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<form method="post" action="upload" enctype="multipart/form-data">
  文件名：<input type="text" id="name" name="name"/><br/><br/>
选择文件：<input type="file" id="file" name="file"/><br/><br/>
<input type="submit" value="上传"/><br/>
</form>
</body>
</html>
