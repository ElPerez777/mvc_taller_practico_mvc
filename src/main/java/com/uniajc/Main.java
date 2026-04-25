package com.uniajc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.JOptionPane;

import com.uniajc.config.ConexionPostgresDatabase;
import com.uniajc.controlador.*;
import com.uniajc.servicios.*;
import com.uniajc.vista.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== Practica MVC - Sistema Academico Uniajc ===");

        // Selección de modo
        Scanner sc = new Scanner(System.in);
        System.out.println("Seleccione el modo de interfaz:");
        System.out.println("  1) Consola (Scanner)");
        System.out.println("  2) Swing   (JOptionPane)");
        System.out.print("Opcion: ");
        String modoStr = sc.nextLine().trim();
        boolean swing = "2".equals(modoStr);

        // Servicios
        EstudianteService      svcEst  = new EstudianteService();
        DocenteService         svcDoc  = new DocenteService();
        MateriaService         svcMat  = new MateriaService();
        GrupoService           svcGrupo = new GrupoService();
        InscripcionCursoService svcInsc = new InscripcionCursoService();

        // Vistas
        IVistaEstudiante      vEst  = swing ? new VistaEstudianteSwing()      : new VistaEstudiante();
        IVistaDocente         vDoc  = swing ? new VistaDocenteSwing()         : new VistaDocente();
        IVistaMateria         vMat  = swing ? new VistaMateriaSwing()         : new VistaMateria();
        IVistaGrupo           vGrupo = swing ? new VistaGrupoSwing()          : new VistaGrupo();
        IVistaInscripcionCurso vInsc = swing ? new VistaInscripcionCursoSwing(): new VistaInscripcionCurso();

        // Controladores
        ControladorEstudiante       ctrlEst   = new ControladorEstudiante(vEst, svcEst);
        ControladorDocente          ctrlDoc   = new ControladorDocente(vDoc, svcDoc);
        ControladorMateria          ctrlMat   = new ControladorMateria(vMat, svcMat);
        ControladorGrupo            ctrlGrupo = new ControladorGrupo(vGrupo, svcGrupo);
        ControladorInscripcionCurso ctrlInsc  = new ControladorInscripcionCurso(vInsc, svcInsc);

        // Menu principal
        boolean salir = false;
        while (!salir) {
            String opcion = pedirOpcion(swing, sc);
            if (opcion == null) opcion = "0";
            switch (opcion.trim()) {
                case "1"  -> ctrlEst.registrarEstudiante();
                case "2"  -> ctrlEst.mostrarTodosLosEstudiantes();
                case "3"  -> ctrlDoc.registrarDocente();
                case "4"  -> ctrlDoc.mostrarTodosLosDocentes();
                case "5"  -> ctrlMat.registrarMateria();
                case "6"  -> ctrlMat.mostrarTodasLasMaterias();
                case "7"  -> ctrlGrupo.registrarGrupo();
                case "8"  -> ctrlGrupo.mostrarTodosLosGrupos();
                case "9"  -> ctrlInsc.registrarInscripcion();
                case "10" -> ctrlInsc.mostrarTodasLasInscripciones();
                case "0"  -> salir = true;
                default   -> { }
            }
        }

        System.out.println("Aplicacion finalizada.");
        sc.close();
    }

    private static String pedirOpcion(boolean swing, Scanner sc) {
        String menu =
            "\n========== MENU PRINCIPAL ==========\n" +
            " 1) Registrar Estudiante\n" +
            " 2) Listar Estudiantes\n" +
            " 3) Registrar Docente\n" +
            " 4) Listar Docentes\n" +
            " 5) Registrar Materia\n" +
            " 6) Listar Materias\n" +
            " 7) Registrar Grupo\n" +
            " 8) Listar Grupos\n" +
            " 9) Registrar Inscripcion\n" +
            "10) Listar Inscripciones\n" +
            " 0) Salir\n" +
            "Seleccione: ";

        if (swing) {
            return JOptionPane.showInputDialog(null, menu, "Menu Principal", JOptionPane.QUESTION_MESSAGE);
        } else {
            System.out.print(menu);
            return sc.nextLine();
        }
    }
}