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
<c:import url="../layout/nav.jsp"/>

<h1 style="text-align: center;" >Notice List Page</h1>

<form action="./noticeWrite.jsp" method="get">
	<div class="container" >
	  <div class="table-responsive">          
	  <table class="table">
	    <thead>
	      <tr>
	        <th>#</th>
	        <th>TITLE</th>
	        <th>WRITER</th>
	        <th>CONTENTS
	        </th>
	        <th>DATE</th>
	        <th>HIT</th>
	      </tr>
	    </thead>
	    <tbody>
		 	<c:forEach items="${list}" var="noticeDTO">
			<tr>
				<td>${noticeDTO.num}</td>
				<td><a href="noticeSelect?num=${noticeDTO.num}">${noticeDTO.title}</a></td>
				<td>${noticeDTO.writer}</td>
				<td>${noticeDTO.contents}</td>
				<td>${noticeDTO.reg_date}</td>
				<td>${noticeDTO.hit}</td>
			</tr>
		</c:forEach>
	
	     
	    </tbody>
	  </table>
	  
	  <div>
	  	<ul class="pagination">
	  		<c:if test="${pager.curBlock gt 1}">
			  	<li><a href="./noticeList?curPage=${pager.startNum-1}">이전</a></li>
	  		</c:if>
	  	
	  		<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
	  			<li><a href="./noticeList?curPage=${i}">${i}</a></li>
	  		
	  		</c:forEach>
	  		
	  		<c:if test="${pager.curBlock lt pager.totalBlock}">
	  			<li><a href="./noticeList?curPage=${pager.lastNum+1}">다음</a></li>
	  		</c:if>
	 	</ul>
	  
	  </div>
	  
	  
	  
<%-- 	<!-- session member, memberDTO 꺼내와서 null이 아니면 글쓰기버튼이 보이도록.-->
	  	<c:if test="${not empty sessionScope.member}">
	  		<a class="btn btn-primary" href="noticeWrite">글쓰기</a>
	  	</c:if> 
--%>
	
	  	<a class="btn btn-primary" href="noticeWrite">글쓰기</a>
	
	  	
	  </div>
	</div>
</form>
</body>
</html>
