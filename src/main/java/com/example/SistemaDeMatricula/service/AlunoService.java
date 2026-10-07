package com.example.SistemaDeMatricula.service;

import com.example.SistemaDeMatricula.model.AlunoModel;
import com.example.SistemaDeMatricula.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepository repository;

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    public void salvar (AlunoModel aluno) {

        if (aluno == null) {
            throw new IllegalArgumentException("Aluno não pode ser inexistente");
        }

        if (aluno.getNome() == null || aluno.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }

        if (aluno.getEmail() == null || aluno.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("Email é obrigatório");
        }

        if (repository.existePorEmail(aluno.getEmail())) {
            throw new IllegalArgumentException("Email já cadastrado");
        }

        if (repository.existePorCpf(aluno.getCpf())) {
            throw new IllegalArgumentException("CPF já cadastrado");
        }

        repository.salvar(aluno);
    }

    public List<AlunoModel> listar() {
        return repository.listar();
    }

    public AlunoModel buscarPorId(Long id) {

        AlunoModel aluno = repository.buscarPorId(id);

        if (aluno == null) {
            throw new IllegalArgumentException("Aluno não encontrado");
        }

        return aluno;
    }

    public void atualizar(AlunoModel aluno) {

        if (aluno == null) {
            throw new IllegalArgumentException("Aluno não pode ser inexistente");
        }

        if (aluno.getNome() == null || aluno.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }

        if (aluno.getEmail() == null || aluno.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("Email é obrigatório");
        }

        repository.atualizar(aluno);
    }

    public void excluir(Long id) {

        AlunoModel aluno = repository.buscarPorId(id);

        if (aluno == null) {
            throw new IllegalArgumentException("Aluno não encontrado");
        }

        repository.excluir(id);
    }
}