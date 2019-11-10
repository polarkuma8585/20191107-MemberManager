<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 게시글 등록</title>
<link rel="stylesheet" href="css/board.css">
</head>
<body>
	<div align="center">
		<div><jsp:include page="topmenu.jsp" /></div>
		<br />
		<div><h2>자유게시판 글 쓰기</h2></div>
		<div>
			<form id="frm" name="frm" action="insertBoardOk.do" method="post" onsubmit="return insertBoardCheck()">
			<input type="hidden" id="writer" name="writer" value="${writer }">
			<div>
			<table cellpadding="5px">
				<tr>
					<th width="50">제목</th>
					<td style="background:#fcd14f;" width="550"><input style="border:none; width:550px; height:20px;" type="text" id="title" name="title"></td>
					<th width="60">작성자</th>
					<td align="center">${writer }</td>
				</tr>
				<tr>
					<th>내용</th>
					<td valign="top" style="background:#fcd14f;" colspan="3" height="500" width="700">
					<textarea style="border:none; resize:none; width:730px; height:700px" cols="60" rows="50" id="contents" name="contents"></textarea>
					</td>			
			</table>
			</div>
			<div>
			<br />
				<input class="input" type="submit" value="저장">&nbsp;&nbsp;
				<input class="input" type="reset" value="취소">&nbsp;&nbsp;
				<button type="button" onclick="location.href='boardList.do'">목록보기</button>
			</div>
			</form>
		</div>
	</div>
</body>
</html>