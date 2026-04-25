package com.uniajc.vista;

import java.util.List;
import javax.swing.JOptionPane;
import com.uniajc.modelo.Estudiante;

public class VistaEstudianteSwing implements IVistaEstudiante {

    @Override
    public Estudiante solicitarDatosEstudiante() {
        String nombre = JOptionPane.showInputDialog(null, "Nombre del estudiante:", "Nuevo Estudiante", JOptionPane.QUESTION_MESSAGE);
        if (nombre == null) return null;
        String apellido = JOptionPane.showInputDialog(null, "Apellido del estudiante:", "Nuevo Estudiante", JOptionPane.QUESTION_MESSAGE);
        if (apellido == null) return null;
        String email = JOptionPane.showInputDialog(null, "Correo del estudiante:", "Nuevo Estudiante", JOptionPane.QUESTION_MESSAGE);
        if (email == null) return null;
        return new Estudiante(0, nombre, apellido, email);
    }

    @Override
    public void mostrarDetallesEstudiante(Estudiante e) {
        JOptionPane.showMessageDialog(null,
            "ID: " + e.getId() + "\nNombre: " + e.getNombre() + "\nApellido: " + e.getApellido() + "\nCorreo: " + e.getEmail(),
            "Estudiante", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void mostrarTodosLosEstudiantes(List<Estudiante> lista) {
        if (lista.isEmpty()) { JOptionPane.showMessageDialog(null, "No hay estudiantes registrados."); return; }
        StringBuilder sb = new StringBuilder("Lista de Estudiantes:\n---\n");
        lista.forEach(e -> sb.append("ID:").append(e.getId()).append(" | ").append(e.getNombre()).append(" ").append(e.getApellido()).append(" | ").append(e.getEmail()).append("\n"));
        JOptionPane.showMessageDialog(null, sb.toString(), "Estudiantes", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void mostrarMensaje(String m) { JOptionPane.showMessageDialog(null, m, "Mensaje", JOptionPane.INFORMATION_MESSAGE); }
}
