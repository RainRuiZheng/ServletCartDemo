package dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import util.DBHelper;

public class Json extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Json() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = null;

		// 设置响应内容类型
		// 设置响应内容类型
		response.setContentType("text/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		//ArrayList<Items> list = new ArrayList<Items>(); // 商品集合
		try {
			conn = DBHelper.getConnection();

			String sql = "select * from items;"; // SQL语句
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			JSONArray jsonarray = new JSONArray();
			JSONObject jsonobj = new JSONObject();
			JSONObject jsonobj1 = new JSONObject();
			// 展开结果集数据库
			while (rs.next()) {
				//Items item = new Items();
				jsonobj.put("GoodsId",rs.getInt("id"));
				jsonobj.put("GoodsName",rs.getString("name"));
				jsonobj.put("GoodsCity",rs.getString("city"));
				jsonobj.put("GoodsNum",rs.getInt("number"));
				jsonobj.put("GoodsPrice",rs.getInt("price"));
				jsonobj.put("GoodsPictur",rs.getString("picture"));
				jsonarray.add(jsonobj);
				//list.add(item);// 把一个商品加入集合
			}
			
			
			jsonobj1.put("goods", jsonarray);
			// 输出数据
			out = response.getWriter();

			out.println(jsonarray);
			// return list; // 返回集合。
		} catch (Exception ex) {
			ex.printStackTrace();
			// return null;
		} finally {
			// 释放数据集对象
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			// 释放语句对象
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}