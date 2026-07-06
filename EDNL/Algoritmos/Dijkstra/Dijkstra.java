import java.util.*;
public class Dijkstra {

    static final int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) {

        int[][] L = {
            {0,    10,   INF,  30,   100}, 
            {INF,  0,    50,   INF,  INF}, 
            {INF,  INF,  0,    INF,  10 }, 
            {INF,  INF,  20,   0,    60 },
            {INF,  INF,  INF,  INF,  0  } 
        };

        String[] nomes = {"v1", "v2", "v3", "v4", "v5"};

        dijkstra(L, 0, nomes);
    }

    /**
     * Executa o algoritmo de Dijkstra a partir do vértice de origem.
     *
     * @param L      matriz de custos L(vi,vj)
     * @param origem índice do vértice fonte (v0)
     * @param nomes  nomes dos vértices, para impressão
     */
    public static void dijkstra(int[][] L, int origem, String[] nomes) {
        int n = L.length;

        int[] D = new int[n];         
        int[] antecessor = new int[n];  
        boolean[] S = new boolean[n];    
        Arrays.fill(antecessor, -1);
        for (int v = 0; v < n; v++) {
            D[v] = L[origem][v];
            if (v != origem && L[origem][v] < INF) {
                antecessor[v] = origem;
            }
        }
        D[origem] = 0;
        S[origem] = true; 

        System.out.println("Início: S = { " + nomes[origem] + " }");
        imprimeLinha(D, nomes, n);

        int iteracao = 1;
        while (!todosEmS(S)) {
            int w = escolheMenor(D, S, n);

            if (w == -1) {
                break;
            }
            S[w] = true;

            System.out.println("\nIteração " + iteracao + ": w = " + nomes[w] + ", D[w] = " + D[w]);
            for (int v = 0; v < n; v++) {
                if (!S[v] && L[w][v] < INF) {
                    int candidato = D[w] + L[w][v];
                    if (candidato < D[v]) {
                        D[v] = candidato;
                        antecessor[v] = w;
                    }
                }
            }

            imprimeLinha(D, nomes, n);
            iteracao++;
        }

        System.out.println("\n--- Resultado final (a partir de " + nomes[origem] + ") ---");
        for (int v = 0; v < n; v++) {
            String dist = (D[v] >= INF) ? "inf" : String.valueOf(D[v]);
            System.out.println(nomes[origem] + " -> " + nomes[v] + " : custo = " + dist
                    + " | caminho: " + montaCaminho(antecessor, v, nomes, origem));
        }
    }
    private static boolean todosEmS(boolean[] S) {
        for (boolean b : S) {
            if (!b) return false;
        }
        return true;
    }
    private static int escolheMenor(int[] D, boolean[] S, int n) {
        int menor = INF;
        int w = -1;
        for (int v = 0; v < n; v++) {
            if (!S[v] && D[v] < menor) {
                menor = D[v];
                w = v;
            }
        }
        return w;
    }
    private static String montaCaminho(int[] antecessor, int destino, String[] nomes, int origem) {
        if (destino == origem) return nomes[origem];
        if (antecessor[destino] == -1) return "sem caminho";

        LinkedList<String> pilha = new LinkedList<>();
        int atual = destino;
        while (atual != -1) {
            pilha.addFirst(nomes[atual]);
            if (atual == origem) break;
            atual = antecessor[atual];
        }
        return String.join(" -> ", pilha);
    }
    private static void imprimeLinha(int[] D, String[] nomes, int n) {
        StringBuilder sb = new StringBuilder("  ");
        for (int v = 0; v < n; v++) {
            String valor = (D[v] >= INF) ? "inf" : String.valueOf(D[v]);
            sb.append("D[").append(nomes[v]).append("]=").append(valor).append("  ");
        }
        System.out.println(sb.toString());
    }
}