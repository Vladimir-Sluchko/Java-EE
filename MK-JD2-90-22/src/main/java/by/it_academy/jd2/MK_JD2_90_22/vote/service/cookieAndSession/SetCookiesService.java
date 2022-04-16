package by.it_academy.jd2.MK_JD2_90_22.vote.service.cookieAndSession;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetCookiesService {


    public static String getValueFromAnywhere(HttpServletRequest request,String key){
        String val = request.getParameter(key);
        if(val == null){
            Cookie[] cookies = request.getCookies();
            if (cookies != null){
                val =Arrays.stream(cookies)
                        .filter(c -> key.equalsIgnoreCase(c.getName()))
                        .map(Cookie::getValue)
                        .findFirst()
                        .orElse(null);
            }
        }
        if(val == null){
            throw new IllegalArgumentException("не переданы параметры");
        }
        return val;
    }

    public static void saveCookies(HttpServletResponse response, String key, String val){
        Cookie myCookie = new Cookie(key, URLEncoder.encode(val, StandardCharsets.UTF_8));
        myCookie.setMaxAge((Math.toIntExact(60*60)));
        response.addCookie(myCookie);
    }


}
