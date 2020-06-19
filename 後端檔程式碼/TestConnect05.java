

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
	    //�X�ʵ{���Ѽ�
	    String sDriver = "org.mariadb.jdbc.Driver";	       
	    String user     = "root";
	    String password = "1234";
	    String url      = "jdbc:mariadb://localhost/test";
	    String sql      = "select ���a,�K��,���� from �ʪ���";
	    String line="";
	    response.setContentType("text/html;charset=utf-8");
	    PrintWriter out=response.getWriter();	       
	    
	    try{   //���JJDBC driver 
	            
	    	Class.forName(sDriver);
	    }
	    catch(Exception e){
	       
	    	out.print("<h1>�L�k���J�X�ʵ{��</h1>");
	        return;
	    }
	       
	    try   //�إ߸�Ƴs���MStatement����
	    {
	        dbCon = DriverManager.getConnection(url,user,password);
	        stmt = dbCon.createStatement();
	        
	        
	    }
	    catch(SQLException e)
	    {
	        out.println("�P��ƨӷ��s�����~");
	        return;
	    }
	    String IDa=request.getParameter("mak");
	    String Namea=request.getParameter("GetFood");
	    String Pricea=request.getParameter("Get22");
	    String doDatabase=request.getParameter("Test");
	    String FoodNumber=request.getParameter("idFood");
	    String OrderNumber=request.getParameter("idOrder");
	    String TotalMoney=request.getParameter("Get");
	    //�H�U����OK
//	    String IDa2="���ն��]";
//	    String Namea2="���ն�";
//	    String Pricea2="80";
	    
	    response.setContentType("text/html);charset=utf-8");
	    if(doDatabase.equals("1")) {
	    	try {
		    	String sql1= "INSERT into �ʪ���(�q��s��,�\�I�s��,���a,�K��,����) VALUES('"+OrderNumber+"','"+FoodNumber+"','"+IDa+"','"+Namea+"','"+Pricea+"')";
		    	//stmt.executeUpdate(sql1);
		    	stmt.executeUpdate(sql1);
		    	stmt.close();
		    	RequestDispatcher disp=request.getRequestDispatcher("MenuForJSP.jsp");
		    	disp.forward(request, response);
		    }catch(SQLException e)
		    {
		    	out.println("��ƫإߥ���");
		    	e.printStackTrace();
		    }
	    }else if(doDatabase.equals("2")){
	    	try {
		    	String sql1= "delete from �ʪ���  where �q��s��='"+OrderNumber+"' and �\�I�s��='"+FoodNumber+"'";
		    	//stmt.executeUpdate(sql1);
		    	stmt.executeUpdate(sql1);
		    	out.println("��ƧR�����\");
		    	stmt.close();
		    	RequestDispatcher disp=request.getRequestDispatcher("MenuForJSP.jsp");
		    	disp.forward(request, response);
		    }catch(SQLException e)
		    {
		    	out.println("��ƫإߥ���");
		    	e.printStackTrace();
		    }
	    }
	    
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
