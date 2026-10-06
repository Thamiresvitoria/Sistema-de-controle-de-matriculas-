package com.example.SistemaDeMatricula.model;

public class AlunoModel {

    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private boolean status;

    public AlunoModel(String nome, String cpf, String email){
        this.id = 1L;
        this.cpf = cpf;
        this.email = email;
        this.status = false;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String toString() {
        return "Aluno" + "\n" +
                "id...:"  + id + "\n" +
                "Nome.:"  + nome + "\n" +
                "Email:"  + email + "\n" +
                "Cpf..:"  + cpf + "\n" +
                "Status:" + status + "\n";
    }
}
