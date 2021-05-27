<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>
	<%
	/* String title = (String) request.getAttribute("title");
	out.print(title); */
	%>
</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/PROJECT_2/assets/css/style.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="/PROJECT_2/assets/js/common.js"></script>
</head>
<style>
</style>
<body>
	
	<div class="row p-0 bg-faded wrapper">
		<jsp:include page="../components/sidebar.jsp"></jsp:include>
		<div class="col-10 right bg-faded py-2 pr-5">

			<h1>
				<%
					String err = (String) request.getParameter("err");
					if(err != null) {
						out.print(err);
					}
				%>
			</h1>
			<form action="add" method="post">
				<div class="form-group">
					<label for="classId">Class ID</label> <input type="text"
						class="form-control" id="classId" placeholder="Enter Class ID"
						name="classId">
				</div>

				<div class="form-group">
					<label for="className">Class Name</label> <input type="text"
						class="form-control" id="className" placeholder="Enter Class Name"
						name="className">
				</div>

				<button type="submit" class="btn btn-primary">Add</button>
			</form>

		</div>
	</div>
</body>
</html>