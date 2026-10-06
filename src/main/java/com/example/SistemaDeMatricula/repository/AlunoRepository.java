package com.example.SistemaDeMatricula.repository;
import com.example.SistemaDeMatricula.model.AlunoModel;
import java.util.List;

public interface AlunoRepository {

    AlunoModel salvar(AlunoModel aluno);

    Optional<AlunoModel> buscarPorId(Long id);

    Optional<AlunoModel> buscarPorCpf(String cpf);

    AlunoModel buscarPorEmail(String email);

    void atualizar(AlunoModel aluno);

    void excluir(Long id);
}
