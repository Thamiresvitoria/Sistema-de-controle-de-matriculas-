package com.example.SistemaDeMatricula.repository;

import com.example.SistemaDeMatricula.model.AlunoModel;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;


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
    public void atualizar(AlunoModel aluno) {

    }

    @Override
    public void excluir(Long id) {
        return;
    }
}
