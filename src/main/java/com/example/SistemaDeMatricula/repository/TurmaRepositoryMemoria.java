package com.example.SistemaDeMatricula.repository;

import com.example.SistemaDeMatricula.model.TurmaModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TurmaRepositoryMemoria implements TurmaRepository {

    private final List<TurmaModel> turmas = new ArrayList<>();
    private Long proximoId = 1L;

    @Override
    public void salvar(TurmaModel turma) {
        turma.setId(proximoId++);
        turmas.add(turma);
    }

    @Override
    public List<TurmaModel> listar() {
        return new ArrayList<>(turmas);
    }

    @Override
    public TurmaModel buscarPorId(Long id) {
        for (TurmaModel turma : turmas) {
            if (turma.getId().equals(id)) {
                return turma;
            }
        }
        return null;
    }

    @Override
    public TurmaModel buscarPorCodigo(String codigo) {
        for (TurmaModel turma : turmas) {
            if (turma.getCodigo() != null && turma.getCodigo().equalsIgnoreCase(codigo)) {
                return turma;
            }
        }
        return null;
    }

    @Override
    public void atualizar(TurmaModel turma) {
        for (int i = 0; i < turmas.size(); i++) {
            if (turmas.get(i).getId().equals(turma.getId())) {
                turmas.set(i, turma);
                return;
            }
        }
    }

    @Override
    public void excluir(Long id) {
        turmas.removeIf(turma -> turma.getId().equals(id));
    }
}