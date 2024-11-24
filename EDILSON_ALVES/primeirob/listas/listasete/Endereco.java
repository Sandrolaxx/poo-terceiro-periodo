package primeirob.listas.listasete;

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

    public Endereco(){

    }
    // public Endereco(String estado, String cidade, String bairro, int numero, String complemento) {
    //     this.estado = estado;
    //     this.cidade = cidade;
    //     this.bairro = bairro;
    //     this.numero = numero;
    //     this.complemento = complemento;
    // }
    


    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setComplemento(String complemento) {
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
