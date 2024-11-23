import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArvoreBinaria {
    private Node base;

    public ArvoreBinaria() {
        base = adicionarNode(null, ' ', new char[0], 0);
    }

    public Node getBase () {
        return base;
    }

    public char searchtNode(char[] caracter) {
        Node no = base;
        for (int i = 0; i < caracter.length; i++) {
            if (caracter[i] == '.') {
                no = no.getEsquerda();
                continue;
            }
            no = no.getDireita();
        }
        return no.getLetra();
    }


    public Node adicionarNode(Node no, char letra, char[] caracter, int posicao) {
        if (no == null) {
            no = new Node(null, null, letra);
            return no;
        }

        if (posicao == caracter.length) {
            no.setLetra(letra);
            return no;
        }

        if (caracter[posicao] == '.') {
            if (no.getEsquerda() == null) {
                no.setEsquerda(new Node(null, null, ' '));
            }
            no.setEsquerda(adicionarNode(no.getEsquerda(), letra, caracter, ++posicao));
        }
        else if (caracter[posicao] == '-') {
            if (no.getDireita() == null) {
                no.setDireita(new Node(null, null, ' '));
            }
            no.setDireita(adicionarNode(no.getDireita(), letra, caracter, ++posicao));
        }

        return no;
    }


    public void printArvore(Node raiz) {
        int maxLevel = maxLevel(raiz);
        printArvoreInternal(Collections.singletonList(raiz), 1, maxLevel);
    }

    private void printArvoreInternal(List<Node> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int edgeLines = (int) Math.pow(2, Math.max(floor - 1, 0));
        int firstSpaces = (int) Math.pow(2, floor) - 1;
        int betweenSpaces = (int) Math.pow(2, floor + 1) - 1;

        printWhitespaces(firstSpaces);

        List<Node> newNodes = new ArrayList<Node>();
        for (Node node : nodes) {
            if (node != null) {
                System.out.print(node.getLetra());
                newNodes.add(node.getEsquerda());
                newNodes.add(node.getDireita());
            } else {
                System.out.print(" ");
                newNodes.add(null);
                newNodes.add(null);
            }

            printWhitespaces(betweenSpaces);
        }
        System.out.println();

        for (int i = 1; i <= edgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printWhitespaces(edgeLines + edgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).getEsquerda() != null)
                    System.out.print("/");
                else
                    printWhitespaces(1);

                printWhitespaces(i + i - 1);

                if (nodes.get(j).getDireita() != null)
                    System.out.print("\\");
                else
                    printWhitespaces(1);

                printWhitespaces(edgeLines + edgeLines - i);
            }

            System.out.println();
        }

        printArvoreInternal(newNodes, level + 1, maxLevel);
    }

    private void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private int maxLevel(Node node) {
        if (node == null)
            return 0;
        return Math.max(maxLevel(node.getEsquerda()), maxLevel(node.getDireita())) + 1;
    }

    private boolean isAllElementsNull(List<Node> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }
        return true;
    }

}

class Node {
    Node direita;
    Node esquerda;
    char letra;

    public Node (Node direita, Node esquerda, char letra) {
        this.direita = direita;
        this.esquerda = esquerda;
        this.letra = letra;
    }

    public void setEsquerda (Node esquerda) {
        this.esquerda = esquerda;
    }

    public void setDireita (Node direita) {
        this.direita = direita;
    }

    public Node getDireita () {
        return direita;
    }

    public Node getEsquerda () {
        return esquerda;
    }

    public void setLetra (char letra) {
        this.letra = letra;
    }

    public char getLetra () {
        return letra;
    }
}
