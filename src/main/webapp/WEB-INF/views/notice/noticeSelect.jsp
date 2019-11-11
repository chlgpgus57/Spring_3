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
	
	
<form action="noticeUpdate" method="POST">
	<div class="container mt-3">
	 <h3>TITLE : ${noticeVO.title}</h3>
	 <h3>WRITER : ${noticeVO.writer}</h3>
		  <div class="media">
	    <div class="media-body">
	      <textarea class="form-control" rows="37" id="comment" readonly="readonly">${noticeVO.contents}</textarea>
	    </div>
	    </div>
	 	<a  href="./noticeUpdate?num=${noticeVO.num}" class="btn btn-danger">글 수정</a>
	 	<a  href="./noticeDelete?num=${noticeVO.num}" class="btn btn-danger">글 삭제</a>
	    <a href="./noticeList" class="btn btn-primary">글 목록</a>
	     
 	</div>
 </form>
	
	
</body>
</html>