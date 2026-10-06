package com.example.SistemaDeMatricula.model;

public class DisciplinaModel {

    private static Long proximoId = 1L;

    private Long id;
    private String nome;
    private String codigo;
    private int cargaHoraria;
    private boolean status;

    public DisciplinaModel(String nome, String codigo, int cargaHoraria){
        this.id = proximoId++;
        this.nome = nome;
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
        this.status = true;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public static Long getProximoId() {
        return proximoId;
    }

    public static void setProximoId(Long proximoId) {
        DisciplinaModel.proximoId = proximoId;
    }

    @Override
    public String toString() {
        return "Disciplina" + "\n" +
                "id...........:"  + id + "\n" +
                "Nome.........:"  + nome + "\n" +
                "Código.......:"  + codigo + "\n" +
                "Carga Horária:"  + cargaHoraria + "\n" +
                "Status........:" + status;
    }
}
