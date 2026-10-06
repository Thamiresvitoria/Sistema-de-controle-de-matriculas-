package com.example.SistemaDeMatricula.controller;

import com.example.SistemaDeMatricula.model.AlunoModel;
import com.example.SistemaDeMatricula.service.AlunoService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AlunoController {

    private final AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    public void cadastrar(AlunoModel aluno) {
        service.cadastrar(aluno);
    }

    public List<AlunoModel> listar() {
        return service.listar();
    }

    public AlunoModel buscarPorId(Long id) {
        return service.buscarPorId(id);
    }

    public void atualizar(Long id, AlunoModel aluno) {
        aluno.setId(id);
        service.atualizar(aluno);
    }

    public void excluir(Long id) {
        service.excluir(id);
    }
}
