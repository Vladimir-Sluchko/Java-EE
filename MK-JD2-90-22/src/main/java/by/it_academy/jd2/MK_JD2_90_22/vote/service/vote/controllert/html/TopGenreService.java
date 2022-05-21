package by.it_academy.jd2.MK_JD2_90_22.vote.service.vote.controllert.html;

import by.it_academy.jd2.MK_JD2_90_22.vote.core.dto.VoteDto;
import by.it_academy.jd2.MK_JD2_90_22.vote.service.singleton.GenrySingleton;

import java.util.*;
import java.util.stream.Collectors;

public class TopGenreService {
    private static TopGenreService topGenreService;

    private Map<String,Integer> topGenre = new HashMap<>();

    private TopGenreService(){

    }

    public static TopGenreService getInstance(){
        if (topGenreService == null){
            topGenreService = new TopGenreService();
        } return topGenreService;
    }

    public Map<String ,Integer> getTopGenre(){
        Map<String,Integer> sortedMap = topGenre.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a,b)->{throw new AssertionError();},
                        LinkedHashMap::new
                ));
        return sortedMap;
    }

    public void addVote(VoteDto voteDto){
        int[] arrGenres = voteDto.getGenres();

        List<String> genres = GenrySingleton.getGenrySingleton().getGenres();
        for (int j = 0; j < arrGenres.length; j++) {
            if (topGenre.containsKey(genres.get(arrGenres[j]))){
                Integer number = topGenre.get(genres.get(arrGenres[j]));
                topGenre.put(genres.get(arrGenres[j]),++number);
            }else topGenre.put(genres.get(arrGenres[j]),1);
        }


    }
}
