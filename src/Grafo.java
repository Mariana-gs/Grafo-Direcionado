import java.lang.reflect.Constructor;

public class Grafo {

    private Vertice grafo[];
    private int qtdVertices;
    private int qtdArestas;

    public int getQtdVertices() {
        return qtdVertices;
    }
    public int getQtdArestas() {
        return qtdArestas;
    }
    Grafo(String arquivoGrafo){
        criarGrafo(arquivoGrafo);
    }
    Grafo(){

    }

    private void criarGrafo(String arquivoGrafo){
        String entrada;
        String dados[];

        ArquivoLeitura arquivo = new ArquivoLeitura(arquivoGrafo);

        //primeira linha do Arquivo
        entrada = arquivo.Ler().trim();
        dados = entrada.split("  ");
        this.qtdVertices = Integer.parseInt(dados[0]);
        this.qtdArestas = Integer.parseInt(dados[1]);
        grafo = new Vertice[qtdVertices+1];

        //Obter Vétices da linha do Arquivo
        int percorridas = 0;

        while(percorridas != this.qtdArestas){  //para todas as arestas
            boolean encontrado = false; // encontrar fim do primeiro número
            int verticeAtual = 0;
            int sucessor = 0;
            int i = 0;
            entrada = arquivo.Ler().trim();

            while(!encontrado){
                if(entrada.charAt(i) == ' '){
                    verticeAtual = Integer.parseInt(entrada.substring(0, (i)));
                    entrada = entrada.substring(i+1);
                    sucessor = Integer.parseInt(entrada.trim());
                    encontrado = true;
                }else{
                    i++;
                }
            }
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


    public void grauSaida(int vertice){
        System.out.println("O grau de Saída do Vértice " + vertice + " é: " + grafo[vertice].getGrauSaida());
    }
    public void grauEntrada(int vertice){
        System.out.println("O grau de Entrada do Vértice " + vertice + " é: " + grafo[vertice].getGrauEntrada());
    }
    public void exibirSucessores(int vertice){
        grafo[vertice].exibirSucessores();
    }
    public void exibirPredecessores(int vertice){
        grafo[vertice].exibirPredecessores();
    }

}
