package com.myself.servlet; 

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myself.domain.Car;
import com.myself.domain.User;

/**
 * 删除购物加中的购物车项
 * @author Jungor
 *
 */
public class DeleteServlet extends HttpServlet {

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
        // 获取session中属性名为user的对象
        User user = (User) session.getAttribute("user");
        // 获取session中属性名为car的对象
        Car car = (Car) session.getAttribute("car");

        // 接收需要删除的购物车项的id
        String id = request.getParameter("id");

        // 如果用户已登录，则向下执行，否则向页面输出提示信息
        if (user != null) {
            // 当car对象存在时，才从此购物车中删除购物车项，且转入的id也不为空
            if (car != null && id != null && !"".equals(id)) {
                car.remove(id);

                out.println("删除成功<br/>");
                out.println("<a href='buy.html'>继续购买</a><br/>");
                out.println("<a href='list'>管理列表</a><br/>");
            } else {
                out.println("也还没车车...");
            }
        } else {
            out.println("还没登录，禁止操作。<a href='login.html'>返回登录</a>");
        }
    }

}