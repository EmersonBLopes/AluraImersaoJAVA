import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;
import java.io.InputStream;
import java.net.URL;

public class App {

    public static void main(String[] args) throws Exception {
        // fazer uma conexão HTTP e buscar os top 250 filmes
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";//end point
        URI endereco = URI.create(url); //criação da uri
        HttpClient client = HttpClient.newHttpClient();//Criação do cliente http 
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();//Criarção  da requisição HTTP
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());// envia a requisição e a armazena dentro do body do response
        String body = response.body(); //Armazena a resposta dentro da string body

        // extrair só os dados que interessam (titulo, poster, classificação)
        JsonParser parser = new JsonParser();//Instância o objeto parse na classe JsonParser
        List<Map<String, String>> listaDeFilmes = parser.parse(body);//passa a string body para ser parseado através do método parse

        // exibir e manipular os dados 
        GeradoraDeFigurinhas Geradora = new GeradoraDeFigurinhas();
        for (Map<String,String> filme : listaDeFilmes) { // exibi atributo/valor de cada item da lista de filmes 
            
            String UrlImagem = filme.get("image");
            String Titulo = filme.get("title");

            InputStream FluxodeEntrada = new URL(UrlImagem).openStream();
            String NomeArquivo = Titulo.replace(":", "-")+".png";
            Geradora.cria(FluxodeEntrada,NomeArquivo);

            System.out.println(Titulo);
            System.out.println();
            }
        }
    }
