# Resumo dos Paradigmas de Programação

Os paradigmas de programação são abordagens diferentes para o desenvolvimento de software. Cada paradigma tem seus princípios, conceitos e maneiras de estruturar e organizar o código.

## 1. Paradigma Imperativo

O paradigma **imperativo** foca em **como** o programa deve executar uma tarefa. Isso é feito através de uma sequência de instruções que alteram o estado do programa.

- **Características**:
  - Uso de **variáveis mutáveis**.
  - Programação baseada em **instruções** e **controle de fluxo** (if, for, while).
  - O estado do programa é alterado conforme a execução avança.

- **Linguagens Comuns**: C, C++, Python, Java.

- **Exemplo**:
    ```python
    soma = 0
    for i in range(1, 6):
        soma += i
    print(soma)
    ```

## 2. Paradigma Funcional

No paradigma **funcional**, a computação é tratada como a avaliação de **funções**. O foco é em **o que** precisa ser feito, e não **como**. Evita-se o uso de variáveis mutáveis e mudanças de estado.

- **Características**:
  - Uso de **funções puras** (sem efeitos colaterais).
  - **Imutabilidade**: os dados não podem ser alterados.
  - **Recursão** é preferida a loops.
  - Funções de **alta ordem**: funções que recebem ou retornam outras funções.

- **Linguagens Comuns**: Haskell, Lisp, Scala, Clojure, Erlang.

- **Exemplo**:
    ```haskell
    somaLista :: [Int] -> Int
    somaLista = foldr (+) 0
    ```

## 3. Paradigma Orientado a Objetos (OO)

O paradigma **orientado a objetos** organiza o código em **objetos**, que são instâncias de **classes**. Cada objeto possui **atributos** (dados) e **métodos** (funções) que operam sobre esses dados.

- **Características**:
  - **Encapsulamento**: proteção do estado interno do objeto.
  - **Herança**: criação de novas classes a partir de outras classes.
  - **Polimorfismo**: diferentes objetos podem responder de maneira diferente à mesma mensagem.
  - **Abstração**: simplificação de conceitos complexos.

- **Linguagens Comuns**: Java, C++, Python, Ruby.

- **Exemplo**:
    ```python
    class Pessoa:
        def __init__(self, nome, idade):
            self.nome = nome
            self.idade = idade

        def saudacao(self):
            print(f"Olá, meu nome é {self.nome} e tenho {self.idade} anos.")

    pessoa1 = Pessoa("Gabriel", 19)
    pessoa1.saudacao()
    ```

## 4. Paradigma Lógico

No paradigma **lógico**, o foco está em **declarações de lógica** (fatos e regras) e não em comandos de controle. A execução do programa é a resolução de **consultas** baseadas nessas regras.

- **Características**:
  - O programador define **fatos** e **regras**.
  - A **inferência lógica** é usada para resolver consultas.
  - Baseia-se em **predicados** e **lógica formal**.

- **Linguagens Comuns**: Prolog.

- **Exemplo**:
    ```prolog
    homem(socrates).
    mortal(X) :- homem(X).

    ?- mortal(socrates).
    ```

## 5. Paradigma Declarativo

O paradigma **declarativo** foca em **o que** o programa deve fazer, sem especificar **como** fazer. Ele descreve o resultado desejado e o compilador ou interpretador lida com a implementação.

- **Características**:
  - Não há manipulação explícita de estados.
  - Declara **relações** e **regras** que o programa deve seguir.

- **Linguagens Comuns**: SQL, HTML, CSS.

- **Exemplo**:
    ```sql
    SELECT nome, idade FROM Pessoas WHERE idade > 30;
    ```

## 6. Paradigma Concorrente

O paradigma **concorrente** lida com a execução de várias **tarefas simultâneas**. O foco está em controlar a comunicação e a sincronização entre processos que podem ser executados em paralelo.

- **Características**:
  - Executa **várias operações ao mesmo tempo**.
  - Envolve **threads**, **processos** e **sincronização**.
  - Lida com **deadlocks** e **condições de corrida**.

- **Linguagens Comuns**: Go, Java, Erlang.

- **Exemplo** (Go):
    ```go
    package main

    import "fmt"

    func ola() {
        fmt.Println("Olá, mundo!")
    }

    func main() {
        go ola() // Executa em uma goroutine
        fmt.Println("Main função")
    }
    ```