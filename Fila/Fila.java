public class Fila{
    private int size;
    private int capacidade;
    Object [] tad_fila;
    private int inicio;
    private int fim;

    public Fila(int capacidade){
        tad_fila = new Object [capacidade];
        size=0;
        this.capacidade=capacidade;
        inicio=0;
        fim=0;
    }
    public boolean isEmpty(){
        return (inicio==fim);
    }
    public Object first(){
        if(size==0){
            throw new FilaExcecao("A fila está vazia.");
        }
        return tad_fila[inicio];
    }
    public int size(){
        return(capacidade - inicio +fim) % capacidade;

    }
    public void enqueue(Object O){
        if(size() == capacidade-1){
            throw new FilaExcecao("A fila está cheia.");
        }
        tad_fila[fim] = O;
        fim = (fim+1)%capacidade;
    }
    public Object dequeue(){
        if(isEmpty()){
            throw new FilaExcecao("A fila está vazia.");
        }
        Object O = tad_fila[inicio];
        inicio = (inicio+1)%capacidade;
        return O;
    }
    

}