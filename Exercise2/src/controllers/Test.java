package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Database;
import models.Class;

//@WebServlet("/hello")
public class Test extends HttpServlet {
	public static final long serialVersionUID = 1L;

	public Test() {
		super();
	}

//	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PrintWriter a = response.getWriter();
		a.print("<h1>GET</h1>");
		a.print(request.getParameter("username"));
		a.print(request.getParameter("password"));
		a.print(request.getParameter("gender"));
//		hello(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//		PrintWriter a = response.getWriter();
//		a.print("<h1>POST</h1>");
//		a.print(request.getParameter("username"));
//		a.print(request.getParameter("password"));
		hello(request, response);
	}
	
	public void hello(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Database db = new Database("localhost", "3306", "student_java", "long", "tnt");
		ArrayList<Class> list = new ArrayList<Class>();
		ResultSet rs = db.query("select * from db_class", null);
		
		try {
			while(rs.next()) {
				list.add(new Class(rs.getInt(1), rs.getString(2)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("info.jsp").forward(request, response);
	}
}



