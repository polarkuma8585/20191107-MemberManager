<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function openFormClose(){
		window.opener.document.getElementById("idch").value = 'Checked'; // memberInputForm.jsp 의 아이디 중복체크 태그의 value를 check로 바꿈 
		window.opener.document.getElementById("pw").focus();
		window.close();
	}
</script>
</head>
<body>
	<div align="center">
		<c:choose>
			<c:when test="${idcheck == false }">
				<div>
					<h3>${id }는 이미 존재하는 아이디입니다. 다른 아이디를 입력해주세요.</h3>
				</div>
			</c:when>
			<c:otherwise>
				<div>
					<h3>${id }는 사용할 수 있는 아이디입니다.</h3>
				</div>
			</c:otherwise>
		</c:choose>
		<div>
			<br />
			<button type="button" onclick="openFormClose()">확인</button>
		</div>
	</div>
	
</body>
</html>