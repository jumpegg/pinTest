<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
		Member Update Page
	</h1>
	<div>
		<div>
		<form action="/update" method="POST">
		<input name="id" type="hidden" value="${member.id}" />
			<p>직원번호 : </p> <input name="memberNo" type="text" value="${member.memberNo }"/><br />
			<p>직급 : </p> <input name="level" type="text" value="${member.level }"/><br />
			<p>이름 : </p> <input name="name" type="text" value="${member.name }"/><br />
			<p>전화번호 : </p> <input name="phone" type="text" value="${member.phone }"/><br />
			<p>메일주소 : </p> <input name="email" type="email" value="${member.email }"/><br />
			
			<button type="submit">등록</button>
		</form>
		</div>
	</div>
</body>
</html>