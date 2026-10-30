// Viper inimiga 1
//fazAtaque() sobrescrito: o veneno às vezes causa o dobro de dano
public class Viper extends Inimigo {

    public Viper() {
        super("Viper", 600, 50);
    }

	@Override
	public void fraseApresentacao() {
        System.out.println("Minha prioridade eh o sofrimento deles!");
	}

	@Override
	public void fraseMorte() {
        System.out.println("O veneno... se virou contra mim...");
	}

    
}
