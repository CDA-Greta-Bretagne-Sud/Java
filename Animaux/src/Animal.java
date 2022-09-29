
public class Animal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Animaux[] tab = new Animaux[6]; 
		tab[0] = new Homme();
		tab[1] = new Lapin();
		tab[2] = new Homme(); 
		tab[3] = new Lapin(); 
		tab[4] = new Chat();
		tab[5] = new Chien();
				
		for (int i=0; i<6; i++){
			tab[i].manger();
			Terminal.ecrireStringln("nbPattes:"+tab[i].nbPatte());
			if (tab[i] instanceof Carnivore ) {
				((Carnivore)tab[i]).chasser();
			}
			if (tab[i] instanceof Cadeaux) {
				((Cadeaux)tab[i]).offrir();
			}
		}
	}
}
	