package com.uniajc.vista;
import java.util.List;
import com.uniajc.modelo.InscripcionCurso;

public interface IVistaInscripcionCurso {
    InscripcionCurso solicitarDatosInscripcion();
    void mostrarDetallesInscripcion(InscripcionCurso i);
    void mostrarTodasLasInscripciones(List<InscripcionCurso> lista);
    void mostrarMensaje(String mensaje);
}
