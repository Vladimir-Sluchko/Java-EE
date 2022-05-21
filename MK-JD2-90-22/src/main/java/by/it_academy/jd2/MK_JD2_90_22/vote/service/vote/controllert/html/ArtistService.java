package by.it_academy.jd2.MK_JD2_90_22.vote.service.vote.controllert.html;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArtistService {

    private final static ArtistService instance = new ArtistService();
    private List<String> artists = new ArrayList<>(Arrays.asList("Круг",
            "Evanessnce","Eminem", "Бах"));

   private ArtistService() {
    }
    public static ArtistService getInstance(){
       return instance;
    }

    public List<String> getArtists(){
        return artists;
    }

    public void add(String artist){
        artists.add(artist);
    }


    public boolean isExist(int index){
        int size = artists.size();
        return index >= 0 && index < size;
    }

}
