public abstract class Criatura {
    private String nome;
    private int vida;
    private int vidaMaxima;
	
    public Criatura(String nome, int vida) {
		this.nome = nome;
		this.vida = vida;
        this.vidaMaxima= vida; //guarda a vida inicial para poder restaurar
	}

    public abstract void fraseApresentacao();
    public abstract void fraseMorte();
    public abstract void fazAtaque( Criatura criatura );

    public void mostraVida(){
        System.out.println(this.nome + ": " + this.vida + " pontos de vida.");
    }

    public String getNome() {
        return this.nome;
    }
    public int getVida() {
        return this.vida;
    }

    public boolean estaVivo() {
        return this.vida > 0;
    }

    public void tomaDano(int dano){
        this.vida -= dano;
        if( this.vida < 0 ){
            this.vida = 0;
        }
        System.out.println(this.nome + " toma " + dano + " de dano.");
    }
    public boolean vidaCritica( int valorCritico ){
        return this.vida < valorCritico;
    }

    // Devolve a vida ao valor máximo (usado entre as batalhas)
    public void restauraVida(){
        this.vida = this.vidaMaxima;
    }

    // Usado no upgrade: aumenta o teto de vida
    public void aumentaVidaMaxima( int bonus ){
        this.vidaMaxima += bonus;
    }
    public void upgrade(){}
}
