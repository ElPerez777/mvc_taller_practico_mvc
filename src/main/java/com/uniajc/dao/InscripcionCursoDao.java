package com.uniajc.dao;

import java.sql.*;
import java.util.*;
import com.uniajc.config.ConexionPostgresDatabase;
import com.uniajc.modelo.InscripcionCurso;

//tested

public class InscripcionCursoDao {

    private static final String SCHEMA = "\"practica_mvc\"";

    public void guardar(InscripcionCurso i) {
        String sql = "INSERT INTO " + SCHEMA + ".inscripciones_curso (student_id, group_id, final_grade, status) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionPostgresDatabase.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, i.getIdEstudiante());
            ps.setInt(2, i.getIdGrupo());
            ps.setFloat(3, i.getNotaFinal());
            ps.setString(4, i.getEstado());
            ps.executeUpdate();
        } catch (SQLException ex) { ex.printStackTrace(); }
    }

    public List<InscripcionCurso> obtenerTodas() {
        List<InscripcionCurso> lista = new ArrayList<>();
        String sql = "SELECT id, student_id, group_id, final_grade, status FROM " + SCHEMA + ".inscripciones_curso ORDER BY id";
        try (Connection conn = ConexionPostgresDatabase.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                InscripcionCurso ic = new InscripcionCurso();
                ic.setId(rs.getInt("id"));
                ic.setIdEstudiante(rs.getInt("student_id"));
                ic.setIdGrupo(rs.getInt("group_id"));
                ic.setNotaFinal(rs.getFloat("final_grade"));
                ic.setEstado(rs.getString("status"));
                lista.add(ic);
            }
        } catch (SQLException ex) { ex.printStackTrace(); }
        return lista;
    }

    public InscripcionCurso obtenerPorId(int id) {
        String sql = "SELECT id, student_id, group_id, final_grade, status FROM " + SCHEMA + ".inscripciones_curso WHERE id = ?";
        try (Connection conn = ConexionPostgresDatabase.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    InscripcionCurso ic = new InscripcionCurso();
                    ic.setId(rs.getInt("id"));
                    ic.setIdEstudiante(rs.getInt("student_id"));
                    ic.setIdGrupo(rs.getInt("group_id"));
                    ic.setNotaFinal(rs.getFloat("final_grade"));
                    ic.setEstado(rs.getString("status"));
                    return ic;
                }
            }
        } catch (SQLException ex) { ex.printStackTrace(); }
        return null;
    }

    public boolean existeInscripcion(int idEstudiante, int idGrupo) {
        String sql = "SELECT 1 FROM " + SCHEMA + ".inscripciones_curso WHERE student_id=? AND group_id=?";
        try (Connection conn = ConexionPostgresDatabase.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idEstudiante);
            ps.setInt(2, idGrupo);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException ex) { ex.printStackTrace(); }
        return false;
    }

    public void actualizar(InscripcionCurso i) {
        String sql = "UPDATE " + SCHEMA + ".inscripciones_curso SET student_id=?, group_id=?, final_grade=?, status=? WHERE id=?";
        try (Connection conn = ConexionPostgresDatabase.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, i.getIdEstudiante());
            ps.setInt(2, i.getIdGrupo());
            ps.setFloat(3, i.getNotaFinal());
            ps.setString(4, i.getEstado());
            ps.setInt(5, i.getId());
            ps.executeUpdate();
        } catch (SQLException ex) { ex.printStackTrace(); }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM " + SCHEMA + ".inscripciones_curso WHERE id=?";
        try (Connection conn = ConexionPostgresDatabase.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) { ex.printStackTrace(); }
    }
}
