package com.boyce.demo.servlet.dao;

import com.boyce.demo.servlet.po.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 姜青林 on 2018/1/30 15:03
 */
public class SqlFactory {

    Connection con;
    PreparedStatement pre;
    ResultSet rs;

    public SqlFactory() {
        try {
            //加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            String url = "jdbc:mysql://172.16.10.71:3306/irs_crm_card01";
            String username = "irs_crm_rw";
            String password = "kjkoh85UGJG36";
            //获得数据库链接
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据ID查询某一条记录
     */
    public Student getSearchById(int id) {
        Student student = new Student();
        try {
            String sql = "select * from student where id=? and deleted = 2";
            pre = con.prepareStatement(sql);
            pre.setInt(1, id);
            rs = pre.executeQuery();
            while (rs.next()) {
                student.setId(rs.getLong("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getByte("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭资源
                rs.close();
                pre.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return student;
    }

    /**
     * 插入新的一条记录
     */
    public int getInsert(Student jBean) {
        int count = 0;
        try {
            String sql = "insert into student(name, age) values(?, ?)";
            pre = con.prepareStatement(sql);
            pre.setString(1, jBean.getName());
            pre.setInt(2, jBean.getAge());
            count = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pre.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return count;
    }

    /**
     * 删除一条记录
     */
    public int getDelete(int id) {
        int count = 0;
        try {
            String sql = "update student set deleted = 1 where id=? and deleted = 2";
            pre = con.prepareStatement(sql);
            pre.setInt(1, id);
            count = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pre.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return count;
    }

    /**
     * 更新某一条记录
     */
    public int getUpdate(Student jBean) {
        int count = 0;
        try {
            String sql = "update student set name=?,age=? where id=? and deleted = 2";
            pre = con.prepareStatement(sql);
            pre.setLong(3, jBean.getId());
            pre.setString(1, jBean.getName());
            pre.setInt(2, jBean.getAge());
            count = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pre.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return count;
    }

    /**
     * 显示所有记录
     */
    public List<Student> getSearch() {
        List list = new ArrayList();
        try {
            String sql = "select * from student where deleted = 2 order by id";
            pre = con.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                Student jBean = new Student();
                jBean.setId(rs.getLong("id"));
                jBean.setName(rs.getString("name"));
                jBean.setAge(rs.getByte("age"));
                list.add(jBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pre.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

}
