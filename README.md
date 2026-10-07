 # Projeto: Sistema de cadastro de matriculas escolares

## 1. Identificação

### 📃Nome do Projeto
Sistema de Matrículas em Turmas

### Nome dos Participantes do Projeto

Alessandro Caetano Macena

Antônio Henrique de Almeida Ramos
 
Jesiane Vitoria Carneiro de Almeida

Vitória Gabriele Paulino Vieira
 
Thamires Vitória Muniz da Silva

Davyd Endhell de Lima Alves
 
Samuel Ribeiro da Silva


### Turma
Análise e Desenvolvimento de Sistemas - Turma E02 - MANHÃ

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

##  Alunos

* [x] Cadastrar aluno
* [x] Listar alunos
* [x] Buscar aluno por ID
* [x] Atualizar aluno
* [x] Excluir aluno

##  Turmas

* [x] Criar turma
* [x] Listar turmas
* [x] Buscar turma por ID
* [x] Atualizar turma
* [x] Excluir turma

##  Matrículas

* [x] Realizar matrícula de aluno em turma
* [x] Listar matrículas
* [x] Buscar matrícula por ID
* [x] Atualizar matrícula
* [x] Cancelar/excluir matrícula
* [x] Listar alunos de uma turma


## 4. Regras de Negócio

- O CPF do aluno deve ser único.
- O e-mail do aluno deve ser único.
- Um aluno não pode ser matriculado duas vezes na mesma turma.
- Uma turma não pode ultrapassar sua capacidade máxima.
- Só é possível realizar matrícula em alunos e turmas existentes.


# 5. Arquitetura

O projeto utiliza uma arquitetura organizada em camadas:

```text
Controller
     ↓
  Service
     ↓
 Repository
```

Além dessas camadas, o projeto possui os **Models**, responsáveis por representar as entidades do domínio.

## Model

Representa as entidades utilizadas pelo sistema.

Principais entidades:

* `Aluno`
* `Turma`
* `Matricula`
* `Disciplina`

Os Models possuem os atributos e comportamentos relacionados aos objetos do domínio.



## Controller

Responsável pela interação com a aplicação.

Os Controllers recebem as informações fornecidas pelo usuário e encaminham as operações para os Services.

Principais Controllers:

* `AlunoController`
* `TurmaController`
* `MatriculaController`
* `DisciplinaController`



## Service

Responsável pelas **regras de negócio** da aplicação.

Os Services recebem as solicitações dos Controllers, verificam as regras necessárias e utilizam os Repositories para acessar os dados.

Principais Services:

* `AlunoService`
* `TurmaService`
* `MatriculaService`
* `DisciplinaService`



## Repository

Responsável pelo armazenamento e recuperação dos dados.

A persistência é realizada **em memória**, utilizando estruturas como `List`/`ArrayList`.

Principais Repositories:

* `AlunoRepository`
* `TurmaRepository`
* `MatriculaRepository`
* `DisciplinaRepository`



# Injeção de Dependências

O projeto utiliza a **injeção de dependências do Spring**.

Os Services recebem seus respectivos Repositories por meio do construtor, evitando a criação manual dessas dependências com `new`.

Exemplo:

```java
@Service
public class AlunoService {

    private final AlunoRepository repository;

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }
}
```

Essa abordagem permite que o Spring seja responsável pelo gerenciamento das dependências da aplicação.



# 6. Estrutura do projeto

```text
src/
└── main/
    └── java/
        └── com/
            └── exemplo/
                └── Sistema de matricula/
                    │
                    ├── Main.java
                    │
                    ├── controller/
                    │   ├── AlunoController.java
                    │   ├── DisciplinaController.java
                    │   ├── TurmaController.java
                    │   └── MatriculaController.java
                    │
                    ├── model/
                    │   ├── AlunoModel.java
                    │   ├── DisciplinaModel.java
                    │   ├── TurmaModel.java
                    │   └── MatriculaModel.java
                    │
                    ├── repository/
                    │   ├── AlunoRepository.java
                    │   ├── DisciplinaRepository.java
                    │   ├── TurmaRepository.java
                    │   └── MatriculaRepository.java
                    │
                    └── service/
                        ├── AlunoService.java
                        ├── DisciplinaService.java
                        ├── TurmaService.java
                        └── MatriculaService.java

└── test/
    └── java/
        └── com/
            └── exemplo/
                └── Sistema de matricula/
                    └── teste

pom.xml
README.md
```



# 7. Tecnologias

