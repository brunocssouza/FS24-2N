package DAO;

import Model.Dinossauro;

import java.sql.*;
import java.util.*;

import static Conexao.ConexaoDB.conectar;


public class DinossauroDAO {

    public static void setDino(Dinossauro dino) {
        String sql = "INSERT INTO dinossauros (nome, especie, dieta, idade_estimada_anos, idade_dinossauro, status_cercado) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, dino.getNome());
            stmt.setString(2, dino.getEspecie());
            stmt.setString(3, dino.getDieta());
            stmt.setString(4, dino.getIdade_estimada_anos());
            stmt.setString(5, dino.getIdade_dinossauro());
            stmt.setString(6, dino.getStatus_cercado());
            System.out.println("Inseriu dado");
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static List<Dinossauro> getDinos() {
        List<Dinossauro> lista = new ArrayList<>();
        String sql = "SELECT * FROM dinossauros";
        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Dinossauro d = new Dinossauro(
                        rs.getInt("id_dinossauro"),
                        rs.getString("nome"),
                        rs.getString("especie"),
                        rs.getString("dieta"),
                        rs.getString("idade_estimada_anos"),
                        rs.getString("idade_dinossauro"),
                        rs.getString("status_cercado")
                );
                lista.add(d);
            }
            System.out.println(lista);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return lista;
    }

    public static void listarPorStatus(String status) {
        List<Dinossauro> lista = new ArrayList<>();
        String sql = "SELECT * FROM dinossauros WHERE status_cercado = ? ORDER BY nome";
        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, status);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Dinossauro d = new Dinossauro(
                        rs.getInt("id_dinossauro"),
                        rs.getString("nome"),
                        rs.getString("especie"),
                        rs.getString("dieta"),
                        rs.getString("idade_estimada_anos"),
                        rs.getString("idade_dinossauro"),
                        rs.getString("status_cercado")
                );
                lista.add(d);
            }
            for(Dinossauro d: lista) {
                System.out.println("ID: "+ d.getId() +" | NOME: "+ d.getNome() +" | DIETA: "+ d.getDieta() +" | ESPECIE: "+ d.getEspecie() +" | IDADE: "+ d.getIdade_dinossauro() +" | IDADE ESTIMADA: "+ d.getIdade_estimada_anos() +" | STATUS: "+ d.getStatus_cercado());
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void listarPorDieta(String dieta) {
        List<Dinossauro> lista = new ArrayList<>();
        String sql = "SELECT * FROM dinossauros WHERE dieta = ?";
        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, dieta);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Dinossauro d = new Dinossauro(
                        rs.getInt("id_dinossauro"),
                        rs.getString("nome"),
                        rs.getString("especie"),
                        rs.getString("dieta"),
                        rs.getString("idade_estimada_anos"),
                        rs.getString("idade_dinossauro"),
                        rs.getString("status_cercado")
                );
                lista.add(d);
            }
            for(Dinossauro d: lista) {
                System.out.println("ID: "+ d.getId() +" | NOME: "+ d.getNome() +" | DIETA: "+ d.getDieta() +" | ESPECIE: "+ d.getEspecie() +" | IDADE: "+ d.getIdade_dinossauro() +" | IDADE ESTIMADA: "+ d.getIdade_estimada_anos() +" | STATUS: "+ d.getStatus_cercado());
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static List<Dinossauro> listarTodos() {
        List<Dinossauro> lista = new ArrayList<>();
        String sql = "SELECT * FROM dinossauros";
        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Dinossauro d = new Dinossauro(
                        rs.getInt("id_dinossauro"),
                        rs.getString("nome"),
                        rs.getString("especie"),
                        rs.getString("dieta"),
                        rs.getString("idade_estimada_anos"),
                        rs.getString("idade_dinossauro"),
                        rs.getString("status_cercado")
                );
                lista.add(d);
            }
            System.out.println("Lista de dinossauros:");
            for(Dinossauro d: lista) {
                System.out.println("ID: "+ d.getId() +" | NOME: "+ d.getNome() +" | DIETA: "+ d.getDieta() +" | ESPECIE: "+ d.getEspecie() +" | IDADE: "+ d.getIdade_dinossauro() +" | IDADE ESTIMADA: "+ d.getIdade_estimada_anos() +" | STATUS: "+ d.getStatus_cercado());
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return lista;
    }

    public static Dinossauro getDino(int id) {
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
                            rs.getString("idade_estimada_anos"),
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

    public static void updateDino(Dinossauro dino) {
        String sql = "UPDATE dinossauros SET nome = ?, especie = ?, dieta = ?, idade_estimada_anos = ?, idade_dinossauro = ?, status_cercado = ? WHERE id_dinossauro = ?";
        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, dino.getNome());
            stmt.setString(2, dino.getEspecie());
            stmt.setString(3, dino.getDieta());
            stmt.setString(4, dino.getIdade_estimada_anos());
            stmt.setString(5, dino.getIdade_dinossauro());
            stmt.setString(6, dino.getStatus_cercado());
            stmt.setInt(7, dino.getId());
            stmt.executeUpdate();
            System.out.println("Dado atualizado");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void deleteDino(int id) {
        String sql = "DELETE FROM dinossauros WHERE id_dinossauro = ?";
        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Dado deletado");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}


