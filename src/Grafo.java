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
        grafo = new Vertice[qtdVertices];


        //preencher vetor
        for(int arestas = 1; arestas <= this.qtdArestas; arestas++){
            entrada = arquivo.Ler().trim();
            dados = entrada.split("      ");

            //System.out.println(dados[0] + " -> " + dados[1]);


        }

        arquivo.fecharArquivo();
    }



    Grafo(String arquivoGrafo){

        criarGrafo(arquivoGrafo);




    }





}
