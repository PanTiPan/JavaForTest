

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/TC9")
public class TestConnect09 extends HttpServlet {
	
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
	    	
	    	String username=request.getParameter("username");
	    	String passwd=request.getParameter("passwd");
	    	String email=request.getParameter("email");
	    	String phone=request.getParameter("phone");
	    	//String username="111";
	    	//String passwd="11111";
	        String sql= "select * from 帳號密碼 where 使用者ID='"+username+"'";
	        rs = stmt.executeQuery(sql);
	        out.print("<body background=\"7eat.png\">");
	        
	        while(rs.next())
	        {
	        	line=line+rs.getString("使用者ID");
	        	
	        }
	        int line2=line.length();
	        if(line2!=0) {
	        	try {
			    	String sql1= "UPDATE 帳號密碼 SET 使用者密碼='"+passwd+"',使用者郵箱='"+email+"',使用者電話='"+phone+"' WHERE 使用者ID='"+username+"'";
			    	stmt.executeUpdate(sql1);
			    	stmt.close();
			    	RequestDispatcher disp=request.getRequestDispatcher("Yes3.jsp");
			    	disp.forward(request, response);
			    }catch(SQLException e)
			    {
			    	out.println("資料建立失敗");
			    	e.printStackTrace();
			    }
	        }else {
	        	RequestDispatcher disp=request.getRequestDispatcher("Not.jsp");
		    	disp.forward(request, response);
	        }
	        
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
