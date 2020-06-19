

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SMD2")
public class SearchMyData extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection dbCon = null;
	    Statement stmt = null;
	    ResultSet rs = null;
	    //驅動程式參數
	    String sDriver = "org.mariadb.jdbc.Driver";	       
	    String user     = "root";
	    String password = "1234";
	    String url      = "jdbc:mariadb://localhost/test";
	    //String sql      = "select * from 購物車 where 餐點編號='A001'";
	    String getsql="";
	    String line="";
	    String fontColorOrange="orange";
	    String fontColorBlue="blue";
	    String fontColorPurple="#EE00EE";
	    String fontColorGold="#EEC900";
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
	    try{ 
	    	getsql=request.getParameter("Test1");
	        String sql= "select * from 購物車 where 訂單編號='"+getsql+"'";
	        rs = stmt.executeQuery(sql);
	        out.print("<body background=\"7eat.png\">");
	        out.print("<center><table border='8' width='300' bgcolor='"+"white"+"'><tr>");
	        out.print("<th><font color='"+fontColorOrange+"'>餐點編號</th><th><font color='"+fontColorBlue+"' >店家</th><th><font color='"+fontColorPurple+"' >便當</th><th><font color='"+fontColorGold+"' >價格</th></tr>");

	        while(rs.next())
	        {
	        	line="<tr><td align=center><font color='"+fontColorOrange+"' >";
	        	line=line+rs.getString("餐點編號")+"</td><td align=center><font color='"+fontColorBlue+"' >";
	        	line=line+rs.getString("店家")+"</td><td align=center><font color='"+fontColorPurple+"' >";
	        	line=line+rs.getString("便當")+"</td><td align=center><font color='"+fontColorGold+"' >";
	        	line=line+rs.getString("價格")+"</td></tr>";
	        	out.print(line);
	        }
	        out.print("</table></center>");
	    }
	    catch(SQLException e){}
	    
	    try{	        
	    	stmt.close(); 
	        dbCon.close(); 
	    }
	    catch( SQLException e ){}
	       
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
