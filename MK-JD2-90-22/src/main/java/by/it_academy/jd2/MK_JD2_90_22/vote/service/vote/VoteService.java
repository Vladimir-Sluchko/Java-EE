package by.it_academy.jd2.MK_JD2_90_22.vote.service.vote;

import by.it_academy.jd2.MK_JD2_90_22.vote.core.dto.VoteDto;
import by.it_academy.jd2.MK_JD2_90_22.vote.service.vote.ArtistService;
import by.it_academy.jd2.MK_JD2_90_22.vote.service.vote.GenreService;

public class VoteService {

    private ArtistService artistService;
    private GenreService genryService;

    public VoteService(){
        this.artistService = ArtistService.getInstance();
        this.genryService = new GenreService();
    }

    public void check(VoteDto vote){
        if(vote.getGenres().length < 3 || vote.getGenres().length > 5){
            throw new IllegalArgumentException("Жанров слишком мало! или много!");
        }
        if(!this.artistService.isExist(vote.getArtist())){
            throw new IllegalArgumentException("Такого артиста не существует");
        }

        for (int genre : vote.getGenres()) {
            if(!this.genryService.isExist(genre)){
                throw new IllegalArgumentException("Такого жанра не существует");
            }
        }
    }

    public void save(VoteDto vote){
        check(vote);
    }
}
