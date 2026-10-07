package com.example.SistemaDeMatricula.repository;

import com.example.SistemaDeMatricula.model.AlunoModel;

import java.util.List;

public interface AlunoRepository {

    AlunoModel salvar(AlunoModel aluno);

    List<AlunoModel> listar();

    AlunoModel buscarPorId(Long id);

    AlunoModel buscarPorCpf(String cpf);

    AlunoModel buscarPorEmail(String email);

    boolean existePorCpf(String cpf);

    boolean existePorEmail(String email);

    void atualizar(AlunoModel aluno);

    void excluir(Long id);
}