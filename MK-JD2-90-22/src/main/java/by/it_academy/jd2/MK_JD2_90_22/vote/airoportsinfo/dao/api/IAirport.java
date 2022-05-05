package by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.api;

import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.dto.AirportInfo;

import java.util.List;

public interface IAirport extends AutoCloseable{

     List<AirportInfo> getAll(String sort);


}
