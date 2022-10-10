import java.util.Scanner;

/**
 * @author Mariana Soares
 */

public class Main {
    static public Scanner e = new Scanner(System.in);

    /**
     * Exibe o menu secundário.
     * @return Opção escolhida
     */
    public static int menuDois(){
        System.out.println("\nO que deseja fazer agora? ");
        System.out.println("1. Informar outro Vértice ");
        System.out.println("2. Abrir outro Arquivo ");
        System.out.println("3. Sair do Programa ");
        return e.nextInt();
    }

    /**
     * Lê o Arquivo informado pelo usuário e cria o Grafo.
     * @return Grafo criado
     */
    public static Grafo abrirArquivo(){
        Grafo grafo = null;
        boolean excecao = true;
        String caminho = "";


        System.out.println("\n == Abrir Arquivo ==");
        System.out.println(" Informe o Caminho do Arquivo com os Dados do Grafo:");
        e.nextLine();
        caminho = e.nextLine();

        while (excecao) {
            try {
                grafo = new Grafo(caminho);
                System.out.println(" Grafo criado com Sucesso!");
                excecao = false;
            } catch (Exception E) {
                System.out.println(" Não foi Possível Abrir o Arquivo!");
                System.out.println(" Por Favor Informe o Caminho Novamente: ");
                excecao = true;
            }
        }
        System.out.println("\n O grafo informado possui: \n-> " + grafo.getQtdVertices() + " Vértices\n-> " + grafo.getQtdArestas() + " Arestas");

        return grafo;
    }

    /**
     * Executa parte principal do programa e repetições de Menu
     * de acordo com a opção selecionada
     */
    public static void executarPrograma(){

        int vertice = 0;
        int menuDois = 0;
        Grafo grafo = null;

        do {
            grafo = abrirArquivo();
            do {
                System.out.println(" Informe um vértice para continuar: ");
                vertice = e.nextInt();
                System.out.println("\nInformações sobre o vértice: ");
                grafo.grauSaida(vertice);
                grafo.grauEntrada(vertice);
                grafo.exibirSucessores(vertice);
                grafo.exibirPredecessores(vertice);
                grafo.buscaProfundidade(vertice);

                do {
                    menuDois = menuDois();
                }while (menuDois < 1 || menuDois > 3);  //Opção Não Existente

            }while (menuDois == 1);                     //Informar Novo Vértice
        }while (menuDois == 2);                         //Abrir Outro Arquivo
    }

    /**
     * Classe principal, exibe menu principal
     * @param args
     */
    public static void main(String[] args) {

        int menuUm = 0; //opção do menu principal
        while (menuUm != 1 && menuUm != 2) {
            System.out.println("\n===== Implementação de Grafos Direcionados =====");
            System.out.println(" == Menu Principal ==");
            System.out.println(" 1. Abrir Arquivo ");
            System.out.println(" 2. Sair do Programa");
            menuUm = e.nextInt();
        }
        switch (menuUm){
            case 1:
                executarPrograma();
                break;
            case 2:
                System.out.println("Programa Finalizado!");
                e.close();
                break;
        }






    }
}
