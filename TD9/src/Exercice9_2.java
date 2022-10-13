import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Exercice9_2
{
    // Si il y a une erreur d'IO non pr�vue dans le main
    //  on retourne l'erreur (le programme s'arr�te et affichera
    //  l'exception
    //
    public static void main(String[] args) throws IOException
    {
        PrintWriter ecrire;
       
        File rep = new File("texte");
        rep.mkdir(); // Si le repertoire existe d�j� cette m�thode ne fait rien

        // D�claration du fichier de sortie
        //
        String nomFichierSortie = "texte"+File.separator+"monfichier.txt";
       
        ecrire =  new PrintWriter(new BufferedWriter
        		   (new FileWriter(nomFichierSortie)));
       //declaration du fichier en entree
        String nomFichierEntre = "binaire"+File.separator+
               "entree.txt.binaire";

      
        
        File fichIn = new File(nomFichierEntre);
        if (! fichIn.exists())
            {
                System.out.println("Le fichier d'entree n'existe pas");
                System.exit(0);
            }
        DataInputStream flotIn = new DataInputStream(new FileInputStream(fichIn));
    
        // On va lire le fichier binaire. Il faut le lire comme il a �t� 
        //  �crit : une chaine UTF par ligne.
        // On ne connait pas � priori le nombe de ligne, on va donc
        //  lire chaque ligne jusqu'a rencontrer une exception.
        //
        StringBuffer strBuf = new StringBuffer();
        try{
            while (true)
                {
                    String str = flotIn.readUTF();
                    
                    strBuf.append(str);
                    strBuf.append("\n"); // On ajoute le retour � la ligne
                }
        }
        catch(IOException ex)
            {
                //Fin de lecture
            }

        // On �crit le StringBuffer
        System.out.println(strBuf);
        ecrire.println(strBuf);
        ecrire.close();
    }
}

