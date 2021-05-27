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
		<jsp:include page="/components/sidebar.jsp"></jsp:include>
		<div class="col-10 right bg-faded py-2 pr-5">
			<h1>
				<%
					String hello = (String) request.getAttribute("hello");
					if (hello != null) {
						out.print(hello);
					} else {
						out.print("not found");
					}
				%>
			</h1>
		</div>
	</div>
</body>
</html>