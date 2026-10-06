package com.example.SistemaDeMatricula.model;


public class MatriculaModel {

    private Long id;
    private AlunoModel aluno;
    private TurmaModel turma;
    private DisciplinaModel disciplina;

    // Construtor vazio
    public MatriculaModel() {
    }

    // Construtor completo
    public MatriculaModel(
            Long id,
            AlunoModel aluno,
            TurmaModel turma,
            DisciplinaModel disciplina
    ) {
        this.id = id;
        this.aluno = aluno;
        this.turma = turma;
        this.disciplina = disciplina;
    }

    // Getters e Setters

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

    // toString

    @Override
    public String toString() {
        return "Matricula" + "\n" +
                "id:" + id + "\n" +
                "Aluno:" + aluno + "\n" +
                "Turma:" + turma + "\n" +
                "isciplina:" + disciplina
                ;
    }
}