public class TadListaLLTeste {
    public static void main(String[] args){
        TadListaLL v = new TadListaLL();
        TadListaLL.Node aux1 = new TadListaLL.Node(15);
        TadListaLL.Node aux2 = new TadListaLL.Node(10);
        TadListaLL.Node aux3 = new TadListaLL.Node(11);
        TadListaLL.Node aux4 = new TadListaLL.Node(12);
        TadListaLL.Node aux5 = new TadListaLL.Node(13);
        v.insertFirst(aux1);
        v.insertBeforeLL(aux1, aux2);
        v.insertAfterLL(aux1, aux3);
        v.verListaLL();
        System.out.println("Tamanho: "+v.size());
        System.out.println("------------ SwapElements ------------");
        v.swapElements(aux1, aux2);
        v.verListaLL();

        System.out.println("------------ ReplaceElements ------------");
        v.replaceElement(aux3, aux5);
        v.verListaLL();
        System.out.println("------------ before e after ------------");
        System.out.println("No anterior ao no 10: "+ v.before(aux1));
        System.out.println("No posterior ao no 10: "+ v.after(aux1));

        System.out.println("------------ remove ------------");
        v.remove(aux1);
        v.verListaLL();

         System.out.println("------------ insertLast ------------");
         v.insertLast(aux4);
         v.verListaLL();
    }
}