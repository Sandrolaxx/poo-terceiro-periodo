package primeirob.aulas.aulaseis;

public class Main {
    
    public static void main(String[] args) {
        
        AlunoNinja alunoNinja = new AlunoNinja();

        alunoNinja.nome = "Boruto";
        alunoNinja.aldeia = "Folha";
        alunoNinja.cla = "Uzumaki";
        alunoNinja.idade =  12;
        alunoNinja.nomeJutso = "Clone das sombras";

        alunoNinja.nomeTime = "Time Konohamaru";
        alunoNinja.nomeProfessor = "Konohamaru Sarutobi";
        
        Ninja ninjaDois = new AlunoNinja();

        ninjaDois.nome = "Sasuke";
        ninjaDois.aldeia = "Folha";
        ninjaDois.cla = "Uchiha";
        ninjaDois.idade = 18;
        ninjaDois.nomeJutso = "Chidori";
        ninjaDois.equipamento = "Shuriken";

        alunoNinja.apresentarse();
        ninjaDois.apresentarse();
    }

}
