

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/TC4")
public class TestConnect04 extends HttpServlet {
	
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
	    out.println(IDa);
	    out.println(Namea);
	    out.println(Pricea);
	    //�H�U����OK
//	    String IDa2="���ն��]";
//	    String Namea2="���ն�";
//	    String Pricea2="80";
	    
	    response.setContentType("text/html);charset=utf-8");
	    try {
	    	String sql1= "delete from �ʪ���  where ���a='4' or ���a='3' or ����='4'";
	    	//stmt.executeUpdate(sql1);
	    	stmt.executeUpdate(sql1);
	    	out.println("��ƧR�����\");
	    	stmt.close();
	    }catch(SQLException e)
	    {
	    	out.println("��ƫإߥ���");
	    	e.printStackTrace();
	    }
	    
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
