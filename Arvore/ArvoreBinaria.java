
import java.util.ArrayList;
import java.util.Iterator;

public class ArvoreBinaria {

    Node root;
    int size;

    public ArvoreBinaria(Object O) {
        root = new Node(O, null, null, null);
        size = 1;
    }

    public Node root() {
        return root;
    }

    public static class Node {

        Object value;
        Node left;
        Node right;
        Node parent;

        public Node(Object O, Node left, Node right, Node parent) {

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
	public boolean isInternal(Node O){
		if((O.left != null) || (O.right != null)){
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
	public Node parent(Node O){
		if(isRoot(O)){
			throw new ArvoreBinexcecao("O nó informado é root.");
		}
		return O.parent;
	}
	public Iterator children(Node O){
		ArrayList<Node> iterator = new ArrayList<>();
		if(isExternal(O)){
			throw new ArvoreBinexcecao("O nó informado é nó folha.");
		}
		if(hasLeft(O)){
			iterator.add(leftChild(O));
		}
		if(hasRight(O)){
			iterator.add(rightChild(O));
		}
		return iterator.iterator();
	}
	/* falta height, elements, nos e replace */

}
