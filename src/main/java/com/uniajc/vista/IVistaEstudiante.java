package com.uniajc.vista;
import java.util.List;
import com.uniajc.modelo.Estudiante;

public interface IVistaEstudiante {
    Estudiante solicitarDatosEstudiante();
    void mostrarDetallesEstudiante(Estudiante e);
    void mostrarTodosLosEstudiantes(List<Estudiante> lista);
    void mostrarMensaje(String mensaje);
}
