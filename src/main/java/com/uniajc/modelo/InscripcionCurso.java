package com.uniajc.modelo;

public class InscripcionCurso {
    private int id;
    private int idEstudiante;
    private int idGrupo;
    private float notaFinal;
    private String estado;

    public InscripcionCurso() { }

    public InscripcionCurso(int id, int idEstudiante, int idGrupo, float notaFinal, String estado) {
        this.id = id; this.idEstudiante = idEstudiante; this.idGrupo = idGrupo;
        this.notaFinal = notaFinal; this.estado = estado;
    }

    public int getId()                      { return id; }
    public void setId(int id)               { this.id = id; }
    public int getIdEstudiante()            { return idEstudiante; }
    public void setIdEstudiante(int v)      { this.idEstudiante = v; }
    public int getIdGrupo()                 { return idGrupo; }
    public void setIdGrupo(int v)           { this.idGrupo = v; }
    public float getNotaFinal()             { return notaFinal; }
    public void setNotaFinal(float v)       { this.notaFinal = v; }
    public String getEstado()               { return estado; }
    public void setEstado(String v)         { this.estado = v; }
}
