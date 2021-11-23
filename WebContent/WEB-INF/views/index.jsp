<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

	<%@ taglib tagdir="/WEB-INF/tags" prefix="m"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<m:layout>
		<jsp:attribute name="content">
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>ID</th>
						<th>NAME</th>
						<th>ACTION</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${listExams.size() != 0}">
							<c:forEach items="${listExams}" var="exam">
								<tr>
									<td>${exam.id}</td>
									<td>${exam.name}</td>
									<td><a href='<c:url value="/exam/destroy?id=${exam.id}"/>' class="btn btn-danger">REMOVE</a></td>
								</tr>
							</c:forEach>
						</c:when>
					</c:choose>
				</tbody>
			</table>
		</jsp:attribute>
	</m:layout>