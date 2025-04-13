import java.sql.*;
import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static final String URL = "jdbc:postgresql://aws-0-us-west-1.pooler.supabase.com:6543/postgres?user=postgres.juhfgcqgpuzrhrbjtuee&password=Gbl@20240912";

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        read();

        create(scanner);
        update(scanner);
        delete(scanner);
    }

    public static void read() throws SQLException {
        Connection c = DriverManager.getConnection(URL);
        String sql = "SELECT * FROM contas";
        PreparedStatement stm = c.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();

        while (rs.next()) {
            long nro = rs.getLong("nro_conta");
            BigDecimal saldo = rs.getBigDecimal("saldo");
            System.out.println("Número da conta: " + nro + " | Saldo: " + saldo);
        }
        c.close();
    }

    public static void create(Scanner scanner) throws SQLException {
        System.out.print("Número para a nova conta: ");
        long nro = Long.parseLong(scanner.nextLine());

        System.out.print("Saldo da nova conta: ");
        BigDecimal saldo = new BigDecimal(scanner.nextLine());

        Connection c = DriverManager.getConnection(URL);
        String sql = "INSERT INTO contas (nro_conta, saldo) VALUES (?, ?)";
        PreparedStatement prepstm = c.prepareStatement(sql);
        prepstm.setLong(1, nro);
        prepstm.setBigDecimal(2, saldo);
        int ret = prepstm.executeUpdate();
        System.out.println("Número de registros inseridos: " + ret);
        c.close();
    }

    public static void update(Scanner scanner) throws SQLException {
        System.out.print("Número de uma conta existente: ");
        long nro = Long.parseLong(scanner.nextLine());

        System.out.print("Novo saldo da conta: ");
        BigDecimal saldo = new BigDecimal(scanner.nextLine());

        Connection c = DriverManager.getConnection(URL);
        String sql = "UPDATE contas SET saldo = ? WHERE nro_conta = ?";
        PreparedStatement prepstm = c.prepareStatement(sql);
        prepstm.setBigDecimal(1, saldo);
        prepstm.setLong(2, nro);
        int ret = prepstm.executeUpdate();
        System.out.println("Número de registros alterados: " + ret);
        c.close();
    }

    public static void delete(Scanner scanner) throws SQLException {
        System.out.print("Número da conta a ser apagada: ");
        long nro = Long.parseLong(scanner.nextLine());

        Connection c = DriverManager.getConnection(URL);
        String sql = "DELETE FROM contas WHERE nro_conta = ?";
        PreparedStatement prepstm = c.prepareStatement(sql);
        prepstm.setLong(1, nro);
        int ret = prepstm.executeUpdate();
        System.out.println("Número de contas apagadas: " + ret);
        c.close();
    }
}

