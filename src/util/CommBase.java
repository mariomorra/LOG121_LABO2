/******************************************************
Cours : LOG121
Session : A2014
Groupe : 01
Projet : Laboratoire #1
Étudiant : Mario Morra
Code(s) perm. : MORM07039202 (AM54710)
Professeur : Ghizlane El boussaidi
Chargés de labo : Alvine Boaye Belle et Michel Gagnon
Nom du fichier : CommBase.java
Date créé : 2014-09-20
Date dern. modif. 2014-09-20
*******************************************************
Historique des modifications
*******************************************************
2014-09-20 Version initiale
2014-09-26 Boucle while
2014-10-02 Ajustement dans la méthode de connection
           Ajout des méthodes connect() et disconnect()
*******************************************************/

package util;

import java.beans.PropertyChangeListener;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.SwingWorker;

import affichage.FenetrePrincipale;
import formes.Carre;
import formes.Cercle;
import formes.Ellipse;
import formes.Forme;
import formes.Ligne;
import formes.Rectangle;

public class CommBase {
	
	private final int DELAI = 1000;
	private SwingWorker<?, ?> threadComm = null;
	private PropertyChangeListener listener = null;
	private boolean isActif = false;
	
	Socket skt;
	Scanner in;
	PrintStream out;
	String messageRecu;	
	
	public CommBase(){
		
	}
	
	public void connect(String host, int port){
		try{
			skt = new Socket(host, port);
			in = new Scanner(skt.getInputStream());
			out = new PrintStream(skt.getOutputStream());	
		}
		catch(Exception e){}
	}
	
	public void disconnect(){
		try{
			out.println("END");
			skt.close();
			in = null;
			out = null;
			skt = null;
		}
		catch(Exception e){}
	}
	
	public void setPropertyChangeListener(PropertyChangeListener listener){
		this.listener = listener;
	}
	
	public void start(){
		if(skt != null){creerCommunication();}
	}
	
	public void stop(){
		if(threadComm!=null)
			threadComm.cancel(true); 
		isActif = false;
		disconnect();
	}
	
	protected void creerCommunication(){		
		threadComm = new SwingWorker<Object, Object>(){

			@Override
			protected Object doInBackground() throws Exception {
			
				while(true){
					try{			
						
						out.flush();
						out.println("GET");
							
						Thread.sleep(DELAI);
						
						in.nextLine();
						messageRecu = in.nextLine();
					
						Forme nouvelleForme = CreateurFormes.creerForme(messageRecu);
						FenetrePrincipale.fenetreFormes.ajouterForme(nouvelleForme);
						
						if(listener!=null){
							firePropertyChange("ENVOIE-TEST", null, (Object) ".");
						}
					}
					catch(Exception ex){
						System.out.println(ex.getMessage());
						out.println("END");
						skt.close();
					}
					finally{
						
					}
					if(skt.isClosed()){
						break;
					}
				}	
				
				return null;
			}
		};
		if(listener!=null)
		   threadComm.addPropertyChangeListener(listener);	
		threadComm.execute();
		isActif = true;
	}
	
	public boolean isActif(){
		return isActif;
	}
}
