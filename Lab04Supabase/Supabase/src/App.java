import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.math.BigDecimal;

class Main{
    public static void main(String [] args) throws SQLException{
        read();
        create();
        
        update();
        delete();
        
       
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
    public static void create()throws SQLException{
        System.out.print("Numero para a nova conta");
        long nro = Long.parseLong(System.console().readLine());
        System.out.print("saldo da nova conta:");
        BigDecimal saldo = new BigDecimal (System.console().readLine());
        String url = "jdbc:postgresql://aws-0-us-west-1.pooler.supabase.com:6543/postgres?user=postgres.juhfgcqgpuzrhrbjtuee&password=Gbl@20240912";
       
        Connection c = DriverManager.getConnection(url);
        String sql = "INSERT INTO contas VALUES (66768,2667.78)";
        PreparedStatement prepstm = c.prepareStatement(sql);
        prepstm.setLong(1,nro);
        prepstm.setBigDecimal(2,saldo);
        int ret = prepstm.executeUpdate();
        System.out.println("numero de registros inseridos" + ret);
        c.close();

    }



    public static void update() throws SQLException{
        System.out.print("Numero de uma conta ja existente");
        long nro= Long.parseLong(System.console().readLine());
        System.out.print("Novo saldo da conta");
        BigDecimal saldo = new BigDecimal (System.console().readLine());
        String url ="jdbc:postgresql://aws-0-us-west-1.pooler.supabase.com:6543/postgres?user=postgres.juhfgcqgpuzrhrbjtuee&password=Gbl@20240912";


        Connection c = DriverManager.getConnection(url);
        String sql = "UPDATE contas SET saldo = 33374  WHERE nro_conta=297406";
        PreparedStatement prepstm = c.prepareStatement(sql);
        prepstm.setBigDecimal(1,saldo);
        prepstm.setLong(2,nro);
        int ret = prepstm.executeUpdate();
        System.out.print("Numero de registros alterados" + ret);
        c.close();


    }

        public static void delete() throws SQLException{

            System.out.print("nmero de conta ja existente");
            long nro= Long.parseLong(System.console().readLine());
            String url = "jdbc:postgresql://aws-0-us-west-1.pooler.supabase.com:6543/postgres?user=postgres.juhfgcqgpuzrhrbjtuee&password=Gbl@20240912";
            Connection c = DriverManager.getConnection(url);
            String sql = "DELETE FROM contas WHERE nro_conta=297406";
            PreparedStatement prepstm = c.prepareStatement(sql);
            prepstm.setLong(1,nro);
            int ret = prepstm.executeUpdate();
            System.out.print("numero de contas apagadas" +ret);
            c.close();

        }
}


