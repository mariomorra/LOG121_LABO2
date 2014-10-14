package util;
/******************************************************
Cours :				LOG121
Session :			Automne 2014
Groupe :			01
Projet :			Exercice 1

�tudiant(e)(s) :	Kolytchev, Dmitri
Code(s) perm. :		KOLD15088804

Professeur :		Ghizlane El boussaidi
Charg�s de labo.:	Alvine Boaye Belle et Michel Gagnon
Nom du fichier: 	CommBase.java
Date cr�e :			2013-05-03
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

import affichage.FenetrePrincipale;


/**
 * Base d'une communication via un fil d'ex�cution parall�le.
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
	 * D�finir le r�cepteur de l'information re�ue dans la communication avec le serveur
	 * @param listener sera alert� lors de l'appel de "firePropertyChanger" par le SwingWorker
	 */
	public void setPropertyChangeListener(PropertyChangeListener listener){
		this.listener = listener;
	}
	
	/**
	 * D�marre la communication
	 */
	public void start(){
		
		String query = JOptionPane.showInputDialog(null, "Veuillez sp�cifier le serveur et le port", "serveur:port");
		
		if(query == null || query.isEmpty())
			return; // cancellation utilisateur
		
		else if(query.matches("^[a-zA-Z0-9\\.\\-\\_]+:[0-9]+$") == false){
			JOptionPane.showMessageDialog(null, "Veuillez vous assurer que l'addresse est sous la forme de \"serveur:port\"\n(le port doit �tre num�rique)");
			return;
		}
		
		String[] addresse = query.split(":");
		
		/*
		 * Esseyer de se connecter au serveur. Si une erreur survient, notifier l'utilisateur.
		 */
		
		try {
			
			client = new Socket(addresse[0], Integer.parseInt(addresse[1]));
			
			/*=========================================================================================================
			 * CODE EMPRUNT�:
			 * les variables "reponse" et "demande" sont bas�es sur le code de ce tutoriel:
			 * http://docs.oracle.com/javase/tutorial/networking/sockets/readingWriting.html
			 * J'ai utilis� les exemples de BufferedReader et PrintWriter pour r�aliser la communication client-serveur
			 *=========================================================================================================*/
			reponse = new BufferedReader(new InputStreamReader(client.getInputStream()));
		    demande = new PrintWriter(client.getOutputStream(), true);
		    /*
		     * Fin du code emprunt�.
		     */
		    
			creerCommunication();
		    
		} catch (UnknownHostException e) {
			// On r�ussit pas � trouver un serveur, notifier l'utilisateur.
			JOptionPane.showMessageDialog(null, "Le serveur sp�cifi� n'a pas pu �tre trouv� (v�rifiez votre addresse)");
			return;
			
		} catch (ConnectException e) {
			// On r�ussit pas � nous connecter � un serveur, notifier l'utilisateur.
			JOptionPane.showMessageDialog(null, "Le serveur sp�cifi� a refus� la connection (est-ce que le port est le bon?)");
			return;
			
		} catch (IOException e) {
			// Une erreur de transfert est survenue, notifier l'utilisateur
			JOptionPane.showMessageDialog(null, "Erreur de connexion.");
			return;
		} 
	}
	
	/**
	 * Arr�te la communication et effectue une remise-�-z�ro pour pouvoir retenter une connexion ult�rieure.
	 */
	public void stop(){

		isActif = false;
		
		try{
			if(demande != null) demande.println("END");
			reponse.close();
			demande.close();
			client.close();
			
		} catch(Exception e){
			// quelques objets sont nuls, probablement parce que le serveur s'est d�connect�. Rien � faire ici.
		}
		
		reponse = null;
	    demande = null;
		client = null;
		
	}
	
	/**
	 * Cr�e un processus parall�le qui s'occupera de la communication. Lance des �v�nements PropertyChange pour signaler son �tat.
	 */
	protected void creerCommunication(){		
		// Cr�e un fil d'ex�cusion parall�le au fil courant,
		
		threadComm = new SwingWorker(){
			
			@Override
			protected Object doInBackground() throws Exception {
				String shell = "";
				while(isActif && shell != null){ // quand shell devient null, le serveur a quitt� 
					try{
						// C'EST DANS CETTE BOUCLE QU'ON COMMUNIQUE AVEC LE SERVEUR
						shell = reponse.readLine();
						for(int i = 0; i<10; i++){
							if(shell != null && shell.equals("commande> ")){
								demande.println("GET");
			 					//La m�thode suivante alerte l'observateur 
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
			threadComm.addPropertyChangeListener(listener); // La m�thode "propertyChange" de ApplicationFormes sera donc appel�e lorsque le SwingWorker invoquera la m�thode "firePropertyChanger"

		threadComm.execute(); // Lance le fil d'ex�cution parall�le.
		isActif = true;
	}
	
	/**
	 * @return si le fil d'ex�cution parall�le est actif
	 */
	public boolean isActif(){
		return isActif;
	}
}
