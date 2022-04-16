package by.it_academy.jd2.MK_JD2_90_22.vote.jsp.service;

import java.util.Random;

public class NameGeneratorServive {
    public static String getRandomName(){
        String[] names = {
                "Илья", "Антон", "Иван"
        };

        Random rnd = new Random();

        return names[rnd.nextInt(names.length)];
    }
}
