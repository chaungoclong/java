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
#search_bar {
	width: 200px;
}
</style>
<body>
	<div class="row p-0 bg-faded wrapper">
		<jsp:include page="../components/sidebar.jsp"></jsp:include>
		<div class="col-10 right bg-faded py-2 pr-5">

			<div class="container d-flex align-items-center row m-0 mb-3">
				<div class="col-6 p-0 d-flex align-items-center">
					<h2 class="mr-2">search</h2>
					<input type="text" placeholder="ID, Name..." id="search_bar"
						class="form-control mr-2">
					<button class="btn btn-primary" id="btn_search">GO</button>
				</div>
				<div class="col-6 p-0 d-flex align-items-center justify-content-end">
					<a class="btn btn-success" href="/PROJECT_2/class/new">ADD</a>
				</div>
			</div>

			<div class="container">
				<table class="table">
					<thead class="thead-light">
						<tr>
							<th scope="col">ID</th>
							<th scope="col">NAME</th>
							<th scope="col">DELETE</th>
							<th scope="col">EDIT</th>
						</tr>
					</thead>
					<tbody id="list_class_content">
						<%-- <a:forEach items="${list_classroom}" var="o">
							<tr>
								<td>${o.class_id}</td>
								<td>${o.class_name}</td>
								<td><a class="btn btn-danger"
									href="/PROJECT_2/class/remove?id=${o.class_id}" onclick="return confirm('Are you sure?')">DELETE</a></td>
								<td><a class="btn btn-primary"
									href="/PROJECT_2/class/edit?id=${o.class_id}">EDIT</a></td>
							</tr>
						</a:forEach> --%>

					</tbody>
				</table>
			</div>

		</div>
	</div>
</body>

<script>
	$(function() {
		fetch();
		$(document).on("input", "#search_bar", function() {
			fetch();
		});
		
		$(document).on("click", "#btn_search", function() {
			fetch();
		});

	});

	function fetch() {
		let key_search = $('#search_bar').val();
		key_search = "%" + key_search + "%";
		let data = {key_search : key_search};
		let get = $.ajax({
			url : "/PROJECT_2/class/fetch",
			type : "post",
			dataType : "html",
			data : data
		});

		get.done(function(res) {
			console.log(res);
			$('#list_class_content').html(res);
		});
	}
</script>
</html>