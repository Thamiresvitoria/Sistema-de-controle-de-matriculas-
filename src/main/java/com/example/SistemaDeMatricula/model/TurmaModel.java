package com.example.SistemaDeMatricula.model;


public class TurmaModel {
    private Long id;
    private String codigo;
    private String nome;
    private String turno;
    private boolean status;

    public TurmaModel(String codigo, String nome, String turno){
        this.id = 1L;
        this.codigo = codigo;
        this.nome = nome;
        this.turno = turno;
        this.status = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Turma" + "\n" +
                "id....:" + id + "\n" +
                "Codigo:" + codigo + "\n" +
                "Nome..:" + nome + "\n"  +
                "Turno.:" + turno + "\n" +
                "Status:" + status
                ;
    }
}
