<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/board.css">
<script type="text/javascript" src="js/myJavaScript.js"></script>
</head>
<body>
	<div align="center">
		<div><jsp:include page="topmenu.jsp"></jsp:include></div>
		<c:choose>
			<c:when test="{id != null}">
				<h1>${id }님은 이미 등록된 회원입니다.</h1>
			</c:when>
			<c:otherwise>
				<div>
				<br />
					<div>
						<h2>회원 등록 화면</h2>
					</div>
					<div>
						<form id="frm" name="frm" action="memberInsertOk.do" method="post" onsubmit="return memberFormCheck()">
							<table cellpadding="5px">
								<tr>
									<th width="120">*아이디</th>
									<td style="background:#FBBC05;"><input  style="border:none;" type="text" id="id" name="id">&nbsp;
									<button type="button" id="idch" name="idch" onclick="idCheck()" value="unCheck">중복체크</button></td>
								</tr>
								<tr >
									<th>*비밀번호</th>
									<td style="background:#FBBC05;"><input style="border:none;" type="password" id="pw" name="pw"></td>
								</tr>
								<tr >
									<th>*비밀번호 확인</th>
									<td style="background:#FBBC05;"><input style="border:none;" type="password" id="pwChk" name="pwChk"></td>
								</tr>
								<tr>
									<th>*이름</th>
									<td style="background:#FBBC05;"><input style="border:none;" type="text" id="name" name="name"></td>
								</tr>
								<tr>
									<th>주소</th>
									<td style="background:#FBBC05;"><input style="border:none; width: 220px;" type="text" id="addr" name="addr"></td>
								</tr>
								<tr>
									<th>*전화번호</th>
									<td style="background:#FBBC05;"><input type="text" style="border:none;" id="tel" name="tel"></td>
								</tr>
							</table>
							<br />
							<div>
								<input class="input" type="submit" value="가입">&nbsp;&nbsp; 
								<input class="input" type="reset" value="취소">
							</div>
						</form>
					</div>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>