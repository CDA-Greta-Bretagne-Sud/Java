package fr.cda.etrevivant;

import fr.cda.multiagent.*;

// Classe de définition d'un Humain.
// Un humain n'a qu'une vie et meurt dès que on tente de le tuer.
// 
// La classe implémente l'interface Agent
//
public class Humain implements Agent
{
    private String nom;      // Un humain a un nom
    private boolean vivant;  // True si vivant sinon false

    // Constructeur
    public Humain(String nom)
    {
        this.nom=nom;
        this.vivant = true;
    }

    // ========== Implémentation de l'interface Agent
    // ======================================================
    
    // Humain est vivant s'il n'a pas été tué
    public boolean estVivant()
    {
        return this.vivant;
    }

    // Un humain a 1 vie 's'il est vivant)
    public int nbVies()
    {
        if (this.vivant) return 1;
        else return 0;
    }

    // Tuer un humain 
    public void tuer()
    {
        this.vivant=false;
    }

    // Ressusciter un humain
    public void ressusciter()
    {
        this.vivant = true;
    }

    // Le genre
    public String genre()
    {
        return "Humain";
    }

    // Le nom d'un humain
    public String nom()
    {
        return nom;
    }
}