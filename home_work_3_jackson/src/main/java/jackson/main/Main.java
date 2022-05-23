package jackson.main;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jackson.dao.DaoCitizen;
import jackson.dao.DaoStudent;
import jackson.dao.api.IDaoCitizen;
import jackson.dao.api.IDaoStudent;
import jackson.dto.Citizen;
import jackson.dto.Student;

import java.util.List;
import java.util.SortedMap;

public class Main {

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper snakeMapper = new ObjectMapper();
        snakeMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        snakeMapper.registerModule(new JavaTimeModule());
        snakeMapper.disable(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS);

        ObjectMapper lowerMapper = new ObjectMapper();
        lowerMapper.setPropertyNamingStrategy(PropertyNamingStrategies.LOWER_CAMEL_CASE);
        lowerMapper.registerModule(new JavaTimeModule());
        lowerMapper.disable(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS);

        IDaoStudent iDaoStudent = DaoStudent.getInstance();
        List<Student> all = iDaoStudent.getAll();
        for (Student student2 : all) {
            System.out.println(snakeMapper.writeValueAsString(student2));
        }
        IDaoCitizen iDaoCitizen = DaoCitizen.getInstance();
        for (Citizen citizen : iDaoCitizen.getAll()) {
            System.out.println(lowerMapper.writeValueAsString(citizen));
        }


    }
}
