<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<h2>공지사항</h2>
		</div>
		<div>
			<c:choose>
				<c:when test="${size < 1  }"> <!--  ${empty list} 로 Attribute 설정없이 가능. -->
					<div>
						<h2>공지사항이 없습니다.</h2>
					</div>
				</c:when>
				<c:otherwise>
					<div>
						<br />
						<form id="frm" name="frm" action="" method="post">
						<table>
							<tr>
								<th>순번</th>
								<th>제목</th>
								<th>작성일</th>
								<th>조회수</th>
							</tr>
							<c:forEach var="dto" items="${list }">
								<tr class="tr" align="center">
									<td class="td" id="id" name="id" width="70">${dto.id }</td>
									<td class="td" id="title" name="title" width="500" onclick="transId(${dto.id})">${dto.title }</td>
									<td class="td" width="100">${dto.nDate }</td>
									<td class="td" width="70">${dto.hit }</td>
								</tr>
							</c:forEach>
						</table>
						</form>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
</html>