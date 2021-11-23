package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Doctor;
import model.Exam;
import service.impl.DoctorService;
import util.ServletUtil;

/**
 * Servlet implementation class DoctorController
 */
@WebServlet("/DoctorController")
public class DoctorController extends HttpServlet implements IBaseController {
	private static final long serialVersionUID = 1L;
	private static final DoctorService doctorService = new DoctorService();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoctorController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.processRequest(request, response);
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

	@Override
	public void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String servletPath = request.getServletPath();

		switch (servletPath) {
		case "/doctor":
			this.index(request, response);
			break;

		default:
			break;
		}

	}

	@Override
	public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Doctor> listDoctors;
		
		if (request.getParameter("min") != null && request.getParameter("max") != null) {
			int min = Integer.parseInt(request.getParameter("min"));
			int max = Integer.parseInt(request.getParameter("max"));
			
			listDoctors = doctorService.select("where age >= ? AND age <= ?", min, max);
		} else {
			listDoctors = doctorService.all();
		}
		
		request.setAttribute("listDoctors", listDoctors);
		ServletUtil.view("index.jsp", request, response);
	}

	@Override
	public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
