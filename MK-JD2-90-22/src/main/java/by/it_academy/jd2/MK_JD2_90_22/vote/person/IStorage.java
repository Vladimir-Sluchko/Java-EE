package by.it_academy.jd2.MK_JD2_90_22.vote.person;

import by.it_academy.jd2.MK_JD2_90_22.vote.person.core.dto.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IStorage {
    void save(HttpServletRequest req, HttpServletResponse resp, Person person);

    Person get(HttpServletRequest req);
}
