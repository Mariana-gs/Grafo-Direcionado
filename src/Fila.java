public class Fila {

    private Vertice fila[];
    private int frente;
    private int tras;
    private int tamanho;

    //Constructor
    Fila (int n){
        this.tamanho = n;
        fila = new Vertice [tamanho];

        //cria um objeto de inteiro em cada posição da fila
        for(int i = 0; i < n ; i++){
            fila[i] = new Vertice();
        }

        //vetor vazio - apontam pro mesmo lugar
        this.frente = 0;
        this.tras = 0;
    }

    Fila(){

    }

    public boolean filaVazia(){
        if(this.frente == this.tras) return true;
        else return false;
    }

    public boolean filaCheia(){
        if(((this.tras+1)%tamanho) == (this.frente%tamanho)) return true;
        else return false;
    }

    public void enfileirar (Vertice novo) throws Exception{
        if(!filaCheia()){
            fila[this.tras % tamanho] = novo;
            tras++;
        }else{
            new Exception("Não foi possível inserir item na fila: a fila está cheia!");
        }

    }

    public Vertice desenfileirar (){
        Vertice item = null;
        if(!filaVazia()) {
            item = fila[this.frente % tamanho];
            frente++;
        }else{
            new Exception("Não foi possível desenfileirar nenhum item na fila: a fila está vazia!");
        }
        return item;
    }

    public void imprimir(){
        for(int i = this.frente; i < this.tras; i++){
            System.out.println(fila[i % tamanho].getRotulo());
        }
    }


}
