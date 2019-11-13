<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../layout/bootStrap.jsp"/>
<style type="text/css">
	#sc{
	width:200px;
	float: left;
	}
	#sc2{
	float: left;
	}
</style>
</head>
<body>
<c:import url="../layout/nav.jsp"/>
<div>
	<form id ="frm" action="./qnaList">
	
		<input type="hidden" id="curPage" value="1" name="curPage" > 
		<select name="kind">
			<option id="kt" value="kt">Title</option>
			<option id="kc" value="kc">Contents</option>
			<option id="kw" value="kw">Writer</option>
		</select>
		<div class="input-group-btn">
			<input type="text" name="search" value="${pager.search}" id="sc" placeholder="search" class="form-control">      			
				
	        <button class="btn btn-default" type="submit" id="sc2" ><i class="glyphicon glyphicon-search"></i></button>
	     </div>
			
	</form>
</div>


<form action="./qnaWrite.jsp" method="get">
<div class="container">
	  <div class="table-responsive">          

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
      </tr>
    </thead>
   <tbody>
		 	<c:forEach items="${list}" var="qnaVO">
				<tr>
					<td>${qnaVO.num}</td>
					<td>
					<c:forEach begin="1" end="${qnaVO.depth}">--</c:forEach>
					<a href="qnaSelect?num=${qnaVO.num}">${qnaVO.title}</a>
					</td>
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
    	<li><span id="${pager.startNum-1}" class="list">이전</span></li>
    </c:if>
   
   	<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
	    <li><span id = "${i}" class="list">${i}</span></li>
	</c:forEach>
   
    <c:if test="${pager.curBlock lt pager.totalBlock}">
    	<li><span id ="${pager.lastNum+1}" class="list">다음</span></li>
    </c:if>
   
  </ul>

	</div>
	
	<div>
		<a class="btn btn-default" href="qnaWrite">글쓰기</a>
		
	</div>
	
</div>
</form>

	<script type="text/javascript">
		var kind = '${pager.kind}';
		if(kind==''){
			kind="kt";
		}
		
		$("#"+kind).prop("selected", true);
		
		$(".list").click(function() {
			
		  $("#curPage").val($(this).attr("id"));
		  $("#frm").submit();
		  
		});
	
	</script>

</body>
</html>