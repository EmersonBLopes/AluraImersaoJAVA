import java.io.InputStream;
import java.net.URL;
import java.util.Map;

public class App {

    public static void main(String[] args) throws Exception {
        String Url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&count=10";

        ClienteHttp http = new ClienteHttp();
        String Json = http.buscaDados(Url);

        // extrair só os dados que interessam (titulo, poster, classificação)
        JsonParser parser = new JsonParser();//Instância o objeto parse na classe JsonParser
        <List<Map<String, String>> listaDeConteudos = parser.parse(Json);//passa a string body para ser parseado através do método parse

        // exibir e manipular os dados 
        GeradoraDeFigurinhas Geradora = new GeradoraDeFigurinhas();

        for (int i = 0; i<=19; i++) { // exibi atributo/valor de cada item da lista de filmes         

            Map<String,String> conteudo = listaDeConteudos;

            InputStream FluxodeEntrada = new URL(conteudo.UrlImagem).openStream();
            String NomeArquivo = Titulo + ".png";

            Geradora.cria(FluxodeEntrada,NomeArquivo);
            System.out.println(Titulo);
            System.out.println();
            }
        }
    }
