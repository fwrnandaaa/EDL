
import java.util.ArrayList;
import java.util.List;

public class ArvoreBinaria {

    Node root;
    int size;

    public ArvoreBinaria() {
        root = null;
        size = 1;
    }

    public Node root() {
        return root;
    }

    public static class Node {

        int value;
        Node left;
        Node right;
        Node parent;

        public Node(int O) {

            this.value = O;
            this.left = null;
            this.right = null;
            this.parent = null;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public boolean isRoot(Node O) {
        if (O.parent == null) {
            return true;
        }
        return false;
    }

    public boolean isExternal(Node O) {
        if ((O.left == null) && (O.right == null)) {
            return true;
        }
        return false;
    }

    public boolean isInternal(Node O) {
        if ((O.left != null) || (O.right != null)) {
            return true;
        }
        return false;
    }

    public Integer leftChild(Node O) {
        if (O.left == null) {
            throw new ArvoreBinexcecao("O nó informado não possui filho esquerdo.");
        }
        return O.left.value;
    }

    public Integer rightChild(Node O) {
        if (O.right == null) {
            throw new ArvoreBinexcecao("O nó informado não possui filho direito.");
        }
        return O.right.value;
    }

    public int depth(Node O) {
        if (isRoot(O)) {
            return 0;
        }
        return 1 + depth(O.parent);
    }

    public boolean hasLeft(Node O) {
        if (O.left == null) {
            return false;
        }
        return true;
    }

    public boolean hasRight(Node O) {
        if (O.right == null) {
            return false;
        }
        return true;
    }

    public Integer parent(Node O) {
        if (isRoot(O)) {
            throw new ArvoreBinexcecao("O nó informado é root.");
        }
        return O.parent.value;
    }

    public List children(Node O) {
        List<Integer> lista = new ArrayList<>();
        if (isExternal(O)) {
            throw new ArvoreBinexcecao("O nó informado é nó folha.");
        }
        if (hasLeft(O)) {
            lista.add(O.left.value);
        }
        if (hasRight(O)) {
            lista.add(O.right.value);
        }
        return lista;
    }

    public int height(Node O) {
        int h = 0;
        if (isExternal(O)) {
            return 0;
        } else {
            if (O.left != null) {
                h = Math.max(h, height(O.left));
            }
            if (O.right != null) {
                h = Math.max(h, height(O.right));
            }
        }
        return 1 + h;
    }

    public Node busca(Node O, int chave) { //
        if (isExternal(O)) {
            return O;
        }
        if (chave < O.value) {
            if (hasLeft(O)) {
                return busca(O.left, chave); // tem filho esquerdo
            } else {
                return O;
            }
        } else if (chave == O.value) {
            return O; // achou o nó
        } else if (chave > O.value) {
            if (hasRight(O)) {
                return busca(O.right, chave);
            }
            return O;
        }
        return O;
    }

    public void insert(Node O) {
        if (root == null) {
            root = O;
            size++;
            return;
        }

        Node aux = busca(root, O.value);
        if (aux.value == O.value) {
            throw new ArvoreBinexcecao("A chave informada já existe na árvore.");
        }
        O.parent = aux;
        if (aux.value > O.value) {
            aux.left = O;
            size++;
        } else {
            aux.right = O;
            size++;
        }
    }

    private void auxiliar(Node O, Integer[] matriz, int aux) {
        if (O == null || aux >= matriz.length) {
            return;
        }
        matriz[aux] = O.value;
        auxiliar(O.left, matriz, aux * 2);
        auxiliar(O.right, matriz, aux * 2 + 1);
    }
// TODO: Resolver impressão da arvore

    public void verArvore() {
        int contador_linha = 0;
        int alturaArvore = height(root);
        int tamanho = (int) Math.pow(2, alturaArvore + 1);
        Integer[] matriz = new Integer[tamanho];
        auxiliar(root, matriz, 1);
        for (int i = 1; i < matriz.length; i++) {
            if (matriz[i] == null) {
                System.out.print("\t");
            } else {
                System.out.print(matriz[i] + "\t");
            }
            if (i == (1 << (contador_linha + 1)) - 1) {
                System.out.println();
                contador_linha++;
            }

        }
    }

    public void replace(Node O, int n) {
        O.value = n;
    }

    public void remove(Node O) {
        if (isRoot(O)) {
            throw new ArvoreBinexcecao("O nó root não pode ser removido");
        }
        if (isExternal(O)) {

            if (O.value > O.parent.value) {
                O.parent.right = null;
            } else {
                O.parent.left = null;
            }
            size--;
            return;
        }
        if (hasLeft(O) && !hasRight(O)) {
            if (O == O.parent.left) {
                O.parent.left = O.left;
            } else {
                O.parent.right = O.left;
            }
            O.left.parent = O.parent;
            size--;
            return;
        }
        if (hasRight(O) && !hasLeft(O)) {
            if (O == O.parent.left) {
                O.parent.left = O.right;
            } else {
                O.parent.right = O.parent;
            }
            O.right.parent = O.right;
            size--;
            return;
        }
        Node current = O.right;
        while (hasLeft(current)) {
            current = current.left;
        }
        O.value = current.value;
        if (current == current.parent.left) {
            current.parent.left = current.right;
        } else {
            current.parent.right = current.right;
        }
        if (hasRight(current)) {
            current.right.parent = current.parent;
        }
        size--;
    }
    public void elements(){
        
    }
}
