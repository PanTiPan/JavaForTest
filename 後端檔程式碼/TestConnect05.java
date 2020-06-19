

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/TC5")
public class TestConnect05 extends HttpServlet {
	
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
	    String IDa=request.getParameter("mak");
	    String Namea=request.getParameter("GetFood");
	    String Pricea=request.getParameter("Get22");
	    String doDatabase=request.getParameter("Test");
	    String FoodNumber=request.getParameter("idFood");
	    String OrderNumber=request.getParameter("idOrder");
	    String TotalMoney=request.getParameter("Get");
	    //以下測試OK
//	    String IDa2="測試飯包";
//	    String Namea2="測試飯";
//	    String Pricea2="80";
	    
	    response.setContentType("text/html);charset=utf-8");
	    if(doDatabase.equals("1")) {
	    	try {
		    	String sql1= "INSERT into 購物車(訂單編號,餐點編號,店家,便當,價格) VALUES('"+OrderNumber+"','"+FoodNumber+"','"+IDa+"','"+Namea+"','"+Pricea+"')";
		    	//stmt.executeUpdate(sql1);
		    	stmt.executeUpdate(sql1);
		    	stmt.close();
		    	RequestDispatcher disp=request.getRequestDispatcher("MenuForJSP.jsp");
		    	disp.forward(request, response);
		    }catch(SQLException e)
		    {
		    	out.println("資料建立失敗");
		    	e.printStackTrace();
		    }
	    }else if(doDatabase.equals("2")){
	    	try {
		    	String sql1= "delete from 購物車  where 訂單編號='"+OrderNumber+"' and 餐點編號='"+FoodNumber+"'";
		    	//stmt.executeUpdate(sql1);
		    	stmt.executeUpdate(sql1);
		    	out.println("資料刪除成功");
		    	stmt.close();
		    	RequestDispatcher disp=request.getRequestDispatcher("MenuForJSP.jsp");
		    	disp.forward(request, response);
		    }catch(SQLException e)
		    {
		    	out.println("資料建立失敗");
		    	e.printStackTrace();
		    }
	    }
	    
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
