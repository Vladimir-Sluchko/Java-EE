package by.it_academy.jd2.MK_JD2_90_22.vote.service.vote;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenreService {
    private List<String> genre = new ArrayList<>(Arrays.asList("рэп","хип-хоп",
            "рок", "классика","честушки","народные", "поп", "металл",
            "какой-то", "русский поп"));


    public List<String> getGenres(){
        return genre;
    }

    public void add(String genre){
        this.genre.add(genre);
    }

    public boolean isExist(int index){
        int size = genre.size();
        return index >= 0 && index < size;
    }
}
