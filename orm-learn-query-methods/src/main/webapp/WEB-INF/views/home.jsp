<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Country Code</title>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
	<h1>${welcome }</h1>
	<h3>Search By Country Name Pattern</h3>
	<input type="text" id="countryNamePattern">
	<div id="result"></div>
	<h3>Search By Country Name Starts With</h3>
	<input type="text" id="countryNameStartsWith">
	<div id="result1"></div>
	<script type="text/javascript">
	$(document).ready(function(){
		
		$("#countryNamePattern").on('input',function(){
			if($("#countryNamePattern").val()=="")
			{
			$("#result").text("");
			}
			else{
			$.ajax({
				url: "/getcountry",
				data:{pattern: $("#countryNamePattern").val()},
				success: function(responseText){
					$("#result").html(responseText);
					if(responseText!="")
						{
						$("#countryNamePattern").focus();
						}
				}
			})
			}
		});
		$("#countryNameStartsWith").on('input',function(){
			if($("#countryNameStartsWith").val()=="")
			{
			$("#result").text("");
			}
			else{
			$.ajax({
				url: "/getcountrysw",
				data:{pattern: $("#countryNameStartsWith").val()},
				success: function(responseText){
					$("#result1").html(responseText);
					if(responseText!="")
						{
						$("#countryNameStartsWith").focus();
						}
				}
			})
			}
		});
	});
</script>
</body>
</html>