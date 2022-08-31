import java.lang.reflect.Constructor;

public class Grafo {

    private Vertice grafo[];
    private int qtdVertices;
    private int qtdArestas;

    private void criarGrafo(String arquivoGrafo){
        String entrada;
        String dados[];

        ArquivoLeitura arquivo = new ArquivoLeitura(arquivoGrafo);

        entrada = arquivo.Ler().trim();
        dados = entrada.split("  ");
        this.qtdVertices = Integer.parseInt(dados[0]);
        this.qtdArestas = Integer.parseInt(dados[1]);
        grafo = new Vertice[qtdVertices+1];

        //preencher vetor
        int percorridas = 0;
        while(percorridas != this.qtdArestas){  //cada linha uma aresta
            entrada = arquivo.Ler().trim();
            dados = entrada.split("      ");

            //dados[0] ->  dados[1]
            int verticeAtual = Integer.parseInt(dados[0]);
            int sucessor = Integer.parseInt(dados[1]);
            inserirVertice(verticeAtual, sucessor);
            percorridas++;
        }
        arquivo.fecharArquivo();
    }

    private void inserirVertice(int verticeAtual, int sucessor){

        //inserir no vetor se não existirem
        if(grafo[verticeAtual] == null){
            Vertice vertice = new Vertice(verticeAtual);
            grafo[verticeAtual] = vertice;
        }
        if(grafo[sucessor] == null){
            Vertice vertice = new Vertice(sucessor);
            grafo[sucessor] = vertice;
        }
        //inserir nas listas
        grafo[verticeAtual].inserirSucessor(sucessor);
        grafo[sucessor].inserirPredecessor(verticeAtual);
    }

    Grafo(String arquivoGrafo){
        criarGrafo(arquivoGrafo);
    }





}
