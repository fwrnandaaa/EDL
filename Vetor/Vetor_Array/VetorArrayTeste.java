
public class VetorArrayTeste {

    public static void main(String[] args) {
        VetorArray v = new VetorArray(10);
        for (int i = 0; i < 5; i++) {
            v.insertAtRank(i, (16 + i));
        }
        v.insertAtRank(2, 2);
        System.out.println("Vetor após inserir elemento em um rank não nulo: " + "\n");
        v.verVetor();
        System.out.println("Antigo elemento do rank 1: " + v.replaceAtRank(1, 3) + "\n" + "Vetor após substituição: ");
        v.verVetor();

        System.out.println("Elemento removido: " + v.removeAtRank(3));
        v.verVetor();

    }
}
