package util;
/******************************************************
Cours :				LOG121
Session :			Automne 2014
Groupe :			01
Projet :			Exercice 1

Étudiant(e)(s) :	Kolytchev, Dmitri
Code(s) perm. :		KOLD15088804

Professeur :		Ghizlane El boussaidi
Chargés de labo.:	Alvine Boaye Belle et Michel Gagnon
Nom du fichier: 	CommBase.java
Date crée :			2013-05-03
Date dern. modif.	2014-09-17
*******************************************************
Historique des modifications
*******************************************************
*@author Dmitri Kolytchev
*2014-09-19 Ajout des variables "client", "demande" et "reponse" et de la connexion
*2014-09-17 Adaptation initiale du squelette
*@author Patrice Boucher
*2013-05-03 Version initiale
*******************************************************/



import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;


/**
 * Base d'une communication via un fil d'exécution parallèle.
 */
public class CommBase{
	
	private final int DELAI = 1000;
	private SwingWorker threadComm =null;
	private PropertyChangeListener listener = null;
	private boolean isActif = false;
	
	

	private Socket client;
    private BufferedReader reponse;
    private PrintWriter demande;
    
	/**
	 * Constructeur
	 */
	public CommBase(){
	}
	
	/**
	 * Définir le récepteur de l'information reçue dans la communication avec le serveur
	 * @param listener sera alerté lors de l'appel de "firePropertyChanger" par le SwingWorker
	 */
	public void setPropertyChangeListener(PropertyChangeListener listener){
		this.listener = listener;
	}
	
	/**
	 * Démarre la communication
	 */
	public void start(){
		
		String query = JOptionPane.showInputDialog(null, "Veuillez spécifier le serveur et le port", "serveur:port");
		
		if(query == null || query.isEmpty())
			return; // cancellation utilisateur
		
		else if(query.matches("^[a-zA-Z0-9\\.\\-\\_]+:[0-9]+$") == false){
			JOptionPane.showMessageDialog(null, "Veuillez vous assurer que l'addresse est sous la forme de \"serveur:port\"\n(le port doit être numérique)");
			return;
		}
		
		String[] addresse = query.split(":");
		
		/*
		 * Esseyer de se connecter au serveur. Si une erreur survient, notifier l'utilisateur.
		 */
		
		try {
			
			client = new Socket(addresse[0], Integer.parseInt(addresse[1]));
			
			/*=========================================================================================================
			 * CODE EMPRUNTÉ:
			 * les variables "reponse" et "demande" sont basées sur le code de ce tutoriel:
			 * http://docs.oracle.com/javase/tutorial/networking/sockets/readingWriting.html
			 * J'ai utilisé les exemples de BufferedReader et PrintWriter pour réaliser la communication client-serveur
			 *=========================================================================================================*/
			reponse = new BufferedReader(new InputStreamReader(client.getInputStream()));
		    demande = new PrintWriter(client.getOutputStream(), true);
		    /*
		     * Fin du code emprunté.
		     */
		    
			creerCommunication();
		    
		} catch (UnknownHostException e) {
			// On réussit pas à trouver un serveur, notifier l'utilisateur.
			JOptionPane.showMessageDialog(null, "Le serveur spécifié n'a pas pu être trouvé (vérifiez votre addresse)");
			return;
			
		} catch (ConnectException e) {
			// On réussit pas à nous connecter à un serveur, notifier l'utilisateur.
			JOptionPane.showMessageDialog(null, "Le serveur spécifié a refusé la connection (est-ce que le port est le bon?)");
			return;
			
		} catch (IOException e) {
			// Une erreur de transfert est survenue, notifier l'utilisateur
			JOptionPane.showMessageDialog(null, "Erreur de connexion.");
			return;
		} 
	}
	
	/**
	 * Arrête la communication et effectue une remise-à-zéro pour pouvoir retenter une connexion ultérieure.
	 */
	public void stop(){

		isActif = false;
		
		try{
			if(demande != null) demande.println("END");
			reponse.close();
			demande.close();
			client.close();
			
		} catch(Exception e){
			// quelques objets sont nuls, probablement parce que le serveur s'est déconnecté. Rien à faire ici.
		}
		
		reponse = null;
	    demande = null;
		client = null;
		
	}
	
	/**
	 * Crée un processus parallèle qui s'occupera de la communication. Lance des Évènements PropertyChange pour signaler son état.
	 */
	protected void creerCommunication(){		
		// Crée un fil d'exécusion paralléle au fil courant,
		
		threadComm = new SwingWorker(){
			
			@Override
			protected Object doInBackground() throws Exception {
				String shell = "";
				while(isActif && shell != null){ // quand shell devient null, le serveur a quitté 
					try{
						// C'EST DANS CETTE BOUCLE QU'ON COMMUNIQUE AVEC LE SERVEUR
						shell = reponse.readLine();
						
						if(shell!= null && shell.equals("commande> ")){
							for(int i = 0; i<10; i++){
								demande.println("GET");
			 					//La méthode suivante alerte l'observateur 
								if(listener!=null){
									firePropertyChange("FORME-CREE", null, (Object) reponse.readLine());
									reponse.readLine();
								}
							}
						}
						
						isActif = false;
					}catch (Exception e){
						// attrapper les erreurs pour empecher le Thread de s'interrompre.
						isActif = false;
					}
				}
				if(shell == null) firePropertyChange("CONNEXION", null, (Object) "END");
				stop();
				return null;
			}
		};
		
		if(listener!=null)
			threadComm.addPropertyChangeListener(listener); // La méthode "propertyChange" de ApplicationFormes sera donc appelée lorsque le SwingWorker invoquera la méthode "firePropertyChanger"

		threadComm.execute(); // Lance le fil d'exécution parallèle.
		isActif = true;
	}
	
	/**
	 * @return si le fil d'exécution parallèle est actif
	 */
	public boolean isActif(){
		return isActif;
	}
}
