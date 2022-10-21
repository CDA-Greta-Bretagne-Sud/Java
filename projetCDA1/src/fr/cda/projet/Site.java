package fr.cda.projet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import fr.cda.util.*;

// Classe de definition du site de vente
//
public class Site 
{
    private ArrayList<Produit> stock;       // Les produits du stock
    private ArrayList<Commande> commandes;  // Les bons de commande

    // Constructeur
    //
    public Site()
    {
        stock = new ArrayList<Produit>();
        commandes = new ArrayList<Commande>();
        // lecture du fichier data/Produits.txt
        //  pour chaque ligne on cree un Produit que l'on ajoute a stock
        initialiserStock("data/Produits.txt");

        //  lecture du fichier data/Commandes.txt
        //  pour chaque ligne on cree une commande ou on ajoute une reference
        //  d'un produit a une commande existante.
        initialiserCommandes("data/Commandes.txt");
        
    }
    
    // Methode qui retourne sous la forme d'une chaine de caractere
    //  tous les produits du stock
    //
    public String listerTousProduits()
    {
        String res="";
        for(Produit prod : stock)
            res=res+prod.toString()+"\n";

        return res;
    }

    // Methode qui retourne sous la forme d'une chaine de caractere
    //  toutes les commandes
    //
    public String listerToutesCommandes()
    {
    	String res="";
        for(Commande c:commandes)
          res=res+c.toString()+"\n";
        return res;
    }

    // Methode qui retourne sous la forme d'une chaine de caractere
    //  une commande
    //
    public String listerCommande(int numero)
    {
    	String res;
        
        Commande com = chercherCommande(numero);
        if (com==null) 
          res="La commande de numero "+ numero + " n'existe pas";
        else
          res=com.toString();
            
        return res;
    }

    // Chargement du fichier de stock
    //
    private void initialiserStock(String nomFichier)
    {
        String[] lignes = Terminal.lireFichierTexte(nomFichier);
        for(String ligne :lignes)
            {
                System.out.println(ligne);
                String[] champs = ligne.split("[;]",4);
                String reference = champs[0];
                String nom = champs[1];
                double prix = Double.parseDouble(champs[2]);
                int quantite =  Integer.parseInt(champs[3]);
                Produit p = new Produit(reference,
                                        nom,
                                        prix,
                                        quantite
                                        );
                stock.add(p);
            }
    }
 // Chargement du fichier des bons de commande
    //
    private void initialiserCommandes(String nomFichier)
    {
      // Lecture de tout le fichier
      String[] lignes = Terminal.lireFichierTexte(nomFichier);
      // Pour chaque ligne du fichier
      for(String ligne :lignes)
        {
          System.out.println(ligne);
          // On decode la ligne
          String[] champs = ligne.split("[;]",4);
          int    numero     = Integer.parseInt(champs[0]);
          String date       = champs[1];
          String client     = champs[2];
          String refProduit = champs[3];
          
          // Si la commande n'existe pas alors
          //  on cree la commande que l'on ajoute au commandes
          Commande com = chercherCommande(numero);
          if (com==null) 
            {
          com = new Commande(numero,date,client);
              commandes.add(com);
           }
          // On ajoute la réference au bon de commande
          com.addRefProduit(refProduit);
        }
    }
    // Methode qui recherche une commande en fonction
    //  de son numero et la retourne
    //  si la commande n'existe pas retourne null
    //
    public Commande chercherCommande(int numero)
    {
      for(Commande c:commandes)
        if (c.getNumero()==numero) return c;
      return null;
    }
    // Methode qui recherche un produit dans le stock
    //  en fonction de sa reference
    //  si la commande n'existe pas retourne null
    //
    public Produit chercherProduit(String reference)
    {
      for(Produit p:stock)
        if (p.getReference().equals(reference)) return p;
      return null;
    }
 // Methode qui realise la livraison des bons de commande
    //
    public String livrer()
    {
      String res = "Les commandes non livres :\n";
      res=res +    "==========================\n\n";
      for(Commande com : commandes)
        {
          // Si la commande n a pas ete livre
          if (! com.isLivre())
            {
              // Pour chaque produit commande on verifie qu il y a le stock
              //  necessaire sans mettre a jour le stock
              boolean valide = true;
              String info = "";
              for(String ref : com.getReferences())
                {
                  String[] tab=ref.split("=",2);
                  int q = Integer.parseInt(tab[1]);
                  Produit p = chercherProduit(tab[0]);
                  int diff = p.getQuantite()-q;
                  if (diff<0) 
                    { 
                      valide=false; 
                      int v = -diff;
                      info=info+"il manque "+v+" "+tab[0]+"\n";
                    }
                }
              // Si la commabde est valide alors on met a jour le stock et
              //  on contruit l'information de la commande
              if (valide)
                {
                  com.setLivre(true);
                  com.setInfo("");
                  for(String ref : com.getReferences())
                    {
                      String[] tab=ref.split("=",2);
                      int q = Integer.parseInt(tab[1]);
                      Produit p = chercherProduit(tab[0]);
                      p.setQuantite(p.getQuantite()-q);
                    }
                }
              // Sinon le bon de commande est invalide et on contruit
              //  une réponse qui sera affiche dans l'IHM
              else
                {
                  com.setLivre(false);
                  com.setInfo(info);
                  res=res+com+"\n";
                }
            }
        }
      return res;
    }	
    // Methode qui calcule la somme des ventes des bons de
    //  commande livres
    //
    public String calculerVentes()
    {
      String res="";
      double somme=0.0;
      for(Commande c:commandes)
        if (c.isLivre())
          {
            res = res + "COMMANDE : "+c.getNumero()+"\n";
            for(String ref : c.getReferences())
              {
                String[] tab=ref.split("=",2);
                int q = Integer.parseInt(tab[1]);
                Produit p = chercherProduit(tab[0]);
                String str = String.format("%50s  %2d  %4.5f\n",
                                           p.getNom(),
                                           q,
                                           p.getPrix());
                res=res+str;
                somme=somme+p.getPrix()*(double)q;
                }
            res=res+"\n";
          }
      res=res+"===================\n";
      res=res+"SOMME : "+somme+" euros";
      return res;
    }
    
    public boolean sauvegarde() {
    	 PrintWriter ecrire;
    	 String nomFichierSortie = "data"+File.separator+"CommandesBack.txt";
    	
    	 
    	    try {
    	    
				ecrire =  new PrintWriter(new BufferedWriter
				   (new FileWriter(nomFichierSortie)));
				 System.out.println("Tri:");
				 
				//Collections.sort(commandes, Commande.ComparatorClient);
				 Collections.sort(commandes, Commande.ComparatorDate);
			
				   for(Commande co:commandes)
				   {
				  
					   System.out.println(co.toStringFile());
			if(!co.toStringFile().equals("")) {
					   ecrire.println(co.toStringFile());}
				   }
				  ecrire.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	
    	
    	return true;
    }
}