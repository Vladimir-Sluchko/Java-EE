package by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.dto;

public class Page {
    private int size;
    private int page;

    public Page(int size, int page) {
        this.size = size;
        this.page = page;
    }

    public Page() {
        this.size = size;
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public int getPage() {
        return page;
    }
    public static Page of (int size, int page){
        return new Page(size, page);
    }
}
