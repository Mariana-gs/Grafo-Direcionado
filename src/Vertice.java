import java.util.ArrayList;
import java.util.List;

public class Vertice {

    private int rotulo;
    private List<Integer> Sucessores;
    private List<Integer> Predecessores;


    Vertice(int rotulo){
        this.rotulo = rotulo;
        this.Sucessores = new ArrayList<>();
        this.Predecessores = new ArrayList<>();
    }

    public void inserirSucessor(Integer sucessor) {

            this.Sucessores.add(sucessor);

    }

    public void inserirPredecessor(Integer predecessor) {

        this.Predecessores.add(predecessor);

    }


}

