package ENZO_PRADO.primeirob.listas.listasete;

public class Cliente extends Pessoa{
   
public Cliente(String nome, Integer idade, Endereco endereco){
    super(nome, idade, endereco);
}



@Override
    void apresentarse(){
        
            System.out.println("Sou o cliente " + getNome() + (" E tenho " + getIdade() + " anos"));
    }
}
