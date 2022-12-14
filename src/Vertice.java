import java.util.ArrayList;
import java.util.List;

public class Vertice {

    private int rotulo;                     //Rótulo do Vértice (número)
    private int grauSaida;                  //Grau de Saída do Vértice
    private int grauEntrada;                //Grau de Entrada do Vértice
    private List<Integer> Sucessores;       //Lista de Sucessores do Vértice
    private List<Integer> Predecessores;    //Lista de Predecessores do Vértice

    // Getters
    public int getGrauSaida() {
        return grauSaida;
    }
    public int getGrauEntrada() {
        return grauEntrada;
    }
    public int getRotulo() {
        return rotulo;
    }
    public List<Integer> getSucessores() {
        return Sucessores;
    }
    public List<Integer> getPredecessores() {
        return Predecessores;
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
    Vertice(){
        this.rotulo = 0;
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

}

