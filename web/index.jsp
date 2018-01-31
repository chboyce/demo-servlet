<%--
  Created by IntelliJ IDEA.
  User: jiangqinglin
  Date: 2018/1/30
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hello</title>
</head>
<body>
hello world !
<UL>
    <LI>author: <%= firstName %> </li>
    <LI>mobile: <%= email %> </li>
</UL>
</body>
</html>

<%!
private String firstName, email;

    public void jspInit() {
        ServletConfig config = getServletConfig();
        firstName = config.getInitParameter("firstName");
        email = config.getInitParameter("email");
    }
%>
