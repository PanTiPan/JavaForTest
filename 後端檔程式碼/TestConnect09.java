

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
	    //�X�ʵ{���Ѽ�
	    String sDriver = "org.mariadb.jdbc.Driver";	       
	    String user     = "root";
	    String password = "1234";
	    String url      = "jdbc:mariadb://localhost/test";
	    //String sql      = "select * from �ʪ��� where �\�I�s��='A001'";
	    String getsql="";
	    String line="";
	    String fontColorOrange="orange";
	    String fontColorBlue="blue";
	    String fontColorPurple="#EE00EE";
	    String fontColorGold="#EEC900";
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
	    try{ 
	    	
	    	String username=request.getParameter("username");
	    	String passwd=request.getParameter("passwd");
	    	String email=request.getParameter("email");
	    	String phone=request.getParameter("phone");
	    	//String username="111";
	    	//String passwd="11111";
	        String sql= "select * from �b���K�X where �ϥΪ�ID='"+username+"'";
	        rs = stmt.executeQuery(sql);
	        out.print("<body background=\"7eat.png\">");
	        
	        while(rs.next())
	        {
	        	line=line+rs.getString("�ϥΪ�ID");
	        	
	        }
	        int line2=line.length();
	        if(line2!=0) {
	        	try {
			    	String sql1= "UPDATE �b���K�X SET �ϥΪ̱K�X='"+passwd+"',�ϥΪ̶l�c='"+email+"',�ϥΪ̹q��='"+phone+"' WHERE �ϥΪ�ID='"+username+"'";
			    	stmt.executeUpdate(sql1);
			    	stmt.close();
			    	RequestDispatcher disp=request.getRequestDispatcher("Yes3.jsp");
			    	disp.forward(request, response);
			    }catch(SQLException e)
			    {
			    	out.println("��ƫإߥ���");
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
