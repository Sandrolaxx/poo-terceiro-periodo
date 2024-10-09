package segundob.aulas.revisaoProva;

import java.util.Date;

public class Reserva {
    private Integer id;
    private Cliente cliente;
    private Quarto quarto;
    private Date dataEntrada;
    private Date dataSaida;
    private Date dataChekin;
    private Date dataChekout;
    private Double total;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Quarto getQuarto() {
        return quarto;
    }
    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }
    public Date getDataEntrada() {
        return dataEntrada;
    }
    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }
    public Date getDataSaida() {
        return dataSaida;
    }
    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }
    public Date getDataChekin() {
        return dataChekin;
    }
    public void setDataChekin(Date dataChekin) {
        this.dataChekin = dataChekin;
    }
    public Date getDataChekout() {
        return dataChekout;
    }
    public void setDataChekout(Date dataChekout) {
        this.dataChekout = dataChekout;
    }
    public Double getTotal() {
        return total;
    }
    public void setTotal(Double total) {
        this.total = total;
    } 
}
