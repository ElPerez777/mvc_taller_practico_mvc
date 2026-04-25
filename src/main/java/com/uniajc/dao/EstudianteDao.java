package com.uniajc.dao;

import java.sql.*;
import java.util.*;
import com.uniajc.config.ConexionPostgresDatabase;
import com.uniajc.modelo.Estudiante;

public class EstudianteDao {

    // ✅ SIN comillas (PostgreSQL lo maneja automáticamente en minúsculas)
    private static final String SCHEMA = "practica_mvc";

    public boolean guardar(Estudiante e) {


        String sql = "INSERT INTO " + SCHEMA + ".estudiantes (name, lastname, email) VALUES (?, ?, ?)";
        

        try (Connection conn = ConexionPostgresDatabase.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, e.getNombre());
            ps.setString(2, e.getApellido());
            ps.setString(3, e.getEmail());

            ps.executeUpdate();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public List<Estudiante> obtenerTodos() {
        List<Estudiante> lista = new ArrayList<>();
        String sql = "SELECT id, name, lastname, email FROM " + SCHEMA + ".estudiantes ORDER BY id";

        try (Connection conn = ConexionPostgresDatabase.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Estudiante est = new Estudiante();
                est.setId(rs.getInt("id"));
                est.setNombre(rs.getString("name"));
                est.setApellido(rs.getString("lastname"));
                est.setEmail(rs.getString("email"));
                lista.add(est);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public Estudiante obtenerPorId(int id) {
        String sql = "SELECT id, name, lastname, email FROM " + SCHEMA + ".estudiantes WHERE id = ?";

        try (Connection conn = ConexionPostgresDatabase.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Estudiante e = new Estudiante();
                    e.setId(rs.getInt("id"));
                    e.setNombre(rs.getString("name"));
                    e.setApellido(rs.getString("lastname"));
                    e.setEmail(rs.getString("email"));
                    return e;
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean actualizar(Estudiante e) {
        String sql = "UPDATE " + SCHEMA + ".estudiantes SET name=?, lastname=?, email=? WHERE id=?";

        try (Connection conn = ConexionPostgresDatabase.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, e.getNombre());
            ps.setString(2, e.getApellido());
            ps.setString(3, e.getEmail());
            ps.setInt(4, e.getId());

            ps.executeUpdate();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM " + SCHEMA + ".estudiantes WHERE id=?";

        try (Connection conn = ConexionPostgresDatabase.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}