
public class Main {
	
	public static void main(String [] arg){
	Paire<String>  p = new Paire<String>  ("abc", "xyz");

    System.out.println ("valeur de p - premier:" + p.getPremier() +" second:"+ p.getSecond()); 
    
    Paire<Integer>  a = new Paire<Integer>(123, 345);
    System.out.println ("valeur de a - premier:" + a.getPremier() +" second:"+ a.getSecond()); 
}
}
