<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>영상 파일 전송 관리 시스템</title>
</head>
<body>
	<h1>영상 파일 전송 관리 시스템</h1>
		<a href="<%= this.getServletContext().getContextPath()%>/device">디바이스 정보 관리</a>
		<a href="<%= this.getServletContext().getContextPath()%>/transfer/history">전송 이력</a>
		<a href="<%= this.getServletContext().getContextPath()%>/logout">로그아웃</a>
		<hr>
	<t1>전송 이력 정보</t1><hr><br>
	<form action="${pageContext.request.contextPath}/transfer/history" method="get">
		<div style="border:1px solid; width:80%; padding-top:20px; padding-bottom:20px; padding-left:15px;">
			<table>
				<tr>
					<td>장소 : </td>
					<td>${transferHistory.place}</td>
				</tr>
				<tr>
					<td>IP : </td>
					<td>${transferHistory.deviceIp}</td>
				</tr>
				<tr>
					<td>디바이스 명 : </td>
					<td>${transferHistory.name}</td>
				</tr>
				<tr>
					<td>전송 일시 : </td>
					<td>${transferHistory.transferDate}</td>
				</tr>
				<tr>
					<td>영상 파일 명 : </td>
					<td>${transferHistory.videoName}</td>
				</tr>
				<tr>
					<td>영상 파일 용량 : </td>
					<td>${transferHistory.fileSize}</td>
				</tr>
				<tr>
					<td>영상 파일 재생 시간 : </td>
					<td>${transferHistory.playTime}</td>
				</tr>
				<tr>
					<td>영상 파일 설명 : </td>
					<td>${transferHistory.note}</td>
				</tr>
			</table>
		</div>
		<input type="submit" value="목록" />
	</form>
	</body>
</html>