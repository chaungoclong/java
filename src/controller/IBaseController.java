package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IBaseController {
	public void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;

	public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	public void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	public void destroy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
