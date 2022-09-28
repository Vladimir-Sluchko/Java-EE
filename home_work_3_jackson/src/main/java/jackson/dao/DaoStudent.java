package jackson.dao;

import jackson.dao.api.IDaoStudent;
import jackson.dto.Student;
import jackson.dto.builders.StudentBuild;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DaoStudent implements IDaoStudent {
    Student student = new Student();
    private static final DaoStudent instance = new DaoStudent();
    private static List<Student> studentList = new ArrayList<>(
            Arrays.asList(StudentBuild.Builder.create().setId(1).setName("Vitaliy").setAge(28).setScore(9).setOlympicGamer(true).build(),
                    StudentBuild.Builder.create().setId(2).setName("Вася").setAge(28).setScore(9).setOlympicGamer(true).build()));


    @Override
    public List<Student> getAll() {
        return studentList;
    }

    public void setStudent(Student student){
        studentList.add(student);
    }

    public static DaoStudent getInstance() {
        return instance;
    }

    /*@Override
    public String toString() {
        return "DaoStudent{" +
                "student=" + student +
                '}';
    }*/
}
