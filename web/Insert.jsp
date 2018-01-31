<%--
  Created by IntelliJ IDEA.
  User: jiangqinglin
  Date: 2018/1/30
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>插入新值</title>
</head>

<center>
    <font color=red size=72>学生管理页面</font>
    <hr>
    <form action="Insert" method="post">
        <table border="1">
            <tr>
                <td>姓名:</td>
                <td><input name="name"></td>
            </tr>
            <tr>
                <td>年龄:</td>
                <td><input type="text" name="age"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <center>
                        <input type="submit" value="提交">
                        <input type="reset" value="重置">
                    </center>
                </td>
            </tr>
        </table>
    </form>
    <a href="SearchList.jsp">查询</a></center>
<body>

</body>
</html>
