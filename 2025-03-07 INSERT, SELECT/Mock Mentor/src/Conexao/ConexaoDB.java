package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {
    private static final String URL = "jdbc:mysql://localhost:3306/mockmentor";
    private static final String USER = "root";
    private static final String PASS = "root";

    public static Connection conectar() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conectado com sucesso!");
        } catch(SQLException e) {
            System.err.println("Erro ao conectar ao Banco de Dados!" + e.getMessage());
        }
        return con;
    }

    public static void desconectar(Connection con) {
        if (con != null) {
            try {
                con.close();
                System.out.println("Fechado com sucesso!");
            } catch(SQLException e) {
                System.err.println("Erro ao fechar a conexão!" + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        Connection con = ConexaoDB.conectar();
        if (con != null) {
            ConexaoDB.desconectar(con);
        }
    }
}
