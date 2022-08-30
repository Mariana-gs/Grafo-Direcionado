import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner e = new Scanner(System.in);

        System.out.println("===== Implementação de Grafos Direcionados =====");
        System.out.println("Informe o Caminho do Arquivo com os Dados do Grafo:" );


        String caminho = e.nextLine();
        Grafo grafo = new Grafo(caminho);


    }
}
