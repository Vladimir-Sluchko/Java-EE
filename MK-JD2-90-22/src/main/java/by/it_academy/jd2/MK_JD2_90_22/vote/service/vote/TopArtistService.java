package by.it_academy.jd2.MK_JD2_90_22.vote.service.vote;

import by.it_academy.jd2.MK_JD2_90_22.vote.core.dto.VoteDto;
import by.it_academy.jd2.MK_JD2_90_22.vote.service.singleton.ArtistSingleton;

import java.util.*;
import java.util.stream.Collectors;

public class TopArtistService {
    private static TopArtistService artistService;

    private Map<String,Integer> topArtist = new HashMap<>();

    private TopArtistService() {
    }
    public static TopArtistService getInstance(){
        if (artistService == null){
            artistService = new TopArtistService();
        } return artistService;
    }

    public Map<String,Integer> getTopArtist(){
        Map<String,Integer> sortedMap = topArtist.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue()))
                .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (a,b)->{throw new AssertionError();},
                LinkedHashMap::new
        ));
        return sortedMap;
    }


    public void addVote(VoteDto voteDto) {
        List<String> artists = ArtistSingleton.getArtistSingleton().getArtists();
        String voteartist = artists.get((voteDto.getArtist()));
            if(topArtist.containsKey(voteartist)){
                Integer number = topArtist.get(voteartist);
                topArtist.put(voteartist,++number);
            }else topArtist.put(voteartist,1);
    }


}
