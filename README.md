# Projeto: Sistema de cadastro de matriculas escolares
Sistema de matricula da escola Tiradentes, desenvolvido inteiramente usando java, maven, Spring Boot e JUnit. 

# Sistema de Matrículas em Turmas

## 1. Identificação

### Nome do Projeto
Sistema de Matrículas em Turmas

### Integrantes do Projeto
- Davyd Endhell de Lima Alves
- Thamires Vitória Muniz da Silva
- Vitória Gabriele Paulino Vieira
- Jesiane Vitoria Carneiro de Almeida
- Samuel Ribeiro da Silva
- Alessandro Caetano Macena
- Antônio Henrique de Almeida Ramos

### Turma
Análise e Desenvolvimento de Sistemas - Turma E03 - MANHÃ

### Disciplina
Desenvolvimento Back-End


## 2. Descrição

### Problema que o sistema resolve
O sistema foi desenvolvido para facilitar o gerenciamento de alunos, turmas e matrículas, evitando controles manuais.

### Quem utiliza o sistema
Secretaria acadêmica, coordenação e administradores.

### Objetivo da aplicação
Gerenciar alunos, turmas e matrículas de forma organizada e segura.


## 3. Funcionalidades

- Cadastrar aluno
- Listar os alunos
- Buscar aluno
- Atualizar aluno
- Excluir aluno
- Criar turma
- Listar turmas
- Buscar turma
- Atualizar turma
- Excluir turma
- Realizar matrícula
- Listar matrículas
- Buscar matrícula
- Atualizar matrícula
- Cancelar matrícula
- Listar alunos de uma turma
- Verificar vagas disponíveis na turma
- Transferir alunos entre turmas
- Consultar histórico de matrículas
- Impedir matrícula duplicada


## 4. Regras de Negócio

- O CPF do aluno deve ser único.
- O e-mail do aluno deve ser único.
- Um aluno não pode ser matriculado duas vezes na mesma turma.
- Uma turma não pode ultrapassar sua capacidade máxima.
- Só é possível realizar matrícula em alunos e turmas existentes.


## 5. Arquitetura

O projeto utiliza a seguinte arquitetura:

Controller
↓
Service
↓
Repository

### Controller
Recebe as requisições HTTP e devolve respostas ao usuário.

### Service
Contém as regras de negócio da aplicação.

### Repository
Realiza o acesso aos dados armazenados.

### Model
Representa as entidades do sistema.

### Main
Ponto inicial da aplicação Spring Boot.


## 6. Tecnologias

- Java 21 ![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
- Maven ![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
- Spring Boot ![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=springboote)
- JUnit ![JUnit](https://img.shields.io/badge/JUnit-25A162?style=for-the-badge&logo=junit5&logoColor=white)
- Git ![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white)
- GitHub ![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white)


## 7. Como Executar

```bash
git clone URL_DO_REPOSITORIO
cd sistema-matriculas
mvn spring-boot:run

