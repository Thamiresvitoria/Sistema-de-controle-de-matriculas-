package com.example.SistemaDeMatricula.service;

import com.example.SistemaDeMatricula.model.AlunoModel;
import com.example.SistemaDeMatricula.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {
    private final AlunoRepository repository;

    public AlunoService(AlunoRepository repository){
        this.repository = repository;
    }

    public void salvar(AlunoModel aluno){
        repository.salvar(aluno);

        if (aluno.getNome() == null){
            throw new IllegalArgumentException("Nome é obrigatório");
        } else if(aluno.getEmail() == null){
            throw new IllegalArgumentException("Email é obrigatório");
        }

        repository.salvar(aluno);
    }

    public List<AlunoModel> listar(){
        return repository.listar();
    }

    public AlunoModel buscarPorId(Long id){
        return repository.buscarPorId(id);
    }

    public void atualizar(AlunoModel aluno){
        repository.atualizar(aluno);
    }

    public void excluir(Long id){
        repository.excluir(id);
    }
}
