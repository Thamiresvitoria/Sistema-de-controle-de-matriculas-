package com.example.sistemaDeMatricula;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.SistemaDeMatricula.repository.*;
import com.example.SistemaDeMatricula.service.AlunoService;
import com.example.SistemaDeMatricula.service.DisciplinaService;
import com.example.SistemaDeMatricula.service.MatriculaService;
import com.example.SistemaDeMatricula.service.TurmaService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.example.SistemaDeMatricula.model.AlunoModel;
import com.example.SistemaDeMatricula.model.MatriculaModel;
import com.example.SistemaDeMatricula.model.DisciplinaModel;
import com.example.SistemaDeMatricula.model.TurmaModel;

import java.time.LocalDateTime;
import java.util.List;

public class MatriculaServiceTest {

    // Teste 1: Matricula valida
    @Test
    void deveSalvarMatricula() {

        // Repositórios
        AlunoRepositoryMemoria alunoRepository =
                new AlunoRepositoryMemoria();

        DisciplinaRepositoryMemoria disciplinaRepository =
                new DisciplinaRepositoryMemoria();

        TurmaRepositoryMemoria turmaRepository =
                new TurmaRepositoryMemoria();

        MatriculaRepositoryMemoria matriculaRepository =
                new MatriculaRepositoryMemoria();


        // Services
        AlunoService alunoService =
                new AlunoService(alunoRepository);

        DisciplinaService disciplinaService =
                new DisciplinaService(disciplinaRepository);

        TurmaService turmaService =
                new TurmaService(turmaRepository);

        MatriculaService matriculaService =
                new MatriculaService(
                        matriculaRepository,
                        alunoRepository,
                        disciplinaRepository,
                        turmaRepository
                );


        // Aluno
        AlunoModel aluno = new AlunoModel(
                1L,
                "Gustavo",
                "12345678900",
                "email@exemplo.com"
        );


        // 5 disciplinas
        DisciplinaModel disciplina1 =
                new DisciplinaModel(
                        "Java",
                        "002",
                        10
                );

        DisciplinaModel disciplina2 =
                new DisciplinaModel(
                        "Banco de Dados",
                        "BD",
                        130
                );

        DisciplinaModel disciplina3 =
                new DisciplinaModel(
                        "Redes",
                        "REDES",
                        50
                );

        DisciplinaModel disciplina4 =
                new DisciplinaModel(
                        "Engenharia de Software",
                        "ES",
                        60
                );

        DisciplinaModel disciplina5 =
                new DisciplinaModel(
                        "UX/UI",
                        "UX",
                        12
                );


        // Turma com as 5 disciplinas
        TurmaModel turma = new TurmaModel(
                "E02",
                "Turma E02",
                "Manhã",
                LocalDateTime.of(2026, 10, 26, 8, 0),
                40,
                List.of(
                        disciplina1,
                        disciplina2,
                        disciplina3,
                        disciplina4,
                        disciplina5
                )
        );


        // Salvar os dados necessários
        alunoService.salvar(aluno);

        disciplinaService.salvar(disciplina1);
        disciplinaService.salvar(disciplina2);
        disciplinaService.salvar(disciplina3);
        disciplinaService.salvar(disciplina4);
        disciplinaService.salvar(disciplina5);

        turmaService.salvar(turma);


        // Criar 5 matrículas
        // O mesmo aluno fica matriculado nas 5 disciplinas

        MatriculaModel matricula1 =
                new MatriculaModel(
                        1L,
                        aluno,
                        turma,
                        disciplina1
                );

        MatriculaModel matricula2 =
                new MatriculaModel(
                        2L,
                        aluno,
                        turma,
                        disciplina2
                );

        MatriculaModel matricula3 =
                new MatriculaModel(
                        3L,
                        aluno,
                        turma,
                        disciplina3
                );

        MatriculaModel matricula4 =
                new MatriculaModel(
                        4L,
                        aluno,
                        turma,
                        disciplina4
                );

        MatriculaModel matricula5 =
                new MatriculaModel(
                        5L,
                        aluno,
                        turma,
                        disciplina5
                );


        // Salvar as matrículas
        matriculaService.salvar(matricula1);
        matriculaService.salvar(matricula2);
        matriculaService.salvar(matricula3);
        matriculaService.salvar(matricula4);
        matriculaService.salvar(matricula5);


        // Verificar se as 5 matrículas foram salvas
        assertEquals(5, matriculaRepository.listar().size());
    }

