<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

		<h5>Crews</h5>
		<button id="getJson">Get List (Json)</button>
		<div id="result"></div>
		
		<script>
		$(document).ready(function(){
			$('#getJson').click(function(){
				$.ajax({
					url:'crewJson.api',
					type:'get'
				}).done(function(data){
					console.log(data)
					var len = data.length;
					var buffer = ['<ul>'];
					for(var i=0; i<len; i++) {
					  buffer.push( '<li>', data[i].name, '</li>' );
					}
					buffer.push( '</ul>' );
					$('#result').html(buffer.join(''));
				});
			});
		});
		</script>
	