<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<SCRIPT language=javascript>function click() {if (event.button==2) {alert('你剛剛是不是右鍵了OAO~');}}document.onmousedown=click</SCRIPT>
<meta charset="UTF-8">
<title>管理者頁面</title>
<style>
legend {
	font-size: 24px;
	color: #0000ff;
}

fieldset {
	border-width: 3px;
	border-color: #ff00ff;
	width: 10cm;
	margin: 0px auto;
}
</style>
</head>
<body background="backforcontrol.png">

<fieldset align="center">
		<legend style="font-weight: bold;">管理者資訊</legend>
<h1>此為管理者介面</h1>
<form name="myForm8" method="get" action="http://localhost:8080/TheProjectFor0612/SMD3" target="_blank">
		<input type="submit" value="查看今天訂餐">
</form>
<br>
<form name="myForm9" method="get" action="http://localhost:8080/TheProjectFor0612/Login.jsp">
		<input type="submit" value="回登入的畫面">
</form>
<br>
<form name="myForm10" method="get" action="http://localhost:8080/TheProjectFor0612/SMD" target="_blank">
		<input type="submit" value="檢視歷史訂餐">
</form>
</fieldset>
</body>
</html>