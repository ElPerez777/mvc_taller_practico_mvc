package com.uniajc.controlador;

//comment

import com.uniajc.modelo.Grupo;
import com.uniajc.servicios.GrupoService;
import com.uniajc.vista.IVistaGrupo;

public class ControladorGrupo {
    private IVistaGrupo vista;
    private GrupoService servicio;

    public ControladorGrupo(IVistaGrupo vista, GrupoService servicio) {
        this.vista = vista; this.servicio = servicio;
    }

    public void registrarGrupo() {
        try {
            Grupo g = vista.solicitarDatosGrupo();
            if (g != null) { servicio.registrarGrupo(g); vista.mostrarMensaje("Grupo registrado exitosamente."); }
        } catch (IllegalArgumentException ex) { vista.mostrarMensaje("Datos invalidos: " + ex.getMessage()); }
          catch (Exception ex)               { vista.mostrarMensaje("Error al registrar el grupo."); ex.printStackTrace(); }
    }

    public void mostrarTodosLosGrupos() {
        vista.mostrarTodosLosGrupos(servicio.obtenerTodosLosGrupos());
    }
}
