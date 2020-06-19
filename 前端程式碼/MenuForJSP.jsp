<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*"%>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<SCRIPT language=javascript>function click() {if (event.button==2) {alert('你剛剛是不是右鍵了OAO~');}}document.onmousedown=click</SCRIPT>
<meta charset="utf-8">
<title>菜單表單樣式</title>
<style>
legend {
	font-size: 24px;
	color: #0000ff;
}

fieldset {
	border-width: 3px;
	border-color: #ff00ff;
	width: 5.5cm;
	margin: auto;
}
</style>
</head>
<body background="back2.png" onload="ShowTime()">
<%
  String username2=(String)session.getAttribute("username2");
%>

<marquee height="80" behavior="alternate"><h1><font color="blue"><img src="1.png">來喔！便當訂起來！</font><img src="1-2.png"></h1></marquee>


	<fieldset align="center">
		<legend style="font-weight: bold;">便當訂訂訂</legend>
		<div id="showbox" style="font-weight: bold;"></div>
		<img style="display:none;" src="HOME.gif" id="Picture1"><img style="display:none;" src="Country.gif" id="Picture2"><img style="display:none;" src="Rice.gif" id="Picture3"><img style="display:none;" src="Chicken.gif" id="Picture4"><img style="display:none;" src="SmallEat.gif" id="Picture5"><img style="display:none;" src="NewOne.gif" id="Picture6"><img style="display:none;" src="FouBurn.gif" id="Picture7"><img style="display:none;" src="WildBurn.gif" id="Picture8"><img style="display:none;" src="ChickenRice.gif" id="Picture9"><img style="display:none;" src="RiceSmellGood.gif" id="Picture10">
		<img style="display:none;" src="OldHome.gif" id="Picture11"><img style="display:none;" src="RiceChicken.gif" id="Picture12"><img style="display:none;" src="ColdNoodles.gif" id="Picture13"><img style="display:none;" src="ThreeWolf.gif" id="Picture14">
		<form name="myForm" method="get" action="http://localhost:8080/TheProjectFor0612/TC5" target="nm_iframe"
			> 
			<b> 店家名稱 ：</b> <SELECT name="mak" id="mak"
				onChange="buildkey(this.selectedIndex);">
				<OPTION value="0" selected disabled="disabled">請選擇店家
				<option value="家基飯包">家基飯包
				<option value="鄉親專賣店">鄉親專賣店
				<option value="豐米便當">豐米便當
				<option value="味香雞腿">味香雞腿
				<option value="丘記小吃">丘記小吃
				<option value="鑫一排骨">鑫一排骨
				<option value="福廣燒臘">福廣燒臘
				<option value="野味炭烤">野味炭烤
				<option value="泰國雞肉飯">泰國雞肉飯
				<option value="飯香本鋪">飯香本鋪
				<option value="老家棧">老家棧
				<option value="巧米雞腿">巧米雞腿
				<option value="福德涼麵">福德涼麵
				<option value="三郎便當">三郎便當
			</Select> <br>
			<br>
			<b>便當與價格:</b> <SELECT id="mem">
				<option value="0" selected disabled="disabled">請選擇餐點</option>
			</Select> <br>
			<br>
			<input id="but1" type="submit" value="加點第0次" onclick="Add(this.form)">
			<input type="submit" value="刪除上一筆" onclick="Del(this.form)">
			<br>
			<br>
			<b>使用者帳號：</b> <br>
			<input name="idUser" id="idUser" type="text" value=<%=username2 %> readonly="readonly"><br>
			<b>訂餐編號：</b> <br>
			<input name="idOrder" id="idOrder" type="text" readonly="readonly"><br>
			<b>餐點編號：</b> <br>
			<input name="idFood" id="idFood" type="text" readonly="readonly"><br>
			<b>餐點單價：</b> <br>
			<input name="Get22" id="Get22" type="text" readonly="readonly"><br>
			<b>餐點名稱：</b> <br>
			<input name="GetFood" id="GetFood" type="text" readonly="readonly">
			<br>
			<b>總金額：</b>
			<input name="Get" id="Get" type="text" readonly="readonly"><br>
			<br>
			<textarea readonly="readonly" name="Shopping" id="Shopping" rows="5"
				cols="10"></textarea>
			<br> <b>總計便當數量：</b>
			<textarea readonly="readonly" id="Total" rows="1" cols="2"
				style="vertical-align: middle">0</textarea>
			
				<input type="hidden" name="Test" id="Test" type="text" readonly="readonly">
		</form>
		<iframe  name="nm_iframe" style="display:none;"></iframe>
		<form name="myForm2" method="get" action="http://localhost:8080/TheProjectFor0612/GTM" target="_blank">
		<input type="submit" value="結帳" onclick="return Pay2(this.form)">
		<input type="hidden" name="Test2" id="Test2" type="text" readonly="readonly">
		<input type="hidden" name="Test3" id="Test3" type="text" readonly="readonly">
		<input type="hidden" name="Test4" id="Test4" type="text" readonly="readonly">
		<input type="hidden" name="Test5" id="Test5" type="text" readonly="readonly">
		<input type="hidden" name="Test6" id="Test6" type="text" value=<%=username2 %> readonly="readonly">
		</form>
		<form name="myForm3" method="get" action="http://localhost:8080/TheProjectFor0612/Yes2.jsp">
		<input type="submit" value="回使用者介面" onclick="return back(this.form)">
		</form>
		<MARQUEE direction=up behavior=alternate height=50>
		<MARQUEE style="HEIGHT: 25px" direction=right behavior=alternate>
		<font color="#912CEE" size="5"><strong>訂便當！吃飽飽</strong></font> 
		</marquee>
		</marquee>
	</fieldset>
