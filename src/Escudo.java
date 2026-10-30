public class Escudo extends Defesa {
    private int reducao;

    Escudo(int reducao){
        if( reducao < 0 ) {
            reducao = 0;
        }
        this.reducao = reducao;
    }

    @Override
    public int danoReduzido( int dano ){
        if( dano < this.reducao ){
            return 0;
        }
        return dano - this.reducao;
    }
}
