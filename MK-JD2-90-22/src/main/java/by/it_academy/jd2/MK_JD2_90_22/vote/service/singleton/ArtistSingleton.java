package by.it_academy.jd2.MK_JD2_90_22.vote.service.singleton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArtistSingleton {
    private static ArtistSingleton artistSingleton;
    private static List<String> artists = new ArrayList<>(Arrays.asList("Круг",
            "Evanessnce","Eminem", "Бах"));

    private ArtistSingleton() {
    }

    public static ArtistSingleton getArtistSingleton(){
        if (artistSingleton == null ){
            artistSingleton = new ArtistSingleton();
        } return artistSingleton;
    }

    public List<String> getArtists() {
        return artists;
    }

    public void addArtist(String artist){
        artists.add(artist);
    }

    public boolean isExist(int index){
        int size = artists.size();
        return index >= 0 && index < size;
    }

}
