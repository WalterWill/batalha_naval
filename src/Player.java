public class Player {
    Tabuleiro embarcacoes;
    Tabuleiro previa;

    String nome;

    Player(String nome){
        this.nome = nome;
        this.embarcacoes = new Tabuleiro(10,10);
        this.embarcacoes.oceano();
        this.previa = new Tabuleiro(10,10);
        this.previa.oceano();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setEmbarcacoes(Tabuleiro embarcacoes) {
        this.embarcacoes = embarcacoes;
    }

    public Tabuleiro getEmbarcacoes() {
        return embarcacoes;
    }

    public void setPrevia(Tabuleiro previa) {
        this.previa = previa;
    }

    public Tabuleiro getPrevia() {
        return previa;
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
            this.embarcacoes.setCelula(embarcacao.getSigla(), vetor.getLinha(), vetor.getColuna() + i);
        }
    }

    private void insereEsquerda(Embarcacao embarcacao, Vetor vetor){
        for (int i = 0; i < vetor.getExtensao(); i++){
            this.embarcacoes.setCelula(embarcacao.getSigla(), vetor.getLinha(), vetor.getColuna() - i);
        }
    }

    private void insereCima(Embarcacao embarcacao, Vetor vetor){
        for (int i = 0; i < vetor.getExtensao(); i++){
            this.embarcacoes.setCelula(embarcacao.getSigla(), vetor.getLinha() - i, vetor.getColuna());
        }
    }

    private void insereBaixo(Embarcacao embarcacao, Vetor vetor){
        for (int i = 0; i < vetor.getExtensao(); i++){
            this.embarcacoes.setCelula(embarcacao.getSigla(), vetor.getLinha() + i, vetor.getColuna());
        }
    }
}
