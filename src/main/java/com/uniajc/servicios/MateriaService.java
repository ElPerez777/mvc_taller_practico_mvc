package com.uniajc.servicios;

import java.util.List;
import com.uniajc.dao.MateriaDao;
import com.uniajc.modelo.Materia;

public class MateriaService {
    private MateriaDao dao = new MateriaDao();

    public void registrarMateria(Materia m) {
        if (m == null) throw new IllegalArgumentException("La materia no puede ser nula.");
        if (m.getNombreMateria() == null || m.getNombreMateria().trim().isEmpty())
            throw new IllegalArgumentException("Nombre de la materia obligatorio.");
        if (m.getCreditos() <= 0 || m.getCreditos() > 10)
            throw new IllegalArgumentException("Creditos deben estar entre 1 y 10.");
        dao.guardar(m);
    }

    public List<Materia> obtenerTodasLasMaterias()  { return dao.obtenerTodas(); }
    public Materia obtenerMateriaPorId(int id)      { return dao.obtenerPorId(id); }
    public boolean existeMateria(int id)            { return dao.obtenerPorId(id) != null; }

    public void actualizarMateria(Materia m) {
        if (m == null || m.getId() <= 0) throw new IllegalArgumentException("Id invalido.");
        if (!existeMateria(m.getId())) throw new IllegalArgumentException("No existe materia con id " + m.getId());
        dao.actualizar(m);
    }

    public void eliminarMateria(int id) {
        if (!existeMateria(id)) throw new IllegalArgumentException("No existe materia con id " + id);
        dao.eliminar(id);
    }
}
