
import java.sql.*;

public class TestConnect01
{
    public static void main(String[] args)
    {
       Connection dbCon = null;
       Statement stmt = null;
       ResultSet rs = null;
       //臱笆祘Α把计
       String sDriver = "org.mariadb.jdbc.Driver";
       
       String user     = "root";
       String password = "1234";
       String url      = "jdbc:mariadb://localhost/test";
       
       try{   //更JDBC driver 
            
           Class.forName(sDriver);
       }
       catch(Exception e){
       
           System.out.println("礚猭更臱笆祘Α");
           return;
       }
       
       try{   
       
           dbCon = DriverManager.getConnection(url,user,password);
           stmt = dbCon.createStatement();
       }
       catch(SQLException e){
       
           System.out.println(e.getMessage());
           return;
       }
       
       try{ 
        
           rs = stmt.executeQuery("SELECT * FROM 潦ó");
           System.out.println("┍產"+'\t'+"獽讽"+"\t"+"基"+'\t');
           System.out.println("================================================"+
                              "==================================");                    
           while (rs.next())
           {
              System.out.printf("%-8s",rs.getString("┍產"));
              System.out.print("\t");
              System.out.printf("%-10s",rs.getString("獽讽"));
              System.out.print("\t");//フ
              System.out.print(rs.getString("基"));
              System.out.print("\n");//传︽
           }
       }
       catch(SQLException e){}
       
       try{
        
             stmt.close(); 
             dbCon.close(); 
       }
       catch( SQLException e ){}
    }
}
