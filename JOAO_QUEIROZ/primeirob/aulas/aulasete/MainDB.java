package aulas.aulasete;

import aulas.aulasete.PostgresDB;

public class MainDB {
    public static void main(String[] args) {
        
        PostgresDB pg = new PostgresDB();

        salvar(pg);

    }

    public static void salvar(PostgresDB pg) {
        pg.salvar();
    }
}
