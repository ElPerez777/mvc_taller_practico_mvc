package com.uniajc.servicios;

import java.util.List;
import com.uniajc.dao.GrupoDao;
import com.uniajc.modelo.Grupo;

public class GrupoService {
    private GrupoDao dao = new GrupoDao();
    private MateriaService materiaService = new MateriaService();
    private DocenteService docenteService = new DocenteService();

    public void registrarGrupo(Grupo g) {
        if (g == null) throw new IllegalArgumentException("El grupo no puede ser nulo.");
        if (g.getIdMateria() <= 0 || !materiaService.existeMateria(g.getIdMateria()))
            throw new IllegalArgumentException("La materia referenciada no existe (id=" + g.getIdMateria() + ").");
        if (g.getIdDocente() <= 0 || !docenteService.existeDocente(g.getIdDocente()))
            throw new IllegalArgumentException("El docente referenciado no existe (id=" + g.getIdDocente() + ").");
        if (g.getAula() == null || g.getAula().trim().isEmpty())
            throw new IllegalArgumentException("El aula es obligatoria.");
        if (g.getHorario() == null || g.getHorario().trim().isEmpty())
            throw new IllegalArgumentException("El horario es obligatorio.");
        dao.guardar(g);
    }

    public List<Grupo> obtenerTodosLosGrupos()  { return dao.obtenerTodos(); }
    public Grupo obtenerGrupoPorId(int id)      { return dao.obtenerPorId(id); }
    public boolean existeGrupo(int id)          { return dao.obtenerPorId(id) != null; }

    public void actualizarGrupo(Grupo g) {
        if (g == null || g.getId() <= 0) throw new IllegalArgumentException("Id invalido.");
        if (!existeGrupo(g.getId())) throw new IllegalArgumentException("No existe grupo con id " + g.getId());
        if (!materiaService.existeMateria(g.getIdMateria())) throw new IllegalArgumentException("Materia no existe.");
        if (!docenteService.existeDocente(g.getIdDocente())) throw new IllegalArgumentException("Docente no existe.");
        dao.actualizar(g);
    }

    public void eliminarGrupo(int id) {
        if (!existeGrupo(id)) throw new IllegalArgumentException("No existe grupo con id " + id);
        dao.eliminar(id);
    }
}