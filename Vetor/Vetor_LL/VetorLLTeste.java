public class VetorLLTeste{
    public static void main(String[] args){
        VetorLL v = new VetorLL();
        for(int i=0; i<5; i++){
            v.insertAtRank(i, (i+5));
        }
        v.verVetorLL();
        System.err.println("\n");
        v.insertAtRank(2, 1);
        v.verVetorLL();
        System.out.println("Elemento no rank 2: "+ v.elemAtRank(2));
        System.out.println("Item removido: "+ v.removeAtRank(5));
        v.verVetorLL();

        System.out.println("Elemento substituido: "+v.replaceAtRank(1, 20));
        v.verVetorLL();
    }

}