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

    private int sucessorNaoVisitado(int u, int [][] matrizBusca, Vertice[] subjacente){
        if(subjacente[u] != null){
            int qtdSucessores = subjacente[u].getSucessores().size();
            int i = 0;
            int sucessor;

            while (i < qtdSucessores){
                sucessor = subjacente[u].getSucessores().get(i); //obtem rótulo de um sucessor
                if(matrizBusca[0][sucessor] != 1){  //se não for visitado
                    return sucessor;
                }else{
                    i++;
                }
            }
        }
        return -1;
    }


    /**
     * Método testa se o grafo possui ciclo
     * @param verticeOrigem
     * @return
     */
    public boolean buscaCiclo(int verticeOrigem){

        int controleCiclo[] = new int[this.grafo.length]; //controle de itens que estão na pilha

        int qtdVisitados = 0;
        int contadorSucessores = 0;

        Pilha visitados = new Pilha(this.grafo.length);
        int matrizBusca[][] = new int[2][this.grafo.length];

        int u = 0;
        int sucessor = 0;

        matrizBusca[0][verticeOrigem] = 1;
        try {
            visitados.empilhar(grafo[verticeOrigem]);
            controleCiclo[verticeOrigem] = 1;
            qtdVisitados++;
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Busca termina qaundo a pilha está vazia
        while(!visitados.pilhaVazia()){
            try {
                u = visitados.consultar().getRotulo();
            } catch (Exception e) {
                e.printStackTrace();
            }

            /**
             * Verifica se há um sucessor do vértice atual que já foi visitado
             * para fechar um ciclo
             */
            while (contadorSucessores < grafo[u].getSucessores().size()){
                sucessor = grafo[u].getSucessores().get(contadorSucessores); //obtem rótulo de um sucessor
                try {
                    if(qtdVisitados <= 2){  //só há ciclo para mais de 2 vértices no grafo
                        break;
                    }else if(controleCiclo[sucessor] == 1){  //se for visitado e não estiver no topo da pilha
                        return true;
                    }else{
                        contadorSucessores++;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            contadorSucessores = 0;

                sucessor = sucessorNaoVisitado(u, matrizBusca);
                if(sucessor != -1){ //se tem sucessores não visitados
                    matrizBusca[0][sucessor] = 1; //visitado
                    controleCiclo[sucessor] = 1;
                    qtdVisitados++;
                    matrizBusca[1][sucessor] = u; //predecessor
                    try {  //empilhar sucessor
                        visitados.empilhar(grafo[sucessor]);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else{
                    try { //desempilhar
                        controleCiclo[visitados.consultar().getRotulo()] = 0; //removendo da pilha
                        visitados.desempilhar();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        return false;
    }

    public Pilha buscaCaminho(int verticeOrigem, int verticeDestino){

        /*
         * Buscar,
         * if
         * encontrar o vertice destino imprimir a pilha
         * else
         * não há caminho
         */

        Pilha visitados = new Pilha(this.grafo.length);
        int matrizBusca[][] = new int[2][this.grafo.length];

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
                try {
                    visitados.empilhar(grafo[sucessor]);
                    if(sucessor == verticeDestino){
                        return visitados;
                    }
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

        return visitados;
    }

    public Pilha buscaCaminho(int verticeOrigem, int verticeDestino, Vertice[] subjacente){

        Pilha visitados = new Pilha(subjacente.length);
        int matrizBusca[][] = new int[2][subjacente.length];

        int u = 0;
        int sucessor;

        matrizBusca[0][verticeOrigem] = 1;
        try {
            visitados.empilhar(subjacente[verticeOrigem]);
        } catch (Exception e) {
            e.printStackTrace();
        }

        while(!visitados.pilhaVazia()){
            try {
                if(visitados.consultar() != null){
                    u = visitados.consultar().getRotulo();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            sucessor = sucessorNaoVisitado(u, matrizBusca, subjacente);

            if(sucessor != -1){ //se tem sucessores não visitados
                matrizBusca[0][sucessor] = 1; //visitado
                matrizBusca[1][sucessor] = u; //predecessor
                try {
                    visitados.empilhar(subjacente[sucessor]);
                    if(sucessor == verticeDestino){
                        return visitados;
                    }
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

        return visitados;
    }

    public boolean ehConexo(Vertice[] subjacente){
        int qtdvertices = grafo.length-1;

        Pilha caminho;

        boolean conexo = true;

        for(int i = 0; i < qtdvertices; i++){
            for(int j = 0; j < qtdvertices; j++){
                caminho = buscaCaminho(i,j,subjacente);
                if(caminho.pilhaVazia()) conexo = false;
                break;
            }
        }

        return conexo;
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