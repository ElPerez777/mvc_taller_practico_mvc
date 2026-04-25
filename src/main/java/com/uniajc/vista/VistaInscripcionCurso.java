package com.uniajc.vista;

import java.util.List;
import java.util.Scanner;
import com.uniajc.modelo.InscripcionCurso;

public class VistaInscripcionCurso implements IVistaInscripcionCurso {
    private Scanner sc = new Scanner(System.in);

    private int leerEntero(String prompt) {
        System.out.print(prompt);
        try { return Integer.parseInt(sc.nextLine().trim()); } catch (NumberFormatException e) { return 0; }
    }

    private float leerFloat(String prompt) {
        System.out.print(prompt);
        try { return Float.parseFloat(sc.nextLine().trim().replace(",", ".")); } catch (NumberFormatException e) { return -1f; }
    }

    @Override
    public InscripcionCurso solicitarDatosInscripcion() {
        int idEst  = leerEntero("ID del estudiante: ");
        int idGrupo = leerEntero("ID del grupo: ");
        float nota  = leerFloat("Nota final (0.0-5.0): ");
        System.out.print("Estado (INSCRITO/APROBADO/REPROBADO/CANCELADO): ");
        String estado = sc.nextLine();
        return new InscripcionCurso(0, idEst, idGrupo, nota, estado);
    }

    @Override
    public void mostrarDetallesInscripcion(InscripcionCurso i) {
        System.out.println("ID:" + i.getId() + " | Est:" + i.getIdEstudiante() + " | Grupo:" + i.getIdGrupo() + " | Nota:" + i.getNotaFinal() + " | " + i.getEstado());
    }

    @Override
    public void mostrarTodasLasInscripciones(List<InscripcionCurso> lista) {
        System.out.println("--- Lista de Inscripciones ---");
        if (lista.isEmpty()) { System.out.println("(No hay inscripciones registradas)"); return; }
        lista.forEach(this::mostrarDetallesInscripcion);
    }

    @Override
    public void mostrarMensaje(String m) { System.out.println(m); }
}
