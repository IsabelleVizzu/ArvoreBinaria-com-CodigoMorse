import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        ArvoreBinaria arvore = new ArvoreBinaria();
        Node base = arvore.getBase();

        char[] a = {'.', '-'};
        char[] b = {'-', '.', '.', '.'};
        char[] c = {'-', '.', '-', '.'};
        char[] d = {'-', '.', '.'};
        char[] e = {'.'};
        char[] f = {'.', '.', '-', '.'};
        char[] g = {'-', '-', '.'};
        char[] h = {'.', '.', '.', '.'};
        char[] i = {'.', '.'};
        char[] j = {'.', '-', '-', '-'};
        char[] k = {'-', '.', '-'};
        char[] l = {'.', '-', '.', '.'};
        char[] m = {'-', '-'};
        char[] n = {'-', '.'};
        char[] o = {'-', '-', '-'};
        char[] p = {'.', '-', '-', '.'};
        char[] q = {'-', '-', '.', '-'};
        char[] r = {'.', '-', '.'};
        char[] s = {'.', '.', '.'};
        char[] t = {'-'};
        char[] u = {'.', '.', '-'};
        char[] v = {'.', '.', '.', '-'};
        char[] w = {'.', '-', '-'};
        char[] x = {'-', '.', '.', '-'};
        char[] y = {'-', '.', '-', '-'};
        char[] z = {'-', '-', '.', '.'};


        arvore.adicionarNode(base, 'A', a, 0);
        arvore.adicionarNode(base, 'B', b, 0);
        arvore.adicionarNode(base, 'C', c, 0);
        arvore.adicionarNode(base, 'D', d, 0);
        arvore.adicionarNode(base, 'E', e, 0);
        arvore.adicionarNode(base, 'F', f, 0);
        arvore.adicionarNode(base, 'G', g, 0);
        arvore.adicionarNode(base, 'H', h, 0);
        arvore.adicionarNode(base, 'I', i, 0);
        arvore.adicionarNode(base, 'J', j, 0);
        arvore.adicionarNode(base, 'K', k, 0);
        arvore.adicionarNode(base, 'L', l, 0);
        arvore.adicionarNode(base, 'M', m, 0);
        arvore.adicionarNode(base, 'N', n, 0);
        arvore.adicionarNode(base, 'O', o, 0);
        arvore.adicionarNode(base, 'P', p, 0);
        arvore.adicionarNode(base, 'Q', q, 0);
        arvore.adicionarNode(base, 'R', r, 0);
        arvore.adicionarNode(base, 'S', s, 0);
        arvore.adicionarNode(base, 'T', t, 0);
        arvore.adicionarNode(base, 'U', u, 0);
        arvore.adicionarNode(base, 'V', v, 0);
        arvore.adicionarNode(base, 'W', w, 0);
        arvore.adicionarNode(base, 'X', x, 0);
        arvore.adicionarNode(base, 'Y', y, 0);
        arvore.adicionarNode(base, 'Z', z, 0);

        System.out.println("  Árvore Binária Não Blanceada:");
        arvore.printArvore(base);


        String[] codigosMorse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
                ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
                "-.--", "--.."};

        String[] letras = escolherPalavra(codigosMorse);

        String palavraTraduzida = "";

        for (String letra : letras) {
            char[] letraSeparada = new char[letra.length()];
            for (int ii = 0; ii < letraSeparada.length; ii++) {
                letraSeparada[ii] = letra.charAt(ii);
            }
            palavraTraduzida += arvore.searchtNode(letraSeparada);
        }

        System.out.println("A código morse traduzido ficou: " + palavraTraduzida);

    }


    public static String[] escolherPalavra (String[] codigosMorse) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Digite uma palavra em morse (separe as letras por espaços): ");
            String codigo = scanner.nextLine();
            String[] letras = codigo.split(" ");
            if (!validarLetras(letras, codigosMorse)) {
                System.out.println("O código: " + codigo + " tem alguma 'letra' incoerente do alfabeto morse!\n" +
                        "Tente novamente!");
                continue;
            }
            return letras;
        }
    }

    public static boolean validarLetras(String[] letras, String[] codigosMorse) {
        List<String> listaCodigosMorse = Arrays.asList(codigosMorse);

        for (String letra : letras) {
            if (!listaCodigosMorse.contains(letra)) {
                return false;
            }
        }
        return true;
    }

}