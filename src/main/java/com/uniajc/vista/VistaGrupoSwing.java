package com.uniajc.vista;

import java.util.List;
import javax.swing.JOptionPane;
import com.uniajc.modelo.Grupo;

public class VistaGrupoSwing implements IVistaGrupo {

    private int parseInt(String s) {
        try { return Integer.parseInt(s.trim()); } catch (NumberFormatException e) { return 0; }
    }

    @Override
    public Grupo solicitarDatosGrupo() {
        String idMat = JOptionPane.showInputDialog(null, "ID de la materia:", "Nuevo Grupo", JOptionPane.QUESTION_MESSAGE);
        if (idMat == null) return null;
        String idDoc = JOptionPane.showInputDialog(null, "ID del docente:", "Nuevo Grupo", JOptionPane.QUESTION_MESSAGE);
        if (idDoc == null) return null;
        String aula = JOptionPane.showInputDialog(null, "Aula:", "Nuevo Grupo", JOptionPane.QUESTION_MESSAGE);
        if (aula == null) return null;
        String horario = JOptionPane.showInputDialog(null, "Horario (ej: Lun-Mie 8:00-10:00):", "Nuevo Grupo", JOptionPane.QUESTION_MESSAGE);
        if (horario == null) return null;
        return new Grupo(0, parseInt(idMat), parseInt(idDoc), aula, horario);
    }

    @Override
    public void mostrarDetallesGrupo(Grupo g) {
        JOptionPane.showMessageDialog(null,
            "ID: " + g.getId() + "\nMateria: " + g.getIdMateria() + "\nDocente: " + g.getIdDocente() + "\nAula: " + g.getAula() + "\nHorario: " + g.getHorario(),
            "Grupo", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void mostrarTodosLosGrupos(List<Grupo> lista) {
        if (lista.isEmpty()) { JOptionPane.showMessageDialog(null, "No hay grupos registrados."); return; }
        StringBuilder sb = new StringBuilder("Lista de Grupos:\n---\n");
        lista.forEach(g -> sb.append("ID:").append(g.getId()).append(" | Mat:").append(g.getIdMateria()).append(" | Doc:").append(g.getIdDocente()).append(" | ").append(g.getAula()).append(" | ").append(g.getHorario()).append("\n"));
        JOptionPane.showMessageDialog(null, sb.toString(), "Grupos", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void mostrarMensaje(String m) { JOptionPane.showMessageDialog(null, m, "Mensaje", JOptionPane.INFORMATION_MESSAGE); }
}
