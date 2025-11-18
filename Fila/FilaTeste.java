public class FilaTeste{
    public static void main(String[] args){
        Fila f = new Fila(10);
        for(int i=0; i<9; i++){
            f.enqueue(i);
        }
        f.verFila();
    }
}