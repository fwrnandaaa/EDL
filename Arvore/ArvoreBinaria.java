
import java.util.ArrayList;
import java.util.Iterator;

public class ArvoreBinaria {

    Node root;
    int size;

    public ArvoreBinaria(int O) {
        root = new Node(O, null, null, null);
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

        public Node(int O, Node left, Node right, Node parent) {

            this.value = O;
            this.left = left;
            this.right = right;
            this.parent = parent;
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

    public Node leftChild(Node O) {
        if (O.left == null) {
            throw new ArvoreBinexcecao("O nó informado não possui filho esquerdo.");
        }
        return O.left;
    }

    public Node rightChild(Node O) {
        if (O.right == null) {
            throw new ArvoreBinexcecao("O nó informado não possui filho direito.");
        }
        return O.right;
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

    public Node parent(Node O) {
        if (isRoot(O)) {
            throw new ArvoreBinexcecao("O nó informado é root.");
        }
        return O.parent;
    }

    public Iterator children(Node O) {
        ArrayList<Node> iterator = new ArrayList<>();
        if (isExternal(O)) {
            throw new ArvoreBinexcecao("O nó informado é nó folha.");
        }
        if (hasLeft(O)) {
            iterator.add(leftChild(O));
        }
        if (hasRight(O)) {
            iterator.add(rightChild(O));
        }
        return iterator.iterator();
    }

    /* falta, elements, nos e replace */
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

    public int comparar(Node O, Node V){
        if(O.value > V.value){
            return 1;
        }
         if(O.value < V.value){
            return -1;
        }
        return 0;
    }
    public Node busca(Node O, int chave){
        if (chave == O.value){
            return O;
        }
        if((O.value > chave)&&(hasLeft(O))){
            return busca(leftChild(O), chave);
        }
        if((O.value < chave)&&(hasRight(O))){
            return busca(rightChild(O), chave);
        }
      return O;
    }
    public void insert(Node O) {
        if(root == null){
            root = O;
            size ++;
        }
        else{
            if(O.value < root.value){

            }
        }
    }
}
