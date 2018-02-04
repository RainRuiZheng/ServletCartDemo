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
 * �û���¼������¼��Ϣ��װ��һ��User���󣬲���ӵ�Session
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

        // ���ñ���
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        // ��ȡ�����
        PrintWriter out = response.getWriter();

        // ���յ��Ĳ���
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // ��ȡsession�����ʹ��JSESSIONIDû���ҵ��򴴽�һ��
        HttpSession session = request.getSession();
        // ��ȡsession��������Ϊuser�Ķ���
        User user = (User) session.getAttribute("user");

        // ���user����Ϊ�գ��û��������벻Ϊ�գ��򽫵�¼��Ϣ��װΪһ��User���󣬲������session��
        if (user == null 
                && username != null && !"".equals(username)
                && password != null &&!"".equals(password)) {

            // ��username��password��װ��һ��User����
            user = new User();
            user.setPassword(password);
            user.setUsername(username);

            // ��������ӵ�session��
            session.setAttribute("user", user);

            out.println("��ӭ������<b>" + user.getUsername() + "</b> <a href='logout'>ע��</a><br/>");
            out.println("<a href='buy.html'>����</a><br/>");
            out.println("<a href='list'>������</a>");

        } else if (user != null && username == null && password == null) {
            //��user����Ϊ�գ���username��passwordΪ�գ�ֱ�Ӷ�ȡsession��user����

            out.println("��ӭ������<b>" + user.getUsername() + "</b> <a href='logout'>ע��</a><br/>");
            out.println("<a href='buy.html'>����</a><br/>");
            out.println("<a href='list'>������</a>");


        }else {

            // ��ǰ������������ʱ����ҳ�������ʾ��Ϣ
            out.println("<a href='/login.html'>���µ�¼</a>");
        }

    }

}