package by.it_academy.jd2.MK_JD2_90_22.vote.service.singleton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenrySingleton {
    public static GenrySingleton genrySingleton;

    private GenrySingleton() {
    }
    public static List<String> genres = new ArrayList<>(Arrays.asList("рэп","хип-хоп",
            "рок", "классика","честушки","народные", "поп", "металл",
            "какой-то", "русский поп"));

    public static GenrySingleton  getGenrySingleton(){
        if(genrySingleton == null){
            genrySingleton = new GenrySingleton();
        } return genrySingleton;
    }

    public List<String> getGenres(){
        return genres;
    }

    public void addGenre(String genre){
        genres.add(genre);
    }

    public boolean isExist (int index){
        int size =genres.size();
        return index >= 0 && index < size;
    }
}
