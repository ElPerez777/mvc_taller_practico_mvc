package com.uniajc.vista;

import java.util.List;
import java.util.Scanner;
import com.uniajc.modelo.Estudiante;

public class VistaEstudiante implements IVistaEstudiante {
    private Scanner sc = new Scanner(System.in);

    @Override
    public Estudiante solicitarDatosEstudiante() {
        System.out.print("Nombre del estudiante: ");
        String nombre = sc.nextLine();
        System.out.print("Apellido del estudiante: ");
        String apellido = sc.nextLine();
        System.out.print("Correo del estudiante: ");
        String email = sc.nextLine();
        return new Estudiante(0, nombre, apellido, email);
    }

    @Override
    public void mostrarDetallesEstudiante(Estudiante e) {
        System.out.println("ID:" + e.getId() + " | " + e.getNombre() + " " + e.getApellido() + " | " + e.getEmail());
    }

    @Override
    public void mostrarTodosLosEstudiantes(List<Estudiante> lista) {
        System.out.println("--- Lista de Estudiantes ---");
        if (lista.isEmpty()) { System.out.println("(No hay estudiantes registrados)"); return; }
        lista.forEach(this::mostrarDetallesEstudiante);
    }

    @Override
    public void mostrarMensaje(String m) { System.out.println(m); }
}
