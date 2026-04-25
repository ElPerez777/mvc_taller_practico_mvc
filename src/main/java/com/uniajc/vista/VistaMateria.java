package com.uniajc.vista;

import java.util.List;
import java.util.Scanner;
import com.uniajc.modelo.Materia;

public class VistaMateria implements IVistaMateria {
    private Scanner sc = new Scanner(System.in);

    @Override
    public Materia solicitarDatosMateria() {
        System.out.print("Nombre de la materia: ");
        String nombre = sc.nextLine();
        System.out.print("Numero de creditos (1-10): ");
        int creditos = 0;
        try { creditos = Integer.parseInt(sc.nextLine().trim()); } catch (NumberFormatException e) { creditos = 0; }
        return new Materia(0, nombre, creditos);
    }

    @Override
    public void mostrarDetallesMateria(Materia m) {
        System.out.println("ID:" + m.getId() + " | " + m.getNombreMateria() + " | Creditos:" + m.getCreditos());
    }

    @Override
    public void mostrarTodasLasMaterias(List<Materia> lista) {
        System.out.println("--- Lista de Materias ---");
        if (lista.isEmpty()) { System.out.println("(No hay materias registradas)"); return; }
        lista.forEach(this::mostrarDetallesMateria);
    }

    @Override
    public void mostrarMensaje(String m) { System.out.println(m); }
}

