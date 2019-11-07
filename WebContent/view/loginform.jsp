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
		<br />
			<h2>LOG IN</h2>
		</div>
		<br />
		<form id="frm" name="frm" action="loginOk.do" method="post" onsubmit="return LoginFormCheck()">
			<div>
				<table cellpadding="5px">
					<tr align="center">
						<th width="100">아이디</th>
						<td style="background:#FBBC05;"><input style="border:none;" type="text" id="id" name="id"></td>
					</tr>
					<tr align="center">
						<th>비밀번호</th>
						<td style="background:#FBBC05;"><input style="border:none;" type="password" id="pw" name="pw"></td>
					</tr>
				</table>
			</div>
			<div>
				<br />
				<input class="input" type="submit" value="로그인" /> &nbsp;&nbsp;
				<input class="input" type="reset" value="취소" /> &nbsp;&nbsp;
			</div>
		</form>
	</div>
</body>
</html>