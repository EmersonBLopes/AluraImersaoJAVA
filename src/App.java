import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {
        String Url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&count=10";

        ClienteHttp http = new ClienteHttp();
        String Json = http.buscaDados(Url);

        

        // exibir e manipular os dados 
        ExtratorDeConteudo Extrator = new ExtratorDeConteudoDaNasa();
        List<Conteudo> Conteudos = Extrator.extraiConteudos(Json);

        GeradoraDeFigurinhas Geradora = new GeradoraDeFigurinhas();

        // exibi atributo/valor de cada item da lista de filmes   
        for(int i = 0; i<=9; i++) {       

            Conteudo conteudo = Conteudos.get(i);

            InputStream FluxodeEntrada = new URL(conteudo.getUrlImagem()).openStream();
            String NomeArquivo = conteudo.getTitulo() + ".png";

            Geradora.cria(FluxodeEntrada,NomeArquivo);
            System.out.println(conteudo.getTitulo());
            System.out.println();
            }
        }
    }
