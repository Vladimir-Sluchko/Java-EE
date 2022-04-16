package by.it_academy.jd2.MK_JD2_90_22.vote.service.cookieAndSession;


import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;


public class SetSessionService {

    public static String getValueFromAnywhere2(HttpServletRequest req,
                                              String key){
        String val = req.getParameter(key);
        if(val == null){
            HttpSession session = req.getSession();

           if(!session.isNew()){
               val = (String) session.getAttribute(key);
           }
        }
        if (val == null){
            throw new IllegalArgumentException("не передан аргумент");
        }
        return val;
    }

    public static void saveSession(HttpServletRequest req, String key, String val){
        HttpSession session = req.getSession();

        session.setAttribute(key,val);
    }


}
