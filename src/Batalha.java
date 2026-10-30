// Batalha é um confronto entre um jogador e UM inimigo.

public class Batalha {
    private Criatura jogador;
    private Criatura inimigo;

    // Guardados para o relatório final
    private boolean jogadorVenceu = false;
    private int turnos = 0;
    private int vidaRestanteJogador = 0;

    public Batalha(Criatura jogador, Criatura inimigo) {
        this.jogador = jogador;
        this.inimigo = inimigo;
    }

    public void executa(){
        System.out.println("Começa a Batalha: " + jogador.getNome() + " x " + inimigo.getNome());
        System.out.println("################\n");

        jogador.fraseApresentacao();
        inimigo.fraseApresentacao();

        while(true){
            this.turnos++;
            jogador.mostraVida();
            inimigo.mostraVida();

            jogador.fazAtaque(inimigo);
            if( inimigo.estaVivo() ){
                inimigo.fazAtaque(jogador);
            }

            if( !jogador.estaVivo() ){
                jogador.fraseMorte();
                System.out.println(inimigo.getNome() + " venceu.");
                this.jogadorVenceu = false;
                break;
            }
            if( !inimigo.estaVivo() ){
                inimigo.fraseMorte();
                System.out.println(jogador.getNome() + " venceu.");
                this.jogadorVenceu = true;
                break;
            }

            jogador.upgrade();
            inimigo.upgrade();
        }
        // Anotado ANTES de o Jogo restaurar a vida do jogador
        this.vidaRestanteJogador = jogador.getVida();
    }

    public boolean jogadorVenceu(){
        return this.jogadorVenceu;
    }

    public String resultado(){
        String texto = "contra " + inimigo.getNome() + ": ";
        if( jogadorVenceu ){
            texto += "VITÓRIA em " + turnos + " turnos (vida restante: " + vidaRestanteJogador + ")";
        } else {
            texto += "DERROTA em " + turnos + " turnos";
        }
        return texto;
    }
}