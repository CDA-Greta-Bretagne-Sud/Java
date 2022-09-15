public class Article {

    String article;
    double montant;
    int quantite;



    public Article(String article, double montant, int quantite){
        this.article = article;
        this.montant = montant;
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "Article{" +
                "article='" + article + '\'' +
                ", montant=" + montant +
                ", quantite=" + quantite +
                '}';
    }
}
