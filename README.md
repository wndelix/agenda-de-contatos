# Agenda de Contatos

Aplicação de agenda de contatos desenvolvida em **Java** para fins educacionais, com foco no aprendizado de programação, estruturas de dados, modularização, persistência em arquivo e organização de código.

A aplicação funciona pelo terminal e permite cadastrar, visualizar, pesquisar, alterar e excluir contatos durante a execução. Os contatos são salvos em arquivo ao sair e carregados novamente na próxima execução.

## Versão

**2.1.0**

## Funcionalidades

A aplicação oferece as seguintes operações:

- Adicionar contatos
- Listar contatos cadastrados
- Pesquisar contatos pelo nome
- Alterar dados de contatos
- Excluir contatos
- Armazenar nome, celular e e-mail
- Pesquisa de nomes sem diferenciação entre maiúsculas e minúsculas
- Persistência dos contatos em arquivo texto (`contatos.txt`)
- Carregamento automático dos contatos ao iniciar a aplicação
- Janela "Sobre" com informações do desenvolvedor
- Mensagens de feedback para operações realizadas e situações sem resultados

## Demonstração

Ao iniciar a aplicação, uma tela de apresentação e o menu principal são exibidos:

```text
╔══════════════════════════════════════╗
║          AGENDA DE CONTATOS          ║
║                v2.1.0                ║
╠══════════════════════════════════════╣
║              Bem-vindo!              ║
╚══════════════════════════════════════╝

1 - Adicionar Contato
2 - Listar Contato
3 - Procurar Contato
4 - Alterar Contato
5 - Excluir Contato
6 - Sobre
7 - Sair

Selecione a opção desejada:
```

### Cadastro

Para cadastrar um contato, são solicitados nome, celular e e-mail:

```text
═════════════ Adicionar Contato ═════════════
Digite o nome: Ana Souza
Digite o celular: (85) 98888-7777
Digite o e-mail: ana.souza@email.com
Contato Ana Souza foi adicionado com sucesso.
```

### Pesquisa

A pesquisa é realizada pelo nome e utiliza `equalsIgnoreCase()`, permitindo localizar o mesmo nome independentemente de diferenças entre letras maiúsculas e minúsculas.

```text
══════════════ Procurar Contato ═════════════
Digite o nome que deseja procurar: Ana Souza
---------------------------------------------
   Nome: Ana Souza
Celular: (85) 98888-7777
 E-mail: ana.souza@email.com
---------------------------------------------
```

### Alteração

A aplicação permite substituir os dados de um contato existente:

```text
══════════════ Alterar Contato ══════════════
Digite o nome que deseja procurar: Ana Souza
Digite o novo nome: Ana Clara Souza
Digite o novo celular: (85) 99999-8888
Digite o novo e-mail: anaclara@email.com
Contato alterado com sucesso.
```

### Exclusão

Um contato pode ser localizado pelo nome e removido da agenda:

```text
══════════════ Excluir Contato ══════════════
Digite o nome do contato que deseja excluir: Ana Clara Souza
Contato excluído com sucesso.
```

### Persistência

Ao escolher a opção **7 - Sair**, os contatos são gravados no arquivo `contatos.txt`. Na próxima execução, esse arquivo é lido automaticamente e os contatos voltam a ficar disponíveis.

O arquivo utiliza uma linha por contato, com os campos separados por `;`:

```text
Ana Souza;(85) 98888-7777;ana.souza@email.com
Carlos Lima;(85) 97777-6666;carlos.lima@email.com
```

## Estrutura do projeto

A aplicação é um projeto **Maven** e está organizada em quatro classes principais:

```text
agenda_contatos/
├── pom.xml
└── src/
    └── main/
        └── java/
            └── br/
                └── edu/
                    └── principal/
                        ├── Principal.java
                        ├── Agenda.java
                        ├── Persistencia.java
                        └── Utils.java
```

### `Principal.java`

Responsável pelo ponto de entrada da aplicação, pela carga inicial dos contatos e pelo controle do fluxo principal.

O menu é executado dentro de um loop e as operações são direcionadas para os métodos correspondentes da classe `Agenda`. A opção de saída também aciona a gravação dos contatos.

### `Agenda.java`

Concentra as operações relacionadas aos contatos:

- `adicionaContato()`
- `listarContato()`
- `procurarContato()`
- `alterarContato()`
- `excluirContato()`

Os dados são manipulados por meio de listas recebidas como parâmetros.

### `Persistencia.java`

Responsável pela leitura e gravação dos contatos em arquivo:

- `carregarContatos()`: lê o arquivo `contatos.txt` e preenche as listas. Linhas com formato inválido são ignoradas e informadas no terminal.
- `salvarContatos()`: grava as listas no arquivo `contatos.txt`, sobrescrevendo o conteúdo anterior.

### `Utils.java`

