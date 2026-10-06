package com.example.SistemaDeMatricula.service;

import com.example.SistemaDeMatricula.model.TurmaModel;
import com.example.SistemaDeMatricula.repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TurmaService {

    private static final int TOTAL_DISCIPLINAS = 5;

    private final TurmaRepository repository;

    public TurmaService(TurmaRepository repository) {
        this.repository = repository;
    }

    private void validar(TurmaModel turma) {

        if (turma == null) {
            throw new RuntimeException("Turma inexistente.");
        }

        if (turma.getCodigo() == null || turma.getCodigo().isBlank()) {
            throw new RuntimeException("A turma precisa de um identificador.");
        }

        if (turma.getDisciplinas() == null || turma.getDisciplinas().isEmpty()) {
            throw new RuntimeException("A turma não pode existir sem disciplinas.");
        }

        if (turma.getDisciplinas().size() != TOTAL_DISCIPLINAS) {
            throw new RuntimeException(
                    "A turma deve ter exatamente " + TOTAL_DISCIPLINAS + " disciplinas."
            );
        }

        if (turma.getHorario() == null) {
            throw new RuntimeException("A turma precisa de um horário.");
        }

        if (turma.getHorario().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("O horário da turma não pode estar no passado.");
        }

        if (turma.getLimiteAlunos() <= 0) {
            throw new RuntimeException("O limite máximo de alunos deve ser maior que zero.");
        }
    }

    public void salvar(TurmaModel turma) {

        validar(turma);

        if (repository.buscarPorCodigo(turma.getCodigo()) != null) {
            throw new RuntimeException("Já existe uma turma com esse identificador.");
        }

        repository.salvar(turma);
    }

    public List<TurmaModel> listar() {
        return repository.listar();
    }

    public TurmaModel buscarPorId(Long id) {

        TurmaModel turma = repository.buscarPorId(id);

        if (turma == null) {
            throw new RuntimeException("Turma inexistente.");
        }

        return turma;
    }

    public TurmaModel buscarPorCodigo(String codigo) {

        TurmaModel turma = repository.buscarPorCodigo(codigo);

        if (turma == null) {
            throw new RuntimeException("Turma inexistente.");
        }

        return turma;
    }

    public void atualizar(TurmaModel turma) {

        validar(turma);

        buscarPorId(turma.getId());

        TurmaModel comMesmoCodigo = repository.buscarPorCodigo(turma.getCodigo());

        if (comMesmoCodigo != null && !comMesmoCodigo.getId().equals(turma.getId())) {
            throw new RuntimeException("Já existe outra turma com esse identificador.");
        }

        repository.atualizar(turma);
    }

    public void cancelar(Long id) {

        TurmaModel turma = buscarPorId(id);

        if (turma.isStatus()) {
            throw new RuntimeException("A turma já está cancelada.");
        }

        turma.setStatus(true);
        repository.atualizar(turma);
    }

    public void excluir(Long id) {

        buscarPorId(id);
        repository.excluir(id);
    }
}