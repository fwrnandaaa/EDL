
public class testePilha {

	public static void main(String[] args) {	
		//pilha vermelha	
		Integer[] b = new Integer[1];		
		Pilha pp=new Pilha(1);
		System.out.println("inserindo - Pilha vermelha");
		for(int f=0;f<10;f++){
		  System.out.println(f);		  
		  pp.push_vermelho(new Integer(f));
		}
		try {
            System.out.println("Topo vermelho: " + pp.top_vermelho());
        } 
		catch (PilhaVaziaExcecao e) {
            System.out.println(e.getMessage());
        }
		System.out.println("retirando - Pilha vermelha");
		for(int f=0;f<10;f++){
			  System.out.print(f);
			  System.out.println(" - "+pp.pop_vermelho());
		}
	

		//pilha preta
		System.out.println("inserindo - Pilha preta");
		for(int f=0;f<10;f++){
		  System.out.println(f);		  
		  pp.push_preto(new Integer(f));
		}
		try {
                System.out.println("Topo preto: " + pp.top_preto());
            } catch (PilhaVaziaExcecao e) {
                System.out.println(e.getMessage());
            }
		System.out.println("retirando - Pilha preta");
		for(int f=0;f<10;f++){
			  System.out.print(f);
			  System.out.println(" - "+pp.pop_preto());
		}
	}
}
