S.O.L.I.D

S. SRP (Principio da Responsabilidade Unica) 
    - Principio onde se cria uma classe com uma unica finalidade (responsabilidade);
    - A pasta SRP nos projetos em Java serve para armazenar essas classes para melhor organização
 
O. OCP (Principio Aberto e Fechado)
    - A ideia é ter uma classe principal como base para outras classes, no entanto o principio reforça que a classe principal não deve ser modificada, somente as classes que foram extendidas a partir da principal (aberta pra extensao e fechada para modificação);

L. LSP (Princípio de Substituição de Liskov)
    - O Princípio de Substituição de Liskov diz que uma classe filha deve ser capaz de substituir sua classe pai sem causar problemas no programa. Ou seja, se você troca um tipo de objeto por outro mais específico, o comportamento do sistema deve continuar funcionando corretamente, sem surpresas. 
    - Exemplo Classe pai Ave (aves voam) e classe filha Pinguim (Ave, mas não voa)

I. ISP (Princípio da Segregação de Interfaces)
    - Se uma interface é muito grande e tem métodos que algumas classes não precisam, isso pode obrigar essas classes a implementar métodos que não fazem sentido para elas. 
    - O ISP sugere dividir as interfaces grandes em interfaces menores e mais especializadas.

D. 