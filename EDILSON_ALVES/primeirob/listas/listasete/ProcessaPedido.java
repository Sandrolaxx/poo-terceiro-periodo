package EDILSON_ALVES.primeirob.listas.listasete;

import java.util.Date;

public class ProcessaPedido {
   
    long diaEmMs = 86400000l;
    long diaEmMss = 86400000l - (86400000l*3);
    long diaEmMsss = 86400000l - (86400000l*2);

    Date dateTeste = new Date(diaEmMs);
    Date agora = new Date();

    Date tresdois = new Date(agora.getTime()+(diaEmMsss));
    Date tresdias = new Date(agora.getTime()+(diaEmMs*3));
    Date tresmenos = new Date(agora.getTime()+(diaEmMss));



    public void processar(){

        Item item = new Item(16, "caneta", "bic", 15);
       
        Item[] items = {item};

        Pedido pedido = new Pedido(15, tresmenos,tresdois,tresdias,"Edilson","alves","lojinhatopzera",items);

            pedido.imprime();
            confirmarPagamento();
    }


    

    public void confirmarPagamento(){
        System.out.println("pagamento confirmado ");

    }

}


/*
        long diaEmMs = 86400000l;
        Date dateTeste = new Date(diaEmMs);
        Date agora = new Date();
        Date amanha = new Date(agora.getTime()+diaEmMs);
        Date daquitres = new Date(agora.getTime()+(diaEmMs*4 ));
*/ 