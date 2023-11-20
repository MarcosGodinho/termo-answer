import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    private static boolean verificarCorrespondencia(String palavra, List<Character> letrasCertas) {
        if (palavra.length() != letrasCertas.size()) {
            return false;
        }

        for (int i = 0; i < palavra.length(); i++) {
            char letraPalavra = palavra.charAt(i);
            Character letraCertas = letrasCertas.get(i);

            if (letraCertas != null && letraCertas != letraPalavra) {
                return false;
            }
        }

        return true;
    }
}
