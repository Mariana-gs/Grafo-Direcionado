import java.util.Scanner;

public class Main {

    static public void executarPrograma(){
        Scanner e = new Scanner(System.in);
        boolean excecao = true;
        String caminho;

        System.out.println("\n == Abrir Arquivo ==");
        System.out.println(" Informe o Caminho do Arquivo com os Dados do Grafo:" );

        while (excecao) {
            caminho = e.nextLine();
            try {
                Grafo grafo = new Grafo(caminho);
                excecao = false;
            } catch (Exception E) {
                System.out.println(" Não foi Possível Abrir o Arquivo!");
                System.out.println(" Por Favor Informe o Caminho Novamente: ");
            }
        }

        
    }


    public static void main(String[] args) {

        Scanner e = new Scanner(System.in);
        int menuUm = 0;

        while (menuUm != 1 && menuUm != 2) {
            System.out.println("\n===== Implementação de Grafos Direcionados =====");
            System.out.println(" == Menu Principal ==");
            System.out.println(" 1. Abrir Arquivo ");
            System.out.println(" 2. Sair ");
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
