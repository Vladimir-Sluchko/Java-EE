package jackson.service.api;

import jackson.dto.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getAll();
    void setStudent(Student student);
}
