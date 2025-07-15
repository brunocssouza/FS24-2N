package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConexaoDB {
    private static final String URL = "jdbc:mysql://localhost:5432/JurassicWorld";
    private static final String USUARIO = "root";
    private static final String SENHA = "postgres";

    public static Connection conectar() {
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("Conexão com o banco de dados estabelecida com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao conectar com o bd: " + e.getMessage());
        }
        return conexao;
    }

    public static void fecharConexao(Connection conexao) {
        if (conexao != null) {
            try {
                conexao.close();
                System.out.println("Conexão com o bd fechada!");

            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão com o bd: " + e.getMessage());
            }
        }
    }
}