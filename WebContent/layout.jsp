<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  	<!--  scripts -->
	<script
	  src="https://code.jquery.com/jquery-3.4.1.min.js"
	  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
	  crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
	<script>
		(function($){
			$(function(){
				$('.sidenav').sidenav();
		  }); // end of document ready
		})(jQuery); // end of jQuery name space
	</script> 
</head>
<body>
<nav class="brown darken-4" role="navigation">
	<div class="nav-wrapper container">
		<a id="logo-container" href="home.do" class="brand-logo">
			<i class="large material-icons">free_breakfast</i>
			My Mug
		</a>
		<ul class="right hide-on-med-and-down">
			<li><a href="menu.do">Menus</a></li>
			<li><a href="event.do">Event</a></li>
			<li><a href="crew.do">Crews</a></li>
		</ul>
		<ul id="nav-mobile" class="sidenav">
			<li><a href="menu.do">Menus</a></li>
			<li><a href="event.do">Event</a></li>
			<li><a href="crew.do">Crews</a></li>
		</ul>
		<a href="#" data-target="nav-mobile" class="sidenav-trigger">
			<i class="material-icons">menu</i>
		</a>
	</div>
</nav>

<div class="container">
	<section class="section">
		<c:choose>
			<c:when test="${page != null }">
				<jsp:include page="${page}"/>
			</c:when>
			<c:otherwise>
				<jsp:include page="home.jsp"/>
			</c:otherwise>
		</c:choose>
	</section>
</div>
	        
</body>
</html>