import java.util.ArrayList;

public class Caisse {
    public static void main(String[] args){

        int continuer = 1 ;
        ArrayList<Article> listeArticles = new ArrayList<>();

        while(continuer == 1){
            Terminal.ecrireString("Nom de l'article : ");
            String nom = Terminal.lireString();
            Terminal.ecrireString("Montant de l'article : ");
            double montant = Terminal.lireDouble();
            Terminal.ecrireString("Quantité : ");
            int quantite = Terminal.lireInt();
            Article article = new Article(nom,montant,quantite);
            ajout(listeArticles,article);
            Terminal.ecrireString("Ajouter un autre article ? (1 : oui et 2 : non) ");
            continuer = Terminal.lireInt();
        }


        Terminal.ecrireString("Panier : \n");
        afficherPanier(listeArticles);

        Terminal.ecrireString("Voulez-vous supprimer  ? (1 : oui et 2 : non) ");
        int suppr = Terminal.lireInt();
        if(suppr == 1){
            Terminal.ecrireString("Nom de l'article : ");
            String article = Terminal.lireString();
            boolean trouve = supprimerArticle(listeArticles,article);
            if(trouve == false){
                Terminal.ecrireString("L'article n'a pas été trouver");
                Terminal.sautDeLigne();
            }
        }

        Terminal.ecrireString("Panier : \n");
        afficherPanier(listeArticles);

        Terminal.ecrireString("Voulez-vous vider le panier  ? (1 : oui et 2 : non) ");
        int vider = Terminal.lireInt();
        if(vider == 1) {
            viderPanier(listeArticles);
        }
        Terminal.ecrireString("Panier : \n");
        afficherPanier(listeArticles);


    }



    public static void ajout(ArrayList<Article> listeArticles,Article article){
        listeArticles.add(article);
    }


    public static boolean supprimerArticle(ArrayList<Article> listeArticles,String article){
        boolean trouve = false;
        for (int i= 0;i<listeArticles.size();i++){
            if(article.equalsIgnoreCase(listeArticles.get(i).article)){
                listeArticles.remove(i);
                trouve = true;
            }
        }
        return trouve;
    }


    public static void afficherPanier(ArrayList<Article> listeArticles){
        double total = 0;

        for(int i = 0;i<listeArticles.size();i++){

            Terminal.ecrireStringln(listeArticles.get(i).toString());
            Terminal.sautDeLigne();
            total += listeArticles.get(i).montant*listeArticles.get(i).quantite;
        }

        Terminal.ecrireString("Total : " + total + " Euros");
        Terminal.sautDeLigne();
    }


    public static void viderPanier(ArrayList<Article> listeArticles){
        listeArticles.clear();
    }




}
