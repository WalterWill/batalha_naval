public class Vetor {
    int linha;
    int coluna;
    int extensao;
    Direcao direcao;

    Vetor(int linha, int coluna, int extensao, Direcao direcao){
        this.linha = linha;
        this.coluna = coluna;
        this.extensao = extensao;
        this.direcao = direcao;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getLinha() {
        return linha;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    public int getColuna() {
        return coluna;
    }

    public void setDirecao(Direcao direcao) {
        this.direcao = direcao;
    }

    public Direcao getDirecao() {
        return direcao;
    }

    public void setExtensao(int extensao) {
        this.extensao = extensao;
    }

    public int getExtensao() {
        return extensao;
    }
}
