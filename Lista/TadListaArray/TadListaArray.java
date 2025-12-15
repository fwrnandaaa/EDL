
public class TadListaArray {

    private int size;
    private Object[] TadListaArray;

    public TadListaArray(int capacidadeInicial) {
        TadListaArray = new Object[capacidadeInicial];
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

    public void aumenta_capacidade() {
        if (size >= TadListaArray.length) {
            Object[] aux = new Object[size * 2];
            for (int i = 0; i < size; i++) {
                aux[i] = TadListaArray[i];
            }
            TadListaArray = aux;
        }
    }

    public Object first() {
        if (size == 0) {
            throw new TAdListaExcecao("Lista vazia.");
        } else {
            return TadListaArray[0];
        }
    }

    public Object last() {
        if (size == 0) {
            throw new TAdListaExcecao("Lista vazia.");
        } else {
            return TadListaArray[size - 1];
        }
    }

    public Object before(int p) {
        if (size == 0 || p >= size || p <= 0) {
            throw new TAdListaExcecao("índice não encontrado.");
        } else {
            return TadListaArray[p - 1];
        }
    }

    public Object after(int p) {
        if (size == 0 || p >= size - 1 || p < 0) {
            throw new TAdListaExcecao("índice não encontrado.");
        } else {
            return TadListaArray[p + 1];
        }
    }

    public boolean isFirst(Object n) {
        if (size == 0) {
            throw new TAdListaExcecao("Lista vazia.");
        }
        if (TadListaArray[0] == n) {
            return true;
        }
        return false;
    }

    public boolean isLast(Object n) {
        if (size == 0) {
            throw new TAdListaExcecao("Lista vazia.");
        }
        if (TadListaArray[size - 1] == n) {
            return true;
        }
        return false;
    }

    public void insertBefore(Object n, Object O) {
        if (size == 0) {
            throw new TAdListaExcecao("A lista está vazia.");
        }
        int indice = -1;
        aumenta_capacidade();
        for (int i = 0; i < size; i++) {
            if (TadListaArray[i].equals(n)) {
                indice = i;
                break;
            }
        }
        if (indice == -1) {
            throw new TAdListaExcecao("Elemento não encontrado.");
        }
        if (indice == 0) {
            insertFirst(O);
            return;
        }

        for (int i = size; i > indice; i--) {
            TadListaArray[i] = TadListaArray[i - 1];
        }
        TadListaArray[indice] = O;
        size++;
    }

    public void verLista() {
        for (int i = 0; i < size; i++) {
            System.out.println(TadListaArray[i] + " ");
        }

    }

    public void insertAfter(Object n, Object O) {
        if (size == 0) {
            throw new TAdListaExcecao("A lista está vazia.");
        }
        aumenta_capacidade();
        int indice = -1;
        for (int i = 0; i < size; i++) {
            if (TadListaArray[i].equals(n)) {
                indice = i;
                break;
            }
        }
        if (indice == -1) {
            throw new TAdListaExcecao("Objeto não encontrado.");
        }
        for (int i = size; i > indice + 1; i--) {
            TadListaArray[i] = TadListaArray[i - 1];
        }
        TadListaArray[indice+1] = O;
        size++;
    }

    public void insertFirst(Object O) {
        if (size == 0) {
            TadListaArray[0] = O;
            size++;
        } else {
            Object[] aux = new Object[size + 1];
            aux[0] = O;
            for (int i = 0; i < size; i++) {
                aux[i + 1] = TadListaArray[i];
            }

            TadListaArray = aux;
            size++;
        }
    }

    public void insertLast(Object O) {
        aumenta_capacidade();
        TadListaArray[size] = O;
        size++;

    }

    public void swapElements(Object n, Object O) {
        int indice1 = -1;
        int indice2 = -1;
        if (size == 0) {
            throw new TAdListaExcecao("A lista está vazia");
        }
        for (int i = 0; i < size; i++) {
            if (TadListaArray[i].equals(O) && indice1 == -1) {
                indice1 = i;

            }
            if (TadListaArray[i].equals(n) && indice2 == -1) {
                indice2 = i;
            }
        }
        if (indice1 == -1 || indice2 == -1) {
            throw new TAdListaExcecao("Um dos objetos informados não existe na lista.");
        } else {
            Object aux = TadListaArray[indice1];
            TadListaArray[indice1] = TadListaArray[indice2];
            TadListaArray[indice2] = aux;
        }
    }

    public void replaceElement(Object n, Object O) {
        if (size == 0) {
            throw new TAdListaExcecao("A lista está vazia");
        }
        int indice = -1;
        for (int i = 0; i < size; i++) {
            if (TadListaArray[i].equals(n)) {
                indice = i;
                break;
            }
        }
        if (indice == -1) {
            throw new TAdListaExcecao("O objeto informado não existe na lista.");
        }
        TadListaArray[indice] = O;
    }
    public void remove (Object n){
        if(size==0){
            throw new TAdListaExcecao("A lista está vazia.");
        }
        int indice = -1;
        for(int i = 0; i<size; i++){
            if (TadListaArray[i].equals(n)){
                indice = i;
                break;
            }
        }
        if(indice == -1){
            throw new TAdListaExcecao("Objeto não encontrado.");
        }
        for(int i=indice; i<size-1; i++){
            TadListaArray[i]=TadListaArray[i+1];

        }
        size--;
    }
}
