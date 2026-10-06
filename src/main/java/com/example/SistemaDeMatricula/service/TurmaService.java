package com.example.SistemaDeMatricula.service;

import com.example.SistemaDeMatricula.model.AlunoModel;
import com.example.SistemaDeMatricula.model.TurmaModel;
import com.example.SistemaDeMatricula.repository.TurmaRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TurmaService {

    private static final int TotalDisciplina = 5;

    private final TurmaRepository repository;

    public TurmaService(TurmaRepository repository) {
        this.repository = repository;
    }


    private void validar(TurmaModel turma){
        if (turma == null){
            throw new RuntimeException("Turma inextistente.");
        }

        if (turma.getCodigo() == null || turma.getCodigo().isBlank()){
            throw new RuntimeException("A turma precisa de um código");
        }

        if (turma.getDisciplinas() == null || turma.getDisciplinas().isEmpty()){
            throw new RuntimeException("A turma precisa de disciplinas para ser cadastrada");
        }

        if(turma.getDisciplinas().size() != TotalDisciplina){
            throw new IllegalArgumentException("Só é permitido cadastrar 5 disciplinas");
        }

        if( turma.getHorario() == null){
            throw new RuntimeException("A turma precisa de um horário");
        }

        if(turma.getHorario().isBefore(LocalDateTime.now())){
            throw new RuntimeException("O horário da turma não pode estar no passado");
        }

        if(turma.getLimiteAlunos() <= 0){
            throw new RuntimeException("O limite máximo de alunos deve ser maior que zero.");
        }

        if(turma.getLimiteAlunos() > 30){
            throw new RuntimeException("A turma não pode ser maior que 30");
        }
    }


    public void salvar(TurmaModel turma) {

        validar(turma);

        TurmaModel existente = repository.buscarPorCodigo(turma.getCodigo());


        if (existente != null ) {
            throw new RuntimeException("Já existe uma turma com esse código.");
        }


        repository.salvar(turma);
    }

    public List<TurmaModel> listar(){
        return repository.listar();
    }

    public TurmaModel buscarPorId(Long id) {

        TurmaModel turma = repository.buscarPorId(id);

        if (turma == null) {
            throw new RuntimeException("Turma não encontrada.");
        }

        return turma;
    }

    public TurmaModel buscarPorCodigo(String codigo){

        TurmaModel turma = repository.buscarPorCodigo(codigo);

        if(turma == null){
            throw new IllegalArgumentException("Esse codígo não existe");
        }

        return turma;
    }

    public void atualizar(TurmaModel turma){
        TurmaModel existente =repository.buscarPorId(turma.getId());

            if(existente == null){
                throw new RuntimeException("Turma não encontrada.");
            }

           TurmaModel comMesmoCodigo = repository.buscarPorCodigo(turma.getCodigo());

            if (comMesmoCodigo != null && !comMesmoCodigo.getId().equals(turma.getId())){
                throw new RuntimeException("Já existe outra turma com esse código");
            }

            repository.atualizar(turma);
    }

    public void excluir(Long id){

        TurmaModel existente = repository.buscarPorId(id);

        if(existente == null) {
            throw new IllegalArgumentException("Não é possivel excliuir uma turma que não existe!");
        }

        repository.excluir(id);
    }

}