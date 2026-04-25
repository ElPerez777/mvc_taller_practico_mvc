package com.uniajc.modelo;

public class Materia {
    private int id;
    private String nombreMateria;
    private int creditos;

    public Materia() { }

    public Materia(int id, String nombreMateria, int creditos) {
        this.id = id; this.nombreMateria = nombreMateria; this.creditos = creditos;
    }

    public int getId()                          { return id; }
    public void setId(int id)                   { this.id = id; }
    public String getNombreMateria()            { return nombreMateria; }
    public void setNombreMateria(String n)      { this.nombreMateria = n; }
    public int getCreditos()                    { return creditos; }
    public void setCreditos(int c)              { this.creditos = c; }
}
