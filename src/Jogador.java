public class Jogador extends Criatura {

    private Arma[] armas;

    //Resgate Explosivo! Qual é o seu nome, agente?"
    public Jogador(String nome, Arma[] armas ) {
        super(nome, 1000);
        this.armas = armas;
    }

    // Mostra o menu (com a munição de cada arma) e devolve a arma escolhida.
    // Armas sem munição não podem ser escolhidas.
    protected Arma escolheArma(){
        System.out.println("Escolha sua arma:");
        for( int i = 0; i < armas.length; i++ ){
            System.out.print( (i + 1) + ") " );
            armas[i].mensagem();
        }

        while( true ){
            int escolha = Entrada.lerInt();
            if( escolha < 1 || escolha > armas.length ){
                System.out.print("Número inválido. Digite novamente: ");
            } else if( !armas[escolha-1].podeUsar() ){
                System.out.print( armas[escolha-1].getNome() + " está sem munição. Escolha outra: ");
            } else {
                return armas[escolha-1];
            }
        }
    }

    private boolean temArmaUsavel(){
        for( Arma arma : armas ){
            if( arma.podeUsar() ){
                return true;
            }
        }
        return false;
    }

    @Override
    public void fazAtaque(Criatura criatura) {
        // Proteção: se nenhuma arma puder ser usada, o menu nunca terminaria
        if( !temArmaUsavel() ){
            System.out.println(getNome() + " não tem nenhuma arma utilizável!");
            return;
        }
        escolheArma().fazAtaque(criatura);
    }

    // Chamado entre as batalhas: vida e munição de volta ao máximo
    public void restaura(){
        restauraVida();
        for( Arma arma : armas ){
            arma.restauraMunicao();
        }
    }

    // Upgrade recebido antes da 3ª batalha
    public void recebeUpgrade(){
        final int BONUS_VIDA = 200;
        final int BONUS_DANO = 30;
        final int BONUS_MUNICAO = 3;

        aumentaVidaMaxima(BONUS_VIDA);
        for( Arma arma : armas ){
            arma.melhora(BONUS_DANO, BONUS_MUNICAO);
        }
        restaura(); // já começa a próxima batalha com tudo cheio
        System.out.println("*** UPGRADE! ***");
        System.out.println("Vida máxima +" + BONUS_VIDA +
                ", todas as armas +" + BONUS_DANO + " de dano" +
                " e +" + BONUS_MUNICAO + " de munição nas armas que usam.");
    }

    @Override
    public void fraseApresentacao() {
        System.out.println("Eu to volta na briga! Se liguem, to cheia de brinquedo barril");
    }

    @Override
    public void fraseMorte() {
        System.out.println("Desculpa Killjoy");
    }

}

    //elestem nem chance
    //boom
    //eu to volta na briga se liguem to cheia d ebrinquedo barriu
    //querem dancar ha deixem que eu canto
    //viu eh tudo teimoso e arregao
    //chegou o raggae

    //se foi
    //de prercisao
    //ultimo infeliz morto
    // te explodi


    //a que cheirinho de vitoria e polvora

    //killjoy para raze quando derrotar o ultimo
    //Raze, Freudin
    //Se eu ver um giroscopio fora do lugar,eu trannco vc para fora do laboratorio
    

