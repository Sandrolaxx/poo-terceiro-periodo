package ENZO_PRADO.primeirob.listas.listaseis;

public class Cliente extends Pessoa{
   

@Override
    void apresentarse(){
            System.out.println("Sou o cliente ".concat(nome).concat(" E tenho " + idade + " anos"));
    }
}
