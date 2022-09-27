package fr.cda.projet;
import java.util.ArrayList;
import java.util.Calendar;
import fr.cda.util.Terminal;

public class Mediatheque {

	private ArrayList<Media> listemedia;
	
	private ArrayList<Emprunteur> listeEmprunteur;
	
    private int compteurMedia;
	public Mediatheque() {
		super();
		this.listemedia = new ArrayList<Media>();
		this.listeEmprunteur = new ArrayList<Emprunteur>();
		this.compteurMedia = 1;
	}
    
    public String ajouterMedia(String categorie,
            String sousCategorie,
            String description){
    	Calendar date= Calendar.getInstance();
    	int annee=date.get(Calendar.YEAR);
    	int mois=date.get(Calendar.MONTH);
    	String ident  = String.format("%d-%d-%d",annee,mois,compteurMedia);
    	 compteurMedia++;
    	  // Création du média
         Media m = new Media(ident,
                             categorie,
                             sousCategorie,
                             description);
         // Ajout du média dans la collection des médias de la médiathèque
         listemedia.add(m);
         return ident;
    }
    public void ajouterInscrit(Emprunteur e)
    {
        e.setNumero(getNumeroInscrit());
        listeEmprunteur.add(e);
    }
 // Affiche dans la console le contenu de la médiathèque : 
    //    - la liste des médias
    //    - la liste des inscrits
    //
    public String afficher()
    {
    	String res ="";
        res="Les medias de la mediatheque :\n";
        for(Media m:listemedia)
            {
                res+=m.toString()+"\n";
               
            }
        
        res+="Les inscrits de la mediatheque \n:";
        for(Emprunteur e:listeEmprunteur)
            {
        	 res+=e.toString()+"\n";
        	 res+="-------------------------\n";
            }
        return res;
         }
 // Cette méthode retourne le numéro d'inscription le plus haut + 1
    // Ce numéro est utilisé pour inscrire un nouvel emprunteur.
    //
    private int getNumeroInscrit()
    {
        if (listeEmprunteur.size()==0) return 1;


        int max=listeEmprunteur.get(0).getNumero();

        for(Emprunteur e:listeEmprunteur)
            if(e.getNumero()>max)
                max=e.getNumero();
        return max+1;
    }
    
