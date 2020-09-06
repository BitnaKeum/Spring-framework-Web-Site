<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="../include/header.jsp"%>

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

.bg-img {
  /* The image used */
  background-image: url("file:///C:/Users/CEO/Documents/workspace-sts-3.9.6.RELEASE/web_tutorial/src/main/webapp/WEB-INF/views/board/${boardVO.title}.PNG");

  min-height: 780px;

  /* Center and scale the image nicely */
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  
  /* Needed to position the navbar */
  position: relative;
}


</style>
</head>

</html>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">${boardVO.addr}</h1>
	</div>
</div>

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				Board Read Page
			</div>
			
			
			<div class="panel-body">
				<div class="form-group">
					<label>Bno</label>
					<input class="form-control" name='bno' value='<c:out value="${boardVO.bno}"/>' readonly="readonly">
				</div>
				
				<div class="form-group">
					<label>Title</label>
					<input class="form-control" name='title' value='<c:out value="${boardVO.title}"/>' readonly="readonly">
				</div>
				
				<body>

<h2>Image</h2>
<div class="bg-img"></div>

</body>
				
				<div class="form-group">
					<label>Text Area</label>
					<textarea class="form-control" name='content' rows='3' readonly="readonly">${boardVO.content}</textarea>
				</div>
				
				<div class="form-group">
					<label>Writer</label>
					<input class="form-control" name='writer' value='<c:out value="${boardVO.writer}"/>' readonly="readonly">
				</div>
				
				<div class="form-group">
					<label>Area</label>
					<input class="form-control" name='addr' value='<c:out value="${boardVO.addr}"/>' readonly="readonly">
				</div>
				
				<button id="LikeBtn" class="btn btn-default">Like</button>
             	<button id="HateBtn" class="btn btn-default">Hate</button>
				<button id="ModiBtn" class="btn btn-default">Modify</button>
				<button id="ListBtn" class="btn btn-default" onclick="location.href='/board/list'">List</button>
				<button id="DelBtn" class="btn btn-default">Delete</button>
			</div>
			<form id="Form" method="post">
				<input type="hidden" name="bno" value="${boardVO.bno}">
			</form>
		</div>
	</div>
</div>

<script>
$(document).ready(function(){
	var FormObj=$("#Form");
	$("#ModiBtn").on("click",function(){
		FormObj.attr("action","/board/modify");
		FormObj.attr("method","get");
		FormObj.submit();
	});
	$("#ListBtn").on("click",function(){
		set.location="/board/list";
	});
	$("#DelBtn").on("click",function(){
		FormObj.attr("action","/board/remove");
		FormObj.submit();
	});
	$("#LikeBtn").on("click",function(){
		FormObj.attr("action","/board/read");
		FormObj.submit();
	});
	
	$("#HateBtn").on("click",function(){
		FormObj.attr("action","/board/read/hate");
		FormObj.submit();
	});
});
</script>

<%@include file="../include/footer.jsp"%>