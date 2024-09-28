package MATHEUS.primeirob.prova;

import java.util.Date;

public class Gerenciahotel {
    
    public static void reservaQuarto(Quarto quarto, Date diainicio, Date diafim, Cliente cliente){
        
        if (verificaDisponivel(quarto, diainicio, diafim)) {
            quarto.setDiaInicioReserva(diainicio);
            quarto.setFimReserva(diafim);
            quarto.setDisponivel(false);
            quarto.setCliente(cliente);
            System.out.println("quarto reservado com sucesso");
            return;
        }
        System.out.println("o querto não esta disponivel para reserva");
    }

    public static Quarto buscaQuarto(Quarto[] quartos, int numero){
        Quarto quartoRetorno = null;
        for (Quarto quarto : quartos) {
            if (quarto != null) {
                if (quarto.getNumero() == numero) {
                    quartoRetorno = quarto;
                   return quartoRetorno;
               }
            }
        }
        return quartoRetorno;
    }

    public static boolean verificaDisponivel(Quarto quarto, Date diainicio, Date diafim){
            if (quarto.getDiaInicioReserva() == null || quarto.getFimReserva() == null ) {
                return true;
            }
            long diaIniciolong = diainicio.getTime();
            long diafimlong = diafim.getTime();
            if ((diaIniciolong > quarto.getDiaInicioReserva().getTime()) && (diaIniciolong < quarto.getFimReserva().getTime())) {
                return false;
            }else if ((diafimlong > quarto.getDiaInicioReserva().getTime()) && (diafimlong < quarto.getFimReserva().getTime())) {
                return false; 
            }else if (quarto.getFimReserva().getTime() - quarto.getDiaInicioReserva().getTime() < diafimlong - diaIniciolong) {
                return false;
            };
            
        return true;
    }

    private static long calcularDias(Date dataInicio, Date dataFim) {
        long diferencaMilissegundos = dataFim.getTime() - dataInicio.getTime();
        return diferencaMilissegundos / (1000 * 60 * 60 * 24); 
    }

    public static  void calcularValorDiarias(Quarto quarto) {
        long dias = calcularDias(quarto.getDiaInicioReserva(), quarto.getFimReserva());
        
       
            double multa = dias * quarto.getValorDiaria();
            System.out.println("valor total das diarias: R$" + multa);
    }
}
