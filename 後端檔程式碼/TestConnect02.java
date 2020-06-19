
import java.sql.*;

public class TestConnect02 {
    public static void main(String[] args) throws Exception
    {
       Connection dbCon = null;
       Statement stmt = null;
       //�X�ʵ{���Ѽ�
       
       String sDriver = "org.mariadb.jdbc.Driver";
       
       String user     = "root";
       String password = "1234";
       String url      = "jdbc:mariadb://localhost/test";
       
       try   //���JJDBC driver 
       {     
           Class.forName(sDriver);
       }
       catch(Exception e)
       {
           System.out.println("�L�k���J�X�ʵ{��");
           return;
       }
       
       try   //�إ߸�Ƴs���MStatement����
       {
           dbCon = DriverManager.getConnection(url,user,password);
           if (dbCon != null)
              System.out.println("�إ߸�ƨӷ��s�����\!");
           
           stmt = dbCon.createStatement();
		   //stmt = (Statement)dbCon.createStatement();
           if (stmt != null)
              System.out.println("�إ�Statement���󦨥\!");
       }
       catch(SQLException e)
       {
           System.out.println("�P��ƨӷ��s�����~: ");
           System.out.println(e.getMessage());
           if (dbCon != null)
           {
              try { dbCon.close(); }
              catch( SQLException e2 ) {}
           }
           return;
       }
       finally
       {
           try 
           { 
        	    stmt.close();
                dbCon.close(); 
           }
           catch( SQLException e ) {}

       }
    }
}
