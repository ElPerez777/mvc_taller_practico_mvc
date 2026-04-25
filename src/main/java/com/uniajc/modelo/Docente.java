package com.uniajc.modelo;

public class Docente {
    private int id;
    private String nombre;
    private String especialidad;

    public Docente() { }

    public Docente(int id, String nombre, String especialidad) {
        this.id = id; this.nombre = nombre; this.especialidad = especialidad;
    }

    public int getId()                      { return id; }
    public void setId(int id)               { this.id = id; }
    public String getNombre()               { return nombre; }
    public void setNombre(String n)         { this.nombre = n; }
    public String getEspecialidad()         { return especialidad; }
    public void setEspecialidad(String e)   { this.especialidad = e; }
}
