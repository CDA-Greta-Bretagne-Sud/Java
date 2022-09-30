package fr.cda.etrevivant;

import fr.cda.multiagent.*;

// Classe de d�finition d'un Dieu.
// Un Dieu est immortel. Son nombre de vie est �gal � 1 mais ne peut
// �tre tu�.
// 
// La classe impl�mente l'interface Agent
//
public class Dieu implements Agent
{
    private String nom;  // Le nom du Dieu

    // Constructeur
    public Dieu(String nom)
    {
        this.nom=nom;
    }

    // ========== Impl�mentation de l'interface Agent
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

    // Un dieu ne peut �tre tu�
     public void tuer()
    {
    }

    // Un dieu ne peut �tre ressuscit� car il ne peut �tre tu�
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