package DAO;

import Model.Aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static Conexao.Conexao.conectar;
import static Conexao.Conexao.fecharConexao;

public class AlunoDAO {

    static Connection conexao = null;
    static PreparedStatement stmt = null;
    static ResultSet rs = null;

    public static void setAluno(Aluno aluno) throws SQLException {
        String sql = "INSERT INTO aluno (nome, idade, telefone) VALUES (?,?,?)";

        try {
            conexao = conectar();
            if (conexao != null) {
                stmt = conexao.prepareStatement(sql);
                stmt.setString(1, aluno.getNome());
                stmt.setInt(2, aluno.getIdade());
                stmt.setString(3, aluno.getTelefone());
                stmt.executeUpdate();
            }

        } finally {
            if (stmt != null) {
                stmt.close();
                fecharConexao(conexao);
            }
        }
    }

    public static ArrayList<Aluno> getAlunos() throws SQLException {
        String sql = "SELECT * FROM aluno";

        ArrayList<Aluno> alunos = new ArrayList<>();
        try {
            conexao = conectar();
            if (conexao != null) {
                stmt = conexao.prepareStatement(sql);
                rs = stmt.executeQuery();

                while (rs.next()) {
                    alunos.add(new Aluno(
                            rs.getInt("id_aluno"),
                            rs.getString("nome"),
                            rs.getInt("idade"),
                            rs.getString("telefone")
                    ));
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro");
        } finally {
            if (stmt != null) {
                stmt.close();
                fecharConexao(conexao);
            }
        }
        return alunos;
    }

    public static void updateAluno(Aluno aluno) throws SQLException {
        String sql = "UPDATE aluno SET " +
                "nome = ?," +
                "idade = ?," +
                "telefone = ?" +
                "WHERE id_aluno = ?";

        try {
            conexao = conectar();
            if (conexao != null) {
                stmt = conexao.prepareStatement(sql);
                stmt.setString(1, aluno.getNome());
                stmt.setInt(2, aluno.getIdade());
                stmt.setString(3, aluno.getTelefone());
                stmt.setInt(4, aluno.getId_aluno());
                stmt.executeUpdate();
            }

        } catch (SQLException e) {
            System.err.println(e);

        } finally {
            if (stmt != null) {
                stmt.close();
                fecharConexao(conexao);
            }
        }
    }

    public static void deleteAluno(int id) throws SQLException {
        String sql = "DELETE FROM aluno WHERE id_aluno = " + id;
        try {
        conexao = conectar();
        if(conexao != null) {
            stmt = conexao.prepareStatement(sql);
            stmt.executeUpdate();
        }
        } catch (SQLException e) {
            System.err.println(e);

        } finally {
            if (stmt != null) {
                stmt.close();
                fecharConexao(conexao);
            }
        }
    }
}
