package com.uniajc.vista;

import java.util.List;
import java.util.Scanner;
import com.uniajc.modelo.Docente;

public class VistaDocente implements IVistaDocente {
    private Scanner sc = new Scanner(System.in);

    @Override
    public Docente solicitarDatosDocente() {
        System.out.print("Nombre del docente: ");
        String nombre = sc.nextLine();
        System.out.print("Especialidad del docente: ");
        String especialidad = sc.nextLine();
        return new Docente(0, nombre, especialidad);
    }

    @Override
    public void mostrarDetallesDocente(Docente d) {
        System.out.println("ID:" + d.getId() + " | " + d.getNombre() + " | " + d.getEspecialidad());
    }

    @Override
    public void mostrarTodosLosDocentes(List<Docente> lista) {
        System.out.println("--- Lista de Docentes ---");
        if (lista.isEmpty()) { System.out.println("(No hay docentes registrados)"); return; }
        lista.forEach(this::mostrarDetallesDocente);
    }

    @Override
    public void mostrarMensaje(String m) { System.out.println(m); }
}