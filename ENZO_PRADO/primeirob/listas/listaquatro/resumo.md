# Paradigmas de programação <h1>

**O que é?**

É um conjunto de regras, principios e conceitos para uma determinada situação, que irá definir como o código de progama é escrito e organizado.

* Está ligada ao estilo de escrita e organização;

* Define como o desenvolvedor pode resover problemas complexos por meio da programação.

## Paradigma imperativo <h2>

* Dirigido por comandos;

* Consiste em um cojunto de instruções;

* Cada declaração orienta o que deve ser feito e como deve ser feito.

    **IMPERATIVO = IMPERADOR = ORDEM**

###  Programação estruturada <h3>
 
* Pode ser referido como programação modular;

* Visa otimizar o código utilizando blocos de fluxos de controle do programa;

* Blocos de tomadas de decisão (if, if then, else);

* Contruções de interações (For, while loops);

* Funções.

* Beneficios:
    
    * Melhora a legibilidade; 
    * Facilita a retutilização do codigo;

* Estruturadas são Cobol, PHP, Perl e Go.

**Exemplo de codigo**

~~~php
    // Função para calcular a soma de números de 1 a n
function calcularSoma($n) {
    $soma = 0;
    for ($i = 1; $i <= $n; $i++) {
        $soma += $i;
    }
    return $soma;
}

$n = 10;
$resultado = calcularSoma($n);
echo "A soma de 1 a $n é: $resultado\n";
~~~~

### Programação Procedural <h3>

* Chamada de procedimentos;

* Estruturadas em sub-rotinas ou funções;

* Lista de instruções para dizer ao computador passo a passo o que fazer.

* Beneficios: 
   
   * Simplicidade e clareza;
   * Reutilização de codigo;
   * Manutenção.
   

* Procedurais são: C, C++, Java e Pascal.

**Exemplo de codigo**

~~~~java
import java.util.Scanner;

public class MediaNumeros {

    // Função para ler um número do usuário
    public static double lerNumero(int indice) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número " + indice + ": ");
        return scanner.nextDouble();
    }

    // Função para calcular a média de três números
    public static double calcularMedia(double num1, double num2, double num3) {
        return (num1 + num2 + num3) / 3;
    }

    // Função para exibir o resultado
    public static void exibirResultado(double media) {
        System.out.printf("A média dos números é: %.2f\n", media);
    }

    public static void main(String[] args) {
        // Código principal (procedural)
        double num1 = lerNumero(1);
        double num2 = lerNumero(2);
        double num3 = lerNumero(3);

        double media = calcularMedia(num1, num2, num3);

        exibirResultado(media);
    }
}
~~~~

### Programação Orientada a objeto <h3>

Explicada mais tarde, mas foi coloado para lembrar que faz parte da imperativa.

## Paradigma Declarativos <h2>
* Focado na logica do programa em si e no resultado;
 
* O mais importante é alcançar o resultado;
 
* Foco não está no "como" e sim no "que".


### Programação Funcional <h3>
 * Tudo são funções;
 * Sequencia de funções matematicas que irão resolver um problema;
 * Evita a mudança de estado e dados mutáveis.
 

 * Beneficios: 
    
    * Imutabilidade;
    * Menos efeitos colaterais;
    * Facilidade de teste;
    * Pararelismo e concorrencia.

* Funcionais são: Haskell, Scala, JS e Clojure.

**Exemplo de codigo**
~~~~javascript
// Função pura para calcular o quadrado de um número
const quadrado = x => x * x;

// Função pura para verificar se um número é maior que um valor específico
const maiorQue = valor => x => x > valor;

// Função pura para aplicar uma transformação a cada item de um array
const map = (func, array) => array.map(func);

// Função pura para filtrar itens de um array com base em uma condição
const filter = (func, array) => array.filter(func);

// Dados de entrada
const numeros = [1, 2, 3, 4, 5];

// Uso das funções para calcular a soma dos quadrados de números maiores que 10
const resultado = map(quadrado, numeros);
const filtrado = filter(maiorQue(10), resultado);

// Soma dos números filtrados
const soma = filtrado.reduce((acc, num) => acc + num, 0);

console.log('Números:', numeros);
console.log('Quadrados:', resultado);
console.log('Filtrado:', filtrado);
console.log('Soma dos filtrados:', soma);
~~~~

### Programação Logica <h3>

 * O programador define qual parte do problema resolver;
 * O sistema encontra a melhor solução;
 * O foco está em declarar fatos e regras que possam ser utilizados para inferir
 novas informações e soluções.

 * Procedurais são: Prolog e DataLog.
 
 **Exemplo de codigo**

 ~~~prolog
 % Fatos
pai(jose, maria).
pai(jose, pedro).
pai(antonio, jose).
pai(antonio, ana).
mae(lucia, maria).
mae(lucia, pedro).
mae(ana, jose).
mae(ana, ana).

% Regras
avo(Avo, Neto) :-
    pai(Avo, Pai),
    pai(Pai, Neto).

% Consultas
% ?- avo(antonio, maria).
% Resultado esperado: true.

% ?- avo(antonio, pedro).
% Resultado esperado: true.

% ?- avo(lucia, pedro).
% Resultado esperado: true.
~~~

## POO - Programação Orientada A Objetos <h2>

 * Se baseia na criação de objetos que possuem propriedades e métodos;
 * Permite o encapsulamento de dados e reutilização de código;
 * Todos os componentes são representados como objetos.

 * POO são: PHP, Java, C#, JS, Python e Ruby.

 ### POO - Pilares do POO <h3>

  * Herança: Criação de novas classes com base nas existentes;
  
  * Polimorfismo: Capacidade de um objeto se passar por outro compativel;

  * Encapsulamento: Gerenciamento de acesso a tributos e métodos;

  * Abstração: Representação de conceitos essenciais do mundo real.

### POO - Beneficios do POO <h3>

* Reutilização do codigo: permite aproveitas classes e objetos já existentes;

* Modularidade: Incentiva a divisão do código em modulos independentes;

* Flexibilidade e escabilidade: Flexibilidade no design do software, permitindo adicionar novas funcionalidades e modificar o comportamento dos objetos sem afetar outras partes do sistema;

* Organização e coesão do código: Atraves da encapsulação e abstração, a logica de programação é estruturada de maneira clara e compreensível.


**Exemplo de codigo**

~~~java
// Classe Pessoa
public class Pessoa {
    private String nome;
    private int idade;

    // Construtor
    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    // Método para apresentar a pessoa
    public void apresentar() {
        System.out.println("Olá, meu nome é " + nome + " e eu tenho " + idade + " anos.");
    }
}

// Classe Principal
public class Main {
    public static void main(String[] args) {
        // Criar um objeto Pessoa
        Pessoa pessoa = new Pessoa("João", 25);

        // Usar o método apresentar
        pessoa.apresentar();

        // Alterar a idade e usar o método novamente
        pessoa.setIdade(26);
        pessoa.apresentar();
    }
}
~~~~

 
## O JAVA É/PODE SER <h2>

* Multiparadigma;
* Procedural;
* Estruturado;
* POO;
* Programação concorrente;
* Funcional ( A partir do java 8)





















