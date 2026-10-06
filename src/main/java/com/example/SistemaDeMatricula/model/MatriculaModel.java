package com.example.SistemaDeMatricula.model;


import java.time.LocalDate;

public class MatriculaModel {

    private static Long proximoId = 1L;

    private Long id;
    private AlunoModel aluno;
    private TurmaModel turma;
    private DisciplinaModel disciplina;
    private LocalDate dataMatricula;
    private boolean status;


    public MatriculaModel(Long id, AlunoModel aluno, TurmaModel turma, DisciplinaModel disciplina) {
        this.id = proximoId++;
        this.aluno = aluno;
        this.turma = turma;
        this.disciplina = disciplina;
        boolean status = true;
    }


    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public AlunoModel getAluno() {

        return aluno;
    }

    public void setAluno(AlunoModel aluno) {

        this.aluno = aluno;
    }

    public TurmaModel getTurma() {

        return turma;
    }

    public void setTurma(TurmaModel turma) {

        this.turma = turma;
    }

    public DisciplinaModel getDisciplina() {

        return disciplina;
    }

    public void setDisciplina(DisciplinaModel disciplina) {

        this.disciplina = disciplina;
    }

    public LocalDate getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(LocalDate dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    @Override
    public String toString() {
        return "Matricula" + "\n" +
                "id:" + id + "\n" +
                "Aluno:" + aluno + "\n" +
                "Turma:" + turma + "\n" +
                "Disciplina:" + disciplina + "\n" +
                "Status"   + status + "\n" +
                "Data matricula" + dataMatricula
                ;
    }
}