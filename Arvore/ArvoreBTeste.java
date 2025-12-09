public class ArvoreBTeste{
    public static void main(String[] args){
        // criando arvore e nós
        ArvoreBinaria v = new ArvoreBinaria();
        ArvoreBinaria.Node aux1 = new ArvoreBinaria.Node(35); //vai ser root
        ArvoreBinaria.Node aux2 = new ArvoreBinaria.Node(90);
        ArvoreBinaria.Node aux3 = new ArvoreBinaria.Node(1);
        ArvoreBinaria.Node aux4 = new ArvoreBinaria.Node(8);
        ArvoreBinaria.Node aux5 = new ArvoreBinaria.Node(6);
        ArvoreBinaria.Node aux6 = new ArvoreBinaria.Node(80);
        ArvoreBinaria.Node aux7 = new ArvoreBinaria.Node(75);
        v.insert(aux1);
        v.insert(aux2);
        v.insert(aux3);
        v.insert(aux4);
        v.insert(aux5);
        v.insert(aux6);
        v.insert(aux7);
        
        System.out.println("Pai do nó aux7 (80): " + v.parent(aux6));
        System.out.println("Filho esquerdo do nó aux6(80): "+ v.leftChild(aux6));
        System.out.println("Altura da arvore: "+ v.height(aux1));
        System.out.println("Profundidade da arvore: "+ v.depth(aux1));
        System.out.println("Filhos do root: "+ v.children(aux1));
        v.verArvore();
    }
}