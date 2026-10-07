package com.example.SistemaDeMatricula.controller;

import com.example.SistemaDeMatricula.model.DisciplinaModel;
import com.example.SistemaDeMatricula.model.TurmaModel;
import com.example.SistemaDeMatricula.service.TurmaService;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Controller
public class TurmaController {

    private final TurmaService service;
    private final DisciplinaController disciplinaController;

    public TurmaController(
            TurmaService service,
            DisciplinaController disciplinaController) {

        this.service = service;
        this.disciplinaController = disciplinaController;
    }

    // MÉTODOS DO CONTROLLER

    public void salvar(TurmaModel turma) {
        service.salvar(turma);
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

    // MENU

    public void menu(Scanner scanner) {

        int opcao;

        do {
            System.out.println();
            System.out.println("==============================");
            System.out.println("           TURMAS");
            System.out.println("==============================");
            System.out.println("1 - Criar turma");
            System.out.println("2 - Listar turmas");
            System.out.println("3 - Buscar turma");
            System.out.println("4 - Atualizar turma");
            System.out.println("5 - Excluir turma");
            System.out.println("0 - Voltar");
            System.out.println("==============================");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    cadastrarTurma(scanner);
                    break;

                case 2:
                    listarTurmas();
                    break;

                case 3:
                    buscarTurma(scanner);
                    break;

                case 4:
                    atualizarTurma(scanner);
                    break;

                case 5:
                    excluirTurma(scanner);
                    break;

                case 0:
                    System.out.println("Voltando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    private void cadastrarTurma(Scanner scanner) {

        System.out.println();
        System.out.println("--- CADASTRAR TURMA ---");

        System.out.print("Código: ");
        String codigo = scanner.nextLine();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Turno: ");
        String turno = scanner.nextLine();

        System.out.print("Horário (AAAA-MM-DDTHH:MM): ");
        LocalDateTime horario =
                LocalDateTime.parse(scanner.nextLine());

        System.out.print("Limite de alunos: ");
        int limiteAlunos = scanner.nextInt();
        scanner.nextLine();

        List<DisciplinaModel> disciplinas =
                selecionarDisciplinas(scanner);

        TurmaModel turma = new TurmaModel(
                codigo,
                nome,
                turno,
                horario,
                limiteAlunos,
                disciplinas
        );

        try {
            salvar(turma);
            System.out.println("Turma cadastrada com sucesso!");

        } catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private List<DisciplinaModel> selecionarDisciplinas(
            Scanner scanner) {

        List<DisciplinaModel> disciplinas =
                new ArrayList<>();

        System.out.println();
        System.out.println("A turma precisa de 5 disciplinas.");

        for (int i = 1; i <= 5; i++) {

            System.out.print(
                    "Digite o ID da disciplina " + i + ": "
            );

            Long id = scanner.nextLong();
            scanner.nextLine();

            try {

                DisciplinaModel disciplina =
                        disciplinaController.buscarPorId(id);

                disciplinas.add(disciplina);

            } catch (RuntimeException e) {

                System.out.println(
                        "Erro: " + e.getMessage()
                );

                i--;
            }
        }

        return disciplinas;
    }

    private void listarTurmas() {

        System.out.println();
        System.out.println("--- LISTA DE TURMAS ---");

        List<TurmaModel> turmas = listar();

        if (turmas.isEmpty()) {
            System.out.println("Nenhuma turma cadastrada.");
            return;
        }

        for (TurmaModel turma : turmas) {
            System.out.println(turma);
        }
    }

    private void buscarTurma(Scanner scanner) {

        System.out.println();
        System.out.println("--- BUSCAR TURMA ---");

        System.out.print("Digite o ID: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        try {

            TurmaModel turma = buscarPorId(id);

            System.out.println(turma);

        } catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void atualizarTurma(Scanner scanner) {

        System.out.println();
        System.out.println("--- ATUALIZAR TURMA ---");

        System.out.print("Digite o ID da turma: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Novo código: ");
        String codigo = scanner.nextLine();

        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();

        System.out.print("Novo turno: ");
        String turno = scanner.nextLine();

        System.out.print("Novo horário (AAAA-MM-DDTHH:MM): ");
        LocalDateTime horario =
                LocalDateTime.parse(scanner.nextLine());

        System.out.print("Novo limite de alunos: ");
        int limiteAlunos = scanner.nextInt();
        scanner.nextLine();

        List<DisciplinaModel> disciplinas =
                selecionarDisciplinas(scanner);

        TurmaModel turma = new TurmaModel(
                codigo,
                nome,
                turno,
                horario,
                limiteAlunos,
                disciplinas
        );

        try {

            atualizar(id, turma);

            System.out.println(
                    "Turma atualizada com sucesso!"
            );

        } catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void excluirTurma(Scanner scanner) {

        System.out.println();
        System.out.println("--- EXCLUIR TURMA ---");

        System.out.print("Digite o ID: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        try {

            excluir(id);

            System.out.println(
                    "Turma excluída com sucesso!"
            );

        } catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}