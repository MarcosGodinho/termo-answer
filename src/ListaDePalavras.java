import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ListaDePalavras {

    static List<String> lerPalavrasDoArquivo(String arquivo) throws IOException {
        List<String> palavras = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                palavras.add(linha);
            }
        }
        return palavras;
    }

    public static List<String> colocarPalavrasDoArquivoEmLista(String caminhoArquivo) {
        List<String> palavras = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                // Dividir a linha em palavras usando espaços como delimitador
                String[] palavrasDaLinha = linha.split(" ");

                // Adicionar cada palavra à lista
                for (String palavra : palavrasDaLinha) {
                    // Remover espaços em branco extras e adicionar à lista se não estiver vazio
                    palavra = palavra.trim();
                    if (!palavra.isEmpty()) {
                        palavras.add(palavra);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return palavras;
    }

}
