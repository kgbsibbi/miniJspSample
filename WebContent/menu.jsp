<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

		<h5>Menus</h5>
		<c:if test="${not empty requestScope.menus }">
			<ul>
			<c:forEach var="menu" items="${requestScope.menus }">
				<li>${menu.name } (${menu.ingredients }): ${menu.price } KRW</li>
			</c:forEach>
			</ul>
		</c:if>
