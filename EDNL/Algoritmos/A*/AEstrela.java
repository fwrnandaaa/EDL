import java.util.*;
public class AEstrela {
    static class No implements Comparable<No> {
        final int linha, coluna;
        int g, h, f;
        No pai;

        No(int linha, int coluna) {
            this.linha = linha;
            this.coluna = coluna;
        }

        @Override
        public int compareTo(No o) {
            return Integer.compare(this.f, o.f); 
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof No)) return false;
            No n = (No) obj;
            return linha == n.linha && coluna == n.coluna;
        }

        @Override
        public int hashCode() {
            return Objects.hash(linha, coluna);
        }

        @Override
        public String toString() {
            return "(" + linha + "," + coluna + ")";
        }
    }

    public static void main(String[] args) {

        int[][] grade = {
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0}, 
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
        };

        No inicio = new No(2, 1);  
        No destino = new No(2, 6); 

        List<No> caminho = aStar(grade, inicio, destino);

        if (caminho == null) {
            System.out.println("Não foi encontrado nenhum caminho até o destino.");
        } else {
            System.out.println("Caminho encontrado (" + (caminho.size() - 1) + " passos):");
            for (No n : caminho) {
                System.out.println("  " + n + "  f=" + n.f + " g=" + n.g + " h=" + n.h);
            }
        }
    }

    /**
     * Executa o A* sobre uma grade de células.
     *
     * @param grade   matriz onde 0 = passável e 1 = obstáculo
     * @param inicio  quadrado inicial
     * @param destino quadrado alvo
     * @return lista de nós do caminho (início -> destino), ou null se não houver caminho
     */
    public static List<No> aStar(int[][] grade, No inicio, No destino) {
        int linhas = grade.length;
        int colunas = grade[0].length;

        PriorityQueue<No> listaAberta = new PriorityQueue<>();
        Map<No, No> naListaAberta = new HashMap<>();
        Set<No> listaFechada = new HashSet<>();

        inicio.g = 0;
        inicio.h = heuristica(inicio, destino);
        inicio.f = inicio.g + inicio.h;

        listaAberta.add(inicio);
        naListaAberta.put(inicio, inicio);
        int[][] direcoes = {
            {-1, -1}, {-1, 0}, {-1, 1},
            { 0, -1},          { 0, 1},
            { 1, -1}, { 1, 0}, { 1, 1}
        };

        while (!listaAberta.isEmpty()) {
            No atual = listaAberta.poll();
            naListaAberta.remove(atual);

            if (atual.equals(destino)) {
                return reconstroiCaminho(atual);
            }

            listaFechada.add(atual);

            for (int[] d : direcoes) {
                int novaLinha = atual.linha + d[0];
                int novaColuna = atual.coluna + d[1];

                if (novaLinha < 0 || novaLinha >= linhas || novaColuna < 0 || novaColuna >= colunas) {
                    continue;
                }
                if (grade[novaLinha][novaColuna] == 1) {
                    continue;
                }

                No vizinho = new No(novaLinha, novaColuna);
                if (listaFechada.contains(vizinho)) {
                    continue;
                }

                boolean diagonal = (d[0] != 0 && d[1] != 0);
                int custoMovimento = diagonal ? 14 : 10;
                int gTentativo = atual.g + custoMovimento;

                No existente = naListaAberta.get(vizinho);

                if (existente == null) {
                    vizinho.g = gTentativo;
                    vizinho.h = heuristica(vizinho, destino);
                    vizinho.f = vizinho.g + vizinho.h;
                    vizinho.pai = atual;

                    listaAberta.add(vizinho);
                    naListaAberta.put(vizinho, vizinho);

                } else if (gTentativo < existente.g) {
                    listaAberta.remove(existente); 
                    existente.g = gTentativo;
                    existente.f = existente.g + existente.h;
                    existente.pai = atual;
                    listaAberta.add(existente);
                }
            }
        }
        return null;
    }

    private static int heuristica(No n, No destino) {
        int dLinha = Math.abs(n.linha - destino.linha);
        int dColuna = Math.abs(n.coluna - destino.coluna);
        return (dLinha + dColuna) * 10;
    }
    private static List<No> reconstroiCaminho(No destino) {
        LinkedList<No> caminho = new LinkedList<>();
        No atual = destino;
        while (atual != null) {
            caminho.addFirst(atual);
            atual = atual.pai;
        }
        return caminho;
    }
}