package segundob.aula.aulaum.isp;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Criando uma instância de Financeiro com saldo inicial
        Financeiro financeiro = new Financeiro(1000.00);

        // Exibindo o saldo atual
        System.out.println("Saldo atual: R$ " + financeiro.getSaldo());

        // Adicionando mais receita
        financeiro.adicionarReceita(200.00);
        System.out.println("Novo saldo após adição: R$ " + financeiro.getSaldo());

        // Exemplo de uso da data
        Date dataInicio = new Date(); // Data atual
        // Simulando uma espera ou operações
        try {
            Thread.sleep(2000); // Espera 2 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Date dataFim = new Date(); // Nova data após a espera

        // Calculando a diferença em dias entre as duas datas
        int diasDiferenca = DateScience.calcularDiferencaEmDias(dataInicio, dataFim);
        System.out.println("Diferença em dias: " + diasDiferenca);
    }
}
