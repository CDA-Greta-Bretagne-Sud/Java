package fr.cda.multiagent;

// Interface de description d'un etre vivant appelé Agent
//
public interface Agent
{
    public boolean estVivant();
    public int nbVies();
    public void tuer();
    public void ressusciter();
    public String genre();
    public String nom();
}