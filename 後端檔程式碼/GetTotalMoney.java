

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetTotalMoney
 */
@WebServlet("/GTM")
public class GetTotalMoney extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection dbCon = null;
	    Statement stmt = null;
	    ResultSet rs = null;
	    //驅動程式參數
	    String sDriver = "org.mariadb.jdbc.Driver";	       
	    String user     = "root";
	    String password = "1234";
	    String url      = "jdbc:mariadb://localhost/test";
	    String sql      = "select 店家,便當,價格 from 購物車";
	    String line="";
	    response.setContentType("text/html;charset=utf-8");
	    PrintWriter out=response.getWriter();	       
	    
	    try{   //載入JDBC driver 
	            
	    	Class.forName(sDriver);
	    }
	    catch(Exception e){
	       
	    	out.print("<h1>無法載入驅動程式</h1>");
	        return;
	    }
	       
	    try   //建立資料連結和Statement物件
	    {
	        dbCon = DriverManager.getConnection(url,user,password);
	        stmt = dbCon.createStatement();
	        
	        
	    }
	    catch(SQLException e)
	    {
	        out.println("與資料來源連結錯誤");
	        return;
	    }
	    
	    String TotalMoney=request.getParameter("Test2");
	    String TotalFoods=request.getParameter("Test3");
	    String TotalNumber=request.getParameter("Test4");
	    String OrderNumber=request.getParameter("Test5");
	    String UserName=request.getParameter("Test6");
	    
	    
	    response.setContentType("text/html;charset=utf-8");
	    
	    String read="readonly";
	    String fontColorRed="red";
	    String fontColorOrange="#FF8C00";
	    String fontColorYellow="#FFFF00";
	    String fontColorGreen="Green";
	    String fontColorBlue="blue";
	    String fontColorDeepBlue="#473C8B";
	    String fontColorPurple="#7D26CD";
	    String fontColorCoffee="#8B5A00";
	    String fontColorDeepGreen="#008B00";
	    out.print("<SCRIPT language=javascript>function click() {if (event.button==2) {alert('你剛剛是不是右鍵了OAO~');}}document.onmousedown=click</SCRIPT>");
	    out.print("<style>");
	    out.print("legend {\r\n" + 
	    		"	font-size: 24px;\r\n" + 
	    		"	color: #E066FF;\r\n" + 
	    		"}");
	    out.print("fieldset {\r\n" + 
	    		"	border-width: 3px;\r\n" + 
	    		"	border-color: #EEB422;\r\n" + 
	    		"	width: 6.5cm;\r\n" + 
	    		"}");
	    out.print("</style>");
	    out.print("<body background=\"total2.png\">");
	    out.print("<center>");
	    out.print("<fieldset>");
	    out.print("<legend style=\"font-weight: bold;\">便當完成訂</legend>");
	    out.println("<h1>"+"<font color='"+fontColorBlue+"'>"+"總金額為"+TotalMoney+"元"+"</font>"+"</h1>");
	    out.println("<h2>"+"<font color='"+fontColorCoffee+"'>"+"總共點了一下餐點："+"</font>"+"</h2>");
	    out.print("<textarea cols='"+10+"' rows='"+10+"'"+"readonly='"+read+"' >");
	    out.print(TotalFoods);
	    out.print("</textarea>");
	    out.println("<h2>"+"<font color='"+fontColorDeepGreen+"'>"+"總共："+TotalNumber+"個餐點"+"</font>"+"</h2>");
	    out.println("<h2>"+"<font color='"+fontColorRed+"'>"+"感"+"</font>");
	    out.println("<font color='"+fontColorOrange+"'>"+"謝"+"</font>");
	    out.println("<font color='"+fontColorYellow+"'>"+"您"+"</font>");
	    out.println("<font color='"+fontColorGreen+"'>"+"的"+"</font>");
	    out.println("<font color='"+fontColorBlue+"'>"+"訂"+"</font>");
	    out.println("<font color='"+fontColorDeepBlue+"'>"+"餐"+"</font>");
	    out.println("<font color='"+fontColorPurple+"'>"+"！"+"</font>"+"</h2>");
	    out.print("<form name=\"myForm3\" method=\"get\" action=\"http://localhost:8080/TheProjectFor0612/MenuForJSP.jsp\">");
	    out.print("<input type=\"submit\" value=\"繼續下一攤\">");
	    out.print("</form>");
	    out.print("<form name=\"myForm4\" method=\"get\" action=\"http://localhost:8080/TheProjectFor0612/SMD2\" target=\"_blank\">");
	    out.print("<input type=\"submit\" value=\"訂餐詳細資訊\"> ");
	    out.print("<input type=\"hidden\" name=\"Test1\" id=\"Test1\" type=\"text\" readonly=\"readonly\" value='"+OrderNumber+"'>");
	    out.print("</form>");
	    out.print("<form name=\"myForm5\" method=\"get\" action=\"http://localhost:8080/TheProjectFor0612/SMD4\" target=\"_blank\">");
	    out.print("<input type=\"submit\" value=\"歷史訂餐資訊\"> ");
	    out.print("<input type=\"hidden\" name=\"Test2\" id=\"Test2\" type=\"text\" readonly=\"readonly\" value='"+UserName+"'>");
	    out.print("</form>");
	    out.print("</fieldset>");
	    out.print("</center>");
	    out.print("</body>");
	    out.print("<script>alert(\"如要修改訂餐請回購物車增加或刪減~\");</script>");
	    //out.print(TestForNumber);有接到
	    
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
