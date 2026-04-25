package com.uniajc.vista;

import java.util.List;
import javax.swing.JOptionPane;
import com.uniajc.modelo.Docente;

public class VistaDocenteSwing implements IVistaDocente {

    @Override
    public Docente solicitarDatosDocente() {
        String nombre = JOptionPane.showInputDialog(null, "Nombre del docente:", "Nuevo Docente", JOptionPane.QUESTION_MESSAGE);
        if (nombre == null) return null;
        String esp = JOptionPane.showInputDialog(null, "Especialidad:", "Nuevo Docente", JOptionPane.QUESTION_MESSAGE);
        if (esp == null) return null;
        return new Docente(0, nombre, esp);
    }

    @Override
    public void mostrarDetallesDocente(Docente d) {
        JOptionPane.showMessageDialog(null,
            "ID: " + d.getId() + "\nNombre: " + d.getNombre() + "\nEspecialidad: " + d.getEspecialidad(),
            "Docente", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void mostrarTodosLosDocentes(List<Docente> lista) {
        if (lista.isEmpty()) { JOptionPane.showMessageDialog(null, "No hay docentes registrados."); return; }
        StringBuilder sb = new StringBuilder("Lista de Docentes:\n---\n");
        lista.forEach(d -> sb.append("ID:").append(d.getId()).append(" | ").append(d.getNombre()).append(" | ").append(d.getEspecialidad()).append("\n"));
        JOptionPane.showMessageDialog(null, sb.toString(), "Docentes", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void mostrarMensaje(String m) { JOptionPane.showMessageDialog(null, m, "Mensaje", JOptionPane.INFORMATION_MESSAGE); }
}
