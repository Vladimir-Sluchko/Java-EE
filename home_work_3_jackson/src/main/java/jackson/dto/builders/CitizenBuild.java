package jackson.dto.builders;

import jackson.dto.Citizen;
import jackson.dto.Passport;

import java.time.LocalDate;
import java.util.Objects;

public class CitizenBuild {
    public static class Builder{
        private String id;
        private Passport passport;
        private String name;
        private LocalDate birthday;

        private Builder(){

        }

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setPassport(Passport passport) {
            this.passport = passport;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setBirthday(LocalDate birthday) {
            this.birthday = birthday;
            return this;
        }
        public static Builder create(){
            return new Builder();
        }

        public Citizen build(){
            Citizen citizen = new Citizen();
            citizen.setId(id);
            citizen.setPassport(passport);
            citizen.setBirthday(birthday);
            citizen.setName(name);
            return citizen;

        }
    }
}
