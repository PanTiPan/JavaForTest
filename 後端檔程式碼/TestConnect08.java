

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/TC8")
public class TestConnect08 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Connection dbCon = null;
	    Statement stmt = null;
	    ResultSet rs = null;
	    ResultSet rs1 = null;
	    ResultSet rs2 = null;
	    ResultSet rs3 = null;
	    ResultSet rs4 = null;
	    //�X�ʵ{���Ѽ�
	    String sDriver = "org.mariadb.jdbc.Driver";	       
	    String user     = "root";
	    String password = "1234";
	    String url      = "jdbc:mariadb://localhost/test";
	    //String sql      = "select * from �ʪ��� where �\�I�s��='A001'";
	    String getsql="";
	    String line="";
	    String line3="";
	    String line4="";
	    String line5="";
	    String line6="";
	    String line7="";
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
	        String sql= "select * from �b���K�X where �ϥΪ�ID='"+username+"'";
	        String sql1= "select * from �b���K�X where �ϥΪ̱K�X='"+passwd+"'";
	        String sql2= "select * from �b���K�X where �ϥΪ�ID='"+username+"' and �ϥΪ̱K�X='"+passwd+"'";
	        rs = stmt.executeQuery(sql);
	        rs1 = stmt.executeQuery(sql2);
	        rs2 = stmt.executeQuery(sql1);
	        out.print("<body background=\"7eat.png\">");
	        
	        while(rs.next())
	        {
	        	line=line+rs.getString("�ϥΪ�ID");
	        	
	        }
	        while(rs1.next())
	        {
	        	line3=line3+rs1.getString("�ϥΪ�ID");
	        	line4=line4+rs1.getString("�ϥΪ̱K�X");
	        }
	        while(rs2.next())
	        {
	        	line5=line5+rs2.getString("�ϥΪ̱K�X");
	        	
	        }
	        int line2=line.length();
	        int getlength=line3.length();
	        int getlength1=line4.length();
	        //int getlength2=line5.length();
	        if(line2==0) {
	        	RequestDispatcher disp=request.getRequestDispatcher("Not3.jsp");
		    	disp.forward(request, response);
	        }else if(line.equals("ROOT")&passwd.equals("1234")){
	        	RequestDispatcher disp=request.getRequestDispatcher("Control.jsp");
		    	disp.forward(request, response);
	        }else if(getlength!=0&getlength1!=0){
	        	//request.setAttribute("username",username);
	        	String sql3= "select �ϥΪ̶l�c from �b���K�X where �ϥΪ�ID='"+username+"' and �ϥΪ̱K�X='"+passwd+"'";
	        	rs3 = stmt.executeQuery(sql3);
	        	while(rs3.next())
		        {
		        	line6=line6+rs3.getString("�ϥΪ̶l�c");
		        	
		        }
	        	String sql4= "select �ϥΪ̹q�� from �b���K�X where �ϥΪ�ID='"+username+"' and �ϥΪ̱K�X='"+passwd+"'";
	        	rs4 = stmt.executeQuery(sql4);
	        	while(rs4.next())
		        {
		        	line7=line7+rs4.getString("�ϥΪ̹q��");
		        	
		        }
	        	session.setAttribute("username", username);
	        	session.setAttribute("passwd", passwd);
	        	session.setAttribute("email", line6);
	        	session.setAttribute("phone", line7);
	        	RequestDispatcher disp=request.getRequestDispatcher("Yes2.jsp");
		    	disp.forward(request, response);
	        }else {
	        	RequestDispatcher disp=request.getRequestDispatcher("Not2.jsp");
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
