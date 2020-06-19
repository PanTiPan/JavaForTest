<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<SCRIPT language=javascript>function click() {if (event.button==2) {alert('你剛剛是不是右鍵了OAO~');}}document.onmousedown=click</SCRIPT>
		<meta charset="UTF-8">
		<title>登入資訊</title>
		
	<style>
		legend {
			font-size: 24px;
			color: #0000ff;
		}

		fieldset {
			border-width: 3px;
			border-color: #ff00ff;
			width: 6cm;
			margin: auto;
		}
	</style>
	</head>
	<body background="inner4.png">
	<fieldset align="center">
	<legend>登入資訊</legend>
		<form name="myForm6" method="post" action="http://localhost:8080/TheProjectFor0612/TC8">
			<p><label for="username">帳號：</label><input type="text" name="username" id="username"></p>
			<p><label for="passwd">密碼：</label><input type="password" name="passwd" id="passwd"></p>
			<p><input type="submit" value="登入" onclick="return confirm3(this.form)">
			   <input type="reset" value="重置">
			</p>		
		</form>
		<form name="myForm7" method="post" action="http://localhost:8080/TheProjectFor0612/Login2.jsp">
			  <input type="submit" value="註冊" onclick="return confirm2(this.form)">
		</form>
	</fieldset>
	</body>
</html>

<SCRIPT Language="JavaScript">
var checklengthUser;
var checklengthpasswd;
var check=0;


function confirm3(myForm6) {
	checklengthUser=document.myForm6.username.value.length;
	checklengthpasswd=document.myForm6.passwd.value.length;
	
	if (checklengthUser==0) {
		alert("請填寫帳號");
		myForm6.username.focus();
		return false;
	}else if(checklengthpasswd==0){
		alert("請填寫密碼");
		myForm6.passwd.focus();
		return false;
	}
}

function confirm2(myForm7) {
	
	var yes=confirm('確定要前往註冊頁面?');
		if(yes){
			alert("即將前往註冊頁面");
		}else{
			return false;
	}
		
		}
</script>