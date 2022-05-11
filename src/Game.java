import java.io.IOException;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) throws IOException {
        //inicialização do teclado
        Scanner teclado = new Scanner(System.in);   //Leitura a partir do teclado

        System.out.printf("Nome: ");
        String nome = teclado.nextLine();

        //Instanciacao dos usuarios
        Player usuario = new Player(nome);
        Player computador = new Player("computador");

        //Instanciacao do Juiz
        Juiz juiz = new Juiz(usuario.getEmbarcacoes(), usuario.getPrevia(),
                computador.getEmbarcacoes(), computador.getPrevia());

        juiz.setPoints(14,14, 0);

        //Instanciacao do Atirador
        Atirador atirador = new Atirador(usuario.getPrevia());

        //Posicionar embarcacoes
        Embarcacao embarcacao = new Embarcacao();
        //5 celulas
        System.out.printf("Posicionar embarcação 5 celulas na linha (0 - 9) ");
        int linha = teclado.nextInt();

        System.out.printf("Posicionar embarcação 5 celulas na coluna (0 - 9) ");
        int coluna = teclado.nextInt();

        teclado.nextLine(); // esvazia o buffer do teclado

        System.out.printf("Direcionar embarcação para D - direita | E - esquerda | C - cima | B - baixo ");
        char direcao = (char)System.in.read();

        switch (direcao){
            case 'd' : usuario.insereEmbarcacao(embarcacao, new Vetor(linha, coluna, 5, Direcao.DIREITA)); break;
            case 'e' : usuario.insereEmbarcacao(embarcacao, new Vetor(linha, coluna, 5, Direcao.ESQUERDA)); break;
            case 'c' : usuario.insereEmbarcacao(embarcacao, new Vetor(linha, coluna, 5, Direcao.CIMA)); break;
            case 'b' : usuario.insereEmbarcacao(embarcacao, new Vetor(linha, coluna, 5, Direcao.BAIXO));    break;
        }

        usuario.getEmbarcacoes().imprimirNaTela();

        //4 celulas
        System.out.printf("Posicionar embarcação 4 celulas na linha (0 - 9) ");
        linha = teclado.nextInt();

        System.out.printf("Posicionar embarcação 4 celulas na coluna (0 - 9) ");
        coluna = teclado.nextInt();

        teclado.nextLine(); // esvazia o buffer do teclado

        System.out.printf("Direcionar embarcação para D - direita | E - esquerda | C - cima | B - baixo ");
        direcao = (char)System.in.read();

        switch (direcao){
            case 'd' : usuario.insereEmbarcacao(embarcacao, new Vetor(linha, coluna, 4, Direcao.DIREITA));  break;
            case 'e' : usuario.insereEmbarcacao(embarcacao, new Vetor(linha, coluna, 4, Direcao.ESQUERDA)); break;
            case 'c' : usuario.insereEmbarcacao(embarcacao, new Vetor(linha, coluna, 4, Direcao.CIMA)); break;
            case 'b' : usuario.insereEmbarcacao(embarcacao, new Vetor(linha, coluna, 4, Direcao.BAIXO));    break;
        }

        usuario.getEmbarcacoes().imprimirNaTela();

        //3 celulas
        System.out.printf("Posicionar embarcação 3 celulas na linha (0 - 9) ");
        linha = teclado.nextInt();

        System.out.printf("Posicionar embarcação 2 celulas na coluna (0 - 9) ");
        coluna = teclado.nextInt();

        teclado.nextLine(); // esvazia o buffer do teclado

        System.out.printf("Direcionar embarcação para D - direita | E - esquerda | C - cima | B - baixo ");
        direcao = (char)System.in.read();

        switch (direcao){
            case 'd' : usuario.insereEmbarcacao(embarcacao, new Vetor(linha, coluna, 3, Direcao.DIREITA));  break;
            case 'e' : usuario.insereEmbarcacao(embarcacao, new Vetor(linha, coluna, 3, Direcao.ESQUERDA)); break;
            case 'c' : usuario.insereEmbarcacao(embarcacao, new Vetor(linha, coluna, 3, Direcao.CIMA)); break;
            case 'b' : usuario.insereEmbarcacao(embarcacao, new Vetor(linha, coluna, 3, Direcao.BAIXO));    break;
        }

        usuario.getEmbarcacoes().imprimirNaTela();

        //2 celulas
        System.out.printf("Posicionar embarcação 2 celulas na linha (0 - 9) ");
        linha = teclado.nextInt();

        System.out.printf("Posicionar embarcação 2 celulas na coluna (0 - 9) ");
        coluna = teclado.nextInt();

        teclado.nextLine(); // esvazia o buffer do teclado

        System.out.printf("Direcionar embarcação para D - direita | E - esquerda | C - cima | B - baixo ");
        direcao = (char)System.in.read();

        switch (direcao){
            case 'd' : usuario.insereEmbarcacao(embarcacao, new Vetor(linha, coluna, 2, Direcao.DIREITA));  break;
            case 'e' : usuario.insereEmbarcacao(embarcacao, new Vetor(linha, coluna, 2, Direcao.ESQUERDA)); break;
            case 'c' : usuario.insereEmbarcacao(embarcacao, new Vetor(linha, coluna, 2, Direcao.CIMA)); break;
            case 'b' : usuario.insereEmbarcacao(embarcacao, new Vetor(linha, coluna, 2, Direcao.BAIXO));    break;
        }

        usuario.getEmbarcacoes().imprimirNaTela();

        System.out.println("O computador esta se preparando");

        //Agente POSICIONADOR entra em ação
        Posicionador posicionador = new Posicionador(new Tabuleiro(10, 10));
        posicionador.posicionar(embarcacao, 5);
        posicionador.posicionar(embarcacao, 4);
        posicionador.posicionar(embarcacao, 3);
        posicionador.posicionar(embarcacao, 2);

        computador.setEmbarcacoes(posicionador.getTabuleiro());

        //Finalizado as preparações

        while (!juiz.fimDePartida()){
            //Vez do usuario
            System.out.println("===Sua visao do inimigo===");
            juiz.getPreviaP2().imprimirNaTela();
            System.out.printf("Digite a linha para o disparo (0 - 9) ");
            linha = teclado.nextInt();

            System.out.printf("Digite a coluna para o disparo (0 - 9) ");
            coluna = teclado.nextInt();

            //Efetuar disparo
            juiz.getPreviaP2().setCelula("D", linha, coluna);

            //Juiz verifica o diparo
            juiz.setEmbarcacoesP1(usuario.getEmbarcacoes());
            juiz.setEmbarcacoesP2(computador.getEmbarcacoes());

            juiz.setPreviaP1(usuario.getPrevia());
            juiz.setPreviaP2(atirador.getTabuleiro());

            juiz.verificarDisparo();

            usuario.setEmbarcacoes(juiz.getEmbarcacoesP1());
            usuario.setPrevia(juiz.getPreviaP1());

            computador.setEmbarcacoes(juiz.getEmbarcacoesP2());
            computador.setPrevia(juiz.getPreviaP2());
            atirador.setTabuleiro(juiz.getPreviaP2());

            //Vez do Computador
            atirador.disparar();

            //Juiz verifica o diparo
            juiz.setEmbarcacoesP1(usuario.getEmbarcacoes());
            juiz.setEmbarcacoesP2(computador.getEmbarcacoes());

            juiz.setPreviaP1(usuario.getPrevia());
            juiz.setPreviaP2(atirador.getTabuleiro());

            juiz.verificarDisparo();

            usuario.setEmbarcacoes(juiz.getEmbarcacoesP1());
            usuario.setPrevia(juiz.getPreviaP1());

            computador.setEmbarcacoes(juiz.getEmbarcacoesP2());
            computador.setPrevia(juiz.getPreviaP2());
            atirador.setTabuleiro(juiz.getPreviaP2());

            //Eh mostrado o disparo do computador
            usuario.getEmbarcacoes().imprimirNaTela();

            //Juiz verifica se pode finalizar a partida
            juiz.fimDePartida();
        }


    }
}
