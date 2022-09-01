import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner e = new Scanner(System.in);

        System.out.println("\n===== Implementação de Grafos Direcionados =====");
        System.out.println("Informe o Caminho do Arquivo com os Dados do Grafo:" );


        //String caminho = e.nextLine();
        String caminho = "D:\\GitHub\\Grafo Direcionado\\src\\Arquivos\\graph-test-4.txt";
        Grafo grafo = new Grafo(caminho);


        grafo.exibirSucessores(1);
        grafo.exibirPredecessores(2);
        grafo.grauSaida(2);
        grafo.grauEntrada(2);



    }
}
