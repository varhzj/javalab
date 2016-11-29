package com.varhzj.lab.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorld extends HttpServlet {

	private static final long serialVersionUID = -2696632155414690724L;

	private String message;

	@Override
	public void init() throws ServletException {
		super.init();
		message = "hello world";
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie firstName = new Cookie("first_name", "varhzj");
		Cookie lastName = new Cookie("last_name", "huang");

		resp.addCookie(firstName);
		resp.addCookie(lastName);

		resp.setContentType("text/html;charset=UTF-8");

		PrintWriter out = resp.getWriter();
		String title = "设置 Cookies 实例";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n"
				+ "<body bgcolor=\"#f0f0f0\">\n" + "<h1 align=\"center\">" + title + "</h1>\n" + "<ul>\n"
				+ "  <li><b>名字</b>：" + req.getParameter("first_name") + "\n</li>" + "  <li><b>姓氏</b>："
				+ req.getParameter("last_name") + "\n</li>" + "</ul>\n" + "</body>" + message + "</html>");
	}
}
