package EDILSON_ALVES.primeirob.listas.listaseis;

public class Endereco {

    public String estado;
    public String cidade; 
    public String bairro;
    public int numero;
    public String complemento;
  

    public void apresentaEndereco(){
        System.out.println("estado "+this.estado);
        System.out.println("cidade "+this.cidade);
        System.out.println("bairro "+this.bairro);
        System.out.println("numero "+this.numero);
        System.out.println("complemento "+this.complemento);
    }

    public Endereco(String estado, String cidade, String bairro, int numero, String complemento) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
    }


    public String getEstado() {
        return estado;
    }
    




    public String getCidade() {
        return cidade;
    }




    public String getBairro() {
        return bairro;
    }




    public int getNumero() {
        return numero;
    }




    public String getComplemento() {
        return complemento;
    }
    


}
