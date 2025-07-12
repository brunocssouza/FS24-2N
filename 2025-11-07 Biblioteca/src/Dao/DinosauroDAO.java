package Dao;

import Model.Dinossauro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static Conexao.ConexaoDB.conectar;

public class DinosauroDAO {
    public void setDino(Dinossauro dinossauro) {
        String sql = "INSERT INTO dinossauro (nome, especie, dieta, idade_estimdada_anos, idade_dinossauro, status_cercado) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conexao = conectar(); PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, dinossauro.getNome());
            ps.setString(2, dinossauro.getEspecie());
            ps.setString(3, dinossauro.getIdade_estimada_anos());
            ps.setInt(4, dinossauro.getIdade_dinossauro());
            ps.setString(5, dinossauro.getStatus_cercado());

            int linhasAfetadas = ps.executeUpdate();
            if (linhasAfetadas > 0) System.out.println("Relação inserida com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }






}

