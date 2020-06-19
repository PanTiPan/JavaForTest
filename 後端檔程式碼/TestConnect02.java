
import java.sql.*;

public class TestConnect02 {
    public static void main(String[] args) throws Exception
    {
       Connection dbCon = null;
       Statement stmt = null;
       //驅動程式參數
       
       String sDriver = "org.mariadb.jdbc.Driver";
       
       String user     = "root";
       String password = "1234";
       String url      = "jdbc:mariadb://localhost/test";
       
       try   //載入JDBC driver 
       {     
           Class.forName(sDriver);
       }
       catch(Exception e)
       {
           System.out.println("無法載入驅動程式");
           return;
       }
       
       try   //建立資料連結和Statement物件
       {
           dbCon = DriverManager.getConnection(url,user,password);
           if (dbCon != null)
              System.out.println("建立資料來源連結成功!");
           
           stmt = dbCon.createStatement();
		   //stmt = (Statement)dbCon.createStatement();
           if (stmt != null)
              System.out.println("建立Statement物件成功!");
       }
       catch(SQLException e)
       {
           System.out.println("與資料來源連結錯誤: ");
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
