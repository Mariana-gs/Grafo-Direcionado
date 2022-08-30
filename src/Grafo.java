import java.lang.reflect.Constructor;

public class Grafo {

    private int grafo[];
    private int qtdVertices;
    private int qtdArestas;

    private void criarGrafo(String arquivoGrafo){
        String entrada;
        String dados[];

        ArquivoLeitura arquivo = new ArquivoLeitura(arquivoGrafo);
        boolean erro = true;

        entrada = arquivo.Ler();
        dados = entrada.split("  ");
        this.qtdVertices = Integer.parseInt(dados[0]);
        this.qtdArestas = Integer.parseInt(dados[1]);

        
    }

    Grafo(String arquivoGrafo){

        criarGrafo(arquivoGrafo);

        System.out.println(this.qtdVertices + " - " + this.qtdArestas);
    }





}
