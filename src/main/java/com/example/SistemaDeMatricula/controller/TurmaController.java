package com.example.SistemaDeMatricula.controller;

import com.example.SistemaDeMatricula.model.TurmaModel;
import com.example.SistemaDeMatricula.service.TurmaService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TurmaController {

    private final TurmaService service;

    public TurmaController(TurmaService service) {
        this.service = service;
    }

    public void cadastrar(TurmaModel turma) {
        service.cadastrar(turma);
    }

    public List<TurmaModel> listar() {
        return service.listar();
    }

    public TurmaModel buscarPorId(Long id) {
        return service.buscarPorId(id);
    }

    public void atualizar(Long id, TurmaModel turma) {
        turma.setId(id);
        service.atualizar(turma);
    }

    public void excluir(Long id) {
        service.excluir(id);
    }
}