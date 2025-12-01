public class ArvoreBTeste{
    public static void main(String[] args){
        // criando arvore e nós
        ArvoreBinaria v = new ArvoreBinaria();
        ArvoreBinaria.Node aux1 = new ArvoreBinaria.Node(35); //vai ser root
        ArvoreBinaria.Node aux2 = new ArvoreBinaria.Node(16);
        ArvoreBinaria.Node aux3 = new ArvoreBinaria.Node(1);
        ArvoreBinaria.Node aux4 = new ArvoreBinaria.Node(8);
        ArvoreBinaria.Node aux5 = new ArvoreBinaria.Node(14);
        ArvoreBinaria.Node aux6 = new ArvoreBinaria.Node(13);
        ArvoreBinaria.Node aux7 = new ArvoreBinaria.Node(9);
        ArvoreBinaria.Node aux8 = new ArvoreBinaria.Node(10);
        ArvoreBinaria.Node aux9 = new ArvoreBinaria.Node(80);
        ArvoreBinaria.Node aux10 = new ArvoreBinaria.Node(9);

        v.insert(aux1);
        v.insert(aux2);
        v.insert(aux3);
        v.insert(aux4);
        v.insert(aux5);
        v.inOrder(aux1); 
        System.out.println("Filhos do  aux 2(16)"+ v.children(aux2));

    }
}