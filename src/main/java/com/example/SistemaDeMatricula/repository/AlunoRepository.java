package com.example.SistemaDeMatricula.repository;
import com.example.SistemaDeMatricula.model.AlunoModel;
import java.util.List;

public interface AlunoRepository {

    AlunoModel salvar(AlunoModel aluno);

    Optional<AlunoModel> buscarPorId(Long id);

    Optional<AlunoModel> buscarPorCpf(String cpf);

    List<AlunoModel> listarTodos();

    void atualizar(AlunoModel aluno);

    boolean deletarPorId(Long id);
}
