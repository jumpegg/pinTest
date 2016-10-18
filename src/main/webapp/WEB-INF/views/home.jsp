<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="../../resources/css/custom.css" rel="stylesheet" type="text/css" />
</head>

<body>
<h1>
	Pin Shot Test Table
</h1>
<a href="/create">직원 등록하기</a>
	<table>
		<thead>
			<tr>
				<th>직원번호</th>
				<th>직급</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>메일주소</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="MemberVO">
				<tr>
					<td>
					<fmt:formatNumber value="${MemberVO.memberNo}" type="number" pattern="###" minIntegerDigits="3" />
					</td>
					<td>${MemberVO.level}</td>
					<td>${MemberVO.name}</td>
					<td>${MemberVO.phone}</td>
					<td>${MemberVO.email}</td>
					<td><a href="/update?id=${MemberVO.id }">수정</a></td>
					<td><a href="/delete?id=${MemberVO.id }">삭제</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>
