package fr.cda.programme;

//Exercice d'application de l'interface : une gestion des êtres vivants.
import fr.cda.multiagent.*;
import fr.cda.etrevivant.*;

// Cette classe permet de tester la classe Population qui gère les êtres vivants
//  de notre univers
//
public class Exercice07
{
    public static void main(String... args)
    {
        // Création de la poulation
        Population pop = new Population();

        // Ajout d'êtres dans la population
        pop.ajouterAgent(new Dieu("Zeus"));
        pop.ajouterAgent(new Humain("moi"));
        pop.ajouterAgent(new Dieu("Chronos"));
        pop.ajouterAgent(new Humain("lui"));
        pop.ajouterAgent(new Chien("kador"));
        pop.ajouterAgent(new Cafard("berk"));
        Humain h = new Humain("zurglob");
        pop.ajouterAgent(h);
        pop.ajouterAgent(new Chat("miaou"));

        pop.afficher();

        // Test 

        System.out.println("Tuer tous (une fois)");
        pop.tuerTous();
        pop.afficher();
        System.out.println("Tuer tous (une fois)");
        pop.tuerTous();
        pop.afficher();
        
        System.out.println("Ressusciter tous");
        pop.ressusciterTous();
        pop.afficher();

        // Ce code permet de tuer un cafard et voir au bout de combien de
        // tentative il est mort
        // On fait le test su 10 cafards
        //
        System.out.println("Etude statistique pour tuer un cafard");
        for(int i=1;i<=10;i++)
            {
                Cafard c = new Cafard("cobaye");
                int n=0;
                while (c.estVivant())
                    {
                        c.tuer();
                        n++;
                    }
                System.out.println(String.format("Tuer en %3d coups",n));
            }
    }

}