package com.example.SistemaDeMatricula.service;

import com.example.SistemaDeMatricula.model.AlunoModel;
import com.example.SistemaDeMatricula.model.TurmaModel;
import com.example.SistemaDeMatricula.repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaService {

    private final TurmaRepository repository;

    public TurmaService(TurmaRepository repository) {
        this.repository = repository;
    }

    public void salvar(TurmaModel turma) {

        TurmaModel existente = repository.buscarPorCodigo(turma.getCodigo());


        if (existente != null ) {
            throw new RuntimeException("Já existe uma turma com esse código.");
        }


        repository.salvar(turma);
    }

    public List<TurmaModel> listar(){
        return repository.listar();
    }



}