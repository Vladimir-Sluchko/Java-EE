package airoportsinfo.service;

import airoportsinfo.dao.dto.Page;
import airoportsinfo.service.api.IPageService;

public class PageService implements IPageService {
    private static final PageService instance = new PageService();

    @Override
    public Page countPage(String countPage, Page page) {
        int pageN = 1;
        String s1 = "Search";
        if(s1.equals(countPage)){
            page = Page.of(25,1);
            return page;
        }
        if(page == null){
            page = Page.of(25,pageN);
            return page;
        }
        if (countPage != null && !countPage.isEmpty()){
            pageN = pageN + Integer.parseInt(countPage);
            page = Page.of(25,pageN);
            return page;
        }
        return page;
    }

    public static PageService getInstance(){
        return instance;
    }

}
