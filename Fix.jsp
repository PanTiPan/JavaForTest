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
			margin: 0px auto;
		}
	</style>
	<%
  	String username=(String)session.getAttribute("username");
	String passwd=(String)session.getAttribute("passwd");
	String email=(String)session.getAttribute("email");
	String phone=(String)session.getAttribute("phone");
  	session.setAttribute("username2", username);
	%>
	</head>
	<body background="backforpass3.png">
	<fieldset align="center">
	<legend>修改資訊</legend>
		<form name="myForm10" method="post" action="http://localhost:8080/TheProjectFor0612/TC9">
			<p><label for="username">帳號：</label><input type="text" name="username" id="username" value=<%=username %> readonly="readonly"></p>
			<p><label for="passwd">密碼：</label><input type="text" name="passwd" id="passwd" value=<%=passwd %>></p>
			<p><label for="email">郵箱：</label><input type="email" name="email" id="email" value=<%=email %>></p>
			<p><label for="phone">電話：</label><input type="text" name="phone" id="phone" value=<%=phone %>></p>
			<p><input type="submit" value="修改" onclick="return confirm1(this.form)">
			   <input type="reset" value="重置">
			   <input type="submit" value="還是不要改好了" onclick="return confirm2(this.form)">
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

function confirm1(myForm10) {
	checklengthpasswd=document.myForm10.passwd.value.length;
	checklengthemail=document.myForm10.email.value.length;
	checklengthphone=document.myForm10.phone.value.length;
	
	if(checklengthpasswd==0){
		alert("請填寫密碼");
		return false;
	}else if(checklengthemail==0){
		alert("請填寫郵箱");
		return false;
	}else if(checklengthphone==0){
		alert("請填寫電話");
		return false;
	}
	var yes=confirm('確定要修改?');
	if(yes){
		alert("修改成功");
	}else{
		return false;
}
}

function confirm2(myForm10) {
	
	var yes=confirm('確定不要修改?');
	if(yes){
		alert("殘忍拒絕");
		document.myForm10.action="http://localhost:8080/TheProjectFor0612/Yes2.jsp";
	}else{
		alert("繼續修改~");
		return false;
}
	
}


</script>