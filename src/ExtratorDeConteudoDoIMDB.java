import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDoIMDB implements ExtratorDeConteudo {
    public List<Conteudo> extraiConteudos(String Json){

        // extrair só os dados que interessam (titulo, poster, classificação)
        JsonParser parser = new JsonParser();//Instância o objeto parse na classe JsonParser
        List<Map<String, String>> ListaDeAtributos = parser.parse(Json);//passa a string body para ser parseado através do método parse
        List<Conteudo> Conteudos = new ArrayList<>();

        //Popular a lista
        for(Map<String,String> atributos : ListaDeAtributos){
            String Titulo = atributos.get("title").replace(":", "-")  + ".png";
            String UrlImagem = atributos.get("image");
            Conteudo conteudo = new Conteudo(Titulo,UrlImagem);
            Conteudos.add(conteudo);
        }
        return Conteudos;
    }
}
