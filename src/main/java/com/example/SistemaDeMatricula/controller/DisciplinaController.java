package com.example.SistemaDeMatricula.controller;

import com.example.SistemaDeMatricula.model.DisciplinaModel;
import com.example.SistemaDeMatricula.service.DisciplinaService;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;

@Controller
public class DisciplinaController {

    private final DisciplinaService service;

    public DisciplinaController(DisciplinaService service) {
        this.service = service;
    }

    // MÉTODOS DO CONTROLLER

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

    // MENU

    public void menu(Scanner scanner) {

        int opcao;

        do {
            System.out.println();
            System.out.println("==============================");
            System.out.println("        DISCIPLINAS");
            System.out.println("==============================");
            System.out.println("1 - Cadastrar disciplina");
            System.out.println("2 - Listar disciplinas");
            System.out.println("3 - Buscar disciplina");
            System.out.println("4 - Atualizar disciplina");
            System.out.println("5 - Excluir disciplina");
            System.out.println("0 - Voltar");
            System.out.println("==============================");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    cadastrarDisciplina(scanner);
                    break;

                case 2:
                    listarDisciplinas();
                    break;

                case 3:
                    buscarDisciplina(scanner);
                    break;

                case 4:
                    atualizarDisciplina(scanner);
                    break;

                case 5:
                    excluirDisciplina(scanner);
                    break;

                case 0:
                    System.out.println("Voltando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    // CADASTRAR

    private void cadastrarDisciplina(Scanner scanner) {

        System.out.println();
        System.out.println("--- CADASTRAR DISCIPLINA ---");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Código: ");
        String codigo = scanner.nextLine();

        System.out.print("Carga horária: ");
        int cargaHoraria = scanner.nextInt();
        scanner.nextLine();

        DisciplinaModel disciplina = new DisciplinaModel(
                nome,
                codigo,
                cargaHoraria
        );

        try {
            cadastrar(disciplina);

            System.out.println(
                    "Disciplina cadastrada com sucesso!"
            );
            System.out.println(
                    "ID gerado: " + disciplina.getId()
            );

        } catch (RuntimeException e) {
            System.out.println(
                    "Erro: " + e.getMessage()
            );
        }
    }

    // LISTAR

    private void listarDisciplinas() {

        System.out.println();
        System.out.println("--- LISTA DE DISCIPLINAS ---");

        List<DisciplinaModel> disciplinas = listar();

        if (disciplinas.isEmpty()) {
            System.out.println(
                    "Nenhuma disciplina cadastrada."
            );
            return;
        }

        for (DisciplinaModel disciplina : disciplinas) {
            System.out.println(disciplina);
        }
    }

    // BUSCAR

    private void buscarDisciplina(Scanner scanner) {

        System.out.println();
        System.out.println("--- BUSCAR DISCIPLINA ---");

        System.out.print("Digite o ID: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        try {

            DisciplinaModel disciplina =
                    buscarPorId(id);

            System.out.println(disciplina);

        } catch (RuntimeException e) {

            System.out.println(
                    "Erro: " + e.getMessage()
            );
        }
    }

    // ATUALIZAR

    private void atualizarDisciplina(Scanner scanner) {

        System.out.println();
        System.out.println("--- ATUALIZAR DISCIPLINA ---");

        System.out.print("Digite o ID: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();

        System.out.print("Novo código: ");
        String codigo = scanner.nextLine();

        System.out.print("Nova carga horária: ");
        int cargaHoraria = scanner.nextInt();
        scanner.nextLine();

        DisciplinaModel disciplina =
                new DisciplinaModel(
                        nome,
                        codigo,
                        cargaHoraria
                );

        // Preserva o ID original
        disciplina.setId(id);

        try {

            atualizar(id, disciplina);

            System.out.println(
                    "Disciplina atualizada com sucesso!"
            );

        } catch (RuntimeException e) {

            System.out.println(
                    "Erro: " + e.getMessage()
            );
        }
    }

    // EXCLUIR

    private void excluirDisciplina(Scanner scanner) {

        System.out.println();
        System.out.println("--- EXCLUIR DISCIPLINA ---");

        System.out.print("Digite o ID: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        try {

            excluir(id);

            System.out.println(
                    "Disciplina excluída com sucesso!"
            );

        } catch (RuntimeException e) {

            System.out.println(
                    "Erro: " + e.getMessage()
            );
        }
    }
}