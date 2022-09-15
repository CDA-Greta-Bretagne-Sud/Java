public class TesteComte2 {
    public static void main(String[] args) {
        Compte conte1 = new Compte(0);
        Compte conte2 = new Compte(0);

        conte1.deposer(500);
        conte2.deposer(1000);
        conte2.retirer(10);
        conte1.virerVers(75, conte2);

        conte1.afficher();
        conte2.afficher();


    }
}
