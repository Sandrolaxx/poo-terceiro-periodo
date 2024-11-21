package data.protocols.Celcoin;

import domain.DTO.ConsultBillsDTO;

public interface IConsultBills {
    String consultBills(ConsultBillsDTO dto) throws IllegalAccessException;
}
