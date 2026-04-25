package com.uniajc.controlador;

//comment

import com.uniajc.modelo.Estudiante;
import com.uniajc.servicios.EstudianteService;
import com.uniajc.vista.IVistaEstudiante;

public class ControladorEstudiante {
    private IVistaEstudiante vista;
    private EstudianteService servicio;

    public ControladorEstudiante(IVistaEstudiante vista, EstudianteService servicio) {
        this.vista = vista; this.servicio = servicio;
    }

    public void registrarEstudiante() {
        try {
            Estudiante e = vista.solicitarDatosEstudiante();
            if (e != null) { servicio.registrarEstudiante(e); vista.mostrarMensaje("Estudiante registrado exitosamente."); }
        } catch (IllegalArgumentException ex) { vista.mostrarMensaje("Datos invalidos: " + ex.getMessage()); }
          catch (Exception ex)               { vista.mostrarMensaje("Error al registrar el estudiante."); ex.printStackTrace(); }
    }

    public void mostrarTodosLosEstudiantes() {
        vista.mostrarTodosLosEstudiantes(servicio.obtenerTodosLosEstudiantes());
    }
}
