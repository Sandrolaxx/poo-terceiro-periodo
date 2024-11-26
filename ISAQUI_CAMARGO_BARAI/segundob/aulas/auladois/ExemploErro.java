package segundob.aulas.auladois;

public class ExemploErro {
    
    public static void main(String[] args) {
        
        printarNome("Show!");
        printarNome(null);
        
    }

    public static void printarNome(String nome) {
        
        try {
            System.out.println(nome.toUpperCase());
        } catch (Exception e) {
            throw new MagagninExeption("Deu ruim mano!");
        }

        System.out.println("Teste");

    }

}
