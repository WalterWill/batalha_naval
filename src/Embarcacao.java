

public class Embarcacao {

    private static final String SIGLA_PADRAO = "E";
    private String sigla;

    Embarcacao(){
        this.sigla = SIGLA_PADRAO;
    }

    void setSigla(String a){
        this.sigla = a;
    }

    String getSigla(){
        return this.sigla;
    }

}
