package segundob.aulas.auladois;
import javax.swing.JOptionPane;
import java.util.List;
public class ExemploJOptionArray {
    public static void main(String[] args) {
        
        List<String> melhorProf=List.of("Sandro","Rita","Elaine");
        String melhorProf2 = (String) JOptionPane.showInputDialog(null,
        "Melhor professor",
        "O the best",
        JOptionPane.QUESTION_MESSAGE, 
        null,
        melhorProf.toArray(),
        melhorProf.toArray()[0]);

        JOptionPane.showMessageDialog(null,"Meu profe favorito é " +  melhorProf2);
    }
}
