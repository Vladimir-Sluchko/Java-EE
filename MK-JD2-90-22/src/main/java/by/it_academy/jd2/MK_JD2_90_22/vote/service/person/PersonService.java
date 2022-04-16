package by.it_academy.jd2.MK_JD2_90_22.vote.service.person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonService {

    private final static PersonService instance = new PersonService();
    private List<String> artists = new ArrayList<>(Arrays.asList());

   private PersonService() {
    }
    public static PersonService getInstance(){
       return instance;
    }


   /* public void addPerson(Person person){
        artists.add(person);
    }*/



}
