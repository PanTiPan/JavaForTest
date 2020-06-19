
import java.sql.*;

public class TestConnect01
{
    public static void main(String[] args)
    {
       Connection dbCon = null;
       Statement stmt = null;
       ResultSet rs = null;
       //�X�ʵ{���Ѽ�
       String sDriver = "org.mariadb.jdbc.Driver";
       
       String user     = "root";
       String password = "1234";
       String url      = "jdbc:mariadb://localhost/test";
       
       try{   //���JJDBC driver 
            
           Class.forName(sDriver);
       }
       catch(Exception e){
       
           System.out.println("�L�k���J�X�ʵ{��");
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
        
           rs = stmt.executeQuery("SELECT * FROM �ʪ���");
           System.out.println("���a"+'\t'+"�K��"+"\t"+"����"+'\t');
           System.out.println("================================================"+
                              "==================================");                    
           while (rs.next())
           {
              System.out.printf("%-8s",rs.getString("���a"));
              System.out.print("\t");
              System.out.printf("%-10s",rs.getString("�K��"));
              System.out.print("\t");//�ť�
              System.out.print(rs.getString("����"));
              System.out.print("\n");//����
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
