package fr.cda.projet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

// Classe de definition d'une commande
//
public class Commande {
	// Les caracteristiques d'une commande
	//
	private int numero; // numero de la commande
	private String date; // date de la commande. Au format JJ/MM/AAAA
	private String client; // nom du client
	private ArrayList<String> references; // les references des produits de la commande
	private boolean livre; // livraison de la commande
	private String info; // information de livraison

	public Commande(int numero, String date, String client) {
		this.numero = numero;
		this.date = date;
		this.client = client;
		this.references = new ArrayList<String>();
		livre = false;
		info = "";
	}
	// Ajoute une reference de produit au bon de commande
	  //
	  public void addRefProduit(String refProduit)
	  {
	    references.add(refProduit);
	  }
	  public String toString()
	  {
	    String strLivre="";
	    if (livre) strLivre ="Livraison faite";

	    String res="Commande       : "+numero+"   "+strLivre+"\n";
	    res=res +   "  Date        : "+date+"\n";
	    res=res +   "  Client      : "+client+"\n";
	    res=res +   "  RefProduits : \n";
	    for(String ref:references)
	      res=res+  "      " + ref + "\n";
	    if (!info.equals("")) res=res+info+"\n";
	    res=res+"---------------------------------\n";

	    return res;
	  }
	  public static Comparator<Commande> ComparatorClient = new Comparator<Commande>() {
		     
	        @Override
	        public int compare(Commande c1, Commande c2) {
	            return c1.getClient().compareTo(c2.getClient());
	        }
	    };
	    
		  public static Comparator<Commande> ComparatorDate = new Comparator<Commande>() {
			     
		        @Override
		        public int compare(Commande c1, Commande c2) {
		        	
		        	 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		             Date date1,date2;
					try {
						date1 = sdf.parse(c1.getDate());
						date2 = sdf.parse(c2.getDate());
					    System.out.println("date1 : " + date1);
			             System.out.println("date2 : " + sdf.format(date2));


			             return date1.compareTo(date2);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		           
					return 0;
		      
		        }
		    };
	  public String toStringFile()
	  {
	
	    String res="";

	    for(String ref:references)
	      res=res+numero+";"+date+";"+client+";" + ref + "\n";

	    return res;
	  }
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public ArrayList<String> getReferences() {
		return references;
	}
	public void setReferences(ArrayList<String> references) {
		this.references = references;
	}
	public boolean isLivre() {
		return livre;
	}
	public void setLivre(boolean livre) {
		this.livre = livre;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	  
}