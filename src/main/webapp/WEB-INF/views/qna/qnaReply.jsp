
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../layout/bootStrap.jsp"/>

</head>
<body>
<c:import url="../layout/nav.jsp" />


	<div class="container">
	  <h2>qna Write Page</h2>


	  <form action="qnaReply" method="post">
		<input type="hidden" name="num" value="${num}">
		
	    <div class="form-group">

	      <label for="title">TITLE : </label>
	        <div class="form-group">
	     	 <input type="text" class="form-control form-control-sm" placeholder="Small form control" name="title">
	   		</div>
	   		<label for="title">Writer : </label>
	        <div class="form-group">
	     	 <input type="text" class="form-control form-control-sm" placeholder="Small form control" name="writer">
	   		</div>
	      <label for="contents">CONTENTS : </label>
	      <textarea class="form-control" rows="37" id="comment" name="contents"></textarea>
	    </div>

	    <button type="submit" class="btn btn-primary">완료</button>
	    
	  </form>
	</div>

</body>

</html>