public class Conteudo {
    private final String UrlImagem;
    private final String Titulo;

    public Conteudo(String Titulo, String UrlImagem){
        this.Titulo = Titulo;
        this.UrlImagem = UrlImagem;
    }

    public String getUrlImagem(){
        return UrlImagem;
    }

    public String getTitulo(){
        return Titulo;
    }
}
