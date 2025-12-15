
public class VetorArray {

    private int size;
    private Object[] VetorArray;

    public VetorArray(int capacidadeInicial) {
        VetorArray = new Object[capacidadeInicial];
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

    public Object elemAtRank(int r) {
        if (r < 0 || r >= size()) {
            throw new VetorArrayExcecao("O rank é inválido");
        } else {
            return VetorArray[r];
        }
    }

    public void insertAtRank(int r, Object O) {
        if (r < 0 || r > size) {
            throw new VetorArrayExcecao("O rank é inválido");
        } else if (size == 0) {
            VetorArray[0] = O;
            size++;
        } else {
            for (int i = size; i > r; i--) {
                VetorArray[i] = VetorArray[i - 1];
            }
            VetorArray[r] = O;
            size++;
        }
    }

    public void verVetor() {
        for (int i = 0; i < size; i++) {
            System.out.println(VetorArray[i] + " ");
        }
    }

    public Object replaceAtRank(int r, Object O) {
        if (r < 0 || r > size) {
            throw new VetorArrayExcecao("Rank inválido");
        } else {
            Object antigo = VetorArray[r];
            VetorArray[r] = O;
            return antigo;
        }
    }

    public Object removeAtRank(int r) {
        if (r < 0 || r > size) {
            throw new VetorArrayExcecao("Rank inválido");
        } else {
            Object removido = VetorArray[r];
            for (int i = r; i < size - 1; i++) {
                VetorArray[i] = VetorArray[i + 1];
            }
            size--;
            return removido;
        }
    }
}
