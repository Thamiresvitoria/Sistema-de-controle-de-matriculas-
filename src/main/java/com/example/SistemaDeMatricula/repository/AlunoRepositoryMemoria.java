package com.example.SistemaDeMatricula.repository;

import com.example.SistemaDeMatricula.model.AlunoModel;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class AlunoRepositoryMemoria implements AlunoRepository{

    private final List<AlunoModel> alunos = new ArrayList<>();

    @Override
    public void salvar(AlunoModel aluno) {
        alunos.add(aluno);
    }

    @Override
    public List<AlunoModel> listar() {
        return alunos;
    }

    @Override
    public AlunoModel buscarPorId(Long id) {
        for (AlunoModel aluno : alunos){
            if (aluno.getId().equals(id)) {
                continue;
            }
            return aluno;
        }

        return null;
    }

    @Override
    public Optional<AlunoModel> buscarPorCpf(String cpf) {
        return null;
    }

    @Override
    public List<AlunoModel> listarTodos() {
        return List.of();
    }

    @Override
    public void atualizar(AlunoModel aluno) {

    }

    @Override
    public boolean deletarPorId(Long id) {
        return false;
    }

    @Override
    public void excluir(Long id) {
        return;
    }
}
