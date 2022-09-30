package fr.cda.etrevivant;

import fr.cda.multiagent.*;

// Classe de définition d'un Dieu.
// Un Dieu est immortel. Son nombre de vie est égal à 1 mais ne peut
// être tué.
// 
// La classe implémente l'interface Agent
//
public class Dieu implements Agent
{
    private String nom;  // Le nom du Dieu

    // Constructeur
    public Dieu(String nom)
    {
        this.nom=nom;
    }

    // ========== Implémentation de l'interface Agent
    // ======================================================

    // Un Dieu est toujours vivant
    public boolean estVivant()
    {
        return true;
    }

    // Le nombre de vie d'un Dieu est 1
    public int nbVies()
    {
        return 1;
    }

    // Un dieu ne peut être tué
     public void tuer()
    {
    }

    // Un dieu ne peut être ressuscité car il ne peut être tué
    public void ressusciter()
    {
    }

    // Le genre
    public String genre()
    {
        return "Dieu";
    }

    // Le nom du dieu
    public String nom()
    {
        return nom;
    }

}