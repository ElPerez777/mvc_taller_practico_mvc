package com.uniajc.modelo;

public class Estudiante {
    private int id;
    private String nombre;
    private String apellido;
    private String email;

    public Estudiante() { }

    public Estudiante(int id, String nombre, String apellido, String email) {
        this.id = id; this.nombre = nombre; this.apellido = apellido; this.email = email;
    }

    public int getId()              { return id; }
    public void setId(int id)       { this.id = id; }
    public String getNombre()       { return nombre; }
    public void setNombre(String n) { this.nombre = n; }
    public String getApellido()     { return apellido; }
    public void setApellido(String a){ this.apellido = a; }
    public String getEmail()        { return email; }
    public void setEmail(String e)  { this.email = e; }
}
