import java.util.ArrayList;
import java.util.List;

public class Vertice {

    private int rotulo;                     //Rótulo do Vértice (número)
    private int grauSaida;                  //Grau de Saída do Vértice
    private int grauEntrada;                //Grau de Entrada do Vértice
    private List<Integer> Sucessores;       //Lista de Sucessores do Vértice
    private List<Integer> Predecessores;    //Lista de Predecessores do Vértice

    public int getGrauSaida() {
        return grauSaida;
    }
    public int getGrauEntrada() {
        return grauEntrada;
    }

    /**
     * Construtor
     * @param rotulo Rótulo do Vétice
     */
    Vertice(int rotulo){
        this.rotulo = rotulo;
        this.Sucessores = new ArrayList<>();
        this.Predecessores = new ArrayList<>();
        this.grauSaida = this.Sucessores.size();
        this.grauEntrada = this.Predecessores.size();
    }

    /**
     * Insere um Sucessor na Lista
     * @param sucessor
     */
    public void inserirSucessor(Integer sucessor) {
        this.Sucessores.add(sucessor);
        this.grauSaida++;
    }
    /**
     * Insere um Predecessor na Lista
     * @param predecessor
     */
    public void inserirPredecessor(Integer predecessor) {
        this.Predecessores.add(predecessor);
        this.grauEntrada++;
    }


    /**
     * Exibe todos os Sucessores do Vértice
     */
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
    /**
     * Exibe todos os Predecessores do Vértice
     */
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

