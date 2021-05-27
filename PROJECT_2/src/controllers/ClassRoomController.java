package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DBConnection;
import entities.ClassRoom;
import helpers.Validate;
import serviceInterface.ClassRoomManager;
import services.ClassRoomService;

/**
 * Servlet implementation class ClassController
 */

public class ClassRoomController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DBConnection dbConnection;
	private ClassRoomManager classRoomManager;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClassRoomController() {
		super();
		this.dbConnection = DBConnection.getInstance();
		this.classRoomManager = new ClassRoomService(dbConnection);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");

		String url = request.getPathInfo();
		url = url == null ? "/list" : url;

		try {
			switch (url) {
			case "/new":
				this.showAddForm(request, response);
				break;

			case "/add":
				this.addClassRoom(request, response);
				break;

			case "/edit":
				this.showFormUpdate(request, response);
				break;

			case "/update":
				this.updateClassRoom(request, response);
				break;

			case "/remove":
				this.deleteClassRoom(request, response);
				break;

			case "/fetch":
				PrintWriter o = response.getWriter();
				this.fetch(request, response);
				break;

			default:
				this.listClassRoom(request, response);
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
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

	// show list of classroom
	protected void listClassRoom(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		List<ClassRoom> list = this.classRoomManager.getAllClassRoom();
		request.setAttribute("list_classroom", list);
		request.getRequestDispatcher("/classroom/index.jsp").forward(request, response);
	}

	// show add form
	protected void showAddForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		request.getRequestDispatcher("/classroom/new.jsp").forward(request, response);
	}

	// add classroom
	private void addClassRoom(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		String classId = request.getParameter("classId");
		String className = request.getParameter("className");

		// validate
		if (Validate.isEmptyString(className) || Validate.isEmptyString(classId)) {

			// if missing data show error
			response.sendRedirect("/PROJECT_2/class/new?err=miss data");
		} else {
			ClassRoom newClass = new ClassRoom(classId, className);
			if (this.classRoomManager.classRoomIsExist(newClass)) {

				// if classroom is already exist show error
				response.sendRedirect("/PROJECT_2/class/new?err=Classroom already exist");
			} else {

				// if add success go to list page
				this.classRoomManager.addClassRoom(newClass);
				response.sendRedirect("/PROJECT_2/class/");
			}
		}
	}

	// show form update classroom
	protected void showFormUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		String classId = request.getParameter("id");

		if (Validate.isEmptyString(classId)) {
			request.setAttribute("error", "not found classroom");
		} else {
			ClassRoom classRoom = this.classRoomManager.getClassRoomById(classId);
			request.setAttribute("classroom", classRoom);
		}

		request.getRequestDispatcher("/classroom/edit.jsp").forward(request, response);
		;
	}

	// update classroom
	protected void updateClassRoom(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		String classId = request.getParameter("classId");
		String className = request.getParameter("className");

		boolean okForUpdate = true;
		String error = "";

		if (Validate.isEmptyString(classId) || Validate.isEmptyString(className)) {
			okForUpdate = false;
			error += "+missing data\n";
		}

		ClassRoom classRoom = new ClassRoom(classId, className);
		if (!this.classRoomManager.checkForUpdate(classRoom)) {
			okForUpdate = false;
			error += "+classroom already exist\n";
		}

		if (okForUpdate) {
			this.classRoomManager.updateClassRoom(classRoom);
			response.sendRedirect("/PROJECT_2/class/");
		} else {
			response.sendRedirect("/PROJECT_2/class/edit?id=" + classId + "&err=" + error);
		}

	}

	// delete classroom
	protected void deleteClassRoom(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		String id = request.getParameter("id");

		if (!Validate.isEmptyString(id)) {
			this.classRoomManager.deleteClassRoom(id);
		}

		response.sendRedirect("/PROJECT_2/class/");
	}

	// fetch page
	protected void fetch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		String key = request.getParameter("key_search");
		key = (key == null) ? "%%" : key;
		List<ClassRoom> listClassRoom = this.classRoomManager.search(key);

		StringBuilder html = new StringBuilder("");

		for (ClassRoom i : listClassRoom) {
			html.append("<tr>");
			html.append("<td>" + i.getClass_id() + "</td>");
			html.append("<td>" + i.getClass_name() + "</td>");
//			<td><a class="btn btn-danger"
//					href="/PROJECT_2/class/remove?id=${o.class_id}" onclick="return confirm('Are you sure?')">DELETE</a></td>
//				<td><a class="btn btn-primary"
//					href="/PROJECT_2/class/edit?id=${o.class_id}">EDIT</a></td>
			html.append("<td>");
			html.append("<a class=\"btn btn-danger\" href=\"/PROJECT_2/class/remove?id=" + i.getClass_id() + "\""
					+ "onclick=\"return confirm('Are you sure?')\">DELETE");
			html.append("</a>");
			html.append("</td>");

			html.append("<td>");
			html.append("<a class=\"btn btn-primary\" href=\"/PROJECT_2/class/edit?id=" + i.getClass_id() + "\">EDIT");
			html.append("</a>");
			html.append("</td>");
			html.append("</tr>");
		}

		PrintWriter o = response.getWriter();
		o.print(html);
	}

}
