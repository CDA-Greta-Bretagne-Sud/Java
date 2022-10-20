
public class Potager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Tomate t= new Tomate("Coeur de Boeuf","rouge");
		String adreTJardin="Jardin de Paris";
		Carotte c= new Carotte("carotte nantaise", "Pays de la loire");
		String adreTCarotte="Jardin de Nantes";
		Plantation<Tomate>  plant = new Plantation<Tomate>  (t,adreTJardin);
		Plantation<Carotte>  plantc = new Plantation<Carotte>  (c,adreTCarotte);
		
System.out.println(plant.toString()+" "+plantc.toString());
	}

}
