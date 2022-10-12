public class Busca {

    private Vertice grafo[];

    Busca(Vertice grafo[]){
        this.grafo = grafo;
    }

    public int[][] buscaLargura(int verticeOrigem){
        Fila visitados = new Fila(this.grafo.length);
        int matrizBusca[][] = new int[2][this.grafo.length];

        int arvore[][] = new int[this.grafo.length][2];
        int a = 0;

        int u = 0;
        int sucessor;

        matrizBusca[0][verticeOrigem] = 1;
        try {
            visitados.enfileirar(grafo[verticeOrigem]);
        } catch (Exception e) {
            e.printStackTrace();
        }

        while(!visitados.filaVazia()){
            try {
                u = visitados.desenfileirar().getRotulo();
            } catch (Exception e) {
                e.printStackTrace();
            }

            int qtdSucessores = grafo[u].getSucessores().size();
            int i = 0;

            //para all vertice adjacente a u
            while (i < qtdSucessores){
                sucessor = grafo[u].getSucessores().get(i); //obtem rótulo de um sucessor
                if(matrizBusca[0][sucessor] != 1){  //se não for visitado
                    matrizBusca[0][sucessor] = 1; //visitado
                    matrizBusca[1][sucessor] = u; //predecessor
                    arvore[a][0] = u;
                    arvore[a][1] = sucessor;
                    a++;
                    //System.out.println(u + "->" + sucessor);
                    try {
                        visitados.enfileirar(grafo[sucessor]);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else{
                    i++;
                }
            }

        }
        return arvore;
    }

    public int[][] buscaProfundidade(int verticeOrigem){
        Pilha visitados = new Pilha(this.grafo.length);
        int matrizBusca[][] = new int[2][this.grafo.length];

        int arvore[][] = new int[this.grafo.length][2];
        int a = 0;

        int u = 0;
        int sucessor;

        matrizBusca[0][verticeOrigem] = 1;
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

            sucessor = sucessorNaoVisitado(u, matrizBusca);
            if(sucessor != -1){ //se tem sucessores não visitados
                matrizBusca[0][sucessor] = 1; //visitado
                matrizBusca[1][sucessor] = u; //predecessor
                arvore[a][0] = u;
                arvore[a][1] = sucessor;
                a++;
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
        return arvore;
    }

    /**
     * Função que retorna o próximo sucessor que ainda não foi
     * visitado, se não houver, retorna -1
     * @param u
     * @return
     */
    private int sucessorNaoVisitado(int u, int [][] matrizBusca){
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

    public void imprimirArvore(int[][] arvore){
        for(int i = 0 ; i < arvore.length; i++){
            if(arvore[i][0] != 0){
                System.out.println(arvore[i][0] + " -> " +  arvore[i][1]);
            }else{
                break;
            }
        }
    }



}