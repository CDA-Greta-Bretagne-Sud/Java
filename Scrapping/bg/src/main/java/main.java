import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.Html;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String args[]) throws Exception {
        PrintWriter ecrire;
        BufferedReader clavier = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Entrez le nom du produit à chercher : ");
        String search = clavier.readLine();
        System.out.println("Entrez le prix minimum : ");
        String min = clavier.readLine();
        System.out.println("Entrez le prix maximum : ");
        String max = clavier.readLine();
        String url = "https://leboncoin.fr/recherche?text=" + search + "&price=" + min + "-" + max;
//        String url = "https://www.leboncoin.fr/recherche?text=ordinateur&price=100-300";

        WebClient webClient = new WebClient(BrowserVersion.FIREFOX);

        webClient.getOptions().setUseInsecureSSL(true);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);
        HtmlPage htmlPage = webClient.getPage(url);

        File rep = new File("Recherches");
        rep.mkdir();
        String nomFichierSortie = "Recherches" + File.separator + search + ".txt";

        List<HtmlElement> li = htmlPage.getByXPath("//div[1]/div[1]/p");




        ecrire = new PrintWriter(new BufferedWriter
                (new FileWriter(nomFichierSortie)));

        String res = "";
        for (HtmlElement e : li) {
            HtmlPage htmlPage1 = webClient.getPage(e.click().getUrl());

            List<HtmlElement> nom = htmlPage1.getByXPath("//div[3]/div/div/h1");
            List<HtmlElement> prix = htmlPage1.getByXPath("//div[3]/div/span//div/div[1]/div/span");
            List<HtmlElement> desc = htmlPage1.getByXPath("//div[5]/div/div/p");
            for (HtmlElement n : nom) {
                String nomArticle = n.getTextContent();
                res += "Article : " + nomArticle + "\n";
            }
            for (HtmlElement p : prix) {
                String prixArticle = p.getTextContent();
                res += "Prix : " + prixArticle + "\n";
            }
            for (HtmlElement d : desc) {
                String description = d.getTextContent();
                res += "Description de l'article : " + description + "\n";
                res += "--------------------------------------------------------------------------------------------\n";
            }

            ecrire.println(res);
        }
        ecrire.close();
//        String res = "";
//        for (HtmlElement e : li) {
//            for (HtmlElement p : prix) {
//                String value = e.getTextContent();
//                String value2 = p.getTextContent();
//                String url2 = String.valueOf(e.click().getUrl());
//                res = "Article : " + value + "\nPrix : " + value2 + "\nLien : " + url2 + "\n";
//            }
//            HtmlPage htmlPage1 = webClient.getPage(e.click().getUrl());
//            List<HtmlElement> desc = htmlPage1.getByXPath("//div[5]/div/div/p");
//            for (HtmlElement d : desc) {
//                String description = d.getTextContent();
//                res += "Description de l'article : " + description + "\n";
//                res += "--------------------------------------------------------------------------------------------\n";
//            }
//            ecrire.println(res);
//        }
//        ecrire.close();
    }
}

