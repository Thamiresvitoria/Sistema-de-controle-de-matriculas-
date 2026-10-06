package com.example.SistemaDeMatricula.service;

import com.example.SistemaDeMatricula.model.AlunoModel;
import com.example.SistemaDeMatricula.model.DisciplinaModel;
import com.example.SistemaDeMatricula.repository.DisciplinaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DisciplinaService {

    private final DisciplinaRepository repository;

    public DisciplinaService(DisciplinaRepository repository) {
        this.repository = repository;
    }

    public void validar(DisciplinaModel disciplina){

        if (disciplina.getNome() == null){
            throw new IllegalArgumentException("A disciplina precisa ter um nome!");
        }

        if (disciplina.getCodigo() == null || disciplina.getCodigo().isBlank()){
            throw new IllegalArgumentException("A disciplina não pode ter o codígo vazio");
        }

        if (disciplina.getCargaHoraria() < 0){
            throw new IllegalArgumentException("A carga horária não pode ser negativo");
        }

        if(disciplina.getCargaHoraria() > 1.050){
            throw new IllegalArgumentException("A carga horária não pode ultrapassar 1050!");
        }
    }
}
