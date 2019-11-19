<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/jsp/top.jsp" %>
		 <div class="normal-table-area">
	        <div class="container">
	            <div class="row">
	                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
	                    <!-- <div class="normal-table-list mg-t-30"> -->
						<div class="normal-table-list">
	                        <div class="basic-tb-hd">
	                            <h2>디바이스 정보 관리</h2>
								<span class="form-example-int mg-t-30" style="text-align: left;">
									접속 상태 : 
	                                <select id="connStatus">
										<option value="N">장애</option>
										<option value="">전체</option>
									</select>
								</span>
								<span class="form-example-int mg-t-15" >
									<button class="btn btn-success notika-btn-success waves-effect" style="float:right;" onclick="drawTable()">검색</button>
								</span>
	                        </div>
	                        <div class="bsc-tbl-hvr" id="tables">
	                            
	                        </div>
	                    </div>
	                </div>
	            </div>
	        </div>
    	</div>
    	<%@ include file="/WEB-INF/jsp/footer.jsp" %>
	</body>
	<script>
		$(document).ready(function(){
			drawTable("N");	
		});
	
		function drawTable(connStatus) {
			var status = connStatus != null ? connStatus : $("#connStatus").val();
			
			$.ajax({
		        url: "${pageContext.request.contextPath}/device",
		        type: "get",
		        headers : {
		        	"Content-Type" : "application/json;charset=utf-8"
		        },
		        data: { 
		        	connStatus : status
		        },
		        dataType : "json",
		        success: function(data) {
		        	var text = '';

		        	text += "<table class='table table-hover'>";
		        	text += "<thead>";
		        	text += "<tr>";
		        	text += "	<td>번호</td>";
		        	text += "	<td>IP</td>";
		        	text += "	<td>장소</td>";
		        	text += "	<td>이름</td>";
		        	text += "	<td>전송 일시</td>";
		        	text += "	<td>등록 일시</td>";
		        	text += "	<td>접속 상태</td>";
		        	text += "</tr>";
		        	text += "</thead>";
		        	text += "<tbody>";
		        	
		        	for(var i = 0; i < data.length; i++) {
		        		var place = data[i].place != null ? data[i].place : "";
		        		var name = data[i].name != null ? data[i].name : "";
		        		var transferDate = data[i].transferDate != null ? data[i].transferDate : "";
		        		var connStatus = data[i].connStatus != "정상" ? data[i].connStatus : "";
		        		text += "<tr>";
		        		text += "<td>" + (i + 1) + "</td>";
		        		text += "<td><a href=\"${pageContext.request.contextPath}/device/" + data[i].ip + "\">" + data[i].ip + "</a></td>";
			        	text += "<td>" + place + "</td>";
			        	text += "<td>" + name + "</td>";
			        	text += "<td>" + transferDate + "</td>";	        			
		        		text += "<td>" + data[i].registerDate + "</td>";
			        	text += "<td>" + connStatus + "</td>";
		        		text += "</tr>";
		        	}
		        	
		        	text += "</tbody>";
		        	text += "</table>";
		        	document.getElementById("tables").innerHTML = text;
		        }, error:function(request, status, error) {
		            alert("세션이 만료되었습니다. 로그인 페이지로 이동합니다."); // 실패 시 처리
		        	window.location.replace("localhost");
		        }
		    })
		};
	</script>
</html>