public class BuscaLargura {

    private int matrizBusca[][];
    private Fila visitados;
    private Vertice grafo[];

    BuscaLargura(Vertice grafo[]){
        this.grafo = grafo;
        this.matrizBusca = new int[2][this.grafo.length]; //posição 0 não é usada
        this.visitados = new Fila(this.grafo.length);
    }

    public void buscar(int verticeOrigem){

        System.out.println("Árvore da Busca em Largura:");
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
                    System.out.println(u + "->" + sucessor);
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

    }



}
