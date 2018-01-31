<%--
  Created by IntelliJ IDEA.
  User: jiangqinglin
  Date: 2018/1/30
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<html>
<head>
    <title>更新</title>
</head>
<body>
<center>
    <font color=red size=72>学生管理页面</font>
    <hr>
    <form action="Update" method="post">
        <table border="1">
            <tr>
                <td>学生ID:</td>
                <td><input name="id" value="<%=request.getAttribute("id") %>" readonly></td>
            </tr>
            <tr>
                <td>学生姓名:</td>
                <td><input name="name" value="<%=request.getAttribute("name") %>"></td>
            </tr>
            <tr>
                <td>学生年龄:</td>
                <td><input type="text" name="age" value="<%=request.getAttribute("age") %>"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <center>
                        <input type="submit" value="提交"> <input type="reset" value="重置">
                    </center>
                </td>
            </tr>
        </table>
    </form>
    <a href="SearchList.jsp">查询</a></center>
</body>
</html>
