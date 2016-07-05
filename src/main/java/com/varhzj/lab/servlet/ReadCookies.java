package com.varhzj.lab.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ReadCookies extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie cookie = null;
		Cookie[] cookies = null;
		// 获取与该域相关的 Cookies 的数组
		cookies = req.getCookies();
		HttpSession session = req.getSession();

		// 设置响应内容类型
		resp.setContentType("text/html;charset=UTF-8");

		PrintWriter out = resp.getWriter();
		String title = "Reading Cookies Example";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		out.println(
				docType + "<html>\n" + "<head><title>" + title + "</title></head>\n" + "<body bgcolor=\"#f0f0f0\">\n");
		if (cookies != null) {
			out.println("<h2>查找 Cookies 名称和值</h2>");
			for (int i = 0; i < cookies.length; i++) {
				cookie = cookies[i];
				out.print("名称：" + cookie.getName() + "，");
				out.print("值：" + cookie.getValue() + " <br/>");
			}
		} else {
			out.println("<h2>未找到 Cookies</h2>");
		}
		out.println(session.getAttribute("user_id"));
		out.println("</body>");
		out.println("</html>");
	}
}
