// Mistura as duas defesas: primeiro tenta ESQUIVAR do golpe;
// se não esquivar, o ESCUDO bloqueia parte do dano.
// Reaproveitamento do Escudo e Esquiva (composição).

public class DefesaMista extends Defesa {
    private Escudo escudo;
    private Esquiva esquiva;

    DefesaMista(int reducao, int chanceEsquiva){
        this.escudo = new Escudo(reducao);
        this.esquiva = new Esquiva(chanceEsquiva);
    }

    @Override
    public int danoReduzido( int dano ){
        int aposEsquiva = this.esquiva.danoReduzido(dano);
        if( aposEsquiva == 0 ){
            return 0; // esquivou: não sobra dano nem para o escudo bloquear
        }
        return this.escudo.danoReduzido(aposEsquiva);
    }
}