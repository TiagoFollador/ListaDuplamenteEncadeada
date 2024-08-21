public class ListaDuplamenteEncadeada {
    private ListaDuplamenteEncadeada anterior;
    private Integer informacao;
    private ListaDuplamenteEncadeada proximo;

    public ListaDuplamenteEncadeada()
    {
        this.informacao = null;
        this.anterior = null;
        this.proximo = null;
    }

    public Integer getInformacao(){
        return informacao;
    }

    public void setInformacao(Integer informacao){
        this.informacao = informacao;
    }
    public ListaDuplamenteEncadeada getProximo(){
        return this.proximo;
    }

    public  void setProximo(ListaDuplamenteEncadeada proximo){
        this.proximo = proximo;
    }

    public ListaDuplamenteEncadeada getAnterior(){
        return anterior;
    }

    public void setAnterior(ListaDuplamenteEncadeada anterior){
        this.anterior = anterior;
    }
}
