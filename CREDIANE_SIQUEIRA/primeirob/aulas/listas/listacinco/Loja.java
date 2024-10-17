package primeirob.aulas.listas.listacinco;

public class Loja {
    String nomeFantasia;
    String razaoSocial;
    String cnpj;
    String cidade;
    String bairro;
    String rua;
    String vendedor;
    String cliente;

    Vendedor[] vendedores = new Vendedor [2];
    Cliente[] clientes = new Cliente [2];
    public Object contarVendedor;

void apresentarse() {
    System.out.println(nomeFantasia);
    System.out.println(cnpj);
    System.out.println(rua);
    
}

public void adicionarVendedor(Vendedor vendedor, int i){

    if (vendedores[0] == null) {
       vendedores[0] = vendedor;
       
       return;
    }
    if (vendedores[1] == null) {
        vendedores[1] = vendedor;
        
        return;
     }
}
public void adicionarCliente(Cliente cliente, int i){

    if (clientes[0] == null) {
        clientes[0] = cliente;
        
        return;
     }
     if (clientes[1] == null) {
         clientes[1] = cliente;
         
         return;
      }
 }

public Integer contarVendedor(Vendedor vendedor){

    Integer contador = 0;

    for (int i = 0; i < vendedores.length; i++) {
        if (vendedores[i] != null) {
            contador ++;
        }

    }

    return contador;

}
public void contarCliente(Cliente cliente){
    Integer contador = 0;

    for (int i = 0; i < vendedores.length; i++) {
        if (vendedores[i] != null) {
            contador ++;
        }

    }

    return;

}
}

