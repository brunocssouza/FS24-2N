package Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static Conexao.ConexaoDB.fecharConexao;
import static Conexao.ConexaoDB.conectar;

public class Actions {

    // Adiciona registro na tabela Aluno
    public static void createAluno(String nome, int idade) {
        String sql = "INSERT INTO aluno (nome, idade) VALUES (?, ?)";
        Connection conexao = null;
        PreparedStatement ps = null;
        try {
            conexao = conectar();
            if(conexao != null) {
                ps = conexao.prepareStatement(sql);
                ps.setString(1, nome);
                ps.setInt(2, idade);
                int linhasAfetadas = ps.executeUpdate();
                if(linhasAfetadas > 0) {
                    System.out.println("Aluno " + nome + " inserido com sucesso!");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir aluno!" + ex.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conexao != null) {
                    fecharConexao(conexao);
                    }
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar recursos após inserção: " + ex.getMessage());
            }
        }
    }

    public static void getAlunos() {
        String sql = "SELECT * FROM aluno ORDER BY id_aluno";
        Connection conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conexao = conectar();
            if(conexao != null) {
                ps = conexao.prepareStatement(sql);
                rs = ps.executeQuery();
                System.out.println("========== TABELA ALUNOS ==========");
                while(rs.next()) {
                    int id = rs.getInt("id_aluno");
                    String nome = rs.getString("nome");
                    int idade = rs.getInt("idade");
                    System.out.println(id + " - " + nome + " - " + idade);
                }
                System.out.println("==================================");
                System.out.println("Tabela Alunos iterada com sucesso.");
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar a tabela Alunos: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {rs.close();}
                if (ps != null) {ps.close();}
                if (conexao != null) {fecharConexao(conexao);}
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar recursos: " + ex.getMessage());
            }
        }
    }
}
