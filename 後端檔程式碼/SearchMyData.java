

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
	    	getsql=request.getParameter("Test1");
	        String sql= "select * from �ʪ��� where �q��s��='"+getsql+"'";
	        rs = stmt.executeQuery(sql);
	        out.print("<body background=\"7eat.png\">");
	        out.print("<center><table border='8' width='300' bgcolor='"+"white"+"'><tr>");
	        out.print("<th><font color='"+fontColorOrange+"'>�\�I�s��</th><th><font color='"+fontColorBlue+"' >���a</th><th><font color='"+fontColorPurple+"' >�K��</th><th><font color='"+fontColorGold+"' >����</th></tr>");

	        while(rs.next())
	        {
	        	line="<tr><td align=center><font color='"+fontColorOrange+"' >";
	        	line=line+rs.getString("�\�I�s��")+"</td><td align=center><font color='"+fontColorBlue+"' >";
	        	line=line+rs.getString("���a")+"</td><td align=center><font color='"+fontColorPurple+"' >";
	        	line=line+rs.getString("�K��")+"</td><td align=center><font color='"+fontColorGold+"' >";
	        	line=line+rs.getString("����")+"</td></tr>";
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
