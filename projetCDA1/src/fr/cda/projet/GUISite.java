package fr.cda.projet;

import fr.cda.ihm.*;

// Classe de definition de l'IHM principale du compte
//
public class GUISite implements FormulaireInt
{
    private Site site;  // Le site

    // Constructeur
    //
    public GUISite(Site site)
    {
        this.site = site;

        // Creation du formulaire
        Formulaire form = new Formulaire("Site de vente",this,1100,730);
        
        //  Creation des elements de l'IHM
        //
        form.addLabel("Afficher tous les produits du stock");
        form.addButton("AFF_STOCK","Tous le stock");
        form.addLabel("");
        form.addLabel("Afficher tous les bons de commande");
        form.addButton("AFF_COMMANDES","Toutes les commandes");
        form.addLabel("");
        form.addText("NUM_COMMANDE","Numero de commande",true,"1");
        form.addButton("AFF_COMMANDE","Afficher");
        form.addLabel("");
        form.addButton("MODIFIER_COMMANDE","Modifier");
        form.addLabel("");
        form.addButton("LIVRE","Livrer");
        form.addButton("VENTES","Calculer ventes");
        form.setPosition(350,0);
        form.addZoneText("RESULTATS","Resultats",
                            true,
                            "",
                            600,700);

        // Affichage du formulaire
        form.afficher();
    }

    // Methode appellee quand on clique dans un bouton
    //
    public void submit(Formulaire form,String nomSubmit)
    {

        // Affichage de tous les produits du stock
        //
        if (nomSubmit.equals("AFF_STOCK"))
            {
                String res = site.listerTousProduits();
                form.setValeurChamp("RESULTATS",res);
            }

        // Affichage de toutes les commandes
        //
        if (nomSubmit.equals("AFF_COMMANDES"))
            {
                String res = site.listerToutesCommandes();
                form.setValeurChamp("RESULTATS",res);
            }

        // Affichage d'une commande
        //
        if (nomSubmit.equals("AFF_COMMANDE"))
            {
                String numStr = form.getValeurChamp("NUM_COMMANDE");
                int num = Integer.parseInt(numStr);
                String res = site.listerCommande(num);
                form.setValeurChamp("RESULTATS",res);
            }
     // Livraison de toutes les commandes
        //
        if (nomSubmit.equals("LIVRE"))
            {
              String res = site.livrer();
              form.setValeurChamp("RESULTATS",res);
            }

        // Modifier une commande non livre
        //
        if (nomSubmit.equals("MODIFIER_COMMANDE"))
          {
            // On recupere le numero de commande saisi
            String numStr = form.getValeurChamp("NUM_COMMANDE");
            int num = Integer.parseInt(numStr);

            // On recherche la commande
            Commande com = site.chercherCommande(num);
            if (com==null)
              form.setValeurChamp("RESULTATS","Le numero de commande n'existe pas");
            else
              {
                // Si la commande est livre on ne peut pas la modifier
                if (com.isLivre())
                  form.setValeurChamp("RESULTATS","Pour modifier un bon de commande, \nil faut qu'il soit non livre");
                else
                  {
                    // Affichage de l'IHM de modification de la commande
                    GUIModifierCommande ihm = new GUIModifierCommande(form,site,com);
                  }
              }
          }

        // Modifier une commande non livre
        //
        if (nomSubmit.equals("VENTES"))
          {
            String res = site.calculerVentes();
            form.setValeurChamp("RESULTATS",res);
          }
    }

}