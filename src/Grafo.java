import java.lang.reflect.Constructor;

public class Grafo {

    private int grafo[];
    private int qtdVertices;
    private int qtdArestas;

    private void criarGrafo(String arquivoGrafo){
        String entrada;
        String dados[];
        ArquivoLeitura arquivo = new ArquivoLeitura(arquivoGrafo);
        entrada = arquivo.Ler();
        dados = entrada.split("  ");
        this.qtdVertices = Integer.parseInt(dados[0]);
        this.qtdArestas = Integer.parseInt(dados[1]);
        grafo = new int[qtdVertices];
        arquivo.fecharArquivo();
    }



    Grafo(String arquivoGrafo){

        criarGrafo(arquivoGrafo);
        



    }





}
