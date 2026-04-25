package com.uniajc.vista;

import java.util.List;
import javax.swing.JOptionPane;
import com.uniajc.modelo.InscripcionCurso;

public class VistaInscripcionCursoSwing implements IVistaInscripcionCurso {

    private int parseInt(String s) {
        try { return Integer.parseInt(s.trim()); } catch (NumberFormatException e) { return 0; }
    }

    private float parseFloat(String s) {
        try { return Float.parseFloat(s.trim().replace(",", ".")); } catch (NumberFormatException e) { return -1f; }
    }

    @Override
    public InscripcionCurso solicitarDatosInscripcion() {
        String idEst = JOptionPane.showInputDialog(null, "ID del estudiante:", "Nueva Inscripcion", JOptionPane.QUESTION_MESSAGE);
        if (idEst == null) return null;
        String idGr = JOptionPane.showInputDialog(null, "ID del grupo:", "Nueva Inscripcion", JOptionPane.QUESTION_MESSAGE);
        if (idGr == null) return null;
        String notaStr = JOptionPane.showInputDialog(null, "Nota final (0.0-5.0):", "Nueva Inscripcion", JOptionPane.QUESTION_MESSAGE);
        if (notaStr == null) return null;
        String[] estados = {"INSCRITO", "APROBADO", "REPROBADO", "CANCELADO"};
        String estado = (String) JOptionPane.showInputDialog(null, "Estado:", "Nueva Inscripcion",
            JOptionPane.QUESTION_MESSAGE, null, estados, estados[0]);
        if (estado == null) return null;
        return new InscripcionCurso(0, parseInt(idEst), parseInt(idGr), parseFloat(notaStr), estado);
    }

    @Override
    public void mostrarDetallesInscripcion(InscripcionCurso i) {
        JOptionPane.showMessageDialog(null,
            "ID: " + i.getId() + "\nEstudiante: " + i.getIdEstudiante() + "\nGrupo: " + i.getIdGrupo() + "\nNota: " + i.getNotaFinal() + "\nEstado: " + i.getEstado(),
            "Inscripcion", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void mostrarTodasLasInscripciones(List<InscripcionCurso> lista) {
        if (lista.isEmpty()) { JOptionPane.showMessageDialog(null, "No hay inscripciones registradas."); return; }
        StringBuilder sb = new StringBuilder("Lista de Inscripciones:\n---\n");
        lista.forEach(i -> sb.append("ID:").append(i.getId()).append(" | Est:").append(i.getIdEstudiante()).append(" | Grupo:").append(i.getIdGrupo()).append(" | Nota:").append(i.getNotaFinal()).append(" | ").append(i.getEstado()).append("\n"));
        JOptionPane.showMessageDialog(null, sb.toString(), "Inscripciones", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void mostrarMensaje(String m) { JOptionPane.showMessageDialog(null, m, "Mensaje", JOptionPane.INFORMATION_MESSAGE); }
}
