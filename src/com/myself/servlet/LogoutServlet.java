package com.myself.servlet; 

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * �û�ע��
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

        // ���ñ���
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // ��ȡsession
        HttpSession session = request.getSession();

        // ע������sessionʧЧ��ͬʱ���user��car��session�еĶ���
        session.invalidate();
        // ע�����ض��򵽵�¼ҳ��
        response.sendRedirect("login.html");
    }
}