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

<div>
	<form id="frm" action="./noticeList">
		<input type="hidden" id="curPage" value="1" name ="curPage">
		<select name="kind">
			<option id="kt" value="kt">Title</option>
			<option id="kc" value="kc">Contents</option>
			<option id="kw" value="kw">Writer</option>
		</select>
		<input type="text" name="search" value="${pager.search}">
		<button>검색</button>
	</form>
</div>



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
		 	<c:forEach items="${list}" var="noticeVO">
			<tr>
				<td>${noticeVO.num}</td>
				<td><a href="noticeSelect?num=${noticeVO.num}">${noticeVO.title}</a></td>
				<td>${noticeVO.writer}</td>
				<td>${noticeVO.contents}</td>
				<td>${noticeVO.reg_date}</td>
				<td>${noticeVO.hit}</td>
			</tr>
		</c:forEach>
	
	     
	    </tbody>
	  </table>
	  
	  <div>
	  	<ul class="pagination">
	  		<c:if test="${pager.curBlock gt 1}">
			  	<li><span id="${pager.startNum-1}" class="list">이전</span></li>
	  		</c:if>
	  	
	  		<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
	  			<li><span id="${i}" class="list">${i}</span></li>
	  		
	  		</c:forEach>
	  		
	  		<c:if test="${pager.curBlock lt pager.totalBlock}">
	  			<li><span id="${pager.lastNum+1}" class="list">다음</span></li>
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
<script type="text/javascript">

	var kind= '${pager.kind}';
	
	if(kind==''){
		kind="kt";
	}
	
	$("#"+kind).prop("selected",true);
	$(".list").click(function() {
		
		$("#curPage").val($(this).attr("id"));
		$("#frm").submit();
		
	});
</script>
</body>
</html>
