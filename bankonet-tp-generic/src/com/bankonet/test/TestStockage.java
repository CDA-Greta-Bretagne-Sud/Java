package com.bankonet.test;

import com.bankonet.Client;
import com.bankonet.Compte;
import com.bankonet.CompteCourant;
import com.bankonet.Stockage;

public class TestStockage {

	public static void main(String[] args) {
		
		Client client1 = new Client("Paul", "Hugues", "C001");
		Client client2 = new Client("Julien", "Hugues", "C002");
		Client client3 = new Client("Julie", "Hugues", "C003");
		
		Stockage<String, Client> stockageClient = new Stockage<String, Client>();
		stockageClient.ajouter(client1.getIdentifiant(), client1);
		stockageClient.ajouter(client2.getIdentifiant(), client2);
		stockageClient.ajouter(client3.getIdentifiant(), client3);
		System.out.println(stockageClient.retournerElement(client2.getIdentifiant()));
		
		CompteCourant cc1 = new CompteCourant("CC001", "COMPTE COURANT 1", 100.0, 400.0);
		CompteCourant cc2 = new CompteCourant("CC002", "COMPTE COURANT 2", 200.0, 400.0);
		CompteCourant cc3 = new CompteCourant("CC003", "COMPTE COURANT 3", 1.0, 400.0);
		
		Stockage<String, Compte> stockageCompte = new Stockage<>();
		stockageCompte.ajouter(cc1.getNumero(), cc1);
		stockageCompte.ajouter(cc2.getNumero(), cc1);
		stockageCompte.ajouter(cc3.getNumero(), cc3);
		System.out.println(stockageCompte.retournerElement(cc1.getNumero()));
		
		
	}
}
