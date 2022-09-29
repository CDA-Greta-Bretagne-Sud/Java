
public class Chat implements Carnivore {

	public Chat()  {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void manger() {
		// TODO Auto-generated method stub
		Terminal.ecrireStringln("le chat mange de la viande.");
	}

	@Override
	public int nbPatte() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public void chasser() {
		Terminal.ecrireStringln("le chat chasse les souris");
	}

	public void test()
	{
		System.out.println("test chat");
	}
}
