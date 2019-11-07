<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<div><h2>로그아웃</h2></div>
		<div><h2>${id }님 정상적으로 로그아웃 되셨습니다.</h2></div>
		<div>
			<button type="button" onclick="location.href='index.do'">확인</button>
		</div>
	</div>
</body>
</html>