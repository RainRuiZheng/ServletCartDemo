package com.myself.servlet; 

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 用户注销
 * @author Jungor
 *
 */
public class LogoutServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void service(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        // 设置编码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // 获取session
        HttpSession session = request.getSession();

        // 注销，让session失效，同时清除user和car在session中的对象
        session.invalidate();
        // 注销后，重定向到登录页面
        response.sendRedirect("login.html");
    }
}