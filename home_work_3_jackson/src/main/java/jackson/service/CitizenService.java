package jackson.service;

import jackson.dao.DaoCitizen;
import jackson.dao.api.IDaoCitizen;
import jackson.dto.Citizen;
import jackson.service.api.ICitizenService;

import java.util.List;

public class CitizenService implements ICitizenService {
    private IDaoCitizen iDaoCitizen;
    private static final CitizenService instance = new CitizenService();

    public CitizenService() {
        this.iDaoCitizen = DaoCitizen.getInstance();
    }

    @Override
    public List<Citizen> getAll() {
        return iDaoCitizen.getAll();
    }

    @Override
    public void setCitizen(Citizen citizen) {
       iDaoCitizen.setCitizen(citizen);

    }
    public static CitizenService getInstance(){
        return instance;
    }
}
