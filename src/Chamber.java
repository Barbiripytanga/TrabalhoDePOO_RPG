public class Chamber extends Inimigo {
//Defesa mista: esquiva 50% + escudo 5
    public Chamber() {
        super("Chamber", 800, 70, new Escudo(20) );
    }

	@Override
	public void fraseApresentacao() {
		System.out.println("Querem brincar? Vamos brincar!");
	}

	@Override
	public void fraseMorte() {
		System.out.println("Isso... não estava nos meus planos...");
	}

	//--Sistema de Upgrade
	private boolean upgraded = false;
	private int vidaCritica = 200;
	@Override
	public void upgrade(){
		if( !upgraded ){
			if( vidaCritica(vidaCritica) ){
				System.out.println(getNome() + " está turbinado!");
				upgraded = true;
				setDefesa(new Escudo(40));
				setAtaque(200);
			}
		}
	}
    //frase quando mata
	//infelizmente vc teve q morrer, mas vc n fazia parte dos meus planos

}
