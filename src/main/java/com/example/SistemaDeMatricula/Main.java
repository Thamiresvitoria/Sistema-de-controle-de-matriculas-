package com.example.SistemaDeMatricula;

import com.example.SistemaDeMatricula.controller.AlunoController;
import com.example.SistemaDeMatricula.controller.DisciplinaController;
import com.example.SistemaDeMatricula.controller.MatriculaController;
import com.example.SistemaDeMatricula.controller.TurmaController;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {

        ConfigurableApplicationContext context =
                SpringApplication.run(Main.class, args);

        AlunoController alunoController =
                context.getBean(AlunoController.class);

        DisciplinaController disciplinaController =
                context.getBean(DisciplinaController.class);

        TurmaController turmaController =
                context.getBean(TurmaController.class);

        MatriculaController matriculaController =
                context.getBean(MatriculaController.class);

        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {

            System.out.println();
            System.out.println("==============================");
            System.out.println("      SISTEMA ACADÊMICO");
            System.out.println("==============================");
            System.out.println("1 - Alunos");
            System.out.println("2 - Disciplinas");
            System.out.println("3 - Turmas");
            System.out.println("4 - Matrículas");
            System.out.println("0 - Sair");
            System.out.println("==============================");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    alunoController.menu(scanner);
                    break;

                case 2:
                    disciplinaController.menu(scanner);
                    break;

                case 3:
                    turmaController.menu(scanner);
                    break;

                case 4:
                    matriculaController.menu(scanner);
                    break;

                case 0:
                    System.out.println();
                    System.out.println("Sistema encerrado.");
                    break;

                default:
                    System.out.println(
                            "Opção inválida!"
                    );
            }

        } while (opcao != 0);

        scanner.close();
        context.close();
    }
}