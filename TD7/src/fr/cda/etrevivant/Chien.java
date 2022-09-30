package fr.cda.etrevivant;

import fr.cda.multiagent.*;

// Classe de définition d'un Chien.
// Un chien a un nombre max de vie de 2.
// 
// La classe implémente l'interface Agent
//
public class Chien implements Agent
{
    private String nom;     // Un chien a un nom
    private int    nbVies;  // Le nombre de vie courant
    private int    maxVies; // Le nombre max de vie d'un chien

    // Constructeur
    public Chien(String nom)
    {
        this.nom=nom;
        this.maxVies = 2;
        this.nbVies = this.maxVies;
    }

    // ========== Implémentation de l'interface Agent
    // ======================================================

    // Un chien est vivant si son nombre de vie est >=1
    public boolean estVivant()
    {
        if (this.nbVies>=1)
            return true;
        else
            return false;
    }

    // Retourne le nombre de vie
    public int nbVies()
    {
        return nbVies;
    }
    
    // Tuer un chien consiste à décrémenter son nombre de vie
    public void tuer()
    {
        if (this.nbVies>=1) this.nbVies--;
    }

    // Ressusciter un chien consiste a lui redonner son nombre max de vie 
    public void ressusciter()
    {
        this.nbVies = this.maxVies;
    }

    // Le genre
    public String genre()
    {
        return "Chien";
    }

    // Le nom
    public String nom()
    {
        return nom;
    }

}