package com.myself.servlet; 

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myself.domain.User;

/**
 * 用户登录，将登录信息封装成一个User对象，并添加到Session
 * @author Jungor
 *
 */
public class LoginServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 设置编码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        // 获取输出流
        PrintWriter out = response.getWriter();

        // 接收到的参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 获取session，如果使用JSESSIONID没有找到则创建一个
        HttpSession session = request.getSession();
        // 获取session中属性名为user的对象
        User user = (User) session.getAttribute("user");

        // 如果user对象为空，用户名和密码不为空，则将登录信息封装为一个User对象，并添加至session中
        if (user == null 
                && username != null && !"".equals(username)
                && password != null &&!"".equals(password)) {

            // 将username和password封装成一个User对象
            user = new User();
            user.setPassword(password);
            user.setUsername(username);

            // 将对象添加到session中
            session.setAttribute("user", user);

            out.println("欢迎回来：<b>" + user.getUsername() + "</b> <a href='logout'>注销</a><br/>");
            out.println("<a href='buy.html'>购物</a><br/>");
            out.println("<a href='list'>管理购物</a>");

        } else if (user != null && username == null && password == null) {
            //当user对象不为空，但username和password为空，直接读取session中user对象

            out.println("欢迎回来：<b>" + user.getUsername() + "</b> <a href='logout'>注销</a><br/>");
            out.println("<a href='buy.html'>购物</a><br/>");
            out.println("<a href='list'>管理购物</a>");


        }else {

            // 当前面条件不满足时，向页面输出提示信息
            out.println("<a href='/login.html'>重新登录</a>");
        }

    }

}