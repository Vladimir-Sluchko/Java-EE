package jackson.service;

import jackson.dao.DaoStudent;
import jackson.dao.api.IDaoStudent;
import jackson.dto.Student;
import jackson.service.api.IStudentService;

import java.util.List;

public class StudentService implements IStudentService {
    private IDaoStudent daoStudent;
    private static StudentService instance = new StudentService();

    public StudentService() {
        this.daoStudent = DaoStudent.getInstance();
    }

    @Override
    public List<Student> getAll() {
        return daoStudent.getAll();
    }

    @Override
    public void setStudent(Student student) {
        daoStudent.setStudent(student);

    }
    public static StudentService getInstance(){
        return instance;
    }
}
