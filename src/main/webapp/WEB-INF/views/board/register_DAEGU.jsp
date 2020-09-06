<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="../include/header.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">DAEGU Area Restaurant Review</h1>
	</div>
</div>

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				Board Register Page
			</div>
			<div class="panel-body">
				<form role="form" action="/board/register_DAEGU" method="post" enctype="multipart/form-data">
					<div class="form-group">	<!-- title -->
						<label>Title</label>
						<input class="form-control" name='title'>
					</div>
					
					<div class="form-group">	<!-- Content -->
						<label>Text Area</label>
						<textarea class="form-control" rows="3" name='content'></textarea>
					</div>
					
					<div class="form-group">	<!-- Writer -->
						<label>Writer</label>
						<input class="form-control" name='writer'>
					</div>
					
					<div class="form-group">	<!-- Area -->
						<label>Addr</label>
						<input class="form-control" name='addr'>
					</div>
					<input type="file" name="uploadfile" placeholder="파일 선택" /><br/>
					<button id="SubmitBtn" type="submit" class="btn btn-default">Submit Button</button>
					<button id="ListBtn" class="btn btn-default">List</button>
				</form>
			</div>
		</div>
	</div>
</div>

<script>
$(document).ready(function(){
	var FormObj=$("form[role='form']")
	$("#ListBtn").on("click",function(){
		FormObj.attr("action","/board/list_DAEGU");
		FormObj.attr("method","get");
		FormObj.submit();
	});
	$("#SubmitBtn").on("click",function(){
		if($("input[name=title]").val()=="")
		{
			alert("제목을 입력하세요!");
			$("input[name=title]").focus();
			return false;
		}
		if($("textarea[name=content]").val()=="")
		{
			alert("내용을 입력하세요!");
			$("textarea[name=content]").focus();
			return false;
		}
		if($("input[name='writer']").val()=="")
		{
			alert("이름을 입력하세요!");
			$("input[name='writer']").focus();
			return false;
		}
		if($("input[name='addr']").val()=="")
		{
			alert("지역을 입력하세요!");
			$("input[name='addr']").focus();
			return false;
		}
		
		if($("input[name='addr']").val()!="대구")
		{
			alert("대구지역을 입력하세요!");
			$("input[name='addr']").focus();
			return false;
		}
	});
});
</script>

<%@include file="../include/footer.jsp"%>