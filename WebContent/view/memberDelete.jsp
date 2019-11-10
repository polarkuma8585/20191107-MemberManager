<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel ="stylesheet" href="css/board.css">
</head>
<body>
	<div align="center">
		<div><jsp:include page="topmenu.jsp" /></div>
		<br />
		<div><h2>회원 탈퇴</h2></div>
		<br />
		<div><h2>${id }님, 본 사이트의 회원을 탈퇴하시겠습니까?</h2></div>
		<div>
		<br />
			<button type="button" onclick="location.href='memberDeleteOk.do'">확인</button>
			<button type="button" onclick="location.href='index.do'">취소</button>
		</div>
	</div>
</body>
</html>