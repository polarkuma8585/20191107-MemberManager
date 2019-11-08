<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		<c:choose>
			<c:when test="${joinChk == 1 }">
			<div><h2>축하합니다! 회원가입에 성공했습니다!</h2></div>
			<div>
				<button type="button" onclick="location.href='login.do'">로그인</button>
			</div>	
			</c:when>
			<c:otherwise>
			<div><h2>죄송합니다. 회원가입이 실패했습니다. 다시 시도해 주세요.</h2></div>
			<div>
			<button type="button" onclick="location.href='memberInput.do'">회원가입</button>
			<button type="button" onclick="location.href='index.do'">홈으로</button>
			</div>
			</c:otherwise>
		</c:choose>
		
		
		
		
	</div>
</body>
</html>