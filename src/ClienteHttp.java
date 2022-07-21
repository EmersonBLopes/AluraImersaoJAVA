import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ClienteHttp {
    public String buscaDados(String Url){
        try {
            URI endereco = URI.create(Url); //criação da uri
            HttpClient client = HttpClient.newHttpClient();//Criação do cliente http 
            HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();//Criarção  da requisição HTTP
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());// envia a requisição e a armazena dentro do body do response
            String body = response.body(); //Armazena a resposta dentro da string body
            return body;
        }catch(IOException | InterruptedException ex){
            throw new RuntimeException(ex);
        }
        
    }
}
