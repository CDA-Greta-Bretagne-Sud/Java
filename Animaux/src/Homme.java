
public class Homme implements Carnivore, Cadeaux{

	@Override
	public void manger() {
		Terminal.ecrireStringln("l'homme mange de tout");
		
	}

	@Override
	public int nbPatte() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public void chasser() {
		// TODO Auto-generated method stub
		Terminal.ecrireStringln("l'homme chasse du sanglier, du poulet...");
	}

	@Override
	public void offrir() {
		Terminal.ecrireStringln("J'ai un budget de "+ Cadeaux.montant +"€ pour offrir des cadeaux");
		
	}

}
