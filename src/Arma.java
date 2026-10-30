import java.util.Random;

public abstract class Arma {
    
    private String nome;
    private int ataque;
    private int chance;


    //municao
    private boolean usaMunicao;
    private int municao;
    private int municaoMaxima;

    //arma com municao
    public Arma(int chance, int ataque, String nome, int municao) {
        this.chance = chance;
        this.ataque = ataque;
        this.nome = nome;
        this.usaMunicao=true;
        this.municao= municao;
        this.municaoMaxima = municao;
    }

    //arma sem municao
    public Arma(String nome, int ataque, int chance) {
        this.nome = nome;
        this.ataque = ataque;
        this.chance = chance;
        this.usaMunicao = false;
    }

    public Arma(String nome, int ataque) {
        this.nome = nome;
        this.ataque = ataque;
        this.chance = 100;
    }

    public String getNome() {
        return this.nome;
    }

    //Só pode ser usada se não depende de munição ou se ainda tem munição
    public boolean podeUsar(){
        return !this.usaMunicao|| this.municao>0;
    }
    public void restauraMunicao(){
        this.municao = this.municaoMaxima;
    }

    // Usado no upgrade do jogador dando bonus de ataque ou municao
    public void melhora( int bonusAtaque, int bonusMunicao ){
        this.ataque += bonusAtaque;
        if( this.usaMunicao ){
            this.municaoMaxima += bonusMunicao;
            this.municao += bonusMunicao;
        }
    }
    public void mensagem(){
        String info = "";
        if( this.usaMunicao ){
            info = " - munição: " + this.municao;
            if( this.municao == 0 ){
                info += " (esgotada)";
            }
        }
        System.out.println( this.nome + " - dano: " +
                this.ataque + " - chance: " +
                this.chance + "%" + info );
    }

    public void fazAtaque( Criatura criatura ){
        if( !podeUsar() ){
            System.out.println(this.nome + " está sem munição!");
            return;
        }
        if( this.usaMunicao ){
            this.municao--; // gasta munição a cada uso, acertando ou errando
        }

        Random rd = new Random();
        int sorteio = rd.nextInt(100);
        if( sorteio < this.chance ){
            criatura.tomaDano(this.ataque);
        } else {
            System.out.println("Errou!");
        }
    }

}


