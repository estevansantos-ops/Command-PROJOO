# Command-PROJOO

Um projeto simples em Java para demonstrar a implementação e o uso do **Padrão de Projeto Command** (Command Design Pattern).

## Sobre o Projeto

O objetivo deste projeto é gerenciar um banco de pessoas (`BancoPessoas`) utilizando diferentes comandos que encapsulam as ações (como criar, obter, deletar e listar todos). O padrão Command permite desacoplar o objeto que invoca a operação daquele que sabe como executá-la.

## Estrutura de Arquivos

* `Command.java` - A interface base para todos os comandos.
* `NewCommand.java` - Comando para adicionar uma nova `Pessoa`.
* `GetCommand.java` - Comando para buscar uma pessoa.
* `DeleteCommand.java` - Comando para remover uma pessoa.
* `AllCommand.java` - Comando para listar todas as pessoas.
* `BancoPessoas.java` - A classe que atua como o banco de dados em memória e contém a lógica principal.
* `Pessoa.java` - A classe de modelo que representa a entidade pessoa.
* `TestesAutomatizados.java` - Classe principal para testar automaticamente os comandos implementados.

## Tecnologias Utilizadas

* **Linguagem:** Java

## Como Executar

1. Compile os arquivos Java no terminal:
   ```bash
   javac *.java
   ```
2. Execute a classe de testes automatizados:
   ```bash
   java TestesAutomatizados
   ```