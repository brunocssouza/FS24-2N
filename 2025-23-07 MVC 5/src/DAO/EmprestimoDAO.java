package DAO;

import Model.Emprestimo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static Conexao.Conexao.conectar;
import static Conexao.Conexao.fecharConexao;

public class EmprestimoDAO {

    static Connection conexao = null;
    static PreparedStatement stmt = null;
    static ResultSet rs = null;

    public static void setEmprestimo(Emprestimo emprestimo) throws SQLException {
        String sql = "INSERT INTO emprestimo (data_emprestimo, data_devolucao, id_aluno, id_livro) VALUES (?,?,?,?)";

        try {
            conexao = conectar();
            if (conexao != null) {
                stmt = conexao.prepareStatement(sql);
                stmt.setString(1, emprestimo.getData_emprestimo());
                stmt.setString(2, emprestimo.getData_devolucao());
                stmt.setInt(3, emprestimo.getId_aluno());
                stmt.setInt(3, emprestimo.getId_livro());
                stmt.executeUpdate();
            }

        } finally {
            if (stmt != null) {
                stmt.close();
                fecharConexao(conexao);
            }
        }
    }

    public static ArrayList<Emprestimo> getEmprestimos() throws SQLException {
        String sql = "SELECT * FROM emprestimo";

        ArrayList<Emprestimo> emprestimos = new ArrayList<>();
        try {
            conexao = conectar();
            if (conexao != null) {
                stmt = conexao.prepareStatement(sql);
                rs = stmt.executeQuery();

                while (rs.next()) {
                    emprestimos.add(new Emprestimo(
                            rs.getInt("emprestimo_id"),
                            rs.getString("data_emprestimo"),
                            rs.getString("data_devolucao"),
                            rs.getInt("id_aluno"),
                            rs.getInt("id_livro")
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
        return emprestimos;
    }

//                                rs.getInt("emprestimo_id"),
//                                        rs.getString("data_emprestimo"),
//                                        rs.getString("data_devolucao"),
//                                        rs.getInt("Aluno_idaluno"),
//                                        rs.getInt("Livro_idlivro")
    public static void updateEmprestimo(Emprestimo emprestimo) throws SQLException {
        String sql = "UPDATE emprestimo SET " +
                "data_emprestimo = ?," +
                "data_devolucao = ?," +
                "id_aluno = ?," +
                "id_livro = ?" +
                "WHERE id_emprestimo = ?";

        try {
            conexao = conectar();
            if (conexao != null) {
                stmt = conexao.prepareStatement(sql);
                stmt.setString(1, emprestimo.getData_emprestimo());
                stmt.setString(2, emprestimo.getData_devolucao());
                stmt.setInt(3, emprestimo.getId_aluno());
                stmt.setInt(4, emprestimo.getId_livro());
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

    public static void deleteEmprestimo(int id) throws SQLException {
        String sql = "DELETE FROM emprestimo WHERE id_emprestimo = " + id;
        try {
            conexao = conectar();
            if (conexao != null) {
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
