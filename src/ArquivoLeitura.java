import java.io.*;

public class ArquivoLeitura {

    private BufferedReader entrada;


    public ArquivoLeitura(String caminhoArquivo) {
        try {
            entrada = new BufferedReader(new FileReader(caminhoArquivo));
        } catch (FileNotFoundException excecao) {
            System.out.println("Arquivo não encontrado");
        }
    }
    public String Ler(){
            String textoArquivo = null;

        try {
             textoArquivo = entrada.readLine();
        }catch (EOFException excecao) { //Exceção de final de arquivo.
            textoArquivo = null;
        }catch (IOException excecao) {
            System.out.println("Erro de leitura: " + excecao);
            textoArquivo = null;
        }finally {
            return textoArquivo;
        }

    }
    public void fecharArquivo() {
        try {
            entrada.close();
        }catch (IOException excecao) {
            System.out.println("Erro no fechamento do arquivo de leitura: " + excecao);
        }
    }
}
