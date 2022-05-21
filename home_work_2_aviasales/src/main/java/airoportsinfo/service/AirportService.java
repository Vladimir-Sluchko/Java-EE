package airoportsinfo.service;


import airoportsinfo.dao.AirportPoolDao2;
import airoportsinfo.dao.api.IAirport;
import airoportsinfo.dao.dto.AirportInfo;
import airoportsinfo.service.api.IAirportService;

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
