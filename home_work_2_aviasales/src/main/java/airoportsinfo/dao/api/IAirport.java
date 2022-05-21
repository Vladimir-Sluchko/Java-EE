package airoportsinfo.dao.api;



import airoportsinfo.dao.dto.AirportInfo;

import java.util.List;

public interface IAirport extends AutoCloseable{

     List<AirportInfo> getAll(String sort);


}
