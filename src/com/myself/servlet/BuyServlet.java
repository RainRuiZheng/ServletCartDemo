package com.myself.servlet; 

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myself.domain.Car;
import com.myself.domain.CarItem;
import com.myself.domain.User;

/**
 * 购买时需要的Servlet，可以将一个购物车项添加到购物车
 * @author Jungor
 *
 */
public class BuyServlet extends HttpServlet {

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
        // 获取打印流
        PrintWriter out = response.getWriter();

        // 获取货品名称
        String product = request.getParameter("product");

        Integer number = null;    // 数量
        try {
            // 接收到的是一个String，将其转换为Integer，如果转换失败，则向页面输出提示信息
            number = Integer.parseInt(request.getParameter("number"));
        } catch (NumberFormatException e) {
            out.println("数量非法，<a href='buy.html'>重新填写</a><br/>");
            return;
            //e.printStackTrace();
        }

        // 通过JSESSIONID,获取session对象，如果没有获取到，则新创建一个session对象
        HttpSession session = request.getSession();
        // 在session中获取user属性的对象
        User user = (User) session.getAttribute("user");
        // 在session中获取car属性的对象
        Car car = (Car) session.getAttribute("car");

        // 只有当用户已登录，且货品和数量不为空时，才允许添加项到购物车
        if (user != null && product != null && number != null) {

            CarItem carItem = new CarItem();    // 创建购物车项
            // UUID.randomUUID().toString()，一个随机且不重复的字符串，方便购物车项的查询
            carItem.setId(UUID.randomUUID().toString());
            carItem.setProduct(product);
            carItem.setNumber(number);

            // 如果购物车为空，则创建一个购物车，并添加到Session
            if (car == null) {
                car = new Car();
                session.setAttribute("car", car);
            }

            car.add(carItem);

            out.println("购买成功<br/>");
            out.println("<a href='buy.html'>继续购买</a><br/>");
            out.println("<a href='list'>管理列表</a><br/>");
        } else {
            out.println("<a href='Shopping/login.html'>请登录</a><br/>");
        }
    }

}