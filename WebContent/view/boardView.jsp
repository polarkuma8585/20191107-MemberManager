<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardView</title>
<link rel="stylesheet" href="css/board.css">
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>

</head>
<body>
	<div align="center">
		<div><jsp:include page="topmenu.jsp" /></div>
		<br />
		<div><h2>자유게시판</h2></div>
		<div>
			<form id="frm" name="frm" action="replyInsert.do" method="post" onsubmit="return replyCheck()">
			<input type="hidden" id="id" name="id" value="${list[0].id }">
			<input type="hidden" id="replycontents" name="replycontents" value="${list[i].contents }">
			<div>
			<table cellpadding="5px">
				<tr>
					<th width="50">제목</th>
					<td width="550">${list[0].title }</td>
					<th width="60">작성자</th>
					<td>${list[0].writer }</td>
				</tr>
				<tr>
					<th>내용</th>
					<td valign="top" colspan="3" height="500" width="700">${list[0].contents }</td>
				</tr>
				<c:if test="${!empty list[1] }">
				<tr>
					<th colspan="5">댓글</th>
				</tr>
				</c:if>
				<c:forEach var="i" begin="1" end="${length -1 }">
				
				<tr id="${list[i].id }">
				
					<td align="center" style="background:#b7d1fb;" width="70" colspan="4">
					${list[i].writer } 
					<input type="hidden" id="replyid" name="replyid" value="">
					<!-- </td> -->
					<!-- <td style="background: #e7f0fe;" colspan="3">${list[i].contents } --> 
					<input type="text" class="replyUpdateInput" id="replyContents" name="replyContents" value="${list[i].contents }" readonly>
					
					<input type="text" class="replyUpdateInput2" id="replyUpdate" name="replyUpdate" placeholder="${list[i].contents }">&nbsp;&nbsp;
					<button type="button" onclick="replyAction(1)" style="display:none;" id="replyUpdate_btn" name="replyUpdate_btn">등록</button>&nbsp;&nbsp;
					
					<!-- <td style="background:#e7f0fe;"> -->
						<c:if test="${list[i].userId == writer }">
						
						<button type="button" onclick="replyAction(2)" id="replyUp" name="replyUp">수정</button>&nbsp;&nbsp; <!--  미완성 -->
						<button type="button" onclick="replyAction(3)" id="replyDel" name="replyDel">삭제</button> <!-- 미완성 -->
						</c:if>
					<!-- </td>  -->
					</td>
				</tr>
				
				</c:forEach>
				<c:if test="${id != null }">
				<tr>
					<th colspan="4">댓글작성</th>
				</tr>
				<tr>
					<td colspan="3" style="background:#FBBC05">
					<textarea id="reply" name="reply" style="resize:none; border:none; width:760px; height:50px" cols="100" rows="5"></textarea>
					</td>
					<!--  <td align="center" style="background:#4285F4; color:white; cursor:pointer;" onclick="return replyCheck()"> -->
					<td style="background:#4285F4;" align="center">
					<input class="replyinput" type="submit" value="등록">
					</td>
				</tr>
				</c:if>
			</table>
			</div>
			<div>
			<br />
				<c:if test="${list[0].userId == writer }">
				<button type="button" onclick="updateBoard()">수정</button>&nbsp;&nbsp;
				<button type="button" onclick="deleteBoard()">삭제</button>&nbsp;&nbsp;
				</c:if>
				<button type="button" onclick="location.href='boardList.do'">목록보기</button>
			</div>
			</form>
		</div>
	</div>
</body>
</html>