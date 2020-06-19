<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<SCRIPT language=javascript>function click() {if (event.button==2) {alert('你剛剛是不是右鍵了OAO~');}}document.onmousedown=click</SCRIPT>
<meta charset="UTF-8"> 
<title>使用者介面</title>

<script Language="JavaScript">
<%
  String username=(String)session.getAttribute("username");
String passwd=(String)session.getAttribute("passwd");
String email=(String)session.getAttribute("email");
String phone=(String)session.getAttribute("phone");
  session.setAttribute("username2", username);
  session.setAttribute("passwd1", passwd);
  session.setAttribute("email1", email);
  session.setAttribute("phone1", phone);
%>


</script>

<style>
		legend {
			font-size: 24px;
			color: #0000ff;
		}

		fieldset {
			border-width: 3px;
			border-color: #EEC900;
			width: 15cm;
			margin: 100px auto;
		}
</style>

</head>

<body background="backforpass3.png">

<fieldset align="center">
<legend style="font-weight: bold;"><font size="6">歡迎<%=username%>使用者</font></legend>
<form  name="myForm7" method="post" action="http://localhost:8080/TheProjectFor0612/MenuForJSP.jsp">
<input type=hidden name="GO" id="GO" type="text" value=<%=username %> readonly="readonly">
<input type=hidden name="GO2" id="GO2" type="text"  readonly="readonly">
<input type="submit" value="前往購物車" onclick="userID(this.form)">
<input type="submit" value="突然吃飽了" onclick="return out(this.form)">
<input type="submit" value="會員修改" onclick="data(this.form)">
</form>
</fieldset>

<br>
</body>
</html>
<script Language="JavaScript">
var userid;
function userID(myForm7){
	alert("即將進入購物車畫面");
	document.myForm7.GO2.value=document.myForm7.GO.value;
	userid=document.myForm7.GO2.value;
}
function out(myForm7){
	var yes=confirm('確定吃飽了?');
	if(yes){
		alert("回登入畫面");
	}else{
		alert("可能還沒吃飽");
		return false;
}
	document.myForm7.action="http://localhost:8080/TheProjectFor0612/Login.jsp";
}
function data(myForm7){
	alert("前往修改畫面");
	document.myForm7.action="http://localhost:8080/TheProjectFor0612/Fix.jsp";
}
</script>