- Java 21 ![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
- Maven ![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
- Spring Boot ![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
- JUnit ![JUnit](https://img.shields.io/badge/JUnit-25A162?style=for-the-badge&logo=junit5&logoColor=white)
- Git ![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white)
- GitHub ![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white)


# 8. Como Executar

## 1. Clonar o repositório

```bash
git clone URL_DO_REPOSITORIO
```

## 2. Entrar na pasta do projeto

```bash
cd nome-do-projeto
```

## 3. Executar a aplicação

```bash
mvn spring-boot:run
```

Caso o projeto utilize a execução pela IDE, também é possível executar a classe principal:

```text
Main.java
```



# 🧪 Como executar os testes

Para executar todos os testes automatizados utilizando o Maven:

```bash
mvn test
```

Os testes verificam comportamentos válidos, regras de negócio e situações inválidas da aplicação.



# 9. Testes automatizados

O projeto possui testes utilizando **JUnit**.

Os testes contemplam:

* comportamento válido;
* regras de negócio;
* situações inválidas;
* lançamento de exceções;
* outros comportamentos relevantes do sistema.

### Exemplos de cenários testados

```text
✓ Deve cadastrar e salvar um matricula
✓ Deve cadastrar e salvar um aluno
✓ Não deve permitir que uma disciplina tenha uma carga horária negativa
✓ Deve salvar as cinco discplina
✓ Não deve permitir matrícula duplicada
```

A avaliação exige pelo menos **5 testes automatizados relevantes**, incluindo um comportamento válido, duas regras de negócio, uma situação inválida/exceção e um teste adicional.



# 🌿 Git e GitHub

O desenvolvimento do projeto foi organizado utilizando **Git e GitHub**, com utilização de branches para separar as etapas de desenvolvimento.

organização:

```text
main
│
├── feature/modelos
├── feature/repositories
├── feature/services
├── feature/controllers
└── feature/testes
```

O projeto utiliza commits que representam etapas reais do desenvolvimento.

### Exemplos de commits semanticos:

```text
feat: cria entidades do sistema
feat: implementa AlunoRepository
feat: implementa TurmaRepository
feat: implementa MatriculaRepository
feat: adiciona regras de matrícula
feat: cria controllers
test: adiciona testes do MatriculaService
docs: atualiza README
```

O histórico do Git/GitHub faz parte da avaliação e deve demonstrar a participação dos integrantes no desenvolvimento.



# Histórico do desenvolvimento

O projeto foi desenvolvido seguindo uma evolução por etapas:

1. Definição do problema e das entidades;
2. Criação dos Models;
3. Implementação dos Repositories;
4. Implementação dos Services;
5. Implementação das regras de negócio;
6. Implementação dos Controllers;
7. Configuração do Spring Boot e Maven;
8. Criação dos testes automatizados;
9. Documentação do projeto;
10. Organização do repositório no GitHub.


#Uso da IA

Alessandro Caetano Macena:

Claude Sonnet 5.5.
Quero uma ajuda com aquele trabalho que te mandei.

Eu já avancei bastante no projeto e queria que você desse uma olhada principalmente em alguns métodos do Repository que fiz. A ideia não é refazer o código inteiro, mas revisar o que já está funcionando e ver se tem alguma coisa que dá pra melhorar, corrigir ou deixar mais organizada.

Dá uma atenção principalmente nos métodos de listar, buscar por ID, alterar e excluir. Se tiver alguma coisa que eu fiz de uma forma que poderia ser melhor, me mostra como você faria e explica o motivo da mudança.

Tenta manter o padrão e a estrutura que já estão no trabalho, sem sair mudando outras partes que não precisam. Quero mais uma revisão e melhoria do código do que uma implementação do zero.

2. Thamires Vitória Muniz da Silva:

Chatgpt 
Versão: GPT-5.6 Luna, da OpenAI. 
Finalidade: esse prompt foi gerado com a finalidade de dar mais ideias para fazer regras de negócio e posteriormente como utilizar algumas dessas regras de negócio seguindo a estrutura que ele passou como base.
Prompt :  Me de ideias para regra de negócio de um sistema de matrícula de uma escola que tem as entidades matrícula, alunos, disciplinas e turma. Faça o caso de uso para posteriormente usar em também testes
Como foi utilizado: seguindo o padrão que foi gerado conseguimos usar como base para fazer os testes e ter mais ideias para fazer as regras de negócio, alguns a gente decidiu por usar, porém outras optamos por modificar.





##  Participação dos Integrantes

| Integrante                              | Contribuições             |
| -----------------------------------     | ------------------------- |
| **Alessandro Caetano Macena**           |         Repository        |
| **Antonio Henrique de Almeida Ramos**   |         Documentação      |
| **Davyd Endhell de Lima Alves**         |         Documentação      |
| **Jesiane Vitoria Carneiro de Almeida** |      Models e service     |
| **Samuel Ribeiro da Silva**             |   Criação dos Controllers |
| **Thamires Vitória Muniz da Silva**     |       Services e testes   |
| **Vitória Gabriele Paulino Vieira**     |     Criação dos Models    |






#  Apresentação

Durante a apresentação serão demonstrados:

1. **Problema**

    * Qual problema o sistema resolve?

2. **Solução**

    * O que foi desenvolvido?

3. **Demonstração**

    * Execução da aplicação.

4. **Arquitetura**

    * Model
    * Controller
    * Service
    * Repository

5. **Testes**

    * Demonstração de pelo menos um teste automatizado.

6. **GitHub**

    * Repositório.
    * Branches.
    * Histórico de commits.

Essa estrutura segue a sugestão de apresentação indicada no projeto de avaliação.



#  Observações

Este projeto foi desenvolvido com foco nos conteúdos estudados durante a **Unidade 1**, priorizando:

* Programação Orientada a Objetos;
* organização em camadas;
* separação de responsabilidades;
* Repository;
* Services;
* Controllers;
* injeção de dependências;
* persistência em memória;
* testes automatizados;
* Maven;
* Spring Boot;
* Git e GitHub.

O projeto não utiliza banco de dados, APIs externas, autenticação, Docker ou front-end, pois esses recursos não são necessários para a avaliação.

---

## 👩‍💻 Desenvolvido para fins acadêmicos na Universidade Tiradentes em Recife-PE

**Projeto de Avaliação — Unidade 1**
**Java + Maven + Spring Boot + JUnit**
