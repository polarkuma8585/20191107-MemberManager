<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member Update</title>
<link rel="stylesheet" href="css/board.css">
</head>
<body>
	<div align="center">
		<div><jsp:include page="topmenu.jsp" /></div>
		<div>
		<br />
			<div><h2>내 정보 수정</h2></div>
			<form id="frm" name="frm" action="memberUpdateOk.do" method="post" onsubmit="memberUpdateFormCheck()">
			<div>
			<br />
				<table cellpadding="5px">
					<tr>
						<th>*id</th><td style="background:#FBBC05;" ><input style="border:none;" type="text" id="id" name="id" value="${dto.id }" readonly></td>
					</tr>
					<tr>
						<th>*패스워드</th><td style="background:#FBBC05;"><input style="border:none;" type="password" id="pw" name="pw" value="${dto.password }">
						<button type="button" onclick="pwUpdate()">변경</button></td><!-- pw변경 버튼 미완성 -->
					</tr>
					<tr>
						<th>*이름</th><td style="background:#FBBC05;" ><input style="border:none;" type="text" id="name" name="name" value="${dto.name }"></td>
					</tr>
					<tr>
						<th>주소</th><td style="background:#FBBC05;" ><input style="border:none; width:200px" type="text" id="addr" name="addr" value="${dto.addr }"></td>
					</tr>
					<tr>
						<th>*전화번호</th><td style="background:#FBBC05;" ><input style="border:none;" type="text" id="tel" name="tel" value="${dto.tel }"></td>
					</tr>
				</table>
			</div>
			<div>
				<br />
				<input class="input" type="submit" value="저장">&nbsp;&nbsp;
				<button type="button" onclick="location.href='index.do'">홈으로</button>
			</div>
			</form>
		</div>
	</div>
</body>
</html>