import java.util.ArrayList;
import java.util.List;

public class Vertice {

    private int rotulo;
    private int grauSaida;
    private int grauEntrada;
    private List<Integer> Sucessores;
    private List<Integer> Predecessores;

    public int getGrauSaida() {
        return grauSaida;
    }
    public int getGrauEntrada() {
        return grauEntrada;
    }

    Vertice(int rotulo){
        this.rotulo = rotulo;
        this.Sucessores = new ArrayList<>();
        this.Predecessores = new ArrayList<>();
        this.grauSaida = this.Sucessores.size();
        this.grauEntrada = this.Predecessores.size();
    }

    public void inserirSucessor(Integer sucessor) {
        this.Sucessores.add(sucessor);
        this.grauSaida++;
    }
    public void inserirPredecessor(Integer predecessor) {
        this.Predecessores.add(predecessor);
        this.grauEntrada++;
    }

    public void exibirSucessores(){
        System.out.print("Os Sucessores do Vértice " + this.rotulo + " são: {");
        for(int i=0; i < this.grauSaida; i++){
            System.out.print("(" + Sucessores.get(i) + ")");
            if(i < this.grauSaida - 1){
                System.out.print("; ");
            }
        }
        System.out.print("}\n");
    }
    public void exibirPredecessores(){
        System.out.print("Os Predecessores do Vértice " + this.rotulo + " são: {");
        for(int i=0; i < this.grauEntrada; i++){
            System.out.print("(" + Predecessores.get(i) + ")");
            if(i < this.grauEntrada-1){
                System.out.print("; ");
            }
        }
        System.out.print("}\n");
    }



}

