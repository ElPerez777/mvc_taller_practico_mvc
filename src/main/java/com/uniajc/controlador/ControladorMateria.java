package com.uniajc.controlador;

//comment

import com.uniajc.modelo.Materia;
import com.uniajc.servicios.MateriaService;
import com.uniajc.vista.IVistaMateria;

public class ControladorMateria {
    private IVistaMateria vista;
    private MateriaService servicio;

    public ControladorMateria(IVistaMateria vista, MateriaService servicio) {
        this.vista = vista; this.servicio = servicio;
    }

    public void registrarMateria() {
        try {
            Materia m = vista.solicitarDatosMateria();
            if (m != null) { servicio.registrarMateria(m); vista.mostrarMensaje("Materia registrada exitosamente."); }
        } catch (IllegalArgumentException ex) { vista.mostrarMensaje("Datos invalidos: " + ex.getMessage()); }
          catch (Exception ex)               { vista.mostrarMensaje("Error al registrar la materia."); ex.printStackTrace(); }
    }

    public void mostrarTodasLasMaterias() {
        vista.mostrarTodasLasMaterias(servicio.obtenerTodasLasMaterias());
    }
}
