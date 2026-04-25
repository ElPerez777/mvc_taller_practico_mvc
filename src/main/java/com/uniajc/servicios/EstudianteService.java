package com.uniajc.servicios;

import java.util.List;
import com.uniajc.dao.EstudianteDao;
import com.uniajc.modelo.Estudiante;

public class EstudianteService {
    private EstudianteDao dao = new EstudianteDao();

    public void registrarEstudiante(Estudiante e) {
        if (e == null) throw new IllegalArgumentException("El estudiante no puede ser nulo.");
        if (e.getNombre() == null || e.getNombre().trim().isEmpty() ||
            e.getEmail() == null || e.getEmail().trim().isEmpty())
            throw new IllegalArgumentException("Nombre y correo son obligatorios.");
        if (!e.getEmail().contains("@") || !e.getEmail().contains("."))
            throw new IllegalArgumentException("El correo no tiene formato valido.");
        dao.guardar(e);
    }

    public List<Estudiante> obtenerTodosLosEstudiantes() { return dao.obtenerTodos(); }
    public Estudiante obtenerEstudiantePorId(int id)     { return dao.obtenerPorId(id); }
    public boolean existeEstudiante(int id)              { return dao.obtenerPorId(id) != null; }

    public void actualizarEstudiante(Estudiante e) {
        if (e == null || e.getId() <= 0) throw new IllegalArgumentException("Id invalido.");
        if (!existeEstudiante(e.getId())) throw new IllegalArgumentException("No existe estudiante con id " + e.getId());
        dao.actualizar(e);
    }

    public void eliminarEstudiante(int id) {
        if (!existeEstudiante(id)) throw new IllegalArgumentException("No existe estudiante con id " + id);
        dao.eliminar(id);
    }
}