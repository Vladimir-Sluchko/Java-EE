package jackson.dto;

import java.util.List;

public class PageJson<T> {
    private List<T> content;

    public PageJson(List<T> content) {
        this.content = content;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }
    public static class Builder<T>{
        private List<T> content;

        public Builder<T> setContent(List<T> content) {
            this.content = content;
            return this;
        }
        public static <T> Builder<T> create(Class<T> tClass){
            return new Builder<>();
        }
        public PageJson<T> build(){
            return new PageJson<>(content);
        }

    }
}
