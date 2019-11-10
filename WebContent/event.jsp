<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
		<h5>Event</h5>
		<div id="result"></div>
		
		<script>
		$(document).ready(function(){
	
			$.ajax({
				url:'event.template',
				type:'get'
			}).done(function(data){
				$('#result').html(data);
			});
				
		});
		</script>