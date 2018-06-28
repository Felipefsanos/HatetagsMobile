package hatetags.com.hatetags.Entitys;

public class Palavra {

    private String Palavra;
    private int Quantidade;

    public Palavra(String Palavra, int Quantidade) {
        this.Palavra = Palavra;
        this.Quantidade = Quantidade;
    }

    public String getPalavra() {
        return Palavra;
    }

    public void setPalavra(String Palavra) {
        this.Palavra = Palavra;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }
}
