package hatetags.com.hatetags.Entitys;

import java.util.Date;

public class Tweet {

    private Long id;

    private Long idUsuario;

    private Long idTweet;

    private String dsTweet;

    private Date dhTweet;

    private Long qtFavoritos;

    private Long qtRetweets;

    private int snRetweet;

    private String nmLocal;

    private String nmPais;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdTweet() {
        return idTweet;
    }

    public void setIdTweet(Long idTweet) {
        this.idTweet = idTweet;
    }

    public String getDsTweet() {
        return dsTweet;
    }

    public void setDsTweet(String dsTweet) {
        this.dsTweet = dsTweet;
    }

    public Date getDhTweet() {
        return dhTweet;
    }

    public void setDhTweet(Date dhTweet) {
        this.dhTweet = dhTweet;
    }

    public Long getQtFavoritos() {
        return qtFavoritos;
    }

    public void setQtFavoritos(Long qtFavoritos) {
        this.qtFavoritos = qtFavoritos;
    }

    public Long getQtRetweets() {
        return qtRetweets;
    }

    public void setQtRetweets(Long qtRetweets) {
        this.qtRetweets = qtRetweets;
    }

    public int getSnRetweet() {
        return snRetweet;
    }

    public void setSnRetweet(int snRetweet) {
        this.snRetweet = snRetweet;
    }

    public String getNmLocal() {
        return nmLocal;
    }

    public void setNmLocal(String nmLocal) {
        this.nmLocal = nmLocal;
    }

    public String getNmPais() {
        return nmPais;
    }

    public void setNmPais(String nmPais) {
        this.nmPais = nmPais;
    }
}
