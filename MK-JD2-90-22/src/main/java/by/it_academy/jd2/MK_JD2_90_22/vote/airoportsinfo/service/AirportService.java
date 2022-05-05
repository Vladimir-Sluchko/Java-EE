package by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.service;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.AirportPoolDao2;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.api.IAirport;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.dto.AirportInfo;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.service.api.IAirportService;

import java.util.List;

public class AirportService implements IAirportService {
    private static String sort = "ASC";


    public List<AirportInfo> getAll() {
        List<AirportInfo> airportList;
        try (IAirport airportPoolDao = new AirportPoolDao2();) {
            airportList = airportPoolDao.getAll(getSort());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return airportList;
    }

    @Override
    public void setSort(String str) {
        sort = str;
    }

    public String getSort(){
        return sort;
    }
}
