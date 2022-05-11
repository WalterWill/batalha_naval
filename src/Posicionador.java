import java.util.Random;

// O Posicionador é responsavel por posicionar as embarcacoes na matriz
public class Posicionador {
    private static final int MINIMO_PADRAO = 0;
    Tabuleiro tabuleiro;

    Posicionador(Tabuleiro a){
        this.tabuleiro = a;
    }

    public void setTabuleiro(Tabuleiro a){
        this.tabuleiro = a;
    }

    public Tabuleiro getTabuleiro(){
        return this.tabuleiro;
    }

    private int getRandom(){
        int nMax = this.tabuleiro.getLinhas();
        Random random = new Random();
        return random.nextInt(nMax - 1);        //Como o index é sempre 1 numero menor que o tamanho da tabela
                                                    //Eh necessario ajustar essa diferenca
    }

    private Direcao getDirecao(){
        Direcao direcao;
        Random random = new Random();
        int numero = random.nextInt(3);

        switch (numero){
            case 0 : direcao = Direcao.DIREITA; break;
            case 1 : direcao = Direcao.BAIXO;   break;
            case 2 : direcao = Direcao.ESQUERDA;    break;
            case 3 : direcao = Direcao.CIMA;    break;

            default: direcao = Direcao.DIREITA; break;
        }

        return direcao;
    }

    public void posicionar(Embarcacao embarcacao, int extensao){

        //O agente seleciona as coordenadas
        int linha = getRandom();
        int coluna = getRandom();

        //O agente seleciona a direcao da embarcacao
        boolean ehPossivel = false;     //indica que eh possivel posicionar a embarcacao
        Direcao direcao;
        boolean status = false;

        Vetor vetor = new Vetor(linha, coluna, extensao, Direcao.CIMA);

        while (!ehPossivel){
            linha = getRandom();
            coluna = getRandom();
            direcao = getDirecao();

            vetor.setLinha(linha);
            vetor.setColuna(coluna);
            vetor.setDirecao(direcao);

            status = checaExtensao(vetor);

            if (status){
                status = checarObstrucao(vetor);
                if (status){
                    ehPossivel = true;
                }
            }
        }

        //O agente efetua a escrita no tabuleiro
        insereEmbarcacao(embarcacao, vetor);
    }

    public boolean checaExtensao(Vetor vetor) {
        Vetor vetorAux = new Vetor(vetor.getLinha(),vetor.getColuna(),vetor.getExtensao(),vetor.getDirecao());     //vetor temporario para ser testado e manupulado sem afetar o vetor principal
        vetorAux.setExtensao(vetorAux.getExtensao() - 1);  //Deve ser decrementado uma unidade pois ela já ocupa a posicao informada

        boolean ehPossivel = false;

        int linhaIncremento = MINIMO_PADRAO;
        int colunaIncremento = MINIMO_PADRAO;

        int linhaLimite = this.tabuleiro.getLinhas() - 1;
        int colunaLimite = this.tabuleiro.getColunas() - 1;

        switch (vetor.getDirecao()) {
            case CIMA : linhaIncremento -= vetorAux.getExtensao();   break;
            case BAIXO: linhaIncremento += vetorAux.getExtensao();   break;
            case DIREITA: colunaIncremento += vetorAux.getExtensao();  break;
            case ESQUERDA: colunaIncremento -= vetorAux.getExtensao(); break;
        }

        int linhaResultante = vetorAux.getLinha() + linhaIncremento;
        int colunaResultante = vetorAux.getColuna() + colunaIncremento;

        if (linhaResultante >= MINIMO_PADRAO && linhaResultante <= linhaLimite){
            if (colunaResultante >= MINIMO_PADRAO && colunaResultante <= colunaLimite){
                ehPossivel = true;
            }
        }

        return ehPossivel;
    }

    boolean checarObstrucao(Vetor vetor){
        boolean resultado = false;
        switch (vetor.getDirecao()){
            case CIMA : resultado = checarCima(vetor);   break;
            case BAIXO : resultado = checarBaixo(vetor);    break;
            case ESQUERDA : resultado = checarEsquerda(vetor);  break;
            case DIREITA : resultado = checarDireita(vetor);    break;
        }
        return resultado;

    }

    boolean checarCima(Vetor vetor){
        int i = 0;
        boolean semObstrucao = true;
        while (i < vetor.getExtensao() && semObstrucao) {
            if (this.tabuleiro.getCelula(vetor.getLinha() - i, vetor.getColuna()) == "E") {
                semObstrucao = false;
                return semObstrucao;
            }
            i++;
        }
        return semObstrucao;

    }

    boolean checarBaixo(Vetor vetor){
        int i = 0;
        boolean semObstrucao = true;
        while (i < vetor.getExtensao() && semObstrucao) {
            if (this.tabuleiro.getCelula(vetor.getLinha() + i, vetor.getColuna()) == "E") {
                semObstrucao = false;
                return semObstrucao;
            }
            i++;
        }
        return semObstrucao;

    }

    boolean checarDireita(Vetor vetor){
        int i = 0;
        boolean semObstrucao = true;
        while (i < vetor.getExtensao() && semObstrucao) {
            if (this.tabuleiro.getCelula(vetor.getLinha(), vetor.getColuna() + i) == "E") {
                semObstrucao = false;
                return semObstrucao;
            }
            i++;
        }
        return semObstrucao;

    }

    boolean checarEsquerda(Vetor vetor){
        int i = 0;
        boolean semObstrucao = true;
        while (i < vetor.getExtensao() && semObstrucao) {
            if (this.tabuleiro.getCelula(vetor.getLinha(), vetor.getColuna() - i) == "E") {
                semObstrucao = false;
                return semObstrucao;
            }
            i++;
        }
        return semObstrucao;

    }

    public void insereEmbarcacao(Embarcacao embarcacao, Vetor vetor){
        switch (vetor.getDirecao()){
            case DIREITA : insereDireita(embarcacao, vetor);   break;
            case ESQUERDA: insereEsquerda(embarcacao, vetor);   break;
            case CIMA: insereCima(embarcacao, vetor);   break;
            case BAIXO: insereBaixo(embarcacao, vetor);   break;
        }
    }

    private void insereDireita(Embarcacao embarcacao, Vetor vetor){
        for (int i = 0; i < vetor.getExtensao(); i++){
            this.tabuleiro.setCelula(embarcacao.getSigla(), vetor.getLinha(), vetor.getColuna() + i);
        }
    }

    private void insereEsquerda(Embarcacao embarcacao, Vetor vetor){
        for (int i = 0; i < vetor.getExtensao(); i++){
            this.tabuleiro.setCelula(embarcacao.getSigla(), vetor.getLinha(), vetor.getColuna() - i);
        }
    }

    private void insereCima(Embarcacao embarcacao, Vetor vetor){
        for (int i = 0; i < vetor.getExtensao(); i++){
            this.tabuleiro.setCelula(embarcacao.getSigla(), vetor.getLinha() - i, vetor.getColuna());
        }
    }

    private void insereBaixo(Embarcacao embarcacao, Vetor vetor){
        for (int i = 0; i < vetor.getExtensao(); i++){
            this.tabuleiro.setCelula(embarcacao.getSigla(), vetor.getLinha() + i, vetor.getColuna());
        }
    }
}
