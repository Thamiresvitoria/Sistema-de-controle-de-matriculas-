package com.example.SistemaDeMatricula.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TurmaModel {
    private Long id;
    private String codigo;
    private String nome;
    private String turno;
    private boolean status; // true = cancelada
    private LocalDateTime horario;
    private int limiteAlunos;
    private List<DisciplinaModel> disciplinas = new ArrayList<>();

    public TurmaModel(String codigo, String nome, String turno) {
        this.codigo = codigo;
        this.nome = nome;
        this.turno = turno;
        this.status = false;
    }

    public TurmaModel(String codigo, String nome, String turno,
                      LocalDateTime horario, int limiteAlunos,
                      List<DisciplinaModel> disciplinas) {
        this(codigo, nome, turno);
        this.horario = horario;
        this.limiteAlunos = limiteAlunos;
        this.disciplinas = disciplinas;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getTurno() { return turno; }
    public void setTurno(String turno) { this.turno = turno; }

    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }

    public LocalDateTime getHorario() { return horario; }
    public void setHorario(LocalDateTime horario) { this.horario = horario; }

    public int getLimiteAlunos() { return limiteAlunos; }
    public void setLimiteAlunos(int limiteAlunos) { this.limiteAlunos = limiteAlunos; }

    public List<DisciplinaModel> getDisciplinas() { return disciplinas; }
    public void setDisciplinas(List<DisciplinaModel> disciplinas) { this.disciplinas = disciplinas; }

    @Override
    public String toString() {
        return "Turma" + "\n" +
                "id.........:" + id + "\n" +
                "Codigo.....:" + codigo + "\n" +
                "Nome.......:" + nome + "\n" +
                "Turno......:" + turno + "\n" +
                "Cancelada..:" + status + "\n" +
                "Horario....:" + horario + "\n" +
                "Limite.....:" + limiteAlunos + "\n" +
                "Disciplinas:" + (disciplinas == null ? 0 : disciplinas.size());
    }
}