    // Teste 2: Deve salvar alunos
    @Test
    void deveSalvarAluno(){

        AlunoRepositoryMemoria alunoRepository = new AlunoRepositoryMemoria();

        AlunoService service = new AlunoService(alunoRepository);

        AlunoModel aluno = new AlunoModel(2L, "Oliver", "123.123.123-11", "oliver@gmail.com");

        service.salvar(aluno);

        assertTrue(alunoRepository.listar().contains(aluno));
    }

    // Teste 3: Disciplina deve da erro
    @Test
    void naoDeveAceitaCargaHorariaNegativa(){

        DisciplinaRepositoryMemoria repository = new DisciplinaRepositoryMemoria();
        DisciplinaService service = new DisciplinaService(repository);

        DisciplinaModel disciplina1 = new DisciplinaModel("Anatomia", "666", -5);

        service.salvar(disciplina1);

        assertThrows(IllegalArgumentException.class, () -> service.salvar(disciplina1));
    }

    // Teste 4: Turma

    @Test
    void deveSalvarTurmaComCincoDisciplinas() {

        DisciplinaRepositoryMemoria disciplinaRepository =
                new DisciplinaRepositoryMemoria();

        TurmaRepositoryMemoria turmaRepository =
                new TurmaRepositoryMemoria();

        DisciplinaService disciplinaService =
                new DisciplinaService(disciplinaRepository);

        TurmaService turmaService =
                new TurmaService(turmaRepository);


        DisciplinaModel disciplina1 =
                new DisciplinaModel("Java", "002", 100);

        DisciplinaModel disciplina2 =
                new DisciplinaModel("Banco de Dados", "BD", 100);

        DisciplinaModel disciplina3 =
                new DisciplinaModel("Redes", "REDES", 100);

        DisciplinaModel disciplina4 =
                new DisciplinaModel("Engenharia de Software", "ES", 100);

        DisciplinaModel disciplina5 =
                new DisciplinaModel("UX/UI", "UX", 100);


        disciplinaService.salvar(disciplina1);
        disciplinaService.salvar(disciplina2);
        disciplinaService.salvar(disciplina3);
        disciplinaService.salvar(disciplina4);
        disciplinaService.salvar(disciplina5);


        TurmaModel turma = new TurmaModel(
                "E02",
                "Turma E02",
                "Manhã",
                LocalDateTime.now().plusDays(1),
                40,
                List.of(
                        disciplina1,
                        disciplina2,
                        disciplina3,
                        disciplina4,
                        disciplina5
                )
        );


        turmaService.salvar(turma);

        assertTrue(turmaRepository.listar().contains(turma));
    }

    // Teste 5: Matricula duas vezes

