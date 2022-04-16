package by.it_academy.jd2.MK_JD2_90_22.vote.service.singleton;

import by.it_academy.jd2.MK_JD2_90_22.vote.core.dto.VoteDto;

public class VoteSingleton {
    public static VoteSingleton voteSingleton;

    private VoteSingleton() {
    }

    public static VoteSingleton getVoteSingleton(){
        if (voteSingleton == null){
            voteSingleton = new VoteSingleton();
        } return voteSingleton;
    }
    public void check(VoteDto vote){
        if(vote.getGenres().length < 3 || vote.getGenres().length > 5){
            throw new IllegalArgumentException("Жанров слишком мало! или много!");
        }
        if(!ArtistSingleton.getArtistSingleton().isExist(vote.getArtist())){
            throw new IllegalArgumentException("Такого артиста не существует");
        }
        for (int genre : vote.getGenres()) {
            if(!GenrySingleton.getGenrySingleton().isExist(genre)){
                throw new IllegalArgumentException("Такого жанра не существует");
            }
        }
    }
    public void save(VoteDto vote){
        check(vote);

    }


}
