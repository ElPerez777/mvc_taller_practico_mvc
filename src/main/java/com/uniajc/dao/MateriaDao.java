package com.uniajc.dao;

import java.sql.*;
import java.util.*;
import com.uniajc.config.ConexionPostgresDatabase;
import com.uniajc.modelo.Materia;

//tested

public class MateriaDao {

    private static final String SCHEMA = "\"practica_mvc\"";

    public void guardar(Materia m) {
        String sql = "INSERT INTO " + SCHEMA + ".materias (subject_name, credits) VALUES (?, ?)";
        try (Connection conn = ConexionPostgresDatabase.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, m.getNombreMateria());
            ps.setInt(2, m.getCreditos());
            ps.executeUpdate();
        } catch (SQLException ex) { ex.printStackTrace(); }
    }

    public List<Materia> obtenerTodas() {
        List<Materia> lista = new ArrayList<>();
        String sql = "SELECT id, subject_name, credits FROM " + SCHEMA + ".materias ORDER BY id";
        try (Connection conn = ConexionPostgresDatabase.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Materia m = new Materia();
                m.setId(rs.getInt("id"));
                m.setNombreMateria(rs.getString("subject_name"));
                m.setCreditos(rs.getInt("credits"));
                lista.add(m);
            }
        } catch (SQLException ex) { ex.printStackTrace(); }
        return lista;
    }

    public Materia obtenerPorId(int id) {
        String sql = "SELECT id, subject_name, credits FROM " + SCHEMA + ".materias WHERE id = ?";
        try (Connection conn = ConexionPostgresDatabase.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Materia m = new Materia();
                    m.setId(rs.getInt("id"));
                    m.setNombreMateria(rs.getString("subject_name"));
                    m.setCreditos(rs.getInt("credits"));
                    return m;
                }
            }
        } catch (SQLException ex) { ex.printStackTrace(); }
        return null;
    }

    public void actualizar(Materia m) {
        String sql = "UPDATE " + SCHEMA + ".materias SET subject_name=?, credits=? WHERE id=?";
        try (Connection conn = ConexionPostgresDatabase.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, m.getNombreMateria());
            ps.setInt(2, m.getCreditos());
            ps.setInt(3, m.getId());
            ps.executeUpdate();
        } catch (SQLException ex) { ex.printStackTrace(); }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM " + SCHEMA + ".materias WHERE id=?";
        try (Connection conn = ConexionPostgresDatabase.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) { ex.printStackTrace(); }
    }
}
