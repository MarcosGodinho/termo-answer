import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ResolverTermo {

    public static void main(String[] args) throws IOException {

        // Criando arquivo com as palavras de 5 letras
        String todasPalavrasCincoLetras = "src/5-letras.txt";

        List<String> listaDePalavras = ProcessamentoStrings.lerPalavrasDoArquivo(todasPalavrasCincoLetras);
        ProcessamentoStrings.colocarPalavrasDoArquivoEmLista(todasPalavrasCincoLetras);

        //Boas vindas e regras
        System.out.println("#########################################################\n");
        System.out.println("Bem vindx!\n");
        System.out.println("As regras são as seguintes: ");
        System.out.println("Eu vou te indicar qual palavra tentar no Termo");
        System.out.println("Você digita a palavra no jogo e me envia os erros e acertos:");
        System.out.println("Casos:\n");
        System.out.println("Letra correta e local correto: Letra maiúscula");
        System.out.println("Letra correta e local incorreto: Letra Minúscula");
        System.out.println("Letra incorreta: # \n");
        System.out.println("EXEMPLO:");
        System.out.println("Palavra: DOCES");
        System.out.println("Tentativa: '#o#e#");
        System.out.println("Palavra: BANGO");
        System.out.println("Tentativa: ##NgO");
        System.out.println("Palavra: GENRO\n");
        System.out.println("#########################################################\n");

        // Criar um ArrayList com 5 posições, todas inicializadas com null
        List<Character> letrasNoLocalCerto = new ArrayList<>();

        // Adicionar null cinco vezes à lista
        for (int i = 0; i < 5; i++) {
            letrasNoLocalCerto.add(null);
        }

        List<Character> letrasCertas = new ArrayList<>();

        // Criando um Scanner para obter a entrada do usuário
        Scanner scanner = new Scanner(System.in);

        while (true) {

            // Solicitando ao usuário para digitar a palavra
            System.out.println("Digite a palavra ou digite 'sair' para sair\n");

            // Indicando a palavra para o usuário
            String palavraIndicada = ProcessamentoStrings.escolherPalavraAleatoria(listaDePalavras);
            System.out.println("Digite a palavra " + palavraIndicada + "\n");
            String palavraDigitada = scanner.nextLine();


            for (int i = 0; i < palavraDigitada.length(); i++) {
                char caractereDigitado = palavraDigitada.charAt(i);
                char caractereIndicado = palavraIndicada.charAt(i);


                if (caractereDigitado == '#') {
                    continue;
                }

                letrasCertas.add(caractereDigitado);

                if (Character.isUpperCase(caractereDigitado)) {
                    letrasNoLocalCerto.set(i, caractereDigitado);
                }

                if (!String.valueOf(caractereDigitado).equalsIgnoreCase(String.valueOf(caractereIndicado))) {
                    listaDePalavras = ProcessamentoStrings.removerPalavrasComLetra(listaDePalavras, caractereIndicado);
                }
            }

            // Exibir as palavras lidas do arquivo
            System.out.println("Palavras do arquivo:");
            for (String palavra : listaDePalavras) {
                System.out.println(palavra);
            }

            System.out.println("Local Certo: " + letrasNoLocalCerto);
            System.out.println("Todas letras certas: " + letrasCertas);

            if (palavraDigitada.equals("sair")) {
                break;
            }
        }
        // Fechando o Scanner
        scanner.close();
    }
}