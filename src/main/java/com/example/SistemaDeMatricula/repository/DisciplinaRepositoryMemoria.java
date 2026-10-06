package com.example.SistemaDeMatricula.repository;

import com.example.SistemaDeMatricula.model.DisciplinaModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DisciplinaRepositoryMemoria implements DisciplinaRepository {

    private final List<DisciplinaModel> disciplinas = new ArrayList<>();
    private Long proximoId = 1L;

    @Override
    public void salvar(DisciplinaModel disciplina) {
        disciplina.setId(proximoId++);
        disciplinas.add(disciplina);
    }

    @Override
    public List<DisciplinaModel> listar() {
        return new ArrayList<>(disciplinas);
    }

    @Override
    public DisciplinaModel buscarPorId(Long id) {
        for (DisciplinaModel disciplina : disciplinas) {
            if (disciplina.getId().equals(id)) {
                return disciplina;
            }
        }
        return null;
    }

    @Override
    public void atualizar(DisciplinaModel disciplina) {
        for (int i = 0; i < disciplinas.size(); i++) {
            if (disciplinas.get(i).getId().equals(disciplina.getId())) {
                disciplinas.set(i, disciplina);
                return;
            }
        }
    }

    @Override
    public void excluir(Long id) {
        disciplinas.removeIf(disciplina -> disciplina.getId().equals(id));
    }
}