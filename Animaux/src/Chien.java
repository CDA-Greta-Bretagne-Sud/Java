
public class Chien implements Carnivore{

	public Chien() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void manger() {
	Terminal.ecrireStringln("le chien mange de la viande et du poulet");
		
	}

	@Override
	public int nbPatte() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public void chasser() {
		Terminal.ecrireStringln("le chien chasse des chats.");
		
	}

	

}
