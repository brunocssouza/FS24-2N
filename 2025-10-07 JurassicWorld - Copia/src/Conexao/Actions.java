package Conexao;

import java.math.BigDecimal;
import java.sql.*;

//

// Para SELECT:
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
            if (conexao != null) {
                ps = conexao.prepareStatement(sql);
                rs = ps.executeQuery();
                System.out.println("========== TABELA " + table_name + " ==========");
                while (rs.next()) {
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
            System.out.println("Erro ao consultar a tabela: " + ex.getMessage());
        }
    }

    public static void createDinossauros(String nome, String dieta, int idade_estimada_anos, int idade_dinossauro, String status_cercado) {
        String sql = "INSERT INTO dinossauros (nome, dieta, idade_estimada_anos, idade_dinossauro, status_cercado) VALUES (?, ?, ?, ?, ?)";
        try (Connection conexao = conectar(); PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, nome);
            ps.setString(2, dieta);
            ps.setInt(3, idade_estimada_anos);
            ps.setInt(4, idade_dinossauro);
            ps.setString(5, status_cercado);
            int linhasAfetadas = ps.executeUpdate();
            if (linhasAfetadas > 0) System.out.println("Relação inserida com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir: " + ex.getMessage());
        }
    }

    public static void deleteDinossauro(int id_dinossauro) {
        String sql = "DELETE FROM dinossauros WHERE id_dinossauro = ?";
        try (Connection conexao = conectar(); PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, id_dinossauro);

            int linhasAfetadas = ps.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("SUCESSO: Registro com ID " + id_dinossauro + " removido.");
            } else {
                System.out.println("ERRO: Nenhum registro com ID " + id_dinossauro + " encontrado para remover.");
            }
        } catch (SQLException ex) {
            System.out.println("ERRO: Erro ao tentar remover registro com o ID: " + id_dinossauro);
        }
    }

    public static void updateDinossauro(int id_dinossauro, String novo_status_cercado) {
        String sql = "UPDATE dinossauros SET status_cercado = ? WHERE id_dinossauro = ?";
        try (Connection conexao = conectar(); PreparedStatement ps = conexao.prepareStatement(sql)) {

            ps.setString(1, novo_status_cercado);
            ps.setInt(2, id_dinossauro);

            int linhasAfetadas = ps.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("SUCESSO: Registro com ID " + id_dinossauro + " removido.");
            } else {
                System.out.println("ERRO: Nenhum registro com ID " + id_dinossauro + " encontrado para remover.");
            }
        } catch (SQLException ex) {
            System.out.println("ERRO: Erro ao tentar remover registro com o ID: " + id_dinossauro);
        }

    }
}
