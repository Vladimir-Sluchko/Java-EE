package jackson.dto.builders;


import jackson.dto.Passport;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class PassportBuild {
    public static class Builder{
        private String id;
        private String idCitizen;
        private String address;

        private LocalDate createDate;

        private Builder(){}

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setIdCitizen(String idCitizen) {
            this.idCitizen = idCitizen;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }
        public Builder setCreateDate(LocalDate createDate){
            this.createDate = createDate;
            return this;
        }
        public static Builder create(){
            return new Builder();
        }

        public Passport build(){
            Passport passport = new Passport(id, idCitizen, address,createDate);
            return passport;
        }
    }
}
