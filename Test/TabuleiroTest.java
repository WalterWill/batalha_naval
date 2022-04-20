import org.junit.Assert;
import org.junit.Test;

public class TabuleiroTest {
    @Test
    public void CriaTabelaComTamanhoInformado(){
        //Define valores para o teste
        int linhas = 10;
        int colunas = 10;

        //Realiza a ação a ser testada
        Tabuleiro a = new Tabuleiro(linhas, colunas);

        //Recolhe os resultados para verificar se estão corretos
        int linhasCriadas = a.getLinhas();
        int colunasCriadas = a.getColunas();

        //Verificação se os resultados estão corretos
        //AssertEquals compara os valores das variaveis.
        //Se estiverem iguais, o teste é validado
        //Se estiverem diferentes, o teste é reprovado
        Assert.assertEquals(linhas, linhasCriadas); //Verifica numero de linhas
        Assert.assertEquals(colunas, colunasCriadas);   //Verifica numero de colunas
    }
}
