package com.varhzj.lab.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HelloForm extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie firstName = new Cookie("first_name", req.getParameter("first_name"));
		Cookie lastName = new Cookie("last_name", req.getParameter("last_name"));

		resp.addCookie(firstName);
		resp.addCookie(lastName);

		HttpSession session = req.getSession(true);
		session.setAttribute("user_id", "varhzj");

		resp.setContentType("text/html;charset=UTF-8");

		PrintWriter out = resp.getWriter();
		String title = "设置 Cookies 实例";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n"
				+ "<body bgcolor=\"#f0f0f0\">\n" + "<h1 align=\"center\">" + title + "</h1>\n" + "<ul>\n"
				+ "  <li><b>名字</b>：" + req.getParameter("first_name") + "\n</li>" + "  <li><b>姓氏</b>："
				+ req.getParameter("last_name") + "\n</li>" + "</ul>\n" + "</body></html>");
	}
}
