package by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.service;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.AirportPoolDao2;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.api.IAirport;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.dto.AirportInfo;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.service.api.IAirportService;

import java.util.List;

public class AirportService implements IAirportService {
    private static final IAirportService instance = new AirportService();
    private  String sort;

    private final IAirport dao;

    private AirportService() {
        this.dao = AirportPoolDao2.getInstance();
    }

    public List<AirportInfo> getAll() {
        return this.dao.getAll(getSort());
    }

    @Override
    public void setSort(String str) {
        sort = str;
    }

    public String getSort(){
        return sort;
    }
    public static IAirportService getInstance(){
        return instance;
    }
}
