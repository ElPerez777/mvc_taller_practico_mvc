package com.uniajc.vista;
import java.util.List;
import com.uniajc.modelo.Materia;

public interface IVistaMateria {
    Materia solicitarDatosMateria();
    void mostrarDetallesMateria(Materia m);
    void mostrarTodasLasMaterias(List<Materia> lista);
    void mostrarMensaje(String mensaje);
}
