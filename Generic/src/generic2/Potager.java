package generic2;

public class Potager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Tomate t= new Tomate("Coeur de Boeuf","rouge");
		String adreTJardin="Jardin de Paris";
		Carotte c= new Carotte("carotte nantaise", "Pays de la loire");
		String adreTCarotte="Jardin de Nantes";
		LeJardinDesPlantes jardinNantes=new LeJardinDesPlantes("Nantes", "1e Allée");
		Garage garageBMW= new Garage("BMW", 200, "Orvault");
		Plantation<Tomate,LeJardinDesPlantes>  plant = new Plantation<Tomate,LeJardinDesPlantes>  (t,jardinNantes);
		Plantation<Carotte,Garage>  plantc = new Plantation<Carotte,Garage>  (c,garageBMW);
		
System.out.println(plant.toString()+"\n "+plantc.toString());
	}

}
