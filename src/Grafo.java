import java.lang.reflect.Constructor;
import java.util.List;

public class Grafo {

    Vertice grafo[];  //Vetor de Listas
    private int qtdVertices;  //Quantidade de Vértices do Grafo
    private int qtdArestas;   //Quantidade de Arestas do Grafo

    public int getQtdVertices() {
        return qtdVertices;
    }
    public int getQtdArestas() {
        return qtdArestas;
    }


    /**
     * Construtor
     * @param arquivoGrafo Caminho do Arquivo
     */
    Grafo(String arquivoGrafo){
        criarGrafo(arquivoGrafo);
    }
    Grafo(int tamanho){
        grafo = new Vertice[tamanho+1];
    }

    /**
     * Lê o Arquivo, cria e preenche o Grafo
     * @param arquivoGrafo Caminho do Arquivo
     */
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
            boolean encontrado = false;         //encontrar fim do primeiro número
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

    /**
     * Insere um vétice no Grafo
     * @param verticeAtual
     * @param sucessor
     */
    public void inserirVertice(int verticeAtual, int sucessor){
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
    /**
     * Exibe Grau de Saída do Vértice
     * @param vertice
     */
    public void grauSaida(int vertice){
        System.out.println("O grau de Saída do Vértice " + vertice + " é: " + grafo[vertice].getGrauSaida());
    }
    /**
     * Exibe Grau de Entrada do Vértice
     * @param vertice
     */
    public void grauEntrada(int vertice){
        System.out.println("O grau de Entrada do Vértice " + vertice + " é: " + grafo[vertice].getGrauEntrada());
    }

    /**
     * Exibe todos os Sucessores do Vértice
     * @param vertice
     */
    public void exibirSucessores(int vertice){
        List<Integer> Sucessores = grafo[vertice].getSucessores();
        System.out.print("Os Sucessores do Vértice " + vertice + " são: {");
        for(int i=0; i < Sucessores.size(); i++){
            System.out.print("(" + Sucessores.get(i) + ")");
            if(i < Sucessores.size() - 1){
                System.out.print("; ");
            }
        }
        System.out.print("}\n");
    }

    /**
     * Exibe todos os Predecessores do Vértice
     * @param vertice
     */
    public void exibirPredecessores(int vertice){
        List<Integer> Predecessores = grafo[vertice].getPredecessores();
        System.out.print("Os Predecessores do Vértice " + vertice + " são: {");
        for(int i=0; i < Predecessores.size(); i++){
            System.out.print("(" + Predecessores.get(i) + ")");
            if(i < Predecessores.size()-1){
                System.out.print("; ");
            }
        }
        System.out.print("}\n");
    }

    public void buscaProfundidade(int verticeOrigem){
        BuscaProfundidade buscaProfundidade = new BuscaProfundidade(grafo);
        System.out.println("Árvore da Busca em Profundidade");
        System.out.println("Raiz: " + verticeOrigem);
        imprimirArvore(buscaProfundidade.buscar(verticeOrigem));
    }

    public void buscaLargura(int verticeOrigem){
        BuscaLargura buscaLargura = new BuscaLargura(grafo);
        System.out.println("Árvore da Busca em Largura");
        System.out.println("Raiz: " + verticeOrigem);
        imprimirArvore(buscaLargura.buscar(verticeOrigem));
    }

    public void imprimirArvore(int[][] arvore){
        for(int i = 0 ; i < arvore.length; i++){
            if(arvore[i][0] != 0){
                System.out.println(arvore[i][0] + " -> " +  arvore[i][1]);
            }else{
                break;
            }
        }
    }

}
