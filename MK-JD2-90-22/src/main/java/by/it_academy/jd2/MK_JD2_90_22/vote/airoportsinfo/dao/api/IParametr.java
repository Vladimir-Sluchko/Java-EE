package by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.api;

import java.util.List;

public interface IParametr<T> {

    List<T> getByColumnName(String columnName, String tableName);
}
