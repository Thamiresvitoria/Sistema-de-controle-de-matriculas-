package com.example.SistemaDeMatricula.controller;

import com.example.SistemaDeMatricula.model.MatriculaModel;
import com.example.SistemaDeMatricula.service.MatriculaService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class MatriculaController {

    private final MatriculaService service;

    public MatriculaController(MatriculaService service) {
        this.service = service;
    }

    public void cadastrar(MatriculaModel matricula) {
        service.cadastrar(matricula);
    }

    public List<MatriculaModel> listar() {
        return service.listar();
    }

    public MatriculaModel buscarPorId(Long id) {
        return service.buscarPorId(id);
    }

    public void atualizar(Long id, MatriculaModel matricula) {
        matricula.setId(id);
        service.atualizar(matricula);
    }

    public void excluir(Long id) {
        service.excluir(id);
    }
}