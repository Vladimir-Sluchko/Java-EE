package jackson.service.api;

import jackson.dto.Citizen;
import jackson.dto.Student;

import java.util.List;

public interface ICitizenService {
    List<Citizen> getAll();
    void setCitizen(Citizen citizen);

}
