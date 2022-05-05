package by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.service.api;

import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.dto.AirportInfo;

import java.util.List;

public interface IAirportService {
    List<AirportInfo> getAll();

    void setSort(String str);

    String getSort();

}
