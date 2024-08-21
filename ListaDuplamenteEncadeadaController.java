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

    public void remove(int posicaoParaRemover){
        int index = 0;
        boolean keepAsking = true;
        ListaDuplamenteEncadeada atual = Lista;

        System.out.println("Removendo o indice " + posicaoParaRemover + "...");

        do {
            if (index == posicaoParaRemover){
                if (atual.getProximo() == null){          // ultimo
                    atual.getAnterior().setProximo(null);
                    atual.setAnterior(null);
                    keepAsking = false;
                } else if (atual.getAnterior() == null) {       // primeiro
                    (atual.getProximo()).setAnterior(null);
                    Lista = atual.getProximo();
                    atual.setProximo(null);
                    keepAsking = false;

                } else {                                    // termo geral
                    (atual.getAnterior()).setProximo(atual.getProximo());
                    atual.getProximo().setAnterior((atual.getAnterior()));

                    atual.setProximo(null);
                    atual.setAnterior(null);
                    keepAsking = false;
                }
            }   else {
                atual = atual.getProximo();
                index++;
                keepAsking = index < posicaoParaRemover + 1;
            }
        } while (keepAsking);
        if (posicaoParaRemover > index){
            System.out.println("Index inserido foi maior que a lista, tente novamente");
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
