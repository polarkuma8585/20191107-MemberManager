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
		<br />
		<div><h2>로그아웃</h2></div>
		<div><h2>${id }님  로그아웃 하시겠습니까?</h2></div>
		<div>
			<button type="button" onclick="location.href='logOutOk.do'">확인</button>&nbsp;&nbsp;
			<button type="button" onclick="location.href='index.do'">취소</button>
		</div>
	</div>
</body>
</html>