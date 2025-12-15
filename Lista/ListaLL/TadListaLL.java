
public class TadListaLL {

    private Node head;
    private Node tail;
    int size;

    public static class Node {

        Object value;
        Node next;
        Node prev;

        Node(Object value) {
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    public TadListaLL() {
        this.head = new Node(null);
        this.tail = new Node(null);
        head.next = tail;
        tail.prev = head;
        size = 0;
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

    public boolean isFirst(Node O) {
        if (size == 0) {
            throw new TadListaLLExcecao("A lista está vazia.");
        }
        if (head.next.value.equals(O.value)) {
            return true;
        }
        return false;
    }

    public boolean isLast(Node O) {
        if (size == 0) {
            throw new TadListaLLExcecao("A lista está vazia.");
        }
        if (tail.prev.value.equals(O.value)) {
            return true;
        }
        return false;

    }

    public void insertFirst(Node O) {
        if (size == 1) {
            head.next = O;
            O.prev = head;
        } else {
            O.next = head.next;
            O.prev = head;
            head.next.prev = O;
            head.next = O;
        }
        size++;
    }

    public void verListaLL() {
        Node current = head.next;
        for (int i = 0; i < size; i++) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public Object first() {
        if (size == 0) {
            throw new TadListaLLExcecao("A lista está vazia.");
        }
        return head.next.value;
    }

    public Object last() {
        if (size == 0) {
            throw new TadListaLLExcecao("A lista está vazia.");
        }
        return tail.prev.value;
    }

    public void insertBeforeLL(Node N, Node O) {
        if (size == 0) {
            throw new TadListaLLExcecao("A lista está vazia");
        }
        O.prev = N.prev;
        O.next = N;
        N.prev.next = O;
        N.prev = O;
        size++;
    }

    public void insertAfterLL(Node N, Node O) {
        if (size == 0) {
            throw new TadListaLLExcecao("A lista está vazia");
        }
        O.prev = N;
        O.next = N.next;
        N.next.prev = O;
        N.next = O;
        size++;
    }

    public void swapElements(Node N, Node O) {
        if (size == 0) {
            throw new TadListaLLExcecao("A lista está vazia");
        }
        Node novo = new Node(N.value);
        N.value = O.value;
        O.value = novo.value;
    }

    public void replaceElement(Node N, Node O) {
        if (size == 0) {
            throw new TadListaLLExcecao("A lista está vazia");
        }
        N.value = O.value;
    }

    public void remove(Node O) {
        if (size == 0) {
            throw new TadListaLLExcecao("A lista está vazia");
        }
        O.next.prev = O.prev;
        O.prev.next = O.next;
        size--;
    }

    public Object before(Node O) {
        if (isFirst(O)) {
            throw new TadListaLLExcecao("Esse nó não possui nós anteriores a ele.");
        }
        return O.prev.value;
    }

    public Object after(Node O) {
        if (isLast(O)) {
            throw new TadListaLLExcecao("Esse nó não possui nós posteriores a ele.");
        }
        return O.next.value;
    }

    public void insertLast(Node O) {
        O.prev = tail.prev;
        tail.prev.next = O;
        O.next = tail;
        size++;
    }
}
