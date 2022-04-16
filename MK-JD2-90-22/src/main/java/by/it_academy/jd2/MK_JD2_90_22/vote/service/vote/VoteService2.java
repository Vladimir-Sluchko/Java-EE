package by.it_academy.jd2.MK_JD2_90_22.vote.service.vote;

import by.it_academy.jd2.MK_JD2_90_22.vote.core.dto.VoteDto;
import by.it_academy.jd2.MK_JD2_90_22.vote.service.singleton.ArtistSingleton;
import by.it_academy.jd2.MK_JD2_90_22.vote.service.singleton.GenrySingleton;

public class VoteService2 {

    public void check(VoteDto vote){
        if(vote.getGenres().length < 3 || vote.getGenres().length > 5){
            throw new IllegalArgumentException("Жанров слишком мало! или много!");
        }
        if(!ArtistSingleton.getArtistSingleton().isExist(vote.getArtist())){
            throw new IllegalArgumentException("Такого артиста не существует");
        }

        for (int genre : vote.getGenres()) {
            if(! GenrySingleton.getGenrySingleton().isExist(genre)){
                throw new IllegalArgumentException("Такого жанра не существует");
            }
        }
    }

    public void save(VoteDto vote){
        check(vote);
    }
}
