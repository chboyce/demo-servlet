<%--
  Created by IntelliJ IDEA.
  User: jiangqinglin
  Date: 2018/1/30
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName() +":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>出错啦!!!</title>
</head>
<body>
对不起!您<%=request.getAttribute("error") %>失败
</body>
</html>
