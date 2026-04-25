package com.uniajc.vista;

import java.util.List;
import javax.swing.JOptionPane;
import com.uniajc.modelo.Materia;

public class VistaMateriaSwing implements IVistaMateria {

    @Override
    public Materia solicitarDatosMateria() {
        String nombre = JOptionPane.showInputDialog(null, "Nombre de la materia:", "Nueva Materia", JOptionPane.QUESTION_MESSAGE);
        if (nombre == null) return null;
        String credStr = JOptionPane.showInputDialog(null, "Numero de creditos (1-10):", "Nueva Materia", JOptionPane.QUESTION_MESSAGE);
        if (credStr == null) return null;
        int creditos = 0;
        try { creditos = Integer.parseInt(credStr.trim()); } catch (NumberFormatException e) { creditos = 0; }
        return new Materia(0, nombre, creditos);
    }

    @Override
    public void mostrarDetallesMateria(Materia m) {
        JOptionPane.showMessageDialog(null,
            "ID: " + m.getId() + "\nNombre: " + m.getNombreMateria() + "\nCreditos: " + m.getCreditos(),
            "Materia", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void mostrarTodasLasMaterias(List<Materia> lista) {
        if (lista.isEmpty()) { JOptionPane.showMessageDialog(null, "No hay materias registradas."); return; }
        StringBuilder sb = new StringBuilder("Lista de Materias:\n---\n");
        lista.forEach(m -> sb.append("ID:").append(m.getId()).append(" | ").append(m.getNombreMateria()).append(" | Creditos:").append(m.getCreditos()).append("\n"));
        JOptionPane.showMessageDialog(null, sb.toString(), "Materias", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void mostrarMensaje(String m) { JOptionPane.showMessageDialog(null, m, "Mensaje", JOptionPane.INFORMATION_MESSAGE); }
}