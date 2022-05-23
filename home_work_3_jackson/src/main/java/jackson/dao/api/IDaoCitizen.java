package jackson.dao.api;

import jackson.dto.Citizen;

import java.util.List;

public interface IDaoCitizen {
    List<Citizen> getAll();
    void setCitizen(Citizen citizen);
}
