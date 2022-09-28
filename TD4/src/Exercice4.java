
public class Exercice4 {

	public static void main(String a_args[])
	{

    Terminal.ecrireStringln("Si on saisie 0 alors on utilise un tableau déja initialisé : 2,32,12,4,3,213,34,7,9,12,3,10,13.\nCela evite de saisir tous les élements a chaque fois que l'on teste.");

    // Création du tableau
    //
    int l_n;
    Terminal.ecrireString("Nombre d'element (ou 0) : ");
    l_n = Terminal.lireInt();
    
    //
    int[] l_tab = {2,32,12,4,3,213,34,7,9,12,3,10,13};
    if (l_n!=0)
        {
            // Saisie des elements du tableau
            //
            l_tab = new int[l_n];
            for(int i=0;i<l_n;i++)
                {
                    Terminal.ecrireString("element " + i + " : ");
                    l_tab[i] = Terminal.lireInt();
                }
        } 
    Terminal.ecrireStringln("Affichage du tableau en entrée:");
    for(int l_v : l_tab) Terminal.ecrireString(l_v+" ");
    Terminal.ecrireStringln("");
    
    Terminal.ecrireStringln("Tri par ordre croissant du tableau");
    //
    // L'algorithme est celui du tri à bulle
    //
    boolean l_fini = false;
    int l_nbtri=0;
    while(! l_fini)
        {
            l_fini = true;
            for(int j=0;j<l_tab.length-l_nbtri-1;j++)
                if (l_tab[j]>l_tab[j+1])
                    {
                        int l_tmp = l_tab[j];
                        l_tab[j]=l_tab[j+1];
                        l_tab[j+1]=l_tmp;
                        l_fini = false;
                    }
            l_nbtri++;
        }

    // Affichage du tableau
    Terminal.ecrireStringln("Tableau trie:");
    for(int i=0;i<l_tab.length;i++)
        Terminal.ecrireStringln(""+i+" : "+l_tab[i]);


    
    // Saisir l'élément à rechercher
    Terminal.ecrireString("Element a rechercher (0 pour sortir) : ");
    int l_elt = Terminal.lireInt();

    // On boucle tantqeue la valeur saisie est différente de 0
    while(l_elt!=0)
        {
            Terminal.ecrireStringln("Recherche par dichotomie");
            // ------------------------------------------
            
            // initialisation des bornes
            int l_inf = 0;
            int l_sup = l_tab.length-1;
            
            // Initialisation des resultats
            boolean l_trouve = false;  // si l'element est trouve
            int     l_indice = -1;     // indice de l'element trouve
            
            // On vérifie d'abord si l'element ne se trouve pas au début et à la fin 
            //  du tableau
            l_fini = false;
            if (l_tab[l_inf]==l_elt)
                {
                    l_indice = l_inf;
                    l_trouve = true;
                    l_fini = true;
                }
            if (l_tab[l_sup]==l_elt)
                {
                    l_indice = l_sup;
                    l_trouve = true;
                    l_fini = true;
                }
            
            // On réalise la recherche dichotomique
            while(! l_fini)
                {
                    // On teste si l'élément est au milieu des bornes
                    int l_milieu = (l_inf+l_sup)/2;
                    if (l_tab[l_milieu]==l_elt)
                        {
                            l_trouve = true;
                            l_fini = true;
                            l_indice = l_milieu;
                        }
                    else
                        {
                            // Si les bornes se touchent la recherche est terminée
                            if ( (l_inf==l_milieu)||(l_sup==l_milieu) )
                                l_fini = true;
                            else
                                {
                                    // On continue la recherche en ajustant uen des bornes
                                    //  en fonction de l'ordre des éléments
                                    if(l_elt<l_tab[l_milieu])
                                        l_sup = l_milieu;
                                    if(l_elt>l_tab[l_milieu])
                                        l_inf = l_milieu;
                                }
                        }
                    
                }
            
            if (l_trouve)
                Terminal.ecrireStringln("Element trouve en " + l_indice);
            else
                Terminal.ecrireStringln("Element non trouve");
            
            Terminal.ecrireString("Element a rechercher : ");
            l_elt = Terminal.lireInt();
            
        }
	}
}
