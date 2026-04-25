package com.uniajc.modelo;

public class Grupo {
    private int id;
    private int idMateria;
    private int idDocente;
    private String aula;
    private String horario;

    public Grupo() { }

    public Grupo(int id, int idMateria, int idDocente, String aula, String horario) {
        this.id = id; this.idMateria = idMateria; this.idDocente = idDocente;
        this.aula = aula; this.horario = horario;
    }

    public int getId()                  { return id; }
    public void setId(int id)           { this.id = id; }
    public int getIdMateria()           { return idMateria; }
    public void setIdMateria(int v)     { this.idMateria = v; }
    public int getIdDocente()           { return idDocente; }
    public void setIdDocente(int v)     { this.idDocente = v; }
    public String getAula()             { return aula; }
    public void setAula(String v)       { this.aula = v; }
    public String getHorario()          { return horario; }
    public void setHorario(String v)    { this.horario = v; }
}
