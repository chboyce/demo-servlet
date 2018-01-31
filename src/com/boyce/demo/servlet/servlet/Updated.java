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
 * Created by 姜青林 on 2018/1/30 17:35
 */
@WebServlet(name = "Updated")
public class Updated extends HttpServlet {

    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //获得前台表单信息
        String sid = request.getParameter("id");
        Long id = Long.parseLong(sid);
        String name = request.getParameter("name");
        String sage = request.getParameter("age");
        Byte age = Byte.parseByte(sage);
        //封装到JavaBean对象中去
        Student jBean = new Student();
        jBean.setId(id);
        jBean.setName(name);
        jBean.setAge(age);
        SqlFactory sBean = new SqlFactory();
        int count = sBean.getUpdate(jBean);
        String url = "";
        if (count > 0) {
            url = "SearchList.jsp";
        }else {
            url ="error.jsp";
            request.setAttribute("error", "更新");
        }
        request.getRequestDispatcher(url).forward(request, response);
    }

}
