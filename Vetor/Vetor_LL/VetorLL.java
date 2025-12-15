
public class VetorLL {

    private Node head;
    private Node tail;
    private int size;

    public static class Node {

        Node next;
        Node prev;
        Object value;

        Node(Object value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    public VetorLL() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void insertAtRank(int r, Object O) {
        if (r > this.size) {
            throw new VetorLLExcecao("Rank inválido");
        }
        Node novoNo = new Node(O);
        if (isEmpty()) {
            head = novoNo;
            tail = novoNo;

        } else if (r == size) {
            novoNo.prev = tail;
            tail.next = novoNo;
            tail = novoNo;
        } else {
            Node current = head;
            for (int i = 0; i < r - 1; i++) {
                current = current.next;
            }
            current.prev.next = novoNo;
            novoNo.prev = current.prev;
            novoNo.next = current;
            current.prev = novoNo;

        }
        size++;

    }

    public void verVetorLL() {
        Node current = head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public Object elemAtRank(int r) {
        if (r > size) {
            throw new VetorLLExcecao("Rank inválido");
        }
        Node current = head;
        for (int i = 0; i <= r - 1; i++) {
            current = current.next;
        }
        return current.value;
    }

    public Object removeAtRank(int r) {
        Node current = head;
        if (r >= size) {
            throw new VetorLLExcecao("Rank inválido");
        }

        if (r == 0) {
            head = head.next;
            return current.value;
        } else {
            for (int i = 0; i <= r - 1; i++) {
                current = current.next;
            }
            current.prev.next = current.next;
            size--;
            return current.value;
        }
    }

    public Object replaceAtRank(int r, Object O) {
        if (r >= size) {
            throw new VetorLLExcecao("Rank inválido");
        } else {
            Node current = head;
            for (int i = 0; i < r; i++) {
                current = current.next;
            }
            Object antigo = current.value;
            current.value = O;
            return antigo;
        }
    }

}
