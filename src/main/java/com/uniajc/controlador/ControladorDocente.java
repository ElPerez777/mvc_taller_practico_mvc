package com.uniajc.controlador;

//comment

import com.uniajc.modelo.Docente;
import com.uniajc.servicios.DocenteService;
import com.uniajc.vista.IVistaDocente;

public class ControladorDocente {
    private IVistaDocente vista;
    private DocenteService servicio;

    public ControladorDocente(IVistaDocente vista, DocenteService servicio) {
        this.vista = vista; this.servicio = servicio;
    }

    public void registrarDocente() {
        try {
            Docente d = vista.solicitarDatosDocente();
            if (d != null) { servicio.registrarDocente(d); vista.mostrarMensaje("Docente registrado exitosamente."); }
        } catch (IllegalArgumentException ex) { vista.mostrarMensaje("Datos invalidos: " + ex.getMessage()); }
          catch (Exception ex)               { vista.mostrarMensaje("Error al registrar el docente."); ex.printStackTrace(); }
    }

    public void mostrarTodosLosDocentes() {
        vista.mostrarTodosLosDocentes(servicio.obtenerTodosLosDocentes());
    }
}
