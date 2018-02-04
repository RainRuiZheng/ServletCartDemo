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
 * 用于显示购物车里面的内容
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

        // 设置编码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        // 获取输出流
        PrintWriter out = response.getWriter();

        // 获取session，如果使用JSESSIONID没有找到则创建一个
        HttpSession session = request.getSession();
        // 获取session中属性名为car的对象
        Car car = (Car) session.getAttribute("car");
        // 获取session中属性名为user的对象
        User user = (User) session.getAttribute("user");

        // 如果user对象为空，则表示还没登录，要求用户登录后才能进行操作
        if (user == null) {
            out.println("还没登录。<a href='login.html'>请登录</a>");
            return;
        }

        out.println("<b>" + user.getUsername() + "</b> 的购物车<br/>");

        // 如果car对象为空，表示还没创建购物车，如果不为空，就表示有购物车，可以依次输出其内容
        if (car != null) {
            for (CarItem carItem : car.list()) {
                out.println("商品：" + carItem.getProduct() + " 数量：" + carItem.getNumber() + " <a href='/delete?id=" + carItem.getId() + "'>删除</a>");
                out.println("<hr>");
            }
        } else {
            out.println("还没购物车，所以没内容");
        }

    }

}