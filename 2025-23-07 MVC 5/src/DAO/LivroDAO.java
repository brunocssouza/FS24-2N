package DAO;

import Model.Livro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static Conexao.Conexao.conectar;
import static Conexao.Conexao.fecharConexao;

public class LivroDAO {

    static Connection conexao = null;
    static PreparedStatement stmt = null;
    static ResultSet rs = null;

    public static void setLivro(Livro livro) throws SQLException {
        String sql = "INSERT INTO livro (isbn, titulo, autor, genero) VALUES (?,?,?,?,?)";

        try {
            conexao = conectar();
            if (conexao != null) {
                stmt = conexao.prepareStatement(sql);
                stmt.setString(1, livro.getIsbn());
                stmt.setString(2, livro.getTitulo());
                stmt.setString(3, livro.getAutor());
                stmt.setString(4, livro.getGenero());
                stmt.executeUpdate();
            }

        } finally {
            if (stmt != null) {
                stmt.close();
                fecharConexao(conexao);
            }
        }
    }

    public static ArrayList<Livro> getLivros() throws SQLException {
        String sql = "SELECT * FROM livro";

        ArrayList<Livro> livros = new ArrayList<>();
        try {
            conexao = conectar();
            if (conexao != null) {
                stmt = conexao.prepareStatement(sql);
                rs = stmt.executeQuery();

                while (rs.next()) {
                    livros.add(new Livro(
                            rs.getInt("id_livro"),
                            rs.getString("isbn"),
                            rs.getString("titulo"),
                            rs.getString("autor"),
                            rs.getString("genero")
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
        return livros;
    }

    public static void updateLivro(Livro livro) throws SQLException {
        String sql = "UPDATE livro SET " +
                "isbn = ?," +
                "titulo = ?," +
                "autor = ?," +
                "genero = ?" +
                "WHERE id_livro = ?";

        try {
            conexao = conectar();
            if (conexao != null) {
                stmt = conexao.prepareStatement(sql);
                stmt.setString(1, livro.getIsbn());
                stmt.setString(2, livro.getTitulo());
                stmt.setString(3, livro.getAutor());
                stmt.setString(4, livro.getGenero());
                stmt.setInt(5, livro.getId_livro());
                stmt.executeUpdate();
            }

        } finally {
            if (stmt != null) {
                stmt.close();
                fecharConexao(conexao);
            }
        }
    }

    public static void deleteLivro(int id) throws SQLException {
        String sql = "DELETE FROM livro WHERE id_livro = " + id;

        try {
            conexao = conectar();
            if (conexao != null) {
                stmt = conexao.prepareStatement(sql);
                stmt.executeUpdate();
            }
        } finally {
            if (stmt != null) {
                stmt.close();
                fecharConexao(conexao);
            }
        }
    }
}
