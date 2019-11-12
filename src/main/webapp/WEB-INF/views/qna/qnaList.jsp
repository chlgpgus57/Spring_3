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

<div class="container">
  <h2>QnA Table</h2>
  <table class="table">
    <thead>
      <tr>
        <th>num</th>
        <th>title</th>
        <th>writer</th>
        <th>contents</th>
        <th>reg_date</th>
        <th>hit</th>
        <th>ref</th>
        <th>step</th>
        <th>depth</th>
      </tr>
    </thead>
   <tbody>
		 	<c:forEach items="${list}" var="qnaVO">
				<tr>
					<td>${qnaVO.num}</td>
					<td><a href="noticeSelect?num=${qnaVO.num}">${qnaVO.title}</a></td>
					<td>${qnaVO.writer}</td>
					<td>${qnaVO.contents}</td>
					<td>${qnaVO.reg_date}</td>
					<td>${qnaVO.hit}</td>
					<td>${qnaVO.ref}</td>
					<td>${qnaVO.step}</td>
					<td>${qnaVO.depth}</td>
				</tr>
			</c:forEach>

	    </tbody>
  </table>
   <ul class="pagination">
   
   	<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
   
	    <li><a href="./qnaList?curPage=${i}">${i}</a></li>
	
	</c:forEach>
   
  </ul>
  
  <a class="btn btn-primary" href="qnaInsert">글쓰기</a>
</div>




</body>
</html>