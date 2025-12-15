public class SequenciaATeste {
    public static void main(String[] args){
        TadSequenciaArray s = new TadSequenciaArray(5);
        s.insertFirst(2);
        s.insertFirst(1);
        System.out.println("Elemento no rank 1: "+ s.elemAtRank(1));
        System.out.println("------------- insert at rank -------------");
        s.insertAtRank(1, 3);
         s.insertAtRank(3, 4);
        s.verSequencia();
        System.out.println("------------- replace at rank -------------");
        s.replaceAtRank(2, 5);
        s.verSequencia();
        System.out.println("------------- remove at rank -------------");
        s.removeAtRank(0);
        s.verSequencia();
        System.out.println("------------- replace element -------------");
        s.replaceElement(5, 200);
        s.verSequencia();
        System.out.println("------------- swap elements -------------");
        s.swapElements(3,4);
        s.verSequencia();
    }
}
