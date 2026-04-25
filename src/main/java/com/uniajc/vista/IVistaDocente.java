package com.uniajc.vista;
import java.util.List;
import com.uniajc.modelo.Docente;

public interface IVistaDocente {
    Docente solicitarDatosDocente();
    void mostrarDetallesDocente(Docente d);
    void mostrarTodosLosDocentes(List<Docente> lista);
    void mostrarMensaje(String mensaje);
}
