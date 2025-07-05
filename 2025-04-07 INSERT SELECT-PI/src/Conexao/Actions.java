package Conexao;

import java.sql.Connection;

//
import java.sql.PreparedStatement;

// Para SELECT:
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static Conexao.ConexaoDB.fecharConexao;
import static Conexao.ConexaoDB.conectar;

public class Actions {
    public static void read(String table_name, String order_by) {
        String sql = "SELECT * FROM " + table_name + " " + (order_by == null ? "" : "ORDER BY " + order_by);
        Connection conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conexao = conectar();
            if(conexao != null) {
                ps = conexao.prepareStatement(sql);
                rs = ps.executeQuery();
                System.out.println("========== TABELA " + table_name + " ==========");
                while(rs.next()) {
                    ArrayList<String> rows = new ArrayList<>();
                    for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                        rows.add(rs.getString(i));
                    }
                    System.out.println(rows);
                }

                System.out.println("==================================");
                System.out.println("Tabela " + table_name + " iterada com sucesso.");
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


    // Adiciona registro na tabela Aluno
    public static void createAluno(String formacao_academica, String idioma_nivelamento, long fk_Usuario_usuario_id, long fk_Usuario_cpf) {
        String sql = "INSERT INTO aluno (formacao_academica, idioma_nivelamento, fk_Usuario_usuario_id, fk_Usuario_cpf) VALUES (?, ?, ?, ?)";
        Connection conexao = null;
        PreparedStatement ps = null;
        try {
            conexao = conectar();
            if(conexao != null) {
                ps = conexao.prepareStatement(sql);
                ps.setString(1, formacao_academica);
                ps.setString(2, idioma_nivelamento);
                ps.setLong(3, fk_Usuario_usuario_id);
                ps.setLong(4, fk_Usuario_cpf);
                int linhasAfetadas = ps.executeUpdate();
                if(linhasAfetadas > 0) {
                    System.out.println("Aluno inserido com sucesso!");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir aluno: " + ex.getMessage());
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


}
