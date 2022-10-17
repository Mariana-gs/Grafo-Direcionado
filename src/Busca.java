public class Busca {

    private Vertice grafo[];

    //Construtor
    Busca(Vertice grafo[]){
        this.grafo = grafo;
    }

    /**
     * Realiza a busca em Largura e retorna uma Matriz
     * para representar a árvore encontrada
     * @param verticeOrigem Vértice Raíz
     * @return Matriz de Inteiros para representar Árvore de Busca
     */
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

            //para cada vertice adjacente a u
            while (i < qtdSucessores){
                sucessor = grafo[u].getSucessores().get(i); //obtem rótulo de um sucessor
                if(matrizBusca[0][sucessor] != 1){ //se não for visitado
                    matrizBusca[0][sucessor] = 1;  //marca como visitado
                    matrizBusca[1][sucessor] = u;  //seta predecessor
                    arvore[a][0] = u;
                    arvore[a][1] = sucessor;
                    a++;
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

    /**
     * Realiza a busca em Profundidade e retorna uma Matriz
     * para representar a árvore encontrada
     * @param verticeOrigem Vértice Raíz
     * @return Matriz de Inteiros para representar Árvore de Busca
     */
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

            if(sucessor != -1){  //se tem sucessores não visitados
                matrizBusca[0][sucessor] = 1; //marca como visitado
                matrizBusca[1][sucessor] = u; //seta predecessor
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
     * Método que retorna o próximo sucessor que ainda não foi
     * visitado, se não houver, retorna -1
     * @param u Rótulo do Vértice
     * @param matrizBusca Matriz de Busca do Grafo
     * @return Rótulo de um Sucessor que ainda não foi visitado
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

    /**
     * Método, para grafo subjacente, que retorna o próximo sucessor que ainda não foi
     * visitado, se não houver, retorna -1
     * @param u Rótulo do Vértice
     * @param matrizBusca Matriz de Busca do Grafo
     * @param subjacente Vetor de Listas que representa o grafo subjacente
     * @return Rótulo de um Sucessor que ainda não foi visitado
     */
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
     * Verifica se existe algum ciclo no grafo partindo do vértice indicado,
     * se não houver testa para outros vértices
     * @param verticeOrigem Rótulo do Primeiro Vértice de Origem
     * @return Verdadeiro se houver ciclo ou Falso se não houver ciclo
     */
    public boolean buscaCiclo(int verticeOrigem){
        boolean ciclo;

        ciclo = buscaUmCiclo(verticeOrigem);
        if(!ciclo){
            for (int i = 1; i < grafo.length; i++) {
                if(i != verticeOrigem){
                    ciclo = buscaUmCiclo(i);
                    if(ciclo) break;
                }
            }
        }

        return ciclo;
    }

    /**
     * Verifica se existe um ciclo partindo
     * somente do vértice indicado
     * @param verticeOrigem Rótulo do vértice de origem
     * @return Verdadeiro se houver ciclo ou Falso se não houver ciclo
     */
    public boolean buscaUmCiclo(int verticeOrigem){

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

    /**
     * Método realiza busca por um caminho entre
     * os dois vértices indicados
     * @param verticeOrigem Rótulo do Vértice de Origem
     * @param verticeDestino Rótulo do Vértice de Destino
     * @return Pilha contendo o caminho encontrado
     */
    public Pilha buscaCaminho(int verticeOrigem, int verticeDestino){

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

        if(verticeOrigem == verticeDestino){
            return visitados;
        }

        while(!visitados.pilhaVazia()){
            try {
                u = visitados.consultar().getRotulo();
            } catch (Exception e) {
                e.printStackTrace();
            }
            sucessor = sucessorNaoVisitado(u, matrizBusca);

            if(sucessor != -1){ //se tem sucessores não visitados
                matrizBusca[0][sucessor] = 1; //marca como visitado
                matrizBusca[1][sucessor] = u; //seta predecessor
                try { //empilhar sucessor
                    visitados.empilhar(grafo[sucessor]);
                    if(sucessor == verticeDestino){
                        return visitados;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }else{
                try { //desempilhar
                    visitados.desempilhar();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return visitados;
    }

    /**
     * Método realiza busca, no grafo subjacente, por um
     * caminho entre os dois vértices indicados
     * @param verticeOrigem Rótulo do Vértice de Origem
     * @param verticeDestino Rótulo do Vértice de Destino
     * @param subjacente Vetor de Listas que representa o grafo subjacente
     * @return Pilha contendo o caminho encontrado
     */
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

        if(verticeOrigem == verticeDestino){
            return visitados;
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
                matrizBusca[0][sucessor] = 1; //marca como visitado
                matrizBusca[1][sucessor] = u; //seta predecessor
                try { //empilhar sucessor
                    visitados.empilhar(subjacente[sucessor]);
                    if(sucessor == verticeDestino){
                        return visitados;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }else{
                try { //desempilhar
                    visitados.desempilhar();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return visitados;
    }

    /**
     * Verifica se há caminho entre todos
     * os pares de vértices do grafo
     * @param subjacente Vetor de Listas que representa o grafo subjacente
     * @return Verdadeiro se for conexo ou falso se for desconexo
     */
    public boolean ehConexo(Vertice[] subjacente){
        int qtdvertices = subjacente.length-1;

        Pilha caminho;

        boolean conexo = true;

        for(int i = 0; i < qtdvertices; i++){
            for(int j = 0; j < qtdvertices; j++){
                if(subjacente[i] != null && subjacente[j] != null){
                    caminho = buscaCaminho(subjacente[i].getRotulo() ,subjacente[j].getRotulo() ,subjacente);
                    if(caminho.pilhaVazia()){
                        conexo = false;
                        break;
                    }
                }
            }
        }
        return conexo;
    }

    /**
     * Exibe uma árvore
     * @param arvore Matriz de inteiros que representa uma árvore
     */
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