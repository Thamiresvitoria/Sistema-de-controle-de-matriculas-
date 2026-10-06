package com.example.SistemaDeMatricula.repository;

import com.example.SistemaDeMatricula.model.MatriculaModel;

import java.util.List;

public interface MatriculaRepository {

    void salvar(MatriculaModel matricula);

    List<MatriculaModel> listar();

    MatriculaModel buscarPorId(Long id);

    List<MatriculaModel> buscarPorAluno(Long alunoId);

    List<MatriculaModel> buscarPorTurma(Long turmaId);

    void atualizar(MatriculaModel matricula);

    void excluir(Long id);
}