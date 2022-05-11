import org.junit.Assert;
import org.junit.Test;

public class PosicionadorTest {
    @Test
    public void DevePermitirPosicionarParaCima(){
        Tabuleiro tabu = new Tabuleiro(10, 10);
        Posicionador agente = new Posicionador(tabu);
        Vetor vetor = new Vetor(9, 0, 10, Direcao.CIMA);

        boolean valorRecebido = agente.checaExtensao(vetor);
        boolean valorExperado = true;

        Assert.assertEquals(valorExperado, valorRecebido);
    }

    @Test
    public void DevePermitirPosicionarParaBaixo(){
        Tabuleiro tabu = new Tabuleiro(10, 10);
        Posicionador agente = new Posicionador(tabu);
        Vetor vetor = new Vetor(0, 0, 10,Direcao.BAIXO);

        boolean valorRecebido = agente.checaExtensao(vetor);
        boolean valorExperado = true;

        Assert.assertEquals(valorExperado, valorRecebido);
    }

    @Test
    public void DevePermitirPosicionarParaDireita(){
        Tabuleiro tabu = new Tabuleiro(10, 10);
        Posicionador agente = new Posicionador(tabu);
        Vetor vetor = new Vetor(0, 0, 10,Direcao.DIREITA);

        boolean valorRecebido = agente.checaExtensao(vetor);
        boolean valorExperado = true;

        Assert.assertEquals(valorExperado, valorRecebido);
    }

    @Test
    public void DevePermitirPosicionarParaEsquerda(){
        Tabuleiro tabu = new Tabuleiro(10, 10);
        Posicionador agente = new Posicionador(tabu);
        Vetor vetor = new Vetor(9, 9, 10,Direcao.ESQUERDA);

        boolean valorRecebido = agente.checaExtensao(vetor);
        boolean valorExperado = true;

        Assert.assertEquals(valorExperado, valorRecebido);
    }

    @Test
    public void DeveInserirEmbardcacao(){
        Tabuleiro tabu = new Tabuleiro(10, 10);
        tabu.oceano();
        Posicionador agente = new Posicionador(tabu);
        Vetor vetor = new Vetor(0, 1, 3,Direcao.BAIXO);
        Embarcacao navio = new Embarcacao();

        agente.posicionar(navio, 5);
        agente.posicionar(navio, 4);
        agente.posicionar(navio, 3);
        agente.posicionar(navio, 2);
        agente.posicionar(navio, 1);

        agente.getTabuleiro().imprimirNaTela();
    }
}
