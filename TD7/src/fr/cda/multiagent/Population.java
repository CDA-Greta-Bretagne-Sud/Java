package fr.cda.multiagent;

import java.util.*;
import fr.cda.multiagent.*;

// Cette classe gère une collection d'être vivants
// et réalise des traitements sur l'ensemble de ces être vivants.
// Ces êtres vivants sont des "agents" c'est à dire tout objet
//  JAVA qui implémente l'interface Agent
//
public class Population
{

    private ArrayList<Agent> etres;  // La collection d'êtres

    // Le constructeur
    public Population()
    {
        this.etres = new ArrayList<Agent>();
    }

    // Methode qui ajoute un nouvel agent
    public void ajouterAgent(Agent a)
    {
        this.etres.add(a);
    }

    // retourne les êtres de la collection qui sont vivants
    public ArrayList<Agent> etresVivants()
    {
        ArrayList<Agent> l = new ArrayList<Agent>();
        for(Agent a : this.etres)
            if (a.estVivant())
                l.add(a);
        return l;
    }

    // retourne tous les êtres de la collection
    public ArrayList<Agent> getEtres()
    {
        return this.etres;
    }

    // Tente de tuer chacun des êtres de la collection
    public void tuerTous()
    {
        for(Agent a : this.etres) a.tuer();
    }

    // Ressuscite tous les être de la collection
    public void ressusciterTous()
    {
        for(Agent a : this.etres) a.ressusciter();
    }

    // Trie par les êtres de la collection par ordre de vivant ou mort
    //   puis par ordre alphabétique sur le genre
    public void trier()
    {
       Collections.sort(this.etres,new ComparerAgent());
    }
    
    // Affiche les êtres de la collection (les trie aussi)
    public void afficher()
    {
        this.trier();
        for(Agent a : this.etres)
            {
                String genre = a.genre();
                String nom = a.nom();
                int vies = a.nbVies();
                String vivant;
                if (a.estVivant()) vivant="vivant";
                else vivant="mort";
                System.out.println(String.format("%20s %20s %6s (%2d)",genre,nom,vivant,vies));
            }
        System.out.println("-----------------------------------");
    }
}


// Classe interne qui définit le critère de tri des agents de la collection
//
class ComparerAgent implements Comparator<Agent> 
{ 
    // Méthode de l'interface Comparator
    //
    public int compare(Agent a1, Agent a2)
    {
        // Les vivants en premier  -1 =+ petit
        if ( (a1.estVivant()) && (! (a2.estVivant())) )
            return -1;
        
        // Puis les morts  1 =+ grand
        if ( (a2.estVivant()) && (! (a1.estVivant())) )
            return 1;

        // Puis par genre return 0= egal
        return (a1.genre().compareTo(a2.genre()));
    }
} 