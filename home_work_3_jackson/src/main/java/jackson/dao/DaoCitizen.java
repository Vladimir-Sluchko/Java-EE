package jackson.dao;

import jackson.dao.api.IDaoCitizen;
import jackson.dto.Citizen;
import jackson.dto.Passport;
import jackson.dto.builders.CitizenBuild;
import jackson.dto.builders.PassportBuild;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DaoCitizen implements IDaoCitizen {
    private static final DaoCitizen instance = new DaoCitizen();
    private static List<Citizen> listCitizen = new ArrayList<>(Arrays.asList(CitizenBuild.Builder.create()
            .setId("MP1112233")
            .setBirthday(LocalDate.of(1991, 4, 8))
            .setName("Valera")
            .setPassport(
                    PassportBuild.Builder.create()
                            .setId("011101")
                            .setIdCitizen("01k11tbs")
                            .setAddress("Minsk")
                            .setCreateDate( LocalDate.now()).build())
            .build()));

    @Override
    public List<Citizen> getAll() {
        return listCitizen;
    }

    @Override
    public void setCitizen(Citizen citizen) {
        listCitizen.add(citizen);

    }
    public static DaoCitizen getInstance(){
        return instance;
    }
}