    //=======================================================================
    // Méthode qui permet d'emprunter un media dans la console
    //
    public void emprunterModeConsole()
    {
        // On affiche les emprunteurs en fonction d'un critère de recherche sur
        //   le nom ou le prénom
        //
        Terminal.ecrireStringln("Choix de l'emprunteur");
        Terminal.ecrireString("Saisir un mot qui est recherché dans le nom ou le prénom (\"exit\" pour arrêter) : ");
        String mot = Terminal.lireString();
        while (! (mot.equals("exit")))
            {
                for(Emprunteur e:this.listeEmprunteur)
                    {
                        if ( (e.getNom().toLowerCase().indexOf(mot.toLowerCase())!=-1) ||
                             (e.getPrenom().toLowerCase().indexOf(mot.toLowerCase())!=-1) )
                            {
                                Terminal.ecrireStringln(e.toString());
                            }
                    }
                Terminal.ecrireStringln("------------------------------");
                Terminal.ecrireString("Nouvelle recherche: ");
                mot = Terminal.lireString();
            }

        // Demande de saisie du numéro de l'emprunteur
        //
        Terminal.ecrireString("Numero de l'emprunteur: ");
        int numeroEmprunteur = Terminal.lireInt();

        //On affiche les medias en fonction d'un critere de recherche sur
        //  categorie, sous-catégorie ou description
        //
        Terminal.ecrireStringln("Choix du media");
        Terminal.ecrireString("Saisir un mot qui est recherché dans la categorie, la sous-categorie ou la description (\"exit\" pour arrêter) : ");
        mot = Terminal.lireString();
        while (! (mot.equals("exit")))
            {
                for(Media e:this.listemedia)
                    {
                        if ( (e.getCategorie().toLowerCase().indexOf(mot.toLowerCase())!=-1) ||
                             (e.getSousCategorie().toLowerCase().indexOf(mot.toLowerCase())!=-1) ||
                             (e.getDescription().toLowerCase().indexOf(mot.toLowerCase())!=-1) )
                            {
                                Terminal.ecrireStringln(e.toString());
                            }
                    }
                Terminal.ecrireStringln("------------------------------");
                Terminal.ecrireString("Nouvelle recherche: ");
                mot = Terminal.lireString();
            }

        // Demance de saisie de l'identificateur du media
        //
        Terminal.ecrireString("Identificateur du media : ");
        String identMedia = Terminal.lireString();
        
        // Appel du traitement d'emprunt d'un media par un emprunteur
        emprunter(identMedia,numeroEmprunteur);
        
    }
    // Méthode d'emprunt :
    //   identMedia : identificateur du média devant être emprunté
    //   numeroEmprunteur : numéro d'inscription de l'emprunteur
    public void emprunter(String identMedia,int numeroEmprunteur)
    {
        // On recherche le média et l'emprunteur
        //
        Media mediaEmprunte = null;
        Emprunteur emprunteur = null;

        Media r = new Media(identMedia);
        int index = listemedia.indexOf(r);
        if (index==-1)
            {
                Terminal.ecrireStringln("********** Ce media " + identMedia + " n'existe pas");
                return;
            }
        else
            {
                mediaEmprunte = listemedia.get(index);
            }
        
        Emprunteur e = new Emprunteur(numeroEmprunteur);
        index = listeEmprunteur.indexOf(e);
        if (index==-1)
            {
                Terminal.ecrireStringln("********** Cet emprunteur " + numeroEmprunteur + " n'existe pas");
                return;
            }
        else
            {
                emprunteur =  listeEmprunteur.get(index);
            }
        
        // Le média est emprunté par l'emprunteur

        // On renseigne le numéro de l'emprunteur
        mediaEmprunte.setEmprunteur(numeroEmprunteur);

        // On renseigne la date d'emprunt
        Calendar cal = Calendar.getInstance();
        mediaEmprunte.setDateEmprunt(cal.get(Calendar.DAY_OF_MONTH)+"/"+cal.get(Calendar.MONTH)+"/"+cal.get(Calendar.YEAR));

        // L'emprunteur a un média de plus emprunté
        //
        emprunteur.addEmprunt(identMedia);
        
    }
    public String RechercheMedia(String mot) {
    	  
    	String res="";
                  for(Media e:this.listemedia)
                      {
                          if ( (e.getCategorie().toLowerCase().indexOf(mot.toLowerCase())!=-1) ||
                               (e.getSousCategorie().toLowerCase().indexOf(mot.toLowerCase())!=-1) ||
                               (e.getDescription().toLowerCase().indexOf(mot.toLowerCase())!=-1) )
                              {
                                  res+= e.toString();
                              }
                      }
           
    	return res;
    }
    public String RechercheInscrit(String mot) {
    	String res="";
    	 for(Emprunteur e:this.listeEmprunteur)
         {
             if ( (e.getNom().toLowerCase().indexOf(mot.toLowerCase())!=-1) ||
                  (e.getPrenom().toLowerCase().indexOf(mot.toLowerCase())!=-1) )
                 {
                     res+= e.toString();
                 }
         }
    	 return res;
    }
    /**
     * methode pour afficher et selectionner les emprunteurs dans liste
     * @return [] string
     */
    public String [] ListeEmprunteurs() {
    	String [] res=new String[this.listeEmprunteur.size()];
    	int i=0;
    	for(Emprunteur e:this.listeEmprunteur) {
    		res[i]=e.getNumero() +" "+e.getNom() + " " + e.getPrenom();
    		i++;
    	}
    	return  res;
    }
    /**
     * methode pourafficher et  selectionner les medias dans liste
     * @return [] string
     */
    public String [] ListeMedia() {
    	String [] res=new String[this.listemedia.size()];
    	int i=0;
    	for(Media m:this.listemedia) {
    		res[i]=m.getIdentificateur() +" "+m.getCategorie() + " " + m.getSousCategorie()+ " "+m.getDescription();
    		i++;
    	}
    	return  res;
    }
}
