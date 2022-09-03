import java.util.Scanner;

public class Main {
    static public Scanner e = new Scanner(System.in);


    static int menuDois(){
        System.out.println("\nO que deseja fazer agora? ");
        System.out.println("1. Informar outro Vértice ");
        System.out.println("2. Abrir outro Arquivo ");
        System.out.println("3. Sair do Programa ");
        return e.nextInt();
    }

    static public Grafo abrirArquivo(){
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

    static public void executarPrograma(){

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

                do {
                    menuDois = menuDois();
                }while (menuDois < 1 || menuDois > 3);

            }while (menuDois == 1);
        }while (menuDois == 2);
    }

    public static void main(String[] args) {

        int menuUm = 0;

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
