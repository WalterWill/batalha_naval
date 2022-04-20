import java.awt.*;
import java.util.ArrayList;

public class Tabuleiro {
    String[][] matriz;

    //Declara a matriz com as dimensões informadas
    Tabuleiro(int linha, int coluna){
        this.matriz = new String[linha][coluna];
    }

    //Retorna conteudo da celula informada pela posição
    String getCelula(int linha, int coluna){
        return this.matriz[linha][coluna];
    }

    //Preenche a celula com o conteudo informado
    void setCelula(String conteudo, int linha, int coluna){
        this.matriz[linha][coluna] = conteudo;
    }

    //Preenche a matriz com o conteudo informado
    void preencher(String conteudo){
        for (int i = 0; i < this.matriz.length; i++){
            for (int j = 0; j < this.matriz[0].length; j++){
                this.matriz[i][j] = conteudo;
            }
        }
    }

    //Retorna a quantidade de linhas da matriz
    int getLinhas(){
        return this.matriz.length;
    }

    //Retorna a quantidade de colunas da matriz
    int getColunas(){
        return this.matriz[0].length;
    }
}
