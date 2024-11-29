package domain.DTO;

import domain.entities.BarCode;

public class ConsultBillsDTO {
    BarCode barCode;

    public ConsultBillsDTO(BarCode barCode) {
        this.barCode = barCode;
    }
}
