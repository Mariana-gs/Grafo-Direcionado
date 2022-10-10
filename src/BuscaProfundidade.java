public class BuscaProfundidade {

    int matrizBusca[][];
    Pilha vertices;
    int verticeOrigem;

    BuscaProfundidade(Grafo grafo){
        this.matrizBusca = new int[2][grafo.getQtdVertices()+1]; //posição 0 não é usada
        this.vertices = new Pilha(grafo.getQtdVertices());

    }


}
