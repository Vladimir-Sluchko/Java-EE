package jackson.dto.builders;

import jackson.dto.Student;

import java.util.Objects;

public class StudentBuild {
    public static class Builder{
        private int id;
        private String name;
        private int age;
        private double score;
        private boolean olympicGamer;

        private Builder(){

        }


        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setScore(double score) {
            this.score = score;
            return this;
        }

        public Builder setOlympicGamer(boolean olympicGamer) {
            this.olympicGamer = olympicGamer;
            return this;
        }

        public static Builder create(){
            return new Builder();
        }

        public Student build(){
            Student student = new Student();
            student.setId(id);
            student.setName(name);
            student.setAge(age);
            student.setScore(score);
            student.setOlympicGamer(olympicGamer);
            return student;
        }



    }
}
