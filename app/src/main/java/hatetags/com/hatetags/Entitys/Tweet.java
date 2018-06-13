package hatetags.com.hatetags.Entitys;

public class Tweet {

    private String tagUser;
    private String dataHora;
    private String content;
    private String favorites;
    private String retweets;

    public Tweet(String tagUser, String dataHora, String content, String favorites, String retweets) {
        this.tagUser = tagUser;
        this.dataHora = dataHora;
        this.content = content;
        this.favorites = favorites;
        this.retweets = retweets;
    }

    public String getTagUser() {
        return tagUser;
    }

    public void setTagUser(String tagUser) {
        this.tagUser = tagUser;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFavorites() {
        return favorites;
    }

    public void setFavorites(String favorites) {
        this.favorites = favorites;
    }

    public String getRetweets() {
        return retweets;
    }

    public void setRetweets(String retweets) {
        this.retweets = retweets;
    }
}
