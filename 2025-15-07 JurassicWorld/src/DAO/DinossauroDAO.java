package DAO;

import Model.Dinossauro;

import java.sql.*;
import java.util.*;

import static Conexao.ConexaoDB.conectar;


public class DinossauroDAO {

    public void setDino(Dinossauro dino) {
        String sql = "INSERT INTO dinossauros (nome, especie, dieta, idade_estimada, idade_dinossauro, status_cercado) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, dino.getNome());
            stmt.setString(2, dino.getEspecie());
            stmt.setString(3, dino.getDieta());
            stmt.setString(4, dino.getIdade_estimada_anos());
            stmt.setString(5, dino.getIdade_dinossauro());
            stmt.setString(6, dino.getStatus_cercado());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<Dinossauro> getDinos() {
        List<Dinossauro> lista = new ArrayList<>();
        String sql = "SELECT * FROM dinossauros ORDER BY";
        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Dinossauro d = new Dinossauro(
                        rs.getInt("id_dinossauro"),
                        rs.getString("nome"),
                        rs.getString("especie"),
                        rs.getString("dieta"),
                        rs.getString("idade_estimada"),
                        rs.getString("idade_dinossauro"),
                        rs.getString("status_cercado")
                );
                lista.add(d);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return lista;
    }

    public Dinossauro getDino(int id) {
        String sql = "SELECT * FROM dinossauros WHERE id_dinossauro = ?";
        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Dinossauro(
                            rs.getInt("id_dinossauro"),
                            rs.getString("nome"),
                            rs.getString("especie"),
                            rs.getString("dieta"),
                            rs.getString("idade_estimada"),
                            rs.getString("idade_dinossauro"),
                            rs.getString("status_cercado")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void updateDino(Dinossauro dino) {
        String sql = "UPDATE dinossauros SET nome = ?, especie = ?, dieta = ?, idade_estimada = ?, idade_dinossauro = ?, status_cercado = ? WHERE id_dinossauro = ?";
        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, dino.getNome());
            stmt.setString(2, dino.getEspecie());
            stmt.setString(3, dino.getDieta());
            stmt.setString(4, dino.getIdade_estimada_anos());
            stmt.setString(5, dino.getIdade_dinossauro());
            stmt.setString(6, dino.getStatus_cercado());
            stmt.setInt(7, dino.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteDino(int id) {
        String sql = "DELETE FROM dinossauros WHERE id_dinossauro = ?";
        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}


