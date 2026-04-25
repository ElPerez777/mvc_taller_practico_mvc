package com.uniajc.dao;

import java.sql.*;
import java.util.*;
import com.uniajc.config.ConexionPostgresDatabase;
import com.uniajc.modelo.Docente;

//tested

public class DocenteDao {


    private static final String SCHEMA = "\"practica_mvc\"";

    public void guardar(Docente d) {
        String sql = "INSERT INTO " + SCHEMA + ".docentes (name, specialty) VALUES (?, ?)";
        try (Connection conn = ConexionPostgresDatabase.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, d.getNombre());
            ps.setString(2, d.getEspecialidad());
            ps.executeUpdate();
        } catch (SQLException ex) { ex.printStackTrace(); }
    }

    public List<Docente> obtenerTodos() {
        List<Docente> lista = new ArrayList<>();
        String sql = "SELECT id, name, specialty FROM " + SCHEMA + ".docentes ORDER BY id";
        try (Connection conn = ConexionPostgresDatabase.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Docente d = new Docente();
                d.setId(rs.getInt("id"));
                d.setNombre(rs.getString("name"));
                d.setEspecialidad(rs.getString("specialty"));
                lista.add(d);
            }
        } catch (SQLException ex) { ex.printStackTrace(); }
        return lista;
    }

    public Docente obtenerPorId(int id) {
        String sql = "SELECT id, name, specialty FROM " + SCHEMA + ".docentes WHERE id = ?";
        try (Connection conn = ConexionPostgresDatabase.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Docente d = new Docente();
                    d.setId(rs.getInt("id"));
                    d.setNombre(rs.getString("name"));
                    d.setEspecialidad(rs.getString("specialty"));
                    return d;
                }
            }
        } catch (SQLException ex) { ex.printStackTrace(); }
        return null;
    }

    public void actualizar(Docente d) {
        String sql = "UPDATE " + SCHEMA + ".docentes SET name=?, specialty=? WHERE id=?";
        try (Connection conn = ConexionPostgresDatabase.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, d.getNombre());
            ps.setString(2, d.getEspecialidad());
            ps.setInt(3, d.getId());
            ps.executeUpdate();
        } catch (SQLException ex) { ex.printStackTrace(); }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM " + SCHEMA + ".docentes WHERE id=?";
        try (Connection conn = ConexionPostgresDatabase.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) { ex.printStackTrace(); }
    }
}
