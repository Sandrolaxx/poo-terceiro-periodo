package domain.usecases;

import domain.DTO.ConsultBillsDTO;

public interface ICheckBills {
    String checkBills(ConsultBillsDTO dto) throws IllegalAccessException;
}
