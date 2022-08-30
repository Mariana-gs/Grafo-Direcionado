import java.util.List;

public class Vertice {

    private int numVertice;
    private List<Integer> Sucessores;
    private List<Integer> Predecessores;

    public void inserirSucessor(Integer vertice) {
        Sucessores.add(vertice);
    }

    public void inserirPredecessor(Integer vertice) {
        Sucessores.add(vertice);
    }


}

