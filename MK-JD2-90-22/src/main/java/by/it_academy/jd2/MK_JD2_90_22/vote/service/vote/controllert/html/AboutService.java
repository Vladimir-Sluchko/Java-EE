package by.it_academy.jd2.MK_JD2_90_22.vote.service.vote.controllert.html;

import java.util.ArrayList;
import java.util.List;

public class AboutService {
    private static AboutService aboutService;
    private static List<String> about = new ArrayList<>();
    private AboutService(){

    }
    public static AboutService getInstance(){
        if(aboutService == null){
            aboutService = new AboutService();
        }return aboutService;
    }
    public List<String> getAbout(){
        return about;
    }

    public void addAbout(String abouts){
        about.add(abouts);
    }
}
