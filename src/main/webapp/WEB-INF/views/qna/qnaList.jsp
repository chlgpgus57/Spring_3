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
					<td><a href="qnaSelect?num=${qnaVO.num}">${qnaVO.title}</a></td>
					<td>${qnaVO.writer}</td>
					<td>${qnaVO.contents}</td>
					<td>${qnaVO.reg_date}</td>
					<td>${qnaVO.hit}</td>
				</tr>
			</c:forEach>

	    </tbody>
  </table>
   <ul class="pagination">
   
    <c:if test="${pager.curBlock gt 1}">
    	<li><a href="./qnaList?curPage=${pager.startNum-1}">이전</a></li>
    </c:if>
   
   	<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
	    <li><a href="./qnaList?curPage=${i}">${i}</a></li>
	</c:forEach>
   
    <c:if test="${pager.curBlock lt pager.totalBlock}">
    	<li><a href="./qnaList?curPage=${pager.lastNum+1}">다음</a></li>
    </c:if>
   
  </ul>
  
 
</div>
 	<a class="btn btn-primary" href="qnaInsert">글쓰기</a>



</body>
</html>