<marquee direction="right" scrollamount="20" onMouseOver="this.stop()" onMouseOut="this.start()">
<a href="https://zh-tw.facebook.com/pages/%E5%B7%A7%E7%B1%B3%E9%9B%9E%E8%85%BF%E5%A4%A7%E7%8E%8B/204966159639130" target="_blank" title="巧米雞腿大王"><img border="0" src="巧米雞腿.png"></a>
<a href="https://zh-tw.facebook.com/pages/%E8%80%81%E5%AE%B6%E6%A3%A7/163981100858001" target="_blank" title="老家棧"><img border="0" src="老家棧.jpg"></a>
<a href="https://www.facebook.com/%E4%B8%98%E8%A8%98%E9%BA%B5%E9%A3%9F%E9%A4%A8-415330711971258/" target="_blank" title="丘記小吃"><img border="0" src="丘記小吃.png"></a>
<a href="https://zh-tw.facebook.com/pages/category/Interest/%E5%91%B3%E9%A6%99%E9%9B%9E%E8%85%BF%E5%A4%A7%E7%8E%8B-400497056813071/" target="_blank" title="味香雞腿"><img border="0" src="味香雞腿.jpg"></a>
<a href="https://www.facebook.com/vvp0081d/?ref=bookmarks" target="_blank" title="家基飯包"><img border="0" src="家基飯包.jpg"></a>
<a href="https://www.facebook.com/pages/888%E6%B3%B0%E5%9C%8B%E9%9B%9E%E8%82%89%E9%A3%AF-%E0%B8%A3%E0%B9%89%E0%B8%B2%E0%B8%99%E0%B8%82%E0%B9%89%E0%B8%B2%E0%B8%A7%E0%B8%A1%E0%B8%B1%E0%B8%99%E0%B9%84%E0%B8%81%E0%B9%88/568122369993764" target="_blank" title="泰國雞肉飯"><img border="0" src="泰國雞肉飯.jpg"></a>
<a href="https://yehweibento.com/" target="_blank" title="野味炭烤"><img border="0" src="野味炭烤.jpg"></a>
<a href="https://www.facebook.com/pages/category/Diner/%E9%84%89%E8%A6%AA%E4%BE%BF%E7%95%B6-298205587734596/" target="_blank" title="鄉親專賣店"><img border="0" src="鄉親專賣店.jpg"></a>
<a href="https://zh-tw.facebook.com/pages/category/Chinese-Restaurant/%E9%A3%AF%E9%A6%99%E6%9C%AC%E8%88%96%E7%B2%BE%E7%B7%BB%E4%BE%BF%E7%95%B6-254238961328484/" target="_blank" title="飯香本鋪"><img border="0" src="飯香本鋪.jpg"></a>
<a href="https://zh-tw.facebook.com/pages/%E7%A6%8F%E5%BB%A3%E7%87%92%E8%87%98%E5%BA%97/141088315952347" target="_blank" title="福廣燒臘"><img border="0" src="福廣燒臘.jpg"></a>
<a href="https://zh-tw.facebook.com/pages/%E7%A6%8F%E5%BE%B7%E6%B6%BC%E9%BA%B5/167235603323386" target="_blank" title="福德涼麵"><img border="0" src="福德涼麵.png"></a>
<a href="https://www.facebook.com/FengMiBianDangPingZhenHePingDian/" target="_blank" title="豐米便當"><img border="0" src="豐米便當.png"></a>
<a href="https://www.facebook.com/pages/category/Society---Culture-Website/%E9%91%AB%E4%B8%80%E6%8E%92%E9%AA%A8-%E4%BE%BF%E7%95%B6%E5%BF%AB%E9%A4%90-809877559093521/" target="_blank" title="鑫一排骨"><img border="0" src="鑫一排骨.jpg"></a>
<a href="https://zh-tw.facebook.com/pages/category/Cafeteria/%E4%B8%89%E9%83%8E%E4%BE%BF%E7%95%B6%E9%87%91%E9%99%B5%E5%BA%97-163882463731899/" target="_blank" title="三郎便當"><img border="0" src="三郎便當.jpg"></a>
</marquee>
</body>
</html>



