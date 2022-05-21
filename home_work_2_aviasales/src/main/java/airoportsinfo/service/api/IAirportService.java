package airoportsinfo.service.api;



import airoportsinfo.dao.dto.AirportInfo;

import java.util.List;

public interface IAirportService {
    List<AirportInfo> getAll();

    void setSort(String str);



}
