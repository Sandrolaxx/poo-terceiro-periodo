package data.usecasesimplementation;

import data.protocols.Celcoin.IGetInstitutions;
import domain.usecases.ICheckInstitutions;

public class CheckInstitutions implements ICheckInstitutions {

    private final IGetInstitutions getInstitutionsRepository;

    public CheckInstitutions(IGetInstitutions getInstitutionsRepository) {
        this.getInstitutionsRepository = getInstitutionsRepository;
    }

    @Override
    public String seeInstitutions() {
        return this.getInstitutionsRepository.getInstitutions();
    }
}
