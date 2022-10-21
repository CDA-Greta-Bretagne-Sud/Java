package fr.cda.projet;


import java.util.*;
import fr.cda.ihm.*;

// Classe d'IHM permettant de modifier un bon de commande
//
public class GUIModifierCommande implements FormulaireInt
{
  private Formulaire formPP;  // Le formulaire principal du programme
  private Site site;    
  private Commande commande;

  public GUIModifierCommande(Formulaire formPP,
                             Site site,
                             Commande commande)
  {
    this.formPP    = formPP;
    this.site      = site;
    this.commande  = commande;

    Formulaire form = new Formulaire("Site de vente",this,320,260);

    // On permet la saisie des quantites des references de produits
    
    ArrayList<String> refProduits  = commande.getReferences();
    for(int i=0;i<refProduits.size();i++)
      {
        String[] tab = refProduits.get(i).split("=");
        String nomReference = String.format("%-20s",tab[0]);
        form.addText("QUANTITE_"+i,nomReference,true,tab[1]);
      }

    // Pour valider la modification des quantites
    form.addButton("VALIDER","Valider");

    form.afficher();
  }
  
  // Les traitements de l'IHM sus selectionsuite a une action
  //
  public void submit(Formulaire form,String nomSubmit)
  {
    // Valider la saisie
    //
    if (nomSubmit.equals("VALIDER"))
      {
        // On reconstruit les references de produit de la commande
        //  avec celles de l'IHM
        //
        ArrayList<String> refProduitsNew = new ArrayList<String>();
        ArrayList<String> refProduits = commande.getReferences();
        for(int i=0;i<refProduits.size();i++)
          {
            String[] tab = refProduits.get(i).split("=");
            String nomReference = tab[0];
            String quantite = form.getValeurChamp("QUANTITE_"+i);
            String refProduit = nomReference+"="+quantite;
            refProduitsNew.add(refProduit);
          }
        // Mise a jour de la commande
        commande.setReferences(refProduitsNew);

        // On construit le resultat de la forme principale :
        //   La commande modifie
        //
        formPP.setValeurChamp("RESULTATS",commande.toString());
        
        // On ferme la fenetre
        form.fermer();
      }
  }
  
}