<SCRIPT Language="JavaScript">
	var count=0;
	var countTotal=0;
	var deluse=0;
	var deluse2=0;
	var deluse3=0;
	var count2=0;
	var dotoDatabase=0;
	var FoodNumber=0;
	var TestForForms=0;
	var selectForMaker;
	var TotalFoods;
	var TotalNumber;
	//var OrderNumber="A003";//準備拿來接收類似訂單編號
	var NowDate2=new Date(); 
	var GetYear=NowDate2.getFullYear();
	selectForMaker=document.myForm.mak.selectedIndex;
	
	
	
	key=new Array(100);
	key[1]=new Array(50);//家基
	key[2]=new Array(3);//鄉親
	key[3]=new Array(50);//豐米
	key[4]=new Array(50);//味香雞腿大王
	key[5]=new Array(50);//丘記小吃
	key[6]=new Array(50);//鑫一排骨
	key[7]=new Array(50);//福廣燒臘
	key[8]=new Array(50);//野味炭烤
	key[9]=new Array(50);//泰國雞肉飯
	key[10]=new Array(50);//飯香本鋪
	key[11]=new Array(50);//老家棧
	key[12]=new Array(50);//巧米雞腿
	key[13]=new Array(50);//福德涼麵
	key[14]=new Array(50);//三郎便當
	//家基飯包
	key[1][0]="雞絲飯 50";key[1][1]="滷肉飯 50";key[1][2]="魯肉便 60";key[1][3]="香腸飯 70";key[1][4]="雞肉飯 80";key[1][5]="雞魯飯 80";key[1][6]="火車飯 80";key[1][7]="排骨飯 80";key[1][8]="控肉飯 80";key[1][9]="炸雞飯 75";key[1][10]="酥排飯 80";key[1][11]="滷排飯 80";key[1][12]="雞排飯 85";key[1][13]="雞腿飯 90";key[1][14]="鱈魚飯 70";key[1][15]="鯖魚飯 75";key[1][16]="無骨雞 70";key[1][17]="椒排骨 75";key[1][18]="黑排骨 75";
	//鄉親專賣店
	key[2][0]="雞腿飯 60";key[2][1]="排骨飯 60";key[2][2]="梅干肉 60";
	//豐米
	key[3][0]="招牌飯 75";key[3][1]="燒肉飯 75";key[3][2]="控肉飯 75";key[3][3]="排骨飯 75";key[3][4]="香排骨 80";key[3][5]="香腸飯 70";key[3][6]="鯖魚飯 70";key[3][7]="鱈魚飯 85";key[3][8]="油雞飯 85";key[3][9]="椒麻雞 85";key[3][10]="三杯雞 85";key[3][11]="糖醋排 85";key[3][12]="蔥爆牛 85";key[3][13]="雞排飯 85";key[3][14]="雞腿飯 90";key[3][15]="火車便 85";
	//味香雞腿大王
	key[4][0]="雞排飯 90";key[4][1]="牛燴飯 90";key[4][2]="泡菜飯 90";key[4][3]="滷排飯 90";key[4][4]="炸排骨 90";key[4][5]="白北魚 90";key[4][6]="鱈魚飯 90";key[4][7]="控肉飯 90";key[4][8]="炸雞腿 90";key[4][9]="滷雞腿 90";
	//丘記小吃
	key[5][0]="牛肉炒 70";key[5][1]="肉絲炒 60";key[5][2]="香腸炒 60";key[5][3]="火腿炒 60";key[5][4]="蛋炒飯 50";key[5][5]="牛燴飯 70";key[5][6]="什錦燴 70";key[5][7]="肉絲燴 60";key[5][8]="咖哩牛 80";key[5][9]="咖豬排 80";key[5][10]="咖雞排 80";key[5][11]="蔥爆牛 70";key[5][12]="宮保雞 70";key[5][13]="卡啦雞 70";key[5][14]="五香肉 70";key[5][15]="土魠魚 70";key[5][16]="香腸飯 70";key[5][17]="牛炒麵 70";key[5][18]="什錦麵 70";key[5][19]="牛粄條 70";key[5][20]="什錦粄 70";key[5][21]="肉絲粄 60";key[5][22]="牛烏龍 80";
	key[5][23]="什錦烏 80";key[5][24]="肉絲烏 70";key[5][25]="燙青菜 40";key[5][26]="小豆干 15";key[5][27]="大豆干 15";key[5][28]="油豆腐 15";key[5][29]="嫩粉腸 50";key[5][30]="嫩大腸 50";key[5][31]="嘴邊肉 50";key[5][32]="嫩筍絲 40";key[5][33]="嫩滷蛋 10";key[5][34]="嫩海帶 10";key[5][35]="湯豬肝 50";key[5][36]="小肉燥 50";key[5][37]="大肉燥 70";key[5][38]="薑牛湯 60";key[5][39]="薑腸湯 50";key[5][40]="薑肝湯 30";key[5][41]="豬血湯 30";key[5][42]="蛋花湯 30";key[5][43]="貢丸湯 30";
	//鑫一排骨
	key[6][0]="滷排骨 75";key[6][1]="香排骨 75";key[6][2]="控肉飯 90";key[6][3]="燒肉飯 80";key[6][4]="糖醋雞 85";key[6][5]="滷雞腿 90";key[6][6]="三杯雞 85";key[6][7]="香雞排 95";key[6][8]="烤雞排 95";key[6][9]="香雞腿 90";key[6][10]="和風腿 95";key[6][11]="菜肉飯 50";
	//福廣燒臘
	key[7][0]="招牌飯 95";key[7][1]="三寶飯 95";key[7][2]="鴨腿飯 95";key[7][3]="燒鴨飯 90";key[7][4]="油雞飯 95";key[7][5]="油雞腿 95";key[7][6]="燒肉飯 95";key[7][7]="叉燒飯 80";key[7][8]="叉鴨飯 90";key[7][9]="排骨飯 85";key[7][10]="牛腩飯 95";key[7][11]="烤雞腿 95";key[7][12]="豬腳飯 85";key[7][13]="東坡肉 80";key[7][14]="魚排飯 85";key[7][15]="香腸飯 80";key[7][16]="香菜飯 60";key[7][17]="小白飯 10";
	//野味炭烤
	key[8][0]="烤雞腿 95";key[8][1]="烤雞排 95";key[8][2]="燒肉飯 85";key[8][3]="鯖魚飯 85";key[8][4]="椒鹽腿 80";key[8][5]="烤排骨 85";key[8][6]="香排骨 80";
	//泰國雞肉飯
	key[9][0]="豬打拋 70";key[9][1]="雞打拋 70";key[9][2]="牛打拋 80";key[9][3]="海鮮拋 80";key[9][4]="蝦炒飯 80";key[9][5]="炒粄條 80";key[9][6]="咖雞飯 80";
	//飯香本鋪
	key[10][0]="招牌飯 70";key[10][1]="香排骨 70";key[10][2]="滷排骨 70";key[10][3]="控肉飯 70";key[10][4]="台油雞 70";key[10][5]="蒜油雞 70";key[10][6]="雞排飯 70";key[10][7]="咯啦雞 70";key[10][8]="肉魚飯 70";key[10][9]="鯖魚飯 70";key[10][10]="鯛魚飯 70";key[10][11]="鱈魚飯 70";key[10][12]="香腸飯 70";key[10][13]="三寶飯 70";key[10][14]="豬腿飯 70";key[10][15]="雞腿飯 70";key[10][16]="椒麻雞 70";key[10][17]="蔥爆牛 70";key[10][18]="蔥爆豬 70";key[10][19]="蒜泥肉 70";key[10][20]="鹽水鴨 70";key[10][21]="宮保雞 70";
	//老家棧
	key[11][0]="塘辣雞 95";key[11][1]="宮保雞 80";key[11][2]="老排骨 80";key[11][3]="炸排骨 80";key[11][4]="薑絲豬 80";key[11][5]="控肉飯 80";key[11][6]="三杯卷 80";key[11][7]="三杯豬 80";key[11][8]="三杯雞 90";key[11][9]="辣炒肉 80";key[11][10]="雞排飯 80";key[11][11]="炸雞腿 90";key[11][12]="椒麻雞 95";
	//巧米雞腿
	key[12][0]="雞腿飯 95";key[12][1]="排骨飯 90";key[12][2]="牛腩飯 90";key[12][3]="控肉飯 90";key[12][4]="雞排飯 90";key[12][5]="鱈魚飯 90";key[12][6]="滷排骨 90";key[12][7]="單雞腿 70";key[12][8]="單牛腩 60";key[12][9]="單控肉 60";key[12][10]="單雞排 60";key[12][11]="單排骨 60";key[12][12]="單魚排 60";key[12][13]="單白飯 10";
	//福德涼麵
	key[13][0]="原味涼 45";key[13][1]="辣味涼 45";key[13][2]="素食涼 45";key[13][3]="榨菜肉 55";key[13][4]="麻辣醬 55";key[13][5]="辣冷麵 60";key[13][6]="香乾麵 50";key[13][7]="肉燥飯 50";key[13][8]="原味涼 45";
	//三郎便當
	key[14][0]="一菜盒 70";key[14][1]="雞腿飯 90";key[14][2]="紅燒牛 90";key[14][3]="二層肉 85";key[14][4]="控肉飯 85";key[14][5]="辣雞丁 85";key[14][6]="蔥爆牛 90";key[14][7]="豬排飯 85";key[14][8]="香腸飯 85";key[14][9]="鹹魚飯 85";key[14][10]="蔥肉絲 85";key[14][11]="叉燒飯 85";
	
	
	function ShowTime(){
		var NowDate=new Date();
	　var h=NowDate.getHours();
	　var m=NowDate.getMinutes();
	　var s=NowDate.getSeconds();
	 var d=NowDate.getDate();
	 var m2=NowDate.getMonth();
	 var y=NowDate.getFullYear();
	  
	　document.getElementById('showbox').innerHTML =y+'年'+(m2+1)+'月'+d+'日'+h+'時'+m+'分'+s+'秒';
	　setTimeout('ShowTime()',1000);
	if(d>=1&d<=9){
		OrderNumber=y+'0'+(m2+1)+'0'+d+document.myForm.idUser.value;
	}else{
		OrderNumber=y+'0'+(m2+1)+d+document.myForm.idUser.value;
	}
	
	}
	
	function buildkey(num){
		document.myForm.mem.selectedIndex=0;
		for(i=0;i<key[num].length;i++){
			//新增select的選項
			document.myForm.mem.options[i]=new Option(key[num][i],key[num][i]);
			
		}
			document.myForm.mem.length=key[num].length;
			if(document.myForm.mak.options[document.myForm.mak.selectedIndex].value=="家基飯包"){
				Picture1.style.display="block";
			}
			else{
				Picture1.style.display="none";
			}
			if(document.myForm.mak.options[document.myForm.mak.selectedIndex].value=="鄉親專賣店"){
				Picture2.style.display="block";
			}
			else{
				Picture2.style.display="none";
			}
			if(document.myForm.mak.options[document.myForm.mak.selectedIndex].value=="豐米便當"){
				Picture3.style.display="block";
			}
			else{
				Picture3.style.display="none";
			}
			if(document.myForm.mak.options[document.myForm.mak.selectedIndex].value=="味香雞腿"){
				Picture4.style.display="block";
			}
			else{
				Picture4.style.display="none";
			}
			if(document.myForm.mak.options[document.myForm.mak.selectedIndex].value=="丘記小吃"){
				Picture5.style.display="block";
			}
			else{
				Picture5.style.display="none";
			}
			if(document.myForm.mak.options[document.myForm.mak.selectedIndex].value=="鑫一排骨"){
				Picture6.style.display="block";
			}
			else{
				Picture6.style.display="none";
			}
			if(document.myForm.mak.options[document.myForm.mak.selectedIndex].value=="福廣燒臘"){
				Picture7.style.display="block";
			}
			else{
				Picture7.style.display="none";
			}
			if(document.myForm.mak.options[document.myForm.mak.selectedIndex].value=="野味炭烤"){
				Picture8.style.display="block";
			}
			else{
				Picture8.style.display="none";
			}
			if(document.myForm.mak.options[document.myForm.mak.selectedIndex].value=="泰國雞肉飯"){
				Picture9.style.display="block";
			}
			else{
				Picture9.style.display="none";
			}
			if(document.myForm.mak.options[document.myForm.mak.selectedIndex].value=="飯香本鋪"){
				Picture10.style.display="block";
			}
			else{
				Picture10.style.display="none";
			}
			if(document.myForm.mak.options[document.myForm.mak.selectedIndex].value=="老家棧"){
				Picture11.style.display="block";
			}
			else{
				Picture11.style.display="none";
			}
			if(document.myForm.mak.options[document.myForm.mak.selectedIndex].value=="巧米雞腿"){
				Picture12.style.display="block";
			}
			else{
				Picture12.style.display="none";
			}
			if(document.myForm.mak.options[document.myForm.mak.selectedIndex].value=="福德涼麵"){
				Picture13.style.display="block";
			}
			else{
				Picture13.style.display="none";
			}
			if(document.myForm.mak.options[document.myForm.mak.selectedIndex].value=="三郎便當"){
				Picture14.style.display="block";
			}
			else{
				Picture14.style.display="none";
			}
	}
	function Add(myForm){
		if(document.myForm.mak.selectedIndex==0){
			alert( "請選擇店家和餐點" );
			return false;
		}
		var total="";
		var spliter="";
		var newArray=new Array();
		dotoDatabase=1;
		FoodNumber+=1;
		
		spliter=document.myForm.mem.options[document.myForm.mem.selectedIndex].value;
		var newArray=spliter.split(" ");
		document.myForm.Get22.value="";
		document.myForm.Get22.value=newArray[1];
		document.myForm.GetFood.value="";
		document.myForm.GetFood.value=newArray[0];
		countTotal+=parseInt(newArray[1]);
		count+=1;
		total+=document.myForm.mem.options[document.myForm.mem.selectedIndex].value;
		//total+=newArray[0];
		document.myForm.Get.value=countTotal;
		document.myForm.Shopping.value+=total;
		document.myForm.Shopping.value+="\n";
		document.myForm.Total.value=count;
		count2++;
		document.myForm.but1.value='加點第'+count2+'次';
		document.myForm.Test.value=dotoDatabase;
		document.myForm.idFood.value=FoodNumber;//餐點編號
		document.myForm.idOrder.value=OrderNumber;//訂餐編號
		TestForForms=countTotal;
		selectForMaker=document.myForm.mak.selectedIndex;
		TotalFoods=document.myForm.Shopping.value+"\n";
		TotalNumber=count;
	}

	function Reset(myForm) {
		countTotal = 0;
		count = 0;
		deluse = 0;
		deluse2 = 0;
		count2 = 0;
		document.myForm.but1.value = '加點第' + count2 + '次';

	}

	function Del(myForm) {
		var spliter2 = "";
		deluse = document.myForm.Shopping.value.length;
		if (deluse <= 0) {
			document.myForm.Get22.value = "";
			document.myForm.GetFood.value = "";
			document.myForm.idFood.value="";
			alert("無便當資訊，沒辦法刪除");
			return false;
		}
		deluse2 = document.myForm.mem.options[document.myForm.mem.selectedIndex].value.length;
		spliter2 = document.myForm.Shopping.value.substring(deluse
				- (deluse2 + 1), deluse);
		var newArray2 = new Array();
		var newArray2 = spliter2.split(" ");
		document.myForm.Get22.value = newArray2[1];
		document.myForm.GetFood.value = newArray2[0];
		//document.myForm.Test.value=spliter2;
		document.myForm.Shopping.value = document.myForm.Shopping.value
				.substring(0, deluse - (deluse2 + 1));
		count -= 1;
		document.myForm.Total.value = count;
		countTotal -= parseInt(document.myForm.Get22.value);
		document.myForm.Get.value = parseInt(document.myForm.Get.value)
				- parseInt(document.myForm.Get22.value);
		count2 -= 1;
		document.myForm.but1.value = '加點第' + count2 + '次';
		dotoDatabase=2;
		document.myForm.Test.value=dotoDatabase;
		document.myForm.idFood.value=FoodNumber;//餐點編號
		FoodNumber-=1;
		TestForForms=countTotal;
		TotalFoods=document.myForm.Shopping.value+"\n";
		TotalNumber=count;
	}

	
	function Pay2(myForm2) {
		
		if (selectForMaker == 0) {
			alert("請選擇店家和餐點");
			return false;
		}else if(TotalNumber==0){
			alert("請選擇店家和餐點");
			return false;
		}else{
			var yes=confirm('確定要前往結帳頁面?');
			if(yes){
				alert("即將前往結帳頁面");
			}else{
				alert("繼續採購");
				return false;
			}
			
		}
		
		function back(myForm3) {
				alert("即將前往使用者頁面");
		}
		document.myForm2.Test2.value=TestForForms;
		document.myForm2.Test3.value=TotalFoods;//儲存訂購的便當清單
		document.myForm2.Test4.value=TotalNumber;//儲存便當總數量
		document.myForm2.Test5.value=OrderNumber;//儲存訂單編號用
	}
	
	
	
	
	
</script>



