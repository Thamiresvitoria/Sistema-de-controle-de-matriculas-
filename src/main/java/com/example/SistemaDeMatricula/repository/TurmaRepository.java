package com.example.SistemaDeMatricula.repository;

import com.example.SistemaDeMatricula.model.TurmaModel;

import java.util.List;

public interface TurmaRepository {

    void salvar(TurmaModel turma);

    List<TurmaModel> listar();

    TurmaModel buscarPorId(Long id);

    TurmaModel buscarPorCodigo(String codigo);

    void atualizar(TurmaModel turma);

    void excluir(Long id);
}