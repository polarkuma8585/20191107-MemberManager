<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/board.css">
</head>
<body>
	<div align="center">
		<div><jsp:include page="topmenu.jsp"></jsp:include>
			<br />
			<div>
				<h2>공지사항</h2>
			</div>
			<div>
				<form id="frm" name="frm" action="updateNotice.do" method="post">
					<input type="hidden" id="id" name="id" value="${dto.id }">
					<table cellpadding="7px">
						<tr align="center">
							<th width="50">글번호</th>
							<td width="30">${dto.id }</td>
							<th width="70">제목</th>
							<td>${dto.title }</td>
							<th width="70">작성일</th>
							<td>${dto.nDate }</td>
						</tr>
						<tr>
							<th>내용</th>
							<td align="left" valign="top" width="600" height="500" colspan="3">${dto.contents }</td>
						</tr>
						
					</table>
					<div>
						<br /> 
						<c:if test="${grant == 'S' }">
						<input class="input" type="submit" value="수정하기">&nbsp;&nbsp;
						</c:if>
						<button type="button" onclick="location.href='noticeList.do'">리스트보기</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>