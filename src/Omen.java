import java.util.Random;
public class Omen extends Inimigo {
    //Defesa mista: esquiva+bloqueio e ataca de forma imprevisivel

    public Omen() {
        super("Omen", 700, 70, new DefesaMista(10,10) );
    }

    // Sobrescreve fazAtaque(): em vez de sempre causar o mesmo dano, o Omen
    // sorteia o dano entre metade e o dobro do seu ataque. Isso o torna
    // imprevisível: às vezes acerta de raspão, às vezes dá um golpe devastador.
    @Override
    public void fazAtaque(Criatura criatura) {
        Random rd = new Random();
        int minimo = getAtaque() / 2;
        int maximo = getAtaque() * 2;
        int dano = minimo + rd.nextInt(maximo - minimo + 1);
        System.out.println(getNome() + " ataca de forma caótica!");
        criatura.tomaDano(dano);
    }

    @Override
    public void fraseApresentacao() {
        System.out.println("Sou o principio sou o fim \n" +
                "Sinto uma risada,Eh de uma raze hmm queria rir de novo.");
    }

    @Override
    public void fraseMorte() {
        System.out.println("Acabou, por enquanto...");
    }


}