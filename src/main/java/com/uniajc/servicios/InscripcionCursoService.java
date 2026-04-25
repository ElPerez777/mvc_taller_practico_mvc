package com.uniajc.servicios;

import java.util.Arrays;
import java.util.List;
import com.uniajc.dao.InscripcionCursoDao;
import com.uniajc.modelo.InscripcionCurso;

public class InscripcionCursoService {

    private static final List<String> ESTADOS_VALIDOS = Arrays.asList(
        "INSCRITO", "APROBADO", "REPROBADO", "CANCELADO"
    );

    private InscripcionCursoDao dao = new InscripcionCursoDao();
    private EstudianteService estudianteService = new EstudianteService();
    private GrupoService grupoService = new GrupoService();

    public void registrarInscripcion(InscripcionCurso i) {
        if (i == null) throw new IllegalArgumentException("La inscripcion no puede ser nula.");
        if (i.getIdEstudiante() <= 0 || !estudianteService.existeEstudiante(i.getIdEstudiante()))
            throw new IllegalArgumentException("El estudiante referenciado no existe (id=" + i.getIdEstudiante() + ").");
        if (i.getIdGrupo() <= 0 || !grupoService.existeGrupo(i.getIdGrupo()))
            throw new IllegalArgumentException("El grupo referenciado no existe (id=" + i.getIdGrupo() + ").");
        if (dao.existeInscripcion(i.getIdEstudiante(), i.getIdGrupo()))
            throw new IllegalArgumentException("El estudiante ya se encuentra inscrito en este grupo.");
        if (i.getNotaFinal() < 0.0f || i.getNotaFinal() > 5.0f)
            throw new IllegalArgumentException("La nota final debe estar entre 0.0 y 5.0.");
        if (i.getEstado() == null || !ESTADOS_VALIDOS.contains(i.getEstado().toUpperCase()))
            throw new IllegalArgumentException("Estado invalido. Valores permitidos: " + ESTADOS_VALIDOS);
        i.setEstado(i.getEstado().toUpperCase());
        dao.guardar(i);
    }

    public List<InscripcionCurso> obtenerTodasLasInscripciones() { return dao.obtenerTodas(); }
    public InscripcionCurso obtenerInscripcionPorId(int id)      { return dao.obtenerPorId(id); }

    public void actualizarInscripcion(InscripcionCurso i) {
        if (i == null || i.getId() <= 0) throw new IllegalArgumentException("Id invalido.");
        if (dao.obtenerPorId(i.getId()) == null) throw new IllegalArgumentException("No existe inscripcion con id " + i.getId());
        if (i.getNotaFinal() < 0.0f || i.getNotaFinal() > 5.0f)
            throw new IllegalArgumentException("La nota final debe estar entre 0.0 y 5.0.");
        if (i.getEstado() == null || !ESTADOS_VALIDOS.contains(i.getEstado().toUpperCase()))
            throw new IllegalArgumentException("Estado invalido. Valores permitidos: " + ESTADOS_VALIDOS);
        i.setEstado(i.getEstado().toUpperCase());
        dao.actualizar(i);
    }

    public void eliminarInscripcion(int id) {
        if (dao.obtenerPorId(id) == null) throw new IllegalArgumentException("No existe inscripcion con id " + id);
        dao.eliminar(id);
    }
}
