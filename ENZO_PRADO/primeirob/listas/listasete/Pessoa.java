package ENZO_PRADO.primeirob.listas.listasete;

import java.text.NumberFormat;
import java.util.Locale;

abstract public class Pessoa {
   private String nome;
   private Integer idade;

   private Endereco endereco;
    
    public Pessoa(String nome, Integer idade, Endereco endereco){
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;

    }


        public String getNome(){
            return nome;
        }


        public Integer getIdade(){

            return idade;
        }

        public Endereco getEndereco() {
            return endereco;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }
     
        public void setIdade(Integer idade) {
            this.idade = idade;
        }
     
        public void setEndereco(Endereco endereco) {
            this.endereco = endereco;
        }

    abstract void apresentarse();
}
