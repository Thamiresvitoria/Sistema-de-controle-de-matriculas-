package com.example.SistemaDeMatricula.service;

import com.example.SistemaDeMatricula.model.AlunoModel;
import com.example.SistemaDeMatricula.model.DisciplinaModel;
import com.example.SistemaDeMatricula.model.MatriculaModel;
import com.example.SistemaDeMatricula.model.TurmaModel;
import com.example.SistemaDeMatricula.repository.AlunoRepository;
import com.example.SistemaDeMatricula.repository.DisciplinaRepository;
import com.example.SistemaDeMatricula.repository.MatriculaRepository;
import com.example.SistemaDeMatricula.repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;
    private final AlunoRepository alunoRepository;
    private final DisciplinaRepository disciplinaRepository;
    private final TurmaRepository turmaRepository;

    public MatriculaService(
            MatriculaRepository matriculaRepository,
            AlunoRepository alunoRepository,
            DisciplinaRepository disciplinaRepository,
            TurmaRepository turmaRepository
    ) {
        this.matriculaRepository = matriculaRepository;
        this.alunoRepository = alunoRepository;
        this.disciplinaRepository = disciplinaRepository;
        this.turmaRepository = turmaRepository;
    }

    public void salvar(MatriculaModel matricula) {

        // 1. Verificar se o aluno existe
        AlunoModel aluno = alunoRepository.buscarPorId(
                matricula.getAluno().getId()
        );

        if (aluno == null) {
            throw new RuntimeException("Aluno não encontrado.");
        }

        // 2. Verificar se a disciplina existe
        DisciplinaModel disciplina = disciplinaRepository.buscarPorId(
                matricula.getDisciplina().getId()
        );

        if (disciplina == null) {
            throw new RuntimeException("Disciplina não encontrada.");
        }

        // 3. Verificar se a turma existe
        TurmaModel turma = turmaRepository.buscarPorId(
                matricula.getTurma().getId()
        );

        if (turma == null) {
            throw new RuntimeException("Turma não encontrada.");
        }

        // 4. Verificar se o aluno já está matriculado na disciplina
        List<MatriculaModel> matriculasDoAluno =
                matriculaRepository.buscarPorAluno(aluno.getId());

        for (MatriculaModel m : matriculasDoAluno) {
            if (m.getDisciplina().getId().equals(disciplina.getId())) {
                throw new RuntimeException(
                        "Aluno já está matriculado nessa disciplina."
                );
            }
        }

        // 5. Se passou por todas as regras
        matriculaRepository.salvar(matricula);
    }

    public List<MatriculaModel> listar() {
        return matriculaRepository.listar();
    }

    public MatriculaModel buscarPorId(Long id) {

        MatriculaModel matricula = matriculaRepository.buscarPorId(id);

        if (matricula == null) {
            throw new RuntimeException("Matrícula não encontrada.");
        }

        return matricula;
    }

    public List<MatriculaModel> buscarPorAluno(Long alunoId) {
        return matriculaRepository.buscarPorAluno(alunoId);
    }

    public List<MatriculaModel> buscarPorTurma(Long turmaId) {
        return matriculaRepository.buscarPorTurma(turmaId);
    }

    public void atualizar(MatriculaModel matricula) {

        MatriculaModel existente =
                matriculaRepository.buscarPorId(matricula.getId());

        if (existente == null) {
            throw new RuntimeException("Matrícula não encontrada.");
        }

        matriculaRepository.atualizar(matricula);
    }

    public void excluir(Long id) {

        MatriculaModel existente = matriculaRepository.buscarPorId(id);

        if (existente == null) {
            throw new RuntimeException("Matrícula não encontrada.");
        }

        matriculaRepository.excluir(id);
    }
}