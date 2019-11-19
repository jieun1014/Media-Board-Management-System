<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	  <meta http-equiv="content-type" content="text/html; charset=UTF-8">
	  <title>영상 파일 전송 관리 시스템</title>
	</head>
	<body>
		<form name="loginForm"action="/login" method="post" onsubmit="return emptyCheck()">
			<input type="text" name="id" placeholder="아이디" />
			<input type="password" name="password" placeholder="비밀번호" />
			<input type="submit" value="로그인"/><br>
			<c:if test="${revisit == \"Y\"}">
				잘못된 아이디 또는 비밀번호입니다.
			</c:if>
		</form>
	</body>
	<script>
		function emptyCheck() {
			if (loginForm.id.value == "") {
				alert("아이디와 비밀번호를 입력하세요.");
				loginForm.id.focus();
				return false;
			}
			else if (loginForm.password.value == "") {
				alert("아이디와 비밀번호를 입력하세요.");
				loginForm.password.focus();
				return false;
			}
			return true;
		}
	</script>
</html>