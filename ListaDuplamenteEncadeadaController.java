public class ListaDuplamenteEncadeadaController {
    private ListaDuplamenteEncadeada Lista;
    public  ListaDuplamenteEncadeadaController()
    {
        this.Lista = null;
    }

    public void inserir (int informacao){
        ListaDuplamenteEncadeada no = new ListaDuplamenteEncadeada();

        no.setInformacao(informacao);
        if(Lista == null){
            Lista = no;
        } else if (Lista.getProximo() == null) {
            ListaDuplamenteEncadeada anterior = Lista;
            anterior.setProximo(no);
            no.setAnterior(anterior);
        } else {
            ListaDuplamenteEncadeada anterior = Lista;
            ListaDuplamenteEncadeada atual = anterior.getProximo();
            while (atual.getProximo()!=null){
                atual = atual.getProximo();
            }
            no.setAnterior(atual);
            atual.setProximo(no);
        }
    }

    public void imprimeComecoFim(){
        ListaDuplamenteEncadeada atual = Lista;
        int posicao = 0;
        while (atual != null) {
            System.out.printf("Nó [%d]: " + atual.getInformacao() + " -> ", posicao);
            atual= atual.getProximo();
            posicao++;
        }
        System.out.println("Acabou");

    }

    public void imprimeFimComeco(){
        ListaDuplamenteEncadeada anterior = Lista;
        ListaDuplamenteEncadeada atual = anterior.getProximo();

        int posicao = 0;
        while (atual != null) {
            anterior = atual;
            atual = atual.getProximo();
            posicao++;
        }
        do {
            System.out.printf("Nó [%d]: " + anterior.getInformacao() + " -> ", posicao);
            anterior = anterior.getAnterior();
            posicao--;
        } while (anterior != null);
        System.out.println("Acabou");

    }
}
