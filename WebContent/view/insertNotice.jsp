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
			<h2>공지사항 등록</h2>
		</div>
		
			<div>
				<form id="frm" name="frm" action="insertNoticetOk.do" method="post" onsubmit="return noticeFormCheck()">
					<table cellpadding="5px">
						<tr>
							<th width="70">제목</th>
							<td><input style="border:none; width:450px" type="text" id="title" name="title"></td>
							<th width="70">작성자</th>
							<td><input style="border:none;" type="text" id="writer" name="writer" value="관리자" readonly></td>
						</tr>
						<tr>
							<th>내용</th>
							<td colspan="3"><textarea style="resize:none; width:700px ;height: 500px;" id="contents" name="contents" cols="20" rows="30"></textarea></td>
						</tr>
					</table>
					<div>
					<br />
						<input class="input" type="submit" value="작성">&nbsp;&nbsp;
						<input class="input" type="reset" value="취소">&nbsp;&nbsp;
						<button type="button" onclick="location.href='noticeList.do'">리스트보기</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>