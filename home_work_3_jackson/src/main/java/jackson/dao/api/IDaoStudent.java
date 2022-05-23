package jackson.dao.api;

import jackson.dto.Student;

import java.util.List;

public interface IDaoStudent {
    List<Student> getAll();
    void setStudent(Student student);
}
