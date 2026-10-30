public class Jogo {

    static final int TOTAL_BATALHAS = 3;

    // Cria um inimigo NOVO a cada batalha (assim vida e upgrades não "vazam" de uma luta para outra)
    static Inimigo criaInimigo( int numero ){
        switch( numero ){
            case 0:  return new Viper();
            case 1:  return new Omen();
            default: return new Chamber();
        }
    }

    // Mostra as opções e devolve a arma escolhida pelo jogador
    static Arma escolheArma( String tipo, Arma[] opcoes ){
        System.out.println("\nEscolha sua " + tipo + ":");
        for( int i = 0; i < opcoes.length; i++ ){
            System.out.print( (i + 1) + ") " );
            opcoes[i].mensagem();
        }
        int escolha = Entrada.lerInt();
        while( escolha < 1 || escolha > opcoes.length ){
            System.out.print("Número inválido. Digite novamente: ");
            escolha = Entrada.lerInt();
        }
        return opcoes[escolha-1];
    }

    public static void main(String[] args){

        // --- Montagem do jogador ---
        System.out.print("Qual é o seu nome, agente? ");
        String nome = Entrada.lerTexto();

        // Curta: Faca ou Espada (nunca acabam). Longa: Ghost ou Vandal (têm munição)
        Arma curta = escolheArma("arma de CURTA distância",
                new Arma[]{ new Faca(), new Espada() });
        Arma longa = escolheArma("arma de LONGA distância",
                new Arma[]{ new Ghost(), new Vandal() });

        Jogador jogador = new Jogador(nome, new Arma[]{ curta, longa });

        // Começo a história só depois de montar o jogador, porque uso o nome dele
        Historia.abertura(nome);

        // --- Sequência de batalhas ---
        Batalha[] batalhas = new Batalha[TOTAL_BATALHAS];
        int realizadas = 0;
        boolean venceuTudo = true;

        for( int i = 0; i < TOTAL_BATALHAS; i++ ){

            // Upgrade antes da terceira batalha (índice 2)
            if( i == 2 ){
                System.out.println("\n=== Antes do desafio final... ===");
                Historia.antesDoUpgrade(); // cena da caixa da Killjoy
                jogador.recebeUpgrade();
            }

            System.out.println("\n===== BATALHA " + (i + 1) + " de " + TOTAL_BATALHAS + " =====");

            // Arte e texto do inimigo antes de a luta começar
            Historia.antesDaBatalha(i);

            Batalha batalha = new Batalha(jogador, criaInimigo(i));
            batalha.executa();
            batalhas[realizadas] = batalha;
            realizadas++;

            // Se eu morri, paro aqui: não tem próxima batalha
            if( !batalha.jogadorVenceu() ){
                venceuTudo = false;
                break;
            }

            // Venci: a Raze comenta e depois vida e munição voltam ao inicial
            Historia.aposVitoria(i);
            jogador.restaura();
        }

        // --- Resultado final ---
        // O final da história só roda aqui, depois de saber se eu venci tudo ou não
        System.out.println("\n===== RESULTADO FINAL =====");
        for( int i = 0; i < realizadas; i++ ){
            System.out.println("Batalha " + (i + 1) + " " + batalhas[i].resultado());
        }
        if( venceuTudo ){
            Historia.finalVitoria(jogador.getNome());
            System.out.println("\nParabéns, " + jogador.getNome() + "! Você venceu as " + TOTAL_BATALHAS + " batalhas!");
        } else {
            Historia.finalDerrota(jogador.getNome());
            System.out.println("\nFim de jogo: " + jogador.getNome() + " foi derrotado.");
        }
    }
}