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
		<div><h2>${id }님의 회원탈퇴가 정상적으로 완료되었습니다. 감사합니다.</h2></div>
		<div>
		<br />
			<button type="button" onclick="location.href='index.do'">홈으로</button>
		</div>
	</div>
</body>
</html>