package com.uniajc.vista;
import java.util.List;
import com.uniajc.modelo.Grupo;

public interface IVistaGrupo {
    Grupo solicitarDatosGrupo();
    void mostrarDetallesGrupo(Grupo g);
    void mostrarTodosLosGrupos(List<Grupo> lista);
    void mostrarMensaje(String mensaje);
}
