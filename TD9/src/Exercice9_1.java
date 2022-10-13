import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercice9_1 {

	 // Si il y a une erreur d'IO non prévue dans le main
    //  on retourne l'erreur (le programme s'arrête et affichera
    //  l'exception
    //
    public static void main(String[] args) throws IOException
    {
        // Recuperation de l'entrée du clavier
        BufferedReader clavier = new BufferedReader(new InputStreamReader(System.in));
        
        /// Lecture du nom du fichier
        System.out.println("Le nom du fichier texte : ");
        String nomFichierEntree = clavier.readLine();
        File fichIn = new File("text",nomFichierEntree);
        if (! fichIn.exists())
            {
                System.out.println("Le fichier d'entree n'existe pas");
                System.exit(0);
            }
        BufferedReader flotIn = new BufferedReader(new InputStreamReader(new FileInputStream(fichIn)));

        // Création du répertoire "binaire"
        File rep = new File("binaire");
        rep.mkdir(); // Si le repertoire existe déjà cette méthode ne fait rien

        // Déclaration du fichier de sortie
        //
        String nomFichierSortie = "binaire"+File.separator+
            nomFichierEntree+".binaire";
        File fichOut = new File(nomFichierSortie);

        DataOutputStream flotOut = new DataOutputStream(new FileOutputStream(fichOut));
        
        // On va lire le fichier texte ligne à ligne et
        //  nous allons écrire la ligne dans un fichier binaire
        //
        try{
            String str = flotIn.readLine();
            while (str!=null)
                {
                    System.out.println("trace: "+str);
                    flotOut.writeUTF(str);
                    str = flotIn.readLine();
                    // Attention on écrit pas le "\n" qui a été absorbé 
                    //  par le readLine.
                }
            flotOut.close();
            System.out.println("Fichier cree : "+nomFichierSortie);
        }
        catch(IOException ex)
            {
                // Si erreur d'écriture alors on trace l'erreur
                System.out.println(ex);
                ex.printStackTrace();
            }
    }
}

