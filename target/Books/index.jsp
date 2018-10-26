<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>红魔馆地下大图书馆</title>
<style type="text/css">
	body{
		background-color: green;
		color: white;
	}
	
	a{
		text-decoration: none;
		color: red;
	}
</style>
<script type="text/javascript" src="script/jquery-3.1.0.js"></script>
</head>
<body>

<c:choose>
	<c:when test="${empty books}">
	<h3 align="center"><a href="getList" >点击获取图书</a></h3>
	<h4 align="center" style="color: bule;">东方project</h4>
	</c:when>
	<c:otherwise>
	<h1 align="center" style="color: black;">book</h1>
	<div>
	<table  align="center">
		<tr>
			<th>编号</th>
			<th>书名</th>
			<th>作者</th>
			<th>库存</th>
			<th>价格</th>
			<th>修改</th>
			<th>删除</th>
		</tr>
		<c:forEach items="${books}" var="book">
			<tr>
				<td>${book.bookId}</td>
				<td>${book.bookName}</td>
				<td>${book.author}</td>
				<td>${book.stock}</td>
				<td>${book.price}</td>
				<td><a href="getBookById?bookId=${book.bookId}" name="${book.bookId}" class="update"> 修改 </a></td>
				<td><a href="deleteBook?bookId=${book.bookId}"> 删除 </a></td>
			</tr>
		</c:forEach>
		<tr>
			<td></td><td></td><td></td><td></td><td></td><td></td>
			<td><button id="btn">添加</button></td>
		</tr>
	</table>
	</div><br/><br/>
	<form action="BookServlet?method=updateOrAdd" method="post">
		<table align="center">
			<tr>
				<th>编号</th>
				<th>书名</th>
				<th>作者</th>
				<th>库存</th>
				<th>价格</th>
				<th>操作</th>
			</tr>
			<tr>
				<td><input type="text" readonly="readonly" name="bookId"/></td>
				<td><input type="text" name="bookName" value=""/></td>
				<td><input type="text" name="author" value=""/></td>
				<td><input type="text" name="stock" value=""/></td>
				<td><input type="text" name="price" value=""/></td>
				<td><input type="submit" value="确定"/></td>
			</tr>
		</table>
		
	</form>
	<form:form action="addOrUpdate" method="post" modelAttribute="book">
		<%-- <form:hidden path="bookId" /> --%><br/>
		书名:<form:input path="bookName"/><br/>
		作者:<form:input path="author"/><br/>
		库存:<form:input path="stock"/><br/>
		价格:<form:input path="price"/><br/>
		<input type="submit" value="确定"/>
	</form:form>
	</c:otherwise>
</c:choose>
<!-- <script type="text/javascript">
$(function(){
	$("#btn").click(function(){
		$("[name=bookId]").val("");
		$("[name=bookName]").val("");
		$("[name=author]").val("");
		$("[name=stock]").val("");
		$("[name=price]").val("");
	})
	$(".update").click(function(){
		var id=$(this).attr("name");
		var url="${pageContext.request.contextPath}/BookServlet";
		$.post(url,{"method":"getBookById","bookId":id},function(data){
			$("[name=bookId]").val(data.bookId);
			$("[name=bookName]").val(data.bookName);
			$("[name=author]").val(data.author);
			$("[name=stock]").val(data.stock);
			$("[name=price]").val(data.price);
		},"json");
		return false;
		
	})
	
})
</script> -->
</body>
</html>