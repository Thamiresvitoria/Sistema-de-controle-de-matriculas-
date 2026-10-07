package com.example.SistemaDeMatricula.controller;

import com.example.SistemaDeMatricula.model.AlunoModel;
import com.example.SistemaDeMatricula.model.DisciplinaModel;
import com.example.SistemaDeMatricula.model.MatriculaModel;
import com.example.SistemaDeMatricula.model.TurmaModel;
import com.example.SistemaDeMatricula.service.MatriculaService;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;

@Controller
public class MatriculaController {

    private final MatriculaService service;

    private final AlunoController alunoController;
    private final TurmaController turmaController;
    private final DisciplinaController disciplinaController;

    public MatriculaController(
            MatriculaService service,
            AlunoController alunoController,
            TurmaController turmaController,
            DisciplinaController disciplinaController) {

        this.service = service;
        this.alunoController = alunoController;
        this.turmaController = turmaController;
        this.disciplinaController = disciplinaController;
    }

    // MÉTODOS DO CONTROLLER

    public void salvar(MatriculaModel matricula) {
        service.salvar(matricula);
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

    // MENU

    public void menu(Scanner scanner) {

        int opcao;

        do {

            System.out.println();
            System.out.println("==============================");
            System.out.println("        MATRÍCULAS");
            System.out.println("==============================");
            System.out.println("1 - Matricular aluno");
            System.out.println("2 - Listar matrículas");
            System.out.println("3 - Buscar matrícula");
            System.out.println("4 - Atualizar matrícula");
            System.out.println("5 - Excluir matrícula");
            System.out.println("0 - Voltar");
            System.out.println("==============================");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    matricularAluno(scanner);
                    break;

                case 2:
                    listarMatriculas();
                    break;

                case 3:
                    buscarMatricula(scanner);
                    break;

                case 4:
                    atualizarMatricula(scanner);
                    break;

                case 5:
                    excluirMatricula(scanner);
                    break;

                case 0:
                    System.out.println("Voltando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    private void matricularAluno(Scanner scanner) {

        System.out.println();
        System.out.println("--- NOVA MATRÍCULA ---");

        System.out.print("ID da matrícula: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        System.out.print("ID do aluno: ");
        Long alunoId = scanner.nextLong();
        scanner.nextLine();

        System.out.print("ID da turma: ");
        Long turmaId = scanner.nextLong();
        scanner.nextLine();

        System.out.print("ID da disciplina: ");
        Long disciplinaId = scanner.nextLong();
        scanner.nextLine();

        try {

            AlunoModel aluno =
                    alunoController.buscarPorId(alunoId);

            TurmaModel turma =
                    turmaController.buscarPorId(turmaId);

            DisciplinaModel disciplina =
                    disciplinaController.buscarPorId(disciplinaId);

            MatriculaModel matricula =
                    new MatriculaModel(
                            id,
                            aluno,
                            turma,
                            disciplina
                    );

            salvar(matricula);

            System.out.println(
                    "Aluno matriculado com sucesso!"
            );

        } catch (RuntimeException e) {

            System.out.println(
                    "Erro: " + e.getMessage()
            );
        }
    }

    private void listarMatriculas() {

        System.out.println();
        System.out.println("--- LISTA DE MATRÍCULAS ---");

        List<MatriculaModel> matriculas =
                listar();

        if (matriculas.isEmpty()) {
            System.out.println(
                    "Nenhuma matrícula cadastrada."
            );
            return;
        }

        for (MatriculaModel matricula : matriculas) {
            System.out.println(matricula);
        }
    }

    private void buscarMatricula(Scanner scanner) {

        System.out.println();
        System.out.println("--- BUSCAR MATRÍCULA ---");

        System.out.print("Digite o ID da matrícula: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        try {

            MatriculaModel matricula =
                    buscarPorId(id);

            System.out.println(matricula);

        } catch (RuntimeException e) {

            System.out.println(
                    "Erro: " + e.getMessage()
            );
        }
    }

    private void atualizarMatricula(Scanner scanner) {

        System.out.println();
        System.out.println("--- ATUALIZAR MATRÍCULA ---");

        System.out.print("Digite o ID da matrícula: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Novo ID do aluno: ");
        Long alunoId = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Novo ID da turma: ");
        Long turmaId = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Novo ID da disciplina: ");
        Long disciplinaId = scanner.nextLong();
        scanner.nextLine();

        try {

            AlunoModel aluno =
                    alunoController.buscarPorId(alunoId);

            TurmaModel turma =
                    turmaController.buscarPorId(turmaId);

            DisciplinaModel disciplina =
                    disciplinaController.buscarPorId(disciplinaId);

            MatriculaModel matricula =
                    new MatriculaModel(
                            id,
                            aluno,
                            turma,
                            disciplina
                    );

            atualizar(id, matricula);

            System.out.println(
                    "Matrícula atualizada com sucesso!"
            );

        } catch (RuntimeException e) {

            System.out.println(
                    "Erro: " + e.getMessage()
            );
        }
    }

    private void excluirMatricula(Scanner scanner) {

        System.out.println();
        System.out.println("--- EXCLUIR MATRÍCULA ---");

        System.out.print("Digite o ID da matrícula: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        try {

            excluir(id);

            System.out.println(
                    "Matrícula excluída com sucesso!"
            );

        } catch (RuntimeException e) {

            System.out.println(
                    "Erro: " + e.getMessage()
            );
        }
    }
}