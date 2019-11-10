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
		<div><jsp:include page="topmenu.jsp"></jsp:include>
			<br />
			<div>
				<h2>공지사항 수정하기</h2>
			</div>
			<div>
				<form id="frm" name="frm" action="updateNoticeOk.do" method="post" onsubmit="return noticeFormCheck()">
					<input type="hidden" id="id" name="id" value="${dto.id }">
					<table cellpadding="7px">
						<tr align="center">
							<th width="50">글번호</th>
							<td width="30">${dto.id }</td>
							<th width="70">제목</th>
							<td align="left"><input style="background:#fcd14f; border:none;width:370px; height:25px;" type="text" id="title" name="title" value="${dto.title }"></td>
							<th width="70">작성일</th>
							<td width="100">${dto.nDate }</td>
						</tr>
						<tr>
							<th>내용</th>
							<td align="left" valign="top" width="600" height="500" colspan="5">
							<textarea style="padding: 5px;background:#fcd14f; border:none; resize:none; width:700px ;height: 500px;" id="contents" name="contents" cols="20" rows="30">${dto.contents }</textarea>
							</td>
						</tr>
					</table>
					<div>
						<br /> <input class="input" type="submit" value="저장">&nbsp;&nbsp;
						<button type="button" onclick="location.href='noticeList.do'">취소</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>