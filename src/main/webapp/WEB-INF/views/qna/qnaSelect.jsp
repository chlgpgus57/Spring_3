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
	<h1>Notice Select Page</h1>
	
	
<form action="qnaUpdate" method="POST">
	<div class="container mt-3">
	 <h3>TITLE : ${qnaVO.title}</h3>
	 <h3>WRITER : ${qnaVO.writer}</h3>
		  <div class="media">
	    <div class="media-body">
	      <textarea class="form-control" rows="37" id="comment" readonly="readonly">${qnaVO.contents}</textarea>
	    </div>
	    </div>
	 	<a  href="./qnaUpdate?num=${qnaVO.num}" class="btn btn-danger">글 수정</a>
	 	<a  href="./qnaDelete?num=${qnaVO.num}" class="btn btn-danger">글 삭제</a>
	 	<a  href="./qnaAnswerWrite?num=${qnaVO.num}" class="btn btn-primary">답글달기</a>
	 	
	    <a href="./qnaList" class="btn btn-primary">글 목록</a>
	     
 	</div>
 </form>
	
	
</body>
</html>