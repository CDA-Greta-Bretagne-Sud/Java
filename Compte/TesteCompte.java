import java.util.ArrayList;

public class TesteCompte {
    public static void main(String[] args) {
        ArrayList <Compte> comptes = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            comptes.add(new Compte(0).deposer(200 + (100 * i)));
        }

        // chaque fois dans la boucle la compte sur l'indice invoyer dans tous les compte qui reste
       for (int source = 0; source < comptes.size(); source++) {
            for (int dest = source + 1; dest < comptes.size(); dest++) {
                comptes.get(source).virerVers(20, comptes.get(dest));
            }
        }

        for (int i = 0; i < comptes.size(); i++) {
            comptes.get(i).afficher();
        }
    }
}
