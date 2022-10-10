public class Pilha {
    private Vertice[] pilha;
    private int topo;
    private int fundo;
    private int tamanho;

    public Pilha(int tamanho){
        this.pilha = new Vertice[tamanho];
        this.fundo = 0;
        this.topo = 0;
        this.tamanho = tamanho;
    }

    public boolean pilhaCheia() {
        boolean cheia;
        if(this.topo == this.tamanho){
            cheia = true;
        }else{
            cheia = false;
        }
        return cheia;
    }

    public boolean pilhaVazia(){
        boolean vazia;

        if(topo == fundo){
            vazia = true;
        }else{
            vazia = false;
        }
        return vazia;
    }

    public void empilhar(Vertice item) throws Exception{
        if(!pilhaCheia()){
            this.pilha[this.topo] = item;
            this.topo++;
        }else{
            throw new Exception("Não foi possível empilhar: as pilha já está cheia!");
        }
    }

    public Vertice desempilhar() throws Exception{
        Vertice item = null;
        if(!pilhaVazia()){
            item = this.pilha[this.topo-1];
            topo--;
        }else{
            throw new Exception("Não foi possível desempilhar: Pilha vazia!");
        }
        return item;
    }

    public void imprimir(){
        for(int i = this.topo-1; i >=0; i--){
            System.out.println(pilha[i].getRotulo());
        }
    }


}
