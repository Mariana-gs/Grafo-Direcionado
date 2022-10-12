public class BuscaLargura {

    private int matrizBusca[][];
    private Fila visitados;
    private Vertice grafo[];

    BuscaLargura(Vertice grafo[]){
        this.grafo = grafo;
        this.matrizBusca = new int[2][this.grafo.length]; //posição 0 não é usada
        this.visitados = new Fila(this.grafo.length);
    }

    public int[][] buscar(int verticeOrigem){

        int arvore[][] = new int[this.grafo.length][2];
        int a = 0;

        int u = 0;
        int sucessor;

        this.matrizBusca[0][verticeOrigem] = 1;
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



}
