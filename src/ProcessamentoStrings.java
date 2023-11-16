import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProcessamentoStrings {

    public static String escolherPalavraAleatoria(List<String> palavras) {
        Random random = new Random();
        int indiceAleatorio = random.nextInt(palavras.size());
        return palavras.get(indiceAleatorio);
    }

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

    public static List<String> removerPalavrasComLetra(List<String> palavras, char letra) {
        List<String> palavrasFiltradas = new ArrayList<>();

        for (String palavra : palavras) {
            // Verificar se a palavra contém a letra especificada
            if (!palavra.toLowerCase().contains(String.valueOf(letra).toLowerCase())) {
                palavrasFiltradas.add(palavra);
            }
        }
        return palavrasFiltradas;
    }
}
