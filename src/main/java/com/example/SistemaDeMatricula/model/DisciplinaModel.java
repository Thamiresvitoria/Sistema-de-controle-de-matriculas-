package com.example.SistemaDeMatricula.model;

public class DisciplinaModel {
    private Long id;
    private String nome;
    private String codigo;
    private int cargaHoraria;

    public DisciplinaModel(String nome, String codigo, int cargaHoraria){
        this.id = 1L;
        this.nome = nome;
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String toString() {
        return "Disciplina" + "\n" +
                "id...........:"  + id + "\n" +
                "Nome.........:"  + nome + "\n" +
                "Código.......:"  + codigo + "\n" +
                "Carga Horária:"  + cargaHoraria;
    }
}
