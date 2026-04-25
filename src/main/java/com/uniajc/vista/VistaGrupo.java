package com.uniajc.vista;

import java.util.List;
import java.util.Scanner;
import com.uniajc.modelo.Grupo;

public class VistaGrupo implements IVistaGrupo {
    private Scanner sc = new Scanner(System.in);

    private int leerEntero(String prompt) {
        System.out.print(prompt);
        try { return Integer.parseInt(sc.nextLine().trim()); } catch (NumberFormatException e) { return 0; }
    }

    @Override
    public Grupo solicitarDatosGrupo() {
        int idMateria = leerEntero("ID de la materia: ");
        int idDocente = leerEntero("ID del docente: ");
        System.out.print("Aula: ");
        String aula = sc.nextLine();
        System.out.print("Horario (ej: Lun-Mie 8:00-10:00): ");
        String horario = sc.nextLine();
        return new Grupo(0, idMateria, idDocente, aula, horario);
    }

    @Override
    public void mostrarDetallesGrupo(Grupo g) {
        System.out.println("ID:" + g.getId() + " | Materia:" + g.getIdMateria() + " | Docente:" + g.getIdDocente() + " | Aula:" + g.getAula() + " | " + g.getHorario());
    }

    @Override
    public void mostrarTodosLosGrupos(List<Grupo> lista) {
        System.out.println("--- Lista de Grupos ---");
        if (lista.isEmpty()) { System.out.println("(No hay grupos registrados)"); return; }
        lista.forEach(this::mostrarDetallesGrupo);
    }

    @Override
    public void mostrarMensaje(String m) { System.out.println(m); }
}
