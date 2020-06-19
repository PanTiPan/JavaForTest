<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<SCRIPT language=javascript>function click() {if (event.button==2) {alert('你剛剛是不是右鍵了OAO~');}}document.onmousedown=click</SCRIPT>
		<meta charset="UTF-8">
		<title>註冊資訊</title>
		
	<style>
		legend {
			font-size: 24px;
			color: #0000ff;
		}

		fieldset {
			border-width: 3px;
			border-color: #ff00ff;
			width: 6cm;
			margin: 100px auto;
		}
	</style>
	</head>
	<body background="backforpass3.png">
	<fieldset align="center">
	<legend>註冊資訊</legend>
		<form name="myForm6" method="post" action="http://localhost:8080/TheProjectFor0612/TC7">
			<p><label for="username">帳號：</label><input type="text" name="username" id="username"></p>
			<p><label for="passwd">密碼：</label><input type="text" name="passwd" id="passwd"></p>
			<p><label for="email">郵箱：</label><input type="text" name="email" id="email"></p>
			<p><label for="phone">電話：</label><input type="text" name="phone" id="phone"></p>
			<p><input type="submit" value="註冊" onclick="return confirm1(this.form)">
			   <input type="reset" value="重置">
			   <input type="submit" value="回登入" onclick="return confirm2(this.form)">
			</p>		
		</form>
	</fieldset>
	</body>
</html>

<SCRIPT Language="JavaScript">
var checklengthUser;
var checklengthpasswd;
var checklengthemail;
var checklengthphone;


function confirm1(myForm6) {
	checklengthUser=document.myForm6.username.value.length;
	checklengthpasswd=document.myForm6.passwd.value.length;
	checklengthemail=document.myForm6.email.value.length;
	checklengthphone=document.myForm6.phone.value.length;
	
	if (checklengthUser==0) {
		alert("請填寫帳號");
		myForm6.username.focus();
		return false;
	}else if(checklengthpasswd==0){
		alert("請填寫密碼");
		myForm6.passwd.focus();
		return false;
	}else if(checklengthemail==0){
		alert("請填寫郵箱");
		myForm6.email.focus();
		return false;
	}else if(checklengthphone==0){
		alert("請填寫電話");
		myForm6.phone.focus();
		return false;
	}
}

function confirm2(myForm6) {
	
	var yes=confirm('確定要前往登入頁面?');
	if(yes){
		alert("殘忍拒絕");
		document.myForm6.action="http://localhost:8080/TheProjectFor0612/Login.jsp";
	}else{
		alert("繼續註冊~");
		return false;
}
	
}


</script>