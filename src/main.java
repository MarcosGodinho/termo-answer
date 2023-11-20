import java.io.IOException;
import java.util.List;
import java.util.Random;

public class main {
    public static void main(String[] args) throws IOException, InterruptedException {

        // Criando arquivo com as palavras de 5 letras
        String todasPalavrasCincoLetras = "src/5-letras.txt";
        List<String> possibleWords = ListaDePalavras.lerPalavrasDoArquivo(todasPalavrasCincoLetras);
        ListaDePalavras.colocarPalavrasDoArquivoEmLista(todasPalavrasCincoLetras);

        // Escolhe uma palavra aleatória da lista de palavras possíveis como a palavra correta
        Random random = new Random();
        String correctWord = possibleWords.get(random.nextInt(possibleWords.size()));

        System.out.println("##################################################");
        System.out.println();

        System.out.println("PALAVRA CORRETA: " + correctWord);

        System.out.println();
        System.out.println("##################################################");
        System.out.println();

        WordleGame game = new WordleGame(possibleWords, correctWord);
        game.playGame();
    }
}