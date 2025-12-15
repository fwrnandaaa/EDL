public class Pilha {
    private int capacidade;
    private Object[] p;
    private int topoV;
    private int topoP;

    public Pilha(int capacidade) {

        this.capacidade = capacidade;
        this.topoP = capacidade;
        this.topoV = -1;
        this.p = new Object[capacidade];
    }

    public int size() {
        return this.topoV + 1;
    }

    public boolean isEmpty() {
        if (this.size() == 0) {
            return true;
        }
        return false;
    }

    public void aumenta_pilha() {
        Object[] novo_array = new Object[this.capacidade * 2];
        for(int i = 0; i <= this.topoV; i++){
            novo_array[i] = this.p[i];
        }
        int novoTopoP = (this.capacidade*2) - (this.capacidade - this.topoP);
        int auxiliar = novoTopoP;
        for (int i = this.topoP; i < this.capacidade; i++) {
            novo_array[auxiliar] = p[i];
            auxiliar++;
            }
        this.topoP = novoTopoP;
        this.capacidade = this.capacidade * 2;
        this.p =  novo_array;

        }
    

    public void reducao_pilha(){
        int totalElementos = (this.topoV + 1) + (this.capacidade - this.topoP);
        if((!isEmpty()) && (totalElementos <= (this.capacidade/3))){
            int novaCapacidade = 0;
            if ((this.capacidade / 2) < 1) {
            novaCapacidade = 1;  
            } else {
            novaCapacidade = this.capacidade / 2;
            }
            Object[] novo_array = new Object[novaCapacidade];
            for (int i = 0; i <= this.topoV; i++) {
                novo_array[i] = this.p[i];
            }
          
            int novoTopoP = (novaCapacidade) - (this.capacidade - topoP);
            int indiceNovo = novoTopoP;
            for (int i = this.topoP; i < this.capacidade; i++) {
                novo_array[indiceNovo] = this.p[i];
                indiceNovo++;
            }
            this.topoP = novoTopoP;
            this.capacidade = novaCapacidade;
            this.p = novo_array;

        }
        
    }
    public Object top_vermelho () throws PilhaVaziaExcecao{
        if(isEmpty()){
            throw new PilhaVaziaExcecao("A pilha está vazia"); 
        }
        return p[topoV];
    }
    public void push_vermelho(Object o){
        aumenta_pilha();
        this.p[++topoV] = o;


    }
    public Object pop_vermelho() throws PilhaVaziaExcecao{
         if(isEmpty()){
            throw new PilhaVaziaExcecao("A pilha está vazia"); 
        }
        Object r=this.p[topoV--];
        reducao_pilha();
        return r;
    }
  
    public void push_preto(Object o){
        aumenta_pilha();
        this.p[--topoP] = o;
    }
    public Object pop_preto() throws PilhaVaziaExcecao{
        if(this.topoP == this.capacidade){
            throw new PilhaVaziaExcecao("A pilha está vazia");
}
        Object r = this.p[topoP++];
        reducao_pilha();
        return r;
    }
    public Object top_preto() throws PilhaVaziaExcecao {
        if (this.topoP == this.capacidade) {
            throw new PilhaVaziaExcecao("A pilha preta está vazia");
        }
        return this.p[topoP];


}
}