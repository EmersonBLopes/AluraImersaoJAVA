import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) throws Exception {
        float stars;
        // fazer uma conexão HTTP e buscar os top 250 filmes
        String url = "https://alura-filmes.herokuapp.com/conteudos";//end point
        URI endereco = URI.create(url); //criação da uri
        HttpClient client = HttpClient.newHttpClient();//Criação do cliente http 
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();//Criarção  da requisição HTTP
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());// envia a requisição e a armazena dentro do body do response
        String body = response.body(); //Armazena a resposta dentro da string body

        // extrair só os dados que interessam (titulo, poster, classificação)
        JsonParser parser = new JsonParser();//Instância o objeto parse na classe JsonParser
        List<Map<String, String>> listaDeFilmes = parser.parse(body);//passa a string body para ser parseado através do método parse

        // exibir e manipular os dados 
        for (Map<String,String> filme : listaDeFilmes) { // exibi atributo/valor de cada item da lista de filmes 
            System.out.println("\u001b[1m\u001b[41m"+filme.get("title")+"\u001b[m");
            System.out.println("Link do poster: "+"\u001b[34m"+filme.get("image")+"\u001b[m");
            System.out.println("Classificação: "+filme.get("imDbRating"));
            stars = Float.parseFloat(filme.get("imDbRating"));
            for(int I=1; I<=Math.round(stars); I++){//cria um emoji de estrela para cada volta do loop completa
                System.out.print('\u2B50');
                if(I==Math.round(stars)){//caso I seja igual a stars retorna uma quebra de linha
                    System.out.println();
                }
            }
        }
    }
}