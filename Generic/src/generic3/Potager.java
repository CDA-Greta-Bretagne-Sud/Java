package generic3;

public class Potager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LeJardinDesPlantes jardinNantes=new LeJardinDesPlantes("Nantes", "1e Allée");
		Legume t= new Tomate("Coeur de Boeuf",jardinNantes,"rouge");
		Legume t2= new Tomate(125,jardinNantes,"rouge");
	
		Garage garageBMW= new Garage("BMW", 200, "Orvault");
		Legume c= new Carotte("carotte nantaise",garageBMW, "Pays de la loire");
		Legume c2= new Carotte("carotte nantaise",garageBMW, "Pays de la loire");

System.out.println("tomate:"+t2);		
		
System.out.println(t.toString()+"\n "+c.toString());
System.out.println("Comparaison carotte et Tomate:"+Util.compareLegume(t, c));
System.out.println("Comparaison lieu:"+Util.compareLieu(c2, c));

	}

}
