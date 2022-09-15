class Compte{
    int solde;
//    String name;
    Compte deposer(int montant){
        solde = solde + montant;
        return (this);
    }
    public Compte( int total){
        //this.name = name;
        solde = total; // No need 'this' !
    }
    void retirer(int montant){
        solde = solde - montant;
    }
    void virerVers(int montant, Compte destination){
        this.retirer(montant);
        destination.deposer(montant);
    }
    void afficher(){
        Terminal.ecrireStringln( "solde: "+ solde);
    }
}
