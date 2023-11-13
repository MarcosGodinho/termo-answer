import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ResolverTermo {

    public static void main(String[] args) throws IOException {

        // Criando arquivo com as palavras de 5 letras
        String todasPalavrasPT = "src/palavras-todas.txt";
        String todasPalavrasCincoLetras = "src/5-letras.txt";
        String PalavrasCincaLetrasAtualizada = "src/5-letras-novo.txt";

        ProcessamentoStrings.processarPalavrasDeCincoLetras(todasPalavrasPT, todasPalavrasCincoLetras);

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

        List<Character> alfabeto = ProcessamentoStrings.obterListaAlfabeto();

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
            String palavraIndicada = ProcessamentoStrings.escolherPalavraAleatoria(PalavrasCincaLetrasAtualizada);

            System.out.println("Digite a palavra " + palavraIndicada + "\n");
            String palavraDigitada = scanner.nextLine();

            for (int i = 0; i < palavraDigitada.length(); i++) {
                char caractere = palavraDigitada.charAt(i);

                if (caractere == '#') {
                    continue;
                }

                letrasCertas.add(caractere);

                if (Character.isUpperCase(caractere)) {
                    letrasNoLocalCerto.set(i, caractere);
                }

                List<String> palavrasFiltradas = ProcessamentoStrings.removerPalavrasComLetraEspecifica(todasPalavrasCincoLetras, caractere);
                ProcessamentoStrings.escreverPalavrasEmArquivo(palavrasFiltradas, PalavrasCincaLetrasAtualizada);
            }

            System.out.println("Local Certo: " + letrasNoLocalCerto);
            System.out.println("Todas letras certas: " + letrasCertas);

            List<Character> listaDeCaracteres = ProcessamentoStrings.separarStringEmLista(palavraDigitada.toUpperCase());

            // Removendo as letras da lista de alfabeto
            alfabeto.removeAll(listaDeCaracteres);

            System.out.println(alfabeto);

            if (palavraDigitada.equals("sair")) {
                break;
            }
        }
        // Fechando o Scanner
        scanner.close();
    }
}




 