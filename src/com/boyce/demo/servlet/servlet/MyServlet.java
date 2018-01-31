package com.boyce.demo.servlet.servlet;

import com.boyce.demo.servlet.dao.SqlFactory;
import com.boyce.demo.servlet.po.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 姜青林 on 2018/1/30 10:25
 */
@WebServlet(name = "MyServlet")
public class MyServlet extends HttpServlet {

    private static final long serialVersionUID = -7975789817540800816L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("----- MyServlet.doPost -----");
        //====================== 设置请求头参数 ======================
        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        //====================== 查询数据库 ======================
        String sid = request.getParameter("id");//获取用户ID
        int id = Integer.parseInt(sid);
        SqlFactory sqlFactory = new SqlFactory();
        Student student = sqlFactory.getSearchById(id);

        //====================== 传值给JSP ======================
        request.setAttribute("id", student.getId());//用户ID
        request.setAttribute("name", student.getName());//用户姓名
        request.setAttribute("age", student.getAge());//用户年龄

        //====================== 转发 ======================
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("----- MyServlet.doGet -----");
        doPost(request, response);
    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("----- MyServlet.doDelete -----");
    }
}
