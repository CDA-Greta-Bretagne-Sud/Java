public class Exercice2 {
	
	public static void main(String[] args) {
		// Lecture du fichier contenant les mots a decouvrir
        //
        String[] listeMots = Terminal.lireFichierTexte("Pendu.txt");
     // On prend un mot aleatoirement : modulo du temps courant
        //   
        int aleat  = Math.abs( (int)(System.currentTimeMillis()) );
        int numero = aleat%listeMots.length;
        String mot = listeMots[numero];
        Terminal.ecrireStringln("index aleatoire="+numero+" Mot trouvé:");
        //TODO Le mot a trouver est transformé en tableau de char
       
        //TODO Le mot cache de la longueur du mot a trouver contient au départ que des "-"
       
     // Nombre d'erreur du joueur. A plus de 7 erreurs il a perdu.
        int nbErreur = 0;
        int nbMaxErreur = 7;
        
        // Les lettrejouees par le joueur et son nombre de coup joues
        char[] lettreJouees = new char[26];
        int nbCoupJoues = 0;

        // Boucle de jeu
        //
        boolean fini = false;
        
        while(!fini)
        {
            //TODO Si le joueur a perdu
            if ()
                {
                    Terminal.ecrireString("Perdu! Le mot est: "+mot);
                    fini = true;
                }
            else
                {
                    Terminal.ecrireString("Mot a trouver  : ");
                    Terminal.ecrireStringln(new String(motCache));
                    Terminal.ecrireString("Lettres jouees : ");
                    Terminal.ecrireStringln(new String(lettreJouees));
                    Terminal.ecrireString("Nb erreurs     : ");
                    Terminal.ecrireStringln(""+nbErreur);
                    Terminal.ecrireString("Saisir un car  : ");
                    char caracJoue = Terminal.lireChar();
                    
                    //TODO Si le caractere joue a deja ete jouee
                    if (caracDansTab())
                       
                    else
                        {
                            //TODO Si le caractere joue fait parti du mot a trouve
                            //  alors on decouvre les lettres
                            //  sinon le joueur a fait une erreur
                            //
                            if (caracDansTab(caracJoue,motATrouve))
                                {
                                   
                                }
                            else
                                {
                                    nbErreur++;
                                }
                            
                            //TODO On stocke le caractère joué
                          
                            //TODO on incréemente le nombre de coup joués
                           
                                
                        }
                }
        }
        }
        //TODO Recherche si le caractere est dans un tableau de caractère
        //
        static boolean caracDansTab(char c,char[] tab)
        {
          
        }
     //TODO Remplace les '-' par le caractère joue si il existe.
        // Retourne true si toutes les lettres ont été trouvées
        //
        static boolean majMotCache(char c,char[] motCache,char[] motATrouve)
        {
           
        }
}


