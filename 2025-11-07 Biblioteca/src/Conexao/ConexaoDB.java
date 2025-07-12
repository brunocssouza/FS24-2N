package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {
    private static final String URL = "jdbc:mysql://localhost:3306/jurassicworld";
    private static final String USER = "root";
    private static final String PASS = "root";

    public static Connection conectar() {
        Connection conexao = null;
        try {
            conexao= DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conectado com sucesso!");
        } catch(SQLException e) {
            System.err.println("Erro ao conectar ao Banco de Dados!" + e.getMessage());
        }
        return conexao;
    }

    public static void fecharConexao(Connection conexao) {
        if (conexao != null) {
            try {
                conexao.close();
                System.out.println("Fechado com sucesso!");
            } catch(SQLException e) {
                System.err.println("Erro ao fechar a conexão!" + e.getMessage());
            }
        }
    }

}

