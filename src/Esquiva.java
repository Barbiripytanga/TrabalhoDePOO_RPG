import java.util.Random;

public class Esquiva extends Defesa {
    private int chance;

    // Corrigido: para limitarmos a variável local
    // e só depois guardamos.
    Esquiva(int chance){
        if( chance < 0 ){ chance = 0; }
        else if ( chance > 100 ){ chance = 100; }
        this.chance = chance;
    }

    @Override
    public int danoReduzido( int dano ){
        Random rd = new Random();
        int sorteio = rd.nextInt(100);
        if( sorteio < this.chance ){
            System.out.println("Esquivou!!");
            return 0;
        }
        return dano;
    }
}
