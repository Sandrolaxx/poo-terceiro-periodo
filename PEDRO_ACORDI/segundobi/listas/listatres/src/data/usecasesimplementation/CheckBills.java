package data.usecasesimplementation;

import data.protocols.Celcoin.IConsultBills;
import domain.DTO.ConsultBillsDTO;
import domain.usecases.ICheckBills;

public class CheckBills implements ICheckBills {

    private final IConsultBills consultBillsRepository;

    public CheckBills(IConsultBills consultBillsRepository) {
        this.consultBillsRepository = consultBillsRepository;
    }

    @Override
    public String checkBills(ConsultBillsDTO dto) throws IllegalAccessException {
        return consultBillsRepository.consultBills(dto);
    }
}
