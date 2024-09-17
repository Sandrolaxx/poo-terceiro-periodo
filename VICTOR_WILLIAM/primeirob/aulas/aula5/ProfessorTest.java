package VICTOR_WILLIAM.primeirob.aulas.aula5;

public class ProfessorTest {
    public static void main(String[] args) {
        Professor professor = new Professor();
            professor.name = "Victor";
            professor.metter = "Java";
            professor.vivo = true;
            professor.qualification = "Suavao";

        Arma gun = new Arma();
            gun.name = "M4A1";
            gun.skin = "Asimov";
            gun.type = "Rifle";
            gun.damage = 30;

            professor.arma = gun;

            professor.apresentar();


        Professor professora = new Professor();
            professora.name = "Maria";
            professora.metter = "Java";
            professora.vivo = true;
            professora.qualification = "Correria";

            professora.apresentar();

    }
}
