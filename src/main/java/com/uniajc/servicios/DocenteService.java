package com.uniajc.servicios;

import java.util.List;
import com.uniajc.dao.DocenteDao;
import com.uniajc.modelo.Docente;

public class DocenteService {
    private DocenteDao dao = new DocenteDao();

    public void registrarDocente(Docente d) {
        if (d == null) throw new IllegalArgumentException("El docente no puede ser nulo.");
        if (d.getNombre() == null || d.getNombre().trim().isEmpty())
            throw new IllegalArgumentException("Nombre del docente obligatorio.");
        if (d.getEspecialidad() == null || d.getEspecialidad().trim().isEmpty())
            throw new IllegalArgumentException("Especialidad del docente obligatoria.");
        dao.guardar(d);
    }

    public List<Docente> obtenerTodosLosDocentes()  { return dao.obtenerTodos(); }
    public Docente obtenerDocentePorId(int id)      { return dao.obtenerPorId(id); }
    public boolean existeDocente(int id)            { return dao.obtenerPorId(id) != null; }

    public void actualizarDocente(Docente d) {
        if (d == null || d.getId() <= 0) throw new IllegalArgumentException("Id invalido.");
        if (!existeDocente(d.getId())) throw new IllegalArgumentException("No existe docente con id " + d.getId());
        dao.actualizar(d);
    }

    public void eliminarDocente(int id) {
        if (!existeDocente(id)) throw new IllegalArgumentException("No existe docente con id " + id);
        dao.eliminar(id);
    }
}
