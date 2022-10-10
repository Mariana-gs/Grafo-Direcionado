public class BuscaProfundidade {

    private int matrizBusca[][];
    private Pilha visitados;
    private Vertice grafo[];

    BuscaProfundidade(Vertice grafo[]){
        this.grafo = grafo;
        this.matrizBusca = new int[2][this.grafo.length]; //posição 0 não é usada
        this.visitados = new Pilha(this.grafo.length);

    }

    public void buscar(int verticeOrigem){

        System.out.println("Árvore da Busca em Profundidade:");
        int u = 0;
        int sucessor;

        this.matrizBusca[0][verticeOrigem] = 1;
        try {
            visitados.empilhar(grafo[verticeOrigem]);
        } catch (Exception e) {
            e.printStackTrace();
        }

        while(!visitados.pilhaVazia()){
            try {
                u = visitados.consultar().getRotulo();
            } catch (Exception e) {
                e.printStackTrace();
            }

            sucessor = sucessorNaoVisitado(u);
            if(sucessor != -1){ //se tem sucessores não visitados
                matrizBusca[0][sucessor] = 1; //visitado
                matrizBusca[1][sucessor] = u; //predecessor
                System.out.println(u + "->" + sucessor);
                try {
                    visitados.empilhar(grafo[sucessor]);
                } catch (Exception e) {
                    e.printStackTrace();
                } //empilhar sucessor



            }else{
                try {
                    visitados.desempilhar();
                } catch (Exception e) {
                    e.printStackTrace();
                } //desempilhar
            }

        }

    }

    public int sucessorNaoVisitado(int u){
        int qtdSucessores = grafo[u].getSucessores().size();
        int i = 0;
        int sucessor;

        while (i < qtdSucessores){
            sucessor = grafo[u].getSucessores().get(i); //obtem rótulo de um sucessor
            if(matrizBusca[0][sucessor] != 1){  //se não for visitado
                return sucessor;
            }else{
                i++;
            }
        }
        return -1;
    }

}
