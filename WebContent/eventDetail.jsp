<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty requestScope.list }">
	<ul>
	<c:forEach var="event" items="${requestScope.list }">
		<li>
		${event.name }<br>${event.description }<br>
		<img src="img/${event.imagePath }">
		</li>
	</c:forEach>
	</ul>
</c:if>
