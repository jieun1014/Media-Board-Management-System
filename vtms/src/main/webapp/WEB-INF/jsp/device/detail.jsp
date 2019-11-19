<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<meta charset="UTF-8">
		<title>영상 파일 전송 관리 시스템</title>
	</head>
	<body>
		<h1>영상 파일 전송 관리 시스템</h1>
		<a href="<%= this.getServletContext().getContextPath()%>/device">디바이스 정보 관리</a>
		<a href="<%= this.getServletContext().getContextPath()%>/transfer/history">전송 이력</a>
		<a href="<%= this.getServletContext().getContextPath()%>/logout">로그아웃</a>
		<hr>
		디바이스 정보
		<hr><br/>
		<div id="loading" style="display:none">
			<img src="/image/waiting.gif" alt="loading" style="width:500px; height:200px">
		</div>

		<form id="form_data" action='<%= this.getServletContext().getContextPath()%>/device/${device.ip}' method="post" enctype="multipart/form-data">
			<input type="hidden" name="_method" />
			<input type="hidden" id="ip" name="ip" value="${device.ip}" />

			<table> 
				<tr>
					<td>IP : </td>
					<td><c:out value="${device.ip}"/></td>
				</tr>
				<tr>
					<td>호스트 명 : </td>
					<td><c:out value="${device.hostName}"/></td>
				</tr>
				<tr>
					<td>장소 : </td>
					<c:if test="${device.place == null}">
						<td><input type="text" name="place" value=""></td>
					</c:if>
					<c:if test="${device.place != null}">
						<td><input type="text" name="place" value="${device.place}"></td>
					</c:if>
				</tr>
				<tr>
					<td>이름 : </td>
					<c:if test="${device.name == null}">
						<td><input type="text" name="name" value=""></td>
					</c:if>
					<c:if test="${device.name != null}">
						<td><input type="text" name="name" value="${device.name}"></td>
					</c:if>
				</tr>
				<tr>
					<td>전송 일시 : </td>
					<c:if test="${device.transferDate == null}">
						<td><c:out value=""/></td>
					</c:if>
					<c:if test="${device.transferDate != null}">
						<td><c:out value="${device.transferDate}"/></td>
					</c:if>
				</tr>
				<tr>
					<td>등록 일시 : </td>
					<td><c:out value="${device.registerDate}"/></td>
				</tr>
				<tr>
					<td>접속 상태 : </td>
					<td>
						<span id="connStatusDisplay">${device.connStatus}</span>
						<input id="doUpdate" type="button" value="갱신">
					</td>
				</tr>
				<tr>
					<td>첨부 파일 :</td>
					<td><input type="file" name="video" id="video"></td>
				</tr>
				<tr>
					<td>재생 시간 :</td>
					<td>
						<select name="playTime">
							<option value="5">5분</option>
							<option value="10">10분</option>
							<option value="15">15분</option>
							<option value="20">20분</option>
							<option value="25">25분</option>
							<option value="30">30분</option>
							<option value="35">35분</option>
							<option value="40">40분</option>
							<option value="50">50분</option>
							<option value="60">60분</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>설명 :</td>
					<td><input type="text" name="note"></td>
				</tr>
			</table>
			<br/>
			<div id="result_msg"><c:if test="${not empty msg}"><div style="color: red"><c:out value="${msg}" /></div></c:if></div>
			<input type="submit" value="수정" id="edit_btn">
			<input type="submit" value="삭제" id="remove_btn">
		</form>
	</body>

	<script>
		$(document).ready(function(){
			$('#edit_btn').attr('disabled', false);
			$('#remove_btn').attr('disabled', false);
			$('#doUpdate').attr('disabled', false);

			$("#loading").hide();
			
			$("#doUpdate").click(function() {
				$('#edit_btn').attr('disabled', true);
				$('#remove_btn').attr('disabled', true);
				$('#doUpdate').attr('disabled', true);
				
				$("#loading").show();
				
				$.ajax({
					url : "${pageContext.request.contextPath}/devicestatus/" + $("#ip").val(),
					type : "get",
					data : { ip : $("#ip").val() },
					headers : {
						"Content-Type" : "application/json;charset=UTF-8"
					},
					success : function(data){
						var text = data.connStatus;
						if (text == true) {
							document.getElementById("connStatusDisplay").innerHTML = "정상";
						}
						else {
						document.getElementById("connStatusDisplay").innerHTML = "장애";
						}
					},
					error:function(request, status, error) {
						document.getElementById("connStatusDisplay").innerHTML = '<font color="red">장애</font>';
					},
					complete:function() {
						$('#edit_btn').attr('disabled', false);
						$('#remove_btn').attr('disabled', false);
						$('#doUpdate').attr('disabled', false);

						$("#loading").hide();
					}
				})
			});
			
			
			$("#remove_btn").click(function() {
				$('#edit_btn').attr('disabled', false);
				$('#remove_btn').attr('disabled', false);
				$('#doUpdate').attr('disabled', false);
				
				if(confirm("삭제하시겠습니까?") == true) {
					$("input[name=_method]").val("delete");
					$("#form_data").submit();
				} else {
					return false;
				}
			});
			
			$("#edit_btn").click(function() {
				var fileObj = null;
				var extension = "noExtension";
				var isEquals = false;
				var permitExtension = new Array('mp4', 'avi', 'wav');
				
				fileObj = document.getElementById("video").value; 
				
				
				if (fileObj != "") {
					extension = fileObj.substring(fileObj.lastIndexOf(".") + 1, fileObj.length);
					
					if (extension != 'noExtension') {
						for(var i = 0; i < permitExtension.length; i++){
							if (permitExtension[i] == extension) {
								isEquals = true;
							}
						}
					}
					
					if (isEquals) {
						$('#edit_btn').attr('disabled', true);
						$('#remove_btn').attr('disabled', true);
						$('#doUpdate').attr('disabled', true);
						
						$("#loading").show();
						$("#form_data").submit();
						
						return true;
					} else {
						alert("확장자가 .mp4, .avi, .wav 인 파일만 전송 가능합니다.");
						
						return false;
					}					
				} 
				$('#edit_btn').attr('disabled', true);
				$('#remove_btn').attr('disabled', true);
				$('#doUpdate').attr('disabled', true);
				
				$("#loading").show();
				$("#form_data").submit();
			});
		});
	</script>
</html>