package com.example.SistemaDeMatricula.repository;

import com.example.SistemaDeMatricula.model.MatriculaModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MatriculaRepositoryMemoria implements MatriculaRepository {

    private final List<MatriculaModel> matriculas = new ArrayList<>();
    private Long proximoId = 1L;

    @Override
    public void salvar(MatriculaModel matricula) {
        matricula.setId(proximoId++);
        matriculas.add(matricula);
    }

    @Override
    public List<MatriculaModel> listar() {
        return new ArrayList<>(matriculas);
    }

    @Override
    public MatriculaModel buscarPorId(Long id) {
        for (MatriculaModel matricula : matriculas) {
            if (matricula.getId().equals(id)) {
                return matricula;
            }
        }
        return null;
    }

    @Override
    public List<MatriculaModel> buscarPorAluno(Long alunoId) {
        List<MatriculaModel> resultado = new ArrayList<>();
        for (MatriculaModel matricula : matriculas) {
            if (matricula.getAluno().getId().equals(alunoId)) {
                resultado.add(matricula);
            }
        }
        return resultado;
    }

    @Override
    public List<MatriculaModel> buscarPorTurma(Long turmaId) {
        List<MatriculaModel> resultado = new ArrayList<>();
        for (MatriculaModel matricula : matriculas) {
            if (matricula.getTurma().getId().equals(turmaId)) {
                resultado.add(matricula);
            }
        }
        return resultado;
    }

    @Override
    public void atualizar(MatriculaModel matricula) {
        for (int i = 0; i < matriculas.size(); i++) {
            if (matriculas.get(i).getId().equals(matricula.getId())) {
                matriculas.set(i, matricula);
                return;
            }
        }
    }

    @Override
    public void excluir(Long id) {
        matriculas.removeIf(matricula -> matricula.getId().equals(id));
    }
}