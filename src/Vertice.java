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

    public void exibirSucessores(){
        System.out.print("\nOs Sucessores do Vétice " + this.rotulo + " são: {");
        for(int i=0; i < Sucessores.size(); i++){
            System.out.print("(" + Sucessores.get(i) + ")");
            if(i < Sucessores.size()-1){
                System.out.print("; ");
            }
        }
        System.out.print("}\n");
    }

    public void exibirPredecessores(){
        System.out.print("\nOs Predecessores do Vétice " + this.rotulo + " são: {");
        for(int i=0; i < Predecessores.size(); i++){
            System.out.print("(" + Predecessores.get(i) + ")");
            if(i < Predecessores.size()-1){
                System.out.print("; ");
            }
        }
        System.out.print("}\n");
    }


}

