
import java.util.ArrayList;
import java.util.List;
    /* falta elements, nos e replace */
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
       
        auxiliar(O.left, matriz, aux * 2);
        matriz[aux] = O.value;
        auxiliar(O.right, matriz, aux * 2 + 1);
    }

    public void verArvore() {
        int alturaArvore = height(root);
        Integer[] matriz = new Integer[(int) Math.pow(2, alturaArvore+1)];
        auxiliar(root, matriz, 1);
        for (int i = 1; i < matriz.length; i++) {
            if (matriz[i] == null) {
                System.out.print("\t");
            } else {
                System.out.println(matriz[i]  + "\t");
            }
          
        }

    }

}
