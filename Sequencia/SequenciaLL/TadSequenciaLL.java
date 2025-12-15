public class TadSequenciaLL {
  private Node head;
  private Node tail;
  int size;

  public static class Node {
    Object value;
    Node prev;
    Node next;

    Node(Object value) {
      this.value = value;
      this.prev = null;
      this.next = null;

    }
  }

  public TadSequenciaLL() {
    head = new Node(null);
    tail = new Node(null);
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

  public void insertFirst(Node O) {
    O.next = head.next;
    O.prev = head;
    head.next.prev = O;
    head.next = O;
    size++;

  }

  public void verSequenciaLL() {
    Node current = head.next;
    while (current != tail) {
      System.out.println(current.value);
      current = current.next;
    }
  }

  public Object first() {
    if (isEmpty()) {
      throw new SequenciaLLExcecao("Sequencia vazia.");
    }
    return head.next.value;
  }

  public Object last() {
    if (isEmpty()) {
      throw new SequenciaLLExcecao("Sequencia vazia.");
    }
    return tail.prev.value;

  }

  public Object before(Node O) {
    if (head.next == O) {
      throw new SequenciaLLExcecao("Nó informado é o primeiro da sequencia.");
    }
    return O.prev.value;
  }

  public Object after(Node O) {
    if (tail.prev == O) {
      throw new SequenciaLLExcecao("Nó informado é o último da sequencia.");
    }
    return O.next.value;
  }

  public Object elemAtRank(int r) {
    if (isEmpty()) {
      throw new SequenciaLLExcecao("A sequencia vazia.");
    }
    if (r <= (size / 2)) {
      Node current = head.next;
      for (int i = 0; i < r; i++) {
        current = current.next;
      }
      return current.value;
    } else {
      Node current = tail.prev;
      for (int i = size - 1; i > r; i--) {
        current = current.prev;
      }
      return current.value;

    }

  }

  public void replaceAtRank(int r, Node O) {
    if (r < 0 || r >= size) {
      throw new SequenciaLLExcecao("O rank não pode ser menor que 0 ou menor que o tamanho da sequencia.");
    }
    if (r == 0) {
      head.next.value = O.value;
      return;
    }
    if (r <= (size / 2)) {
      Node current = head.next;
      for (int i = 0; i < r; i++) {
        current = current.next;
      }
      current.value = O.value;
    } else {
      Node current = tail.prev;
      for (int i = size - 1; i > r; i++) {
        current = current.prev;
      }
      current.value = O.value;
    }
  }

  public void insertAtRank(int r, Node O) {
    if (r < 0 || r > size) {
      throw new SequenciaLLExcecao("O rank não pode ser menor que 0 ou maior que o tamanho da sequencia.");
    }
    Node current = head.next;
    if (r == 0) {
      O.next = head.next;
      O.prev = head;
      head.next.prev = O;
      head.next = O;
      size++;
      return;
    }
    if (r <= (size / 2)) {

      for (int i = 0; i < r; i++) {
        current = current.next;
      }
    } else {
      current = tail.prev;
      for (int i = size - 1; i > r - 1; i--) {
        current = current.prev;
      }
    }
    O.next = current;
    O.prev = current.prev;
    current.prev.next = O;
    current.prev = O;
    size++;
  }

  public Object removeAtRank(int r) {
    if (head.next == tail) {
      throw new SequenciaLLExcecao("A sequencia está vazia");
    }
    Node current = head.next;
    if (r == 0) {
      head.next = current.next;
      current.next.prev = head;
      size--;
      return current.value;
    }

    if (r <= (size / 2)) {
      for (int i = 0; i < r; i++) {
        current = current.next;
      }
    } else {
      current = tail.prev;
      for (int i = size - 1; i > r; i--) {
        current = current.prev;
      }
    }
    current.prev.next = current.next;
    current.next.prev = current.prev;
    size--;
    return current.value;
  }

  public Object atRank(int r) {
    if (head.next == tail) {
      throw new SequenciaLLExcecao("A sequencia está vazia.");
    }
    Node current = head.next;
    if (r == 0) {
      return current.value;
    }

    if (r <= (size / 2)) {
      for (int i = 0; i < r; i++) {
        current = current.next;
      }
    } else {
      current = tail.prev;
      for (int i = size - 1; i > r; i--) {
        current = current.prev;
      }
    }
    return current.value;
  }

  public int rankOf(Node O) {
    if (head.next == tail) {
      throw new SequenciaLLExcecao("A sequencia está vazia.");
    }
    Node current = head.next;
    for (int i = 0; i < size; i++) {
      if (current.value == O.value) {
        return i;
      }
      current = current.next;
    }
    throw new SequenciaLLExcecao("O nó informado não está na lista");
  }

  public void insertLast(Node O) {
    O.prev = tail.prev;
    O.next = tail;
    tail.prev.next = O;
    tail.prev = O;
    size++;

  }

  public void replaceElement(Node N, Node O) {
    if (head.next == tail) {
      throw new SequenciaLLExcecao("A sequencia está vazia.");
    }
    N.value = O.value;
  }

  public void swapElements(Node N, Node O) {
    Node current = new Node(N.value);
    N.value = O.value;
    O.value = current.value;
  }

  public void insertBefore(Node N, Node O) {
    O.prev = N.prev;
    O.next = N;
    N.prev.next = O;
    N.prev = O;
    size++;
  }

  public void insertAfter(Node N, Node O) {
    O.next = N.next;
    O.prev = N;
    N.next.prev = O;
    N.next = O;
    size++;

  }

  public Object remove(Node O) {
    O.prev.next = O.next;
    O.next.prev = O.prev;
    size--;
    return O.value;
  }
}
