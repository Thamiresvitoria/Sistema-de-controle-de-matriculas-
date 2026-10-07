package com.example.SistemaDeMatricula.controller;

import com.example.SistemaDeMatricula.model.AlunoModel;
import com.example.SistemaDeMatricula.service.AlunoService;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;

@Controller
public class AlunoController {

    private final AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    // MÉTODOS DO CONTROLLER

    public void salvar(AlunoModel aluno) {
        service.salvar(aluno);
    }

    public List<AlunoModel> listar() {
        return service.listar();
    }

    public AlunoModel buscarPorId(Long id) {
        return service.buscarPorId(id);
    }

    public void atualizar(Long id, AlunoModel aluno) {
        aluno.setId(id);
        service.atualizar(aluno);
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
            System.out.println("          ALUNOS");
            System.out.println("==============================");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Listar alunos");
            System.out.println("3 - Buscar aluno");
            System.out.println("4 - Atualizar aluno");
            System.out.println("5 - Excluir aluno");
            System.out.println("0 - Voltar");
            System.out.println("==============================");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    cadastrarAluno(scanner);
                    break;

                case 2:
                    listarAlunos();
                    break;

                case 3:
                    buscarAluno(scanner);
                    break;

                case 4:
                    atualizarAluno(scanner);
                    break;

                case 5:
                    excluirAluno(scanner);
                    break;

                case 0:
                    System.out.println("Voltando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    private void cadastrarAluno(Scanner scanner) {

        System.out.println();
        System.out.println("--- CADASTRAR ALUNO ---");

        System.out.print("ID: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        AlunoModel aluno = new AlunoModel(
                id,
                nome,
                cpf,
                email
        );

        try {
            salvar(aluno);
            System.out.println("Aluno cadastrado com sucesso!");

        } catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void listarAlunos() {

        System.out.println();
        System.out.println("--- LISTA DE ALUNOS ---");

        List<AlunoModel> alunos = listar();

        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }

        for (AlunoModel aluno : alunos) {
            System.out.println(aluno);
        }
    }

    private void buscarAluno(Scanner scanner) {

        System.out.println();
        System.out.println("--- BUSCAR ALUNO ---");

        System.out.print("Digite o ID: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        try {
            AlunoModel aluno = buscarPorId(id);
            System.out.println(aluno);

        } catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void atualizarAluno(Scanner scanner) {

        System.out.println();
        System.out.println("--- ATUALIZAR ALUNO ---");

        System.out.print("Digite o ID do aluno: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();

        System.out.print("Novo CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Novo email: ");
        String email = scanner.nextLine();

        AlunoModel aluno = new AlunoModel(
                id,
                nome,
                cpf,
                email
        );

        try {
            atualizar(id, aluno);
            System.out.println("Aluno atualizado com sucesso!");

        } catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void excluirAluno(Scanner scanner) {

        System.out.println();
        System.out.println("--- EXCLUIR ALUNO ---");

        System.out.print("Digite o ID do aluno: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        try {
            excluir(id);
            System.out.println("Aluno excluído com sucesso!");

        } catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}