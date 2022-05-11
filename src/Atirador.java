import java.util.Random;

public class Atirador {
    private static final String SPLACH = "S";
    private static final String ATINGIDO = "A";

    private static final String DISPARO = "D";
    Tabuleiro tabuleiro;

    Atirador(Tabuleiro tabuleiro){
        this.tabuleiro = tabuleiro;
    }

    public void setTabuleiro(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    private int getRandom(){
        int nMax = this.tabuleiro.getLinhas();
        Random random = new Random();
        return random.nextInt(nMax - 1);        //Como o index é sempre uma unidade menor que o tamanho da tabela
                                                        //Eh necessario ajustar essa diferenca
    }

    void disparar(){
        boolean disparado = false;
        while (!disparado){
            //Selecionar local
            int linha = getRandom();
            int coluna = getRandom();

            //Verifica se local ja foi alvo
            if(alvoVirgem(linha, coluna)){
                this.tabuleiro.setCelula(DISPARO, linha, coluna);
                disparado = true;
            }
        }
    }

    private boolean alvoVirgem(int linha, int coluna) {
        String alvo = this.tabuleiro.getCelula(linha, coluna);

        if (alvo.equals(SPLACH) || alvo.equals(ATINGIDO)){
            return false;
        }
        return true;
    }
}
