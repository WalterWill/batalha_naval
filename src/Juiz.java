public class Juiz {
    private static final String SPLACH = "S";
    private static final String ATINGIDO = "A";
    private static final String DISPARO = "D";
    private static final String EMBARCACAO = "E";

    Tabuleiro embarcacoesP1;    //Matriz com embarcacoes do Player 1
    Tabuleiro previaP1;         //matriz com a pré vizualização do tabuleiro do Player 1

    Tabuleiro embarcacoesP2;    //Matriz com embarcacoes do Player 2
    Tabuleiro previaP2;         //matriz com a pré vizualização do tabuleiro do Player 2

    int pointP1;    //Pontuação que o  Player 1 efetuou
    int pointP2;    //Pontuação que o  Player 2 efetuou

    int targetPoints; //Pontos necessarios para finalizar a partida

    Juiz(Tabuleiro embarcacoesP1, Tabuleiro previaP1, Tabuleiro embarcacoesP2, Tabuleiro previaP2){
        this.embarcacoesP1 = embarcacoesP1;
        this.embarcacoesP2 = embarcacoesP2;
        this.previaP1 = previaP1;
        this.previaP2 = previaP2;
    }

    void setPoints(int p1, int p2, int targetPoints){
        this.pointP1 = p1;
        this.pointP2 = p2;
        this.targetPoints = targetPoints;
    }

    void acerto(Jogador player){
        switch (player){
            case PLAYER1 : this.pointP1++; break;
            case PLAYER2 : this.pointP2++; break;
        }
    }

    void verificarDisparo(){

        //Verifica a tabela PREVIAP1
        for (int linha = 0; linha < this.previaP1.getLinhas(); linha++){
            for (int coluna = 0; coluna < this.previaP1.getColunas(); coluna++){
                if (this.previaP1.getCelula(linha,coluna).equals(DISPARO)){
                    if (this.embarcacoesP2.getCelula(linha,coluna).equals(EMBARCACAO)) {
                        this.previaP1.setCelula(ATINGIDO, linha, coluna);
                        this.embarcacoesP2.setCelula(ATINGIDO,linha,coluna);
                        pointP1--;
                    } else {
                        this.previaP1.setCelula(SPLACH, linha,coluna);
                    }
                }
            }
        }

        //verifica a tabela PREVIAP2
        for (int linha = 0; linha < this.previaP2.getLinhas(); linha++) {
            for (int coluna = 0; coluna < this.previaP2.getColunas(); coluna++) {
                if (this.previaP2.getCelula(linha,coluna).equals(DISPARO)){
                    if (this.embarcacoesP1.getCelula(linha,coluna).equals(EMBARCACAO)) {
                        this.previaP2.setCelula(ATINGIDO, linha, coluna);
                        this.embarcacoesP1.setCelula(ATINGIDO,linha,coluna);
                        pointP2--;
                    } else {
                        this.previaP2.setCelula(SPLACH, linha,coluna);
                    }
                }
            }
        }
    }

    boolean zerou(Jogador jogador){
        switch (jogador){
            case PLAYER1 : if(pointP1 <= targetPoints){
                return true;
            }
            break;

            case PLAYER2: if(pointP2 <= targetPoints){
                return true;
            }
        }
        return false;
    }

    boolean fimDePartida(){
        verificarDisparo();
        if (zerou(Jogador.PLAYER1) || zerou(Jogador.PLAYER2)){
            return true;
        } else {
            return false;
        }
    }

    public void setEmbarcacoesP1(Tabuleiro embarcacoesP1) {
        this.embarcacoesP1 = embarcacoesP1;
    }

    public Tabuleiro getEmbarcacoesP1() {
        return embarcacoesP1;
    }

    public void setEmbarcacoesP2(Tabuleiro embarcacoesP2) {
        this.embarcacoesP2 = embarcacoesP2;
    }

    public Tabuleiro getEmbarcacoesP2() {
        return embarcacoesP2;
    }

    public void setPreviaP1(Tabuleiro previaP1) {
        this.previaP1 = previaP1;
    }

    public Tabuleiro getPreviaP1() {
        return previaP1;
    }

    public void setPreviaP2(Tabuleiro previaP2) {
        this.previaP2 = previaP2;
    }

    public Tabuleiro getPreviaP2() {
        return previaP2;
    }
}
