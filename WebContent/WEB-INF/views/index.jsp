<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

	<%@ taglib tagdir="/WEB-INF/tags" prefix="m"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<m:layout>
		<jsp:attribute name="content">
			<div>
				<form action='<c:url value="/doctor"></c:url>' method="get">
					FROM:<input type="number" name="min" required> TO:<input type="number" name="max" required><button>SEARCH</button>
				</form>
			</div>
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>ID</th>
						<th>NAME</th>
						<th>AGE</th>
					    <th>ADDRESS</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${listDoctors.size() != 0}">
							<c:forEach items="${listDoctors}" var="doctor">
								<tr>
									<td>${doctor.id}</td>
									<td>${doctor.name}</td>
									<td>${doctor.age}</td>
									<td>${doctor.address}</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td>EMPTY</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</jsp:attribute>
	</m:layout>