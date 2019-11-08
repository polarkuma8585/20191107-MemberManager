<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/board.css">

</head>
<body>
	<div align="center">
		<div><jsp:include page="topmenu.jsp" /></div>
		<br />
		<div><h2>회원 정보 목록</h2></div>
		<div>
		<br />
		<table cellpadding="5px">
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>가입일</th>
				<th>주소</th>
				<th>전화번호</th>
			</tr>
			<c:forEach var="dto" items="${list }">
					<tr class="tr" align="center">
						<td class="td" width="70">${dto.id }</td>
						<td class="td" width="70">${dto.name }</td>
						<td class="td" width="100">${dto.eDate }</td>
						<td class="td" width="300">${dto.addr }</td>
						<td class="td" width="200">${dto.tel }</td>
					</tr>
			</c:forEach>
		</table>
		</div>
		<div>
		<br />
			<button type="button" onclick="location.href='index.do'">닫기</button>
		</div>
	</div>
</body>
</html>