    @Test
    void naoDevePermitirMatriculaDuplicada() {

        // Repositórios
        AlunoRepositoryMemoria alunoRepository = new AlunoRepositoryMemoria();
        DisciplinaRepositoryMemoria disciplinaRepository = new DisciplinaRepositoryMemoria();
        TurmaRepositoryMemoria turmaRepository = new TurmaRepositoryMemoria();
        MatriculaRepositoryMemoria matriculaRepository = new MatriculaRepositoryMemoria();

        // Services
        AlunoService alunoService = new AlunoService(alunoRepository);
        DisciplinaService disciplinaService = new DisciplinaService(disciplinaRepository);
        TurmaService turmaService = new TurmaService(turmaRepository);
        MatriculaService matriculaService = new MatriculaService(
                matriculaRepository,
                alunoRepository,
                disciplinaRepository,
                turmaRepository
        );

        // Aluno
        AlunoModel aluno = new AlunoModel(1L, "Gustavo", "12345678900", "email@exemplo.com");

        // Disciplinas
        DisciplinaModel disciplina1 = new DisciplinaModel("Java", "002", 10);
        DisciplinaModel disciplina2 = new DisciplinaModel("Banco de Dados", "BD", 130);
        DisciplinaModel disciplina3 = new DisciplinaModel("Redes", "REDES", 50);
        DisciplinaModel disciplina4 = new DisciplinaModel("Engenharia de Software", "ES", 60);
        DisciplinaModel disciplina5 = new DisciplinaModel("UX/UI", "UX", 12);

        // Turma
        TurmaModel turma = new TurmaModel(
                "E02",
                "Turma E02",
                "Manhã",
                LocalDateTime.of(2026, 10, 26, 8, 0),
                40,
                List.of(disciplina1, disciplina2, disciplina3, disciplina4, disciplina5)
        );

        // Salvar dados necessários
        alunoService.salvar(aluno);
        disciplinaService.salvar(disciplina1);
        disciplinaService.salvar(disciplina2);
        disciplinaService.salvar(disciplina3);
        disciplinaService.salvar(disciplina4);
        disciplinaService.salvar(disciplina5);
        turmaService.salvar(turma);

        // 5 matrículas válidas
        matriculaService.salvar(new MatriculaModel(1L, aluno, turma, disciplina1));
        matriculaService.salvar(new MatriculaModel(2L, aluno, turma, disciplina2));
        matriculaService.salvar(new MatriculaModel(3L, aluno, turma, disciplina3));
        matriculaService.salvar(new MatriculaModel(4L, aluno, turma, disciplina4));
        matriculaService.salvar(new MatriculaModel(5L, aluno, turma, disciplina5));

        // Tentativas de duplicar: IDs novos, mesmo aluno + turma + disciplina
        MatriculaModel duplicada1 = new MatriculaModel(101L, aluno, turma, disciplina1);
        MatriculaModel duplicada2 = new MatriculaModel(102L, aluno, turma, disciplina2);
        MatriculaModel duplicada3 = new MatriculaModel(103L, aluno, turma, disciplina3);
        MatriculaModel duplicada4 = new MatriculaModel(104L, aluno, turma, disciplina4);
        MatriculaModel duplicada5 = new MatriculaModel(105L, aluno, turma, disciplina5);

        assertAll(
                () -> assertThrows(RuntimeException.class, () -> matriculaService.salvar(duplicada1)),
                () -> assertThrows(RuntimeException.class, () -> matriculaService.salvar(duplicada2)),
                () -> assertThrows(RuntimeException.class, () -> matriculaService.salvar(duplicada3)),
                () -> assertThrows(RuntimeException.class, () -> matriculaService.salvar(duplicada4)),
                () -> assertThrows(RuntimeException.class, () -> matriculaService.salvar(duplicada5))
        );

        // Nada além das 5 matrículas originais deve ter sido salvo
        assertEquals(5, matriculaRepository.listar().size());
        RuntimeException ex = assertThrows(RuntimeException.class,
                () -> matriculaService.salvar(duplicada1));
        assertEquals("Aluno já matriculado nesta disciplina.", ex.getMessage());
    }


    // 6.Aluno — assertFalse

    @Test
    void listaDeAlunosNaoDeveEstarVazia() {

        AlunoRepositoryMemoria repository =
                new AlunoRepositoryMemoria();

        AlunoService service =
                new AlunoService(repository);

        AlunoModel aluno = new AlunoModel(
                1L,
                "Gustavo",
                "12345678900",
                "gustavo@email.com"
        );

        service.salvar(aluno);

        assertFalse(service.listar().isEmpty());
    }

    // 7. Disciplina — assertTrue

    @Test
    void deveEncontrarDisciplinaPeloCodigo() {

        DisciplinaRepositoryMemoria repository =
                new DisciplinaRepositoryMemoria();

        DisciplinaService service =
                new DisciplinaService(repository);

        DisciplinaModel disciplina =
                new DisciplinaModel(
                        "Java",
                        "002",
                        100
                );

        service.salvar(disciplina);

        DisciplinaModel resultado =
                service.buscarPorCodigo("002");

        assertTrue(resultado != null);
    }


}

