package com.example.SistemaDeMatricula.repository;

import com.example.SistemaDeMatricula.model.AlunoModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AlunoRepositoryMemoria implements AlunoRepository {

    private final List<AlunoModel> alunos = new ArrayList<>();
    private Long proximoId = 1L;

    @Override
    public AlunoModel salvar(AlunoModel aluno) {
        aluno.setId(proximoId++);
        alunos.add(aluno);
        return aluno;
    }

    @Override
    public List<AlunoModel> listar() {
        return new ArrayList<>(alunos);
    }

    @Override
    public AlunoModel buscarPorId(Long id) {
        for (AlunoModel aluno : alunos) {
            if (aluno.getId().equals(id)) {
                return aluno;
            }
        }
        return null;
    }

    @Override
    public AlunoModel buscarPorCpf(String cpf) {
        for (AlunoModel aluno : alunos) {
            if (aluno.getCpf() != null && aluno.getCpf().equals(cpf)) {
                return aluno;
            }
        }
        return null;
    }

    @Override
    public AlunoModel buscarPorEmail(String email) {
        for (AlunoModel aluno : alunos) {
            if (aluno.getEmail() != null && aluno.getEmail().equalsIgnoreCase(email)) {
                return aluno;
            }
        }
        return null;
    }

    @Override
    public void atualizar(AlunoModel aluno) {
        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).getId().equals(aluno.getId())) {
                alunos.set(i, aluno);
                return;
            }
        }
    }

    @Override
    public void excluir(Long id) {
        alunos.removeIf(aluno -> aluno.getId().equals(id));
    }
}