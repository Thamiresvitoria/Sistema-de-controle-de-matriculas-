package com.example.SistemaDeMatricula.controller;

import com.example.SistemaDeMatricula.model.DisciplinaModel;
import com.example.SistemaDeMatricula.service.DisciplinaService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class DisciplinaController {

    private final DisciplinaService service;

    public DisciplinaController(DisciplinaService service) {
        this.service = service;
    }

    public void cadastrar(DisciplinaModel disciplina) {
        service.salvar(disciplina);
    }

    public List<DisciplinaModel> listar() {
        return service.listar();
    }

    public DisciplinaModel buscarPorId(Long id) {
        return service.buscarPorId(id);
    }

    public void atualizar(Long id, DisciplinaModel disciplina) {
        disciplina.setId(id);
        service.atualizar(disciplina);
    }

    public void excluir(Long id) {
        service.excluir(id);
    }
}