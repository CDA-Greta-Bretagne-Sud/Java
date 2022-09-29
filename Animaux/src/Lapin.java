
public class Lapin implements Herbivore{

	public Lapin() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void manger() {
		Terminal.ecrireStringln("Un lapin mange des carottes");
		
	}

	@Override
	public int nbPatte() {
		// TODO Auto-generated method stub
		return 4;
	}



	
}
