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
		<div>
			<h2>로그인</h2>
		</div>
		<br />
		<form id="frm" name="frm" action="loginOk.do" method="post" onsubmit="return LoginFormCheck()">
			<div>
				<table cellpadding="5px">
					<tr align="center">
						<th width="100">아이디</th>
						<td><input type="text" id="id" name="id"></td>
					</tr>
					<tr align="center">
						<th>패스워드</th>
						<td><input type="password" id="pw" name="pw"></td>
					</tr>
				</table>
			</div>
			<div>
				<br />
				<input type="submit" value="로그인" /> &nbsp;&nbsp;
				<input type="reset" value="취소" /> &nbsp;&nbsp;
			</div>
		</form>
	</div>
</body>
</html>