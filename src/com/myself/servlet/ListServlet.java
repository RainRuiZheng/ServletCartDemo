package com.myself.servlet; 

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myself.domain.Car;
import com.myself.domain.CarItem;
import com.myself.domain.User;

/**
 * ������ʾ���ﳵ���������
 * @author Jungor
 *
 */
public class ListServlet extends HttpServlet {

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

        // ��ȡsession�����ʹ��JSESSIONIDû���ҵ��򴴽�һ��
        HttpSession session = request.getSession();
        // ��ȡsession��������Ϊcar�Ķ���
        Car car = (Car) session.getAttribute("car");
        // ��ȡsession��������Ϊuser�Ķ���
        User user = (User) session.getAttribute("user");

        // ���user����Ϊ�գ����ʾ��û��¼��Ҫ���û���¼����ܽ��в���
        if (user == null) {
            out.println("��û��¼��<a href='login.html'>���¼</a>");
            return;
        }

        out.println("<b>" + user.getUsername() + "</b> �Ĺ��ﳵ<br/>");

        // ���car����Ϊ�գ���ʾ��û�������ﳵ�������Ϊ�գ��ͱ�ʾ�й��ﳵ�������������������
        if (car != null) {
            for (CarItem carItem : car.list()) {
                out.println("��Ʒ��" + carItem.getProduct() + " ������" + carItem.getNumber() + " <a href='/delete?id=" + carItem.getId() + "'>ɾ��</a>");
                out.println("<hr>");
            }
        } else {
            out.println("��û���ﳵ������û����");
        }

    }

}