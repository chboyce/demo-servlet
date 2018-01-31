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
 * Created by 姜青林 on 2018/1/30 17:15
 */
@WebServlet(name = "SearchById")
public class SearchById extends HttpServlet {
    private static final long serialVersionUID = 4124398871829704221L;

    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //获取用户ID
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        SqlFactory sBean = new SqlFactory();
        Student jBean = sBean.getSearchById(id);
        //用户ID
        request.setAttribute("id", jBean.getId());
        //用户姓名
        request.setAttribute("name", jBean.getName());
        //用户年龄
        request.setAttribute("age", jBean.getAge());
        //转发
        request.getRequestDispatcher("Update.jsp").forward(request, response);
    }
}
