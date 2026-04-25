package com.uniajc.controlador;

//comment

import com.uniajc.modelo.InscripcionCurso;
import com.uniajc.servicios.InscripcionCursoService;
import com.uniajc.vista.IVistaInscripcionCurso;

public class ControladorInscripcionCurso {
    private IVistaInscripcionCurso vista;
    private InscripcionCursoService servicio;

    public ControladorInscripcionCurso(IVistaInscripcionCurso vista, InscripcionCursoService servicio) {
        this.vista = vista; this.servicio = servicio;
    }

    public void registrarInscripcion() {
        try {
            InscripcionCurso i = vista.solicitarDatosInscripcion();
            if (i != null) { servicio.registrarInscripcion(i); vista.mostrarMensaje("Inscripcion registrada exitosamente."); }
        } catch (IllegalArgumentException ex) { vista.mostrarMensaje("Datos invalidos: " + ex.getMessage()); }
          catch (Exception ex)               { vista.mostrarMensaje("Error al registrar la inscripcion."); ex.printStackTrace(); }
    }

    public void mostrarTodasLasInscripciones() {
        vista.mostrarTodasLasInscripciones(servicio.obtenerTodasLasInscripciones());
    }
}
