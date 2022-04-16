package by.it_academy.jd2.MK_JD2_90_22.vote.person.core.dto;

import by.it_academy.jd2.MK_JD2_90_22.vote.servlets.cookieAndSession.iliy.SessionServlet;

public enum StorageType {
    COOKIES,
    SESSION
    ;


    public static StorageType valueOfIgnoreCase(String name){
        for (StorageType type : values()) {
            if (type.name().equalsIgnoreCase(name)){
                return type;
            }
        }
        throw new IllegalArgumentException("Не верный тип хранилища");
    }

}

