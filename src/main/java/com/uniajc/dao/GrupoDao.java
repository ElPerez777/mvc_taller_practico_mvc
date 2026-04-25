package com.uniajc.dao;

import java.sql.*;
import java.util.*;
import com.uniajc.config.ConexionPostgresDatabase;
import com.uniajc.modelo.Grupo;


//tested
public class GrupoDao {

    private static final String SCHEMA = "\"practica_mvc\"";

    public void guardar(Grupo g) {
        String sql = "INSERT INTO " + SCHEMA + ".grupos (subject_id, teacher_id, classroom, schedule) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionPostgresDatabase.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, g.getIdMateria());
            ps.setInt(2, g.getIdDocente());
            ps.setString(3, g.getAula());
            ps.setString(4, g.getHorario());
            ps.executeUpdate();
        } catch (SQLException ex) { ex.printStackTrace(); }
    }

    public List<Grupo> obtenerTodos() {
        List<Grupo> lista = new ArrayList<>();
        String sql = "SELECT id, subject_id, teacher_id, classroom, schedule FROM " + SCHEMA + ".grupos ORDER BY id";
        try (Connection conn = ConexionPostgresDatabase.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Grupo g = new Grupo();
                g.setId(rs.getInt("id"));
                g.setIdMateria(rs.getInt("subject_id"));
                g.setIdDocente(rs.getInt("teacher_id"));
                g.setAula(rs.getString("classroom"));
                g.setHorario(rs.getString("schedule"));
                lista.add(g);
            }
        } catch (SQLException ex) { ex.printStackTrace(); }
        return lista;
    }

    public Grupo obtenerPorId(int id) {
        String sql = "SELECT id, subject_id, teacher_id, classroom, schedule FROM " + SCHEMA + ".grupos WHERE id = ?";
        try (Connection conn = ConexionPostgresDatabase.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Grupo g = new Grupo();
                    g.setId(rs.getInt("id"));
                    g.setIdMateria(rs.getInt("subject_id"));
                    g.setIdDocente(rs.getInt("teacher_id"));
                    g.setAula(rs.getString("classroom"));
                    g.setHorario(rs.getString("schedule"));
                    return g;
                }
            }
        } catch (SQLException ex) { ex.printStackTrace(); }
        return null;
    }

    public void actualizar(Grupo g) {
        String sql = "UPDATE " + SCHEMA + ".grupos SET subject_id=?, teacher_id=?, classroom=?, schedule=? WHERE id=?";
        try (Connection conn = ConexionPostgresDatabase.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, g.getIdMateria());
            ps.setInt(2, g.getIdDocente());
            ps.setString(3, g.getAula());
            ps.setString(4, g.getHorario());
            ps.setInt(5, g.getId());
            ps.executeUpdate();
        } catch (SQLException ex) { ex.printStackTrace(); }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM " + SCHEMA + ".grupos WHERE id=?";
        try (Connection conn = ConexionPostgresDatabase.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) { ex.printStackTrace(); }
    }
}
