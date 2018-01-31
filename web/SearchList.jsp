<%--
  Created by IntelliJ IDEA.
  User: jiangqinglin
  Date: 2018/1/30
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<html>
<head>
    <title>学生记录</title>
</head>
<body>
<center>
    <font color=red size=72>学生信息如下:</font>
    <hr>
    <table border=1 bgColor="#ffffff" width="500px" height="100px">
        <tr>
            <td>ID</td>
            <td>姓名</td>
            <td>年龄</td>
            <td>
                <center>操作</center>
            </td>
        </tr>

        <jsp:useBean id="sBean" class="com.boyce.demo.servlet.dao.SqlFactory"/>
        <jsp:useBean id="jBean" class="com.boyce.demo.servlet.po.Student"/>
        <%
            java.util.List list = sBean.getSearch();
            for (java.util.Iterator it = list.iterator(); it.hasNext(); ) {
                //获取一个JavaBean对象
                jBean = (com.boyce.demo.servlet.po.Student) it.next();
        %>

        <tr>
            <td><%=jBean.getId() %>
            </td>
            <td><%=jBean.getName() %>
            </td>
            <td><%=jBean.getAge() %>
            </td>
            <td>
                <a href="Insert.jsp">增加</a>
                <a href="Delete?id=<%=jBean.getId()%>">删除</a>&nbsp;
                <a href="SearchById?id=<%=jBean.getId()%>">更新</a>
            </td>
        </tr>
        <% }%>
    </table>
</center>
</body>
</html>
