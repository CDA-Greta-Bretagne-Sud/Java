package fr.cda.etrevivant;

import java.util.Random;

import fr.cda.multiagent.*;

// Classe de définition d'un cafard.
// Un cafard a qu'une vie mais il est difficile à tuer. Il a une 
//  probabilité de mourir de 1/10
// 
// La classe implémente l'interface Agent
//
public class Cafard implements Agent
{
    private String nom;    // Un cafard a un nom
    private int    nbVies; // Le nombre de vie d'un cafard
    private Random rnd;    // La fonction aléatoire 

    // Constructeur qui initialise notamment le nombre de vie a 1
    public Cafard(String nom)
    {
        this.nom=nom;
        this.nbVies = 1;
        this.rnd = new Random();
    }

    // ========== Implémentation de l'interface Agent
    // ======================================================

    // Un cafard est vivant si son nombre de vie est >=1
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

    // Si le cafard n'est pas mort alors
    //  on décrémente son nombre de vie que si aléatoirement 
    //   on tire le chiffre 9 entre 0 et 9 (proba = 1/10)
    public void tuer()
    {
        if (this.nbVies>=1) 
            {
                //int n = Math.abs(this.rnd.nextInt())%10;
                int n = this.rnd.nextInt(10);
                //System.out.print(n + " ");
                //System.out.println();
                if (n==9)
                    this.nbVies--;
            }
    }

    // Ressusciter un cafard
    public void ressusciter()
    {
        this.nbVies=1;
    }

    // Le genre du cafard
    public String genre()
    {
        return "Cafard";
    }

    //Le nom du cafard
    public String nom()
    {
        return nom;
    }

}