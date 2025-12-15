public class TadSequenciaArray{
    private int size;
    private Object[] tad_sequencia;
    private int capacidade;

    public TadSequenciaArray(int capacidade){
        tad_sequencia = new Object[capacidade];
        size = 0;
        this.capacidade=capacidade;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        if(size==0){
            return true;
        }
        return false;
    }
    public void aumenta_capacidade(){
        if(size >= capacidade){
            capacidade = capacidade*2;
            Object[] aux = new Object[capacidade];
            for(int i =0; i<size; i++){
                aux[i] = tad_sequencia[i];
            }
            tad_sequencia = aux;
        }
    }
    public Object elemAtRank(int r){
        if(isEmpty()){
            throw new TadSequenciaExcecao("O array está vazio.");
        }
        if(r >=size){
            throw new TadSequenciaExcecao("O rank informado é maior que o tamanho do array.");
        }
        return tad_sequencia[r-1];
    }
    public void verSequencia(){
        for(int i=0;i<size;i++){
            System.out.println(tad_sequencia[i]+"");
        }
    }
    public void insertFirst(Object O){
        if(size==0){
            tad_sequencia[0]=O;
        }
        else{
            aumenta_capacidade();
            for(int i =size; i>0;i--){
                tad_sequencia[i] = tad_sequencia[i-1];
            }
        }
        tad_sequencia[0]=O;
        size++;
    }
    public void replaceAtRank(int i, Object O){
        if(i >size){
            throw new TadSequenciaExcecao("Rank informado não existe.");
        }
        tad_sequencia[i] = O;
    }
    public void insertAtRank(int r, Object O){
        if(r >size || r<0){
            throw new TadSequenciaExcecao("O rank informado não existe.");
        }
        aumenta_capacidade();
        for(int i = size; i>r; i--){
            tad_sequencia[i] = tad_sequencia[i-1];
        }
        tad_sequencia[r]= O;
        size++;
    }
    public void removeAtRank(int r){
        if(r < 0|| r >= size){
            throw new TadSequenciaExcecao("Rank inválido.");
        }
        if(r==size){
            tad_sequencia[size-1] = null;
            size--;
            return;
        }
        for(int i = r; i<size-1; i++){
            tad_sequencia[i] = tad_sequencia[i+1];
        }
        size--;
    }
    public Object first(){
        if(size==0){
            throw new TadSequenciaExcecao("Lista vazia.");
        }
        return tad_sequencia[0];
    }
    public Object last(){
        if(size==0){
            throw new TadSequenciaExcecao("Lista vazia.");
        }
        return tad_sequencia[size-1];
    }
    public Object before(Object n){
        if(size==0){
            throw new TadSequenciaExcecao("O array está vazio.");
        }
        if(tad_sequencia[0].equals(n)){
            throw new TadSequenciaExcecao("Objeto informado é o primeiro elemento do array.");
        }
        for(int i=1; i<size;i++){
            if(tad_sequencia[i].equals(n)){
                return tad_sequencia[i-1];
            }
        }
        throw new TadSequenciaExcecao("Objeto informado não foi encontrado na lista.");
    }
    public Object after(Object n){
        if(size==0){
            throw new TadSequenciaExcecao("O array está vazio.");
        }
        if(tad_sequencia[size-1].equals(n)){
            throw new TadSequenciaExcecao("Objeto informado é o ultimo elemento do array.");
        }
        for(int i=0; i<size-1;i++){
            if(tad_sequencia[i].equals(n)){
                return tad_sequencia[i+1];
            }
        }
        throw new TadSequenciaExcecao("Objeto informado não foi encontrado na lista.");
    }
    public void replaceElement(Object N, Object O){
        if(size==0){
            throw new TadSequenciaExcecao("O Array está vazio.");
        }
        for(int i =0; i<size; i++){
            if(tad_sequencia[i].equals(N)){
                tad_sequencia[i]=O;
                return;
            }
        }
        throw new TadSequenciaExcecao("O Objecto informado não foi encontrado");
    }
    public void swapElements(Object N, Object O){
        if(size==0){
            throw new TadSequenciaExcecao("A lista está vazia");
        }
        int indiceN =-1;
        int indiceO=-1;
        for(int i = 0; i<size;i++){
            if(tad_sequencia[i].equals(N) && indiceN == -1){
                indiceN=i;
            }
            if(tad_sequencia[i].equals(O) && indiceO == -1){
                indiceO=i;
            }
        }
        if(indiceN ==-1 || indiceO ==-1){
            throw new TadSequenciaExcecao("Um dos objetos informados não existe no array.");
        }
        tad_sequencia[indiceN] = O;
        tad_sequencia[indiceO] = N;
    }
    public void insertBefore(Object N, Object O){
            if(size==0){
                throw new TadSequenciaExcecao("O Array está vazio.");
            }

    }
}