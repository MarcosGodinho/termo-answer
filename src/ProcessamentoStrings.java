import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProcessamentoStrings {
    public static List<Character> separarStringEmLista(String inputString) {
        List<Character> listaDeCaracteres = new ArrayList<>();

        for (int i = 0; i < inputString.length(); i++) {
            char caractere = inputString.charAt(i);

            // Substituindo "#" por null
            if (caractere == '#') {
                listaDeCaracteres.add(null);
            } else {
                listaDeCaracteres.add(caractere);
            }
        }
        return listaDeCaracteres;
    }
    public static List<Character> obterListaAlfabeto() {
        List<Character> alfabeto = new ArrayList<>();

        // Adicionando as letras do alfabeto à lista
        for (char letra = 'A'; letra <= 'Z'; letra++) {
            alfabeto.add(letra);
        }
        return alfabeto;
    }

    public static void processarPalavrasDeCincoLetras(String inputFile, String outputFile) throws IOException {
        List<String> palavrasDeCincoLetras = extrairPalavrasDeCincoLetras(inputFile);
        escreverPalavrasEmArquivo(palavrasDeCincoLetras, outputFile);
    }

    private static List<String> extrairPalavrasDeCincoLetras(String arquivo) throws IOException {
        List<String> palavrasDeCincoLetras = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] palavras = linha.split("\\s+"); // Divide a linha em palavras
                for (String palavra : palavras) {
                    // Verifica se a palavra tem exatamente 5 letras
                    if (palavra.length() == 5) {
                        palavrasDeCincoLetras.add(palavra);
                    }
                }
            }
        }
        return palavrasDeCincoLetras;
    }

    public static List<String> removerPalavrasComLetraEspecifica(String arquivo, char letra) throws IOException {
        List<String> palavrasFiltradas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] palavras = linha.split("\\s+"); // Divide a linha em palavras
                for (String palavra : palavras) {
                    // Verifica se a palavra contém a letra especificada
                    if (!palavra.toLowerCase().contains(String.valueOf(letra).toLowerCase())) {
                        palavrasFiltradas.add(palavra);
                    }
                }
            }
        }

        return palavrasFiltradas;
    }

    public static void escreverPalavrasEmArquivo(List<String> palavras, String arquivo) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
            for (String palavra : palavras) {
                bw.write(palavra);
                bw.write("\n"); // Adiciona um espaço entre as palavras
            }
        }
    }

    public static void removerLetras(List<Character> lista, List<Character> letrasParaRemover) {
        lista.removeAll(letrasParaRemover);
    }

    public static String escolherPalavraAleatoria(String arquivo) throws IOException {
        List<String> palavras = lerPalavrasDoArquivo(arquivo);

        // Escolher uma palavra aleatória usando a classe Random
        Random random = new Random();
        int indiceAleatorio = random.nextInt(palavras.size());

        return palavras.get(indiceAleatorio);
    }

    private static List<String> lerPalavrasDoArquivo(String arquivo) throws IOException {
        List<String> palavras = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                palavras.add(linha);
            }
        }
        return palavras;
    }
}
