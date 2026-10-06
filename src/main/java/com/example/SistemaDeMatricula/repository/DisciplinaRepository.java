package com.example.SistemaDeMatricula.repository;

import com.example.SistemaDeMatricula.model.DisciplinaModel;

import java.util.List;

public interface DisciplinaRepository {

    void salvar(DisciplinaModel disciplina);

    List<DisciplinaModel> listar();

    DisciplinaModel buscarPorId(Long id);

    void atualizar(DisciplinaModel disciplina);

    void excluir(Long id);
}