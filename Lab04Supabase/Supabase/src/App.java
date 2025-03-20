import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.math.BigDecimal;

class Main{
    public static void main(String [] args) throws SQLException{
        read();
       
    }
    public static void read () throws SQLException{
        String url= "jdbc:postgresql://aws-0-us-west-1.pooler.supabase.com:6543/postgres?user=postgres.juhfgcqgpuzrhrbjtuee&password=Gbl@20240912";
        Connection c = DriverManager.getConnection(url);
        String sql  = "SELECT * FROM contas";
        PreparedStatement stm = c.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();

        while (rs.next()){
            long nro = rs.getLong("nro_conta");
            BigDecimal saldo = rs.getBigDecimal("saldo");
            System.out.println("numero da conta" + nro + "saldo " + saldo);



        }
        c.close();


    } 


}