Responsável por funcionalidades auxiliares da interface, incluindo:

- Tela de apresentação
- Exibição do menu
- Leitura da opção escolhida
- Janela de informações sobre o programa

## Tecnologias

- **Java 21**
- **Maven**
- **Java Collections Framework**
- `List`
- `ArrayList`
- `Scanner`
- `BufferedReader` / `FileReader`
- `PrintWriter` / `FileWriter`
- `JOptionPane`

## Conceitos praticados

O projeto utiliza diversos conceitos fundamentais da linguagem Java:

### Controle de fluxo

```java
while
switch
if
else
for
break
```

### Coleções

```java
List
ArrayList
```

### Entrada de dados

```java
Scanner
```

### Manipulação de arquivos

```java
BufferedReader
FileReader
PrintWriter
FileWriter
```

### Tratamento de exceções

```java
try
catch (IOException e)
```

### Manipulação de listas

```java
add()
get()
set()
remove()
size()
isEmpty()
```

### Comparação de strings

```java
equalsIgnoreCase()
```

### Modularização

A lógica foi distribuída entre diferentes métodos e classes, evitando concentrar todas as responsabilidades no método `main`.

## Armazenamento dos contatos

Durante a execução, cada contato é representado por três listas:

```java
List<String> nomesContatos = new ArrayList<>();
List<String> numerosContatos = new ArrayList<>();
List<String> emailsContatos = new ArrayList<>();
```

Os dados correspondentes a um contato compartilham o mesmo índice nas três listas.

Por exemplo:

```text
Índice 0
├── Nome:     Ana Souza
├── Celular:  (85) 98888-7777
└── E-mail:   ana.souza@email.com
```

Ao sair, essas listas são gravadas em `contatos.txt`. Ao iniciar, o arquivo é lido e as listas são preenchidas novamente.

## Como executar

### Maven (terminal)

Na raiz do projeto, onde está o `pom.xml`, compile a aplicação:

```bash
mvn compile
```

Execute a aplicação:

```bash
java -cp target/classes br.edu.principal.Principal
```

É necessário ter o **JDK 21** (ou superior) e o **Maven** instalados.

### Eclipse

1. Abra o projeto no Eclipse como projeto Maven (ou importe-o como projeto Java).
2. Localize `Principal.java`.
3. Execute a classe como uma aplicação Java:

```text
Run As → Java Application
```

> **Importante:** o arquivo `contatos.txt` é criado e lido no diretório de onde a aplicação é executada. No Eclipse, esse diretório costuma ser a raiz do projeto.

## Limitações atuais

A versão atual possui algumas limitações conhecidas:

- Os contatos são mantidos em memória durante a execução e só são gravados em arquivo ao escolher a opção **Sair**. Se o programa for encerrado de outra forma, as alterações feitas na sessão são perdidas.
- O arquivo `contatos.txt` usa `;` como separador. Nomes, celulares ou e-mails que contenham `;` quebram o formato e o registro é ignorado na leitura.
- Nome, celular e e-mail são mantidos em listas separadas.
- A pesquisa é baseada no nome informado pelo usuário.
- Não há validação específica para celular ou e-mail.

Essas limitações fazem parte do estágio atual do projeto e podem ser abordadas em versões futuras.

## Evolução do projeto

| Versão | Alterações |
|---|---|
| `0.0.0` | Implementação inicial da agenda |
| `0.1.0` | Suporte a múltiplos contatos utilizando arrays, além de listagem, pesquisa e exclusão |
| `0.2.0` | Migração para `ArrayList` e remoção do limite fixo de contatos |
| `0.3.0` | Adição da funcionalidade de alteração de contatos utilizando `set()` |
| `1.0.0` | Refatoração e modularização do código em métodos estáticos |
| `1.1.0` | Organização da aplicação em classes `Principal`, `Agenda` e `Utils`, além da evolução da interface do programa |
| `2.1.0` | Persistência dos contatos em arquivo (`contatos.txt`), com carregamento na inicialização e gravação ao sair; inclusão da classe `Persistencia`; projeto convertido para Maven com Java 21; opção "Sobre" no menu |

## Próximos passos

Possíveis evoluções para versões futuras:

- Criar uma classe `Contato`
- Substituir as listas paralelas por uma coleção de objetos
- Salvar os contatos automaticamente a cada alteração
- Adicionar validação de dados
- Permitir pesquisas mais flexíveis
- Melhorar a interface do terminal
- Adicionar testes automatizados
- Migrar a persistência para um formato mais robusto, como CSV ou banco de dados

## Objetivo

O projeto acompanha a evolução do aprendizado em **Java**, permitindo aplicar novos conceitos progressivamente em uma aplicação prática.

A agenda serve como projeto de estudo para experimentar estruturas de dados, métodos, classes, manipulação de arquivos, modularização e organização de código.

## Licença

Projeto desenvolvido para fins educacionais.
