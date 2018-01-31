package com.boyce.demo.servlet.servlet;

import com.boyce.demo.servlet.dao.SqlFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 姜青林 on 2018/1/30 17:42
 */
@WebServlet(name = "Delete")
public class Delete extends HttpServlet {
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        //获取超链接传来的数据
        String sId = request.getParameter("id");
        int id = Integer.parseInt(sId);
        //调用模型层删除方法
        SqlFactory sBean = new SqlFactory();
        int count = sBean.getDelete(id);
        String url = "";
        if (count > 0) {
            url = "SearchList.jsp";
        } else {
            url = "error.jsp";
            request.setAttribute("error", "删除");
        }
        //转发
        request.getRequestDispatcher(url).forward(request, response);
    }
}
