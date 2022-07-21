import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;


public class GeradoraDeFigurinhas {
    public void cria(InputStream FluxoDeEntrada, String NomeArquivo) throws Exception{

        //leitura da imagem
        //InputStream FluxoDeEntrada = new URL("https://imersao-java-apis.s3.amazonaws.com/TopMovies_4.jpg").openStream();
        BufferedImage ImagemOriginal = ImageIO.read(FluxoDeEntrada);

        //Criar nova imagem em memória com tranparência e redimensionada    
        int largura = ImagemOriginal.getWidth();
        int altura = ImagemOriginal.getHeight();
        int novaAltura = (int) (altura + Math.round(altura*0.2));
        BufferedImage NovaImagem = new BufferedImage(largura,novaAltura, BufferedImage.TRANSLUCENT);

        //Copiar a imagem original para nova imagem(em memória)
        Graphics2D Graphics = (Graphics2D) NovaImagem.getGraphics();
        Graphics.drawImage(ImagemOriginal, 0, 0, null);

        //Setar a fonte
            Font Fonte = new Font(Font.SANS_SERIF, Font.BOLD,128);
            Graphics.setFont(Fonte);
            Graphics.setColor(Color.RED);

        //inserir um texto na nova imagem

        Graphics.drawString("TOPZERA", NovaImagem.getWidth()/2 , novaAltura-100);

        //escrever a nova imagem em um arquivo
        //DirSaida = DirSaida + NomeArquivo;
        ImageIO.write(NovaImagem, "png", new File("../saida/"+NomeArquivo));
    }
    //public static void main(String[] args) throws IOException{
      //  GeradoraDeFigurinhas Geradora = new GeradoraDeFigurinhas();
        //Geradora.cria();
//    }
}
