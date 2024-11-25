package segundob.listas.listatres;

public interface IBassRepository {

    String consultarBoleto(String linhaDigitavel) throws Exception;

    String listarConvenios() throws Exception;

    public String gerarToken() throws Exception;


}
