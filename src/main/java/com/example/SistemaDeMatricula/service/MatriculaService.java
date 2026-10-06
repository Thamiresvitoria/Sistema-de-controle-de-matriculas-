package com.example.SistemaDeMatricula.service;


import com.example.SistemaDeMatricula.model.AlunoModel;
import com.example.SistemaDeMatricula.model.MatriculaModel;
import com.example.SistemaDeMatricula.model.TurmaModel;
import com.example.SistemaDeMatricula.model.DisciplinaModel;
import com.example.SistemaDeMatricula.repository.MatriculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaService {

    private final MatriculaRepository repository;
    private final TurmaService turmaService;
    private final DisciplinaService disciplinaService;
    private final AlunoService alunoService;

    public MatriculaService (MatriculaRepository repository, TurmaService turmaService, DisciplinaService disciplinaService, AlunoService alunoService){
        this.repository = repository;
        this.turmaService = turmaService;
        this.disciplinaService = disciplinaService;
        this.alunoService = alunoService;
    }


    public void salvar(MatriculaModel matricula) {

        //A matricula não pode ser nula

        if (matricula ==  null){
            throw new IllegalArgumentException("A matricula está vazia");
        }

        // verificando se o aluno existe
        if (matricula.getAluno() == null){
            throw new IllegalArgumentException("Aluno não informado");
        }

        // verificando se a disciplina existe
        if (matricula.getDisciplina() == null){
            throw new IllegalArgumentException("Disciplina não informada!");
        }

        // verificando se a turma existe
        if (matricula.getTurma() == null ){
            throw new IllegalArgumentException("Turma não existe");
        }

        // verificando se o aluno existe no sistema
        AlunoModel aluno = alunoService.buscarPorId(
                matricula.getAluno().getId()
        );

        if (aluno == null){
            throw new IllegalArgumentException("O aluno informado não existe");
        }

        // verificando se a turma existe no sistema



        // Verifica se já existe uma matrícula igual
        for (MatriculaModel existente : repository.listar()) {

            if (existente.getAluno().getId()
                    .equals(matricula.getAluno().getId())
                    && existente.getDisciplina().getId()
                    .equals(matricula.getDisciplina().getId())
                    && existente.getTurma().getId()
                    .equals(matricula.getTurma().getId())) {

                throw new IllegalArgumentException(
                        "Aluno já está matriculado nessa disciplina e turma."
                );
            }


        }

        repository.salvar(matricula);
    }

}
