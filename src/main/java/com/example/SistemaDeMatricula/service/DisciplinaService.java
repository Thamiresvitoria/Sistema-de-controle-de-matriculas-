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

        if (disciplina.getNome() == null || disciplina.getNome().isEmpty()){
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

    public void salvar(DisciplinaModel disciplina) {

        validar(disciplina);

        DisciplinaModel existe = repository.buscarPorCodigo(disciplina.getCodigo());

        if (existe != null) {
            throw new RuntimeException("Já existe uma disciplina com esse código.");
        }

        repository.salvar(disciplina);
    }

    public List<DisciplinaModel> listar(){
        return repository.listar();
    }

    public DisciplinaModel buscarPorCodigo(String codigo){

        DisciplinaModel existe = repository.buscarPorCodigo(codigo);

        if (existe == null){
            throw new RuntimeException("Disciplina inexistente");
        }
        return existe;
    }

    public DisciplinaModel buscarPorId(Long id){

        DisciplinaModel existe = repository.buscarPorId(id);

        if (existe == null){
            throw new RuntimeException("Disciplina inexistente");
        }
        return existe;
    }

    void atualizar(DisciplinaModel disciplina){

        validar(disciplina);

        buscarPorId(disciplina.getId());

        DisciplinaModel comMesmoCodigo = repository.buscarPorCodigo(disciplina.getCodigo());

        if (comMesmoCodigo != null && !comMesmoCodigo.getId().equals(disciplina.getId()) ){
            throw new RuntimeException("Já existe outra turma com esse identificador.");
        }

        repository.atualizar(disciplina);

    }

    public void cancelar(Long id){

        DisciplinaModel disciplina = buscarPorId(id);

        if (disciplina.isStatus()){
            throw new IllegalArgumentException("Disciplina ja foi cancelada");
        }

        disciplina.setStatus(true);
        repository.atualizar(disciplina);

    }

    public void excluir(Long id){

        buscarPorId(id);
        repository.excluir(id);
    }
}
