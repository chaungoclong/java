<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="css" fragment="true"%>
<%@ attribute name="content" fragment="true"%>
<%@ attribute name="js" fragment="true"%>

<!DOCTYPE html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Page Title</title>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<%@ include file="../blocks/head.jsp"%>
<!-- css invoke  -->
<jsp:invoke fragment="css" />
</head>
<body>
	<div class="container-fluid">
		<div class="row content">
			<%@ include file="../blocks/sidebar.jsp"%>

			<div class="col-sm-9">
				<!-- content invoke  -->
				<jsp:invoke fragment="content" />
			</div>
		</div>
	</div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<!-- js invoke  -->
	<jsp:invoke fragment="js" />
</body>
</html>