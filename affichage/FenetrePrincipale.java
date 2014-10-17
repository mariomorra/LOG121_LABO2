package affichage;
/******************************************************
Cours :				LOG121
Session :			Automne 2014
Groupe :			01
Projet :			Laboratoire 2

Étudiant(e)(s) :	Kolytchev Dmitri, Morra Mario, Girard Alexandre.
Code(s) perm. :		KOLD15088804, MORM07039202, GIRA08059305

Professeur :		Ghizlane El boussaidi
Chargés de labo.:	Alvine Boaye Belle et Michel Gagnon
Nom du fichier :	FenetrePrincipale.java
Date crée :			2013-05-03
Date dern. modif.	2014-10-16
*******************************************************
Historique des modifications
*******************************************************
*@author Dmitri Kolytchev
*2014-09-17 Adaptation initiale du squelette
*@author Patrice Boucher
*2013-05-03 Version initiale
*******************************************************/



import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import util.CommBase;
import util.ParseurRegex;
import formes.UsineFormes;

/**
 * Cette classe représente la fenêtre principale de l'application 
 * @author Patrice Boucher
 * @date 2013/05/04
 */
public class FenetrePrincipale extends JFrame implements PropertyChangeListener, WindowListener{
	
	private static final long serialVersionUID = -1210804336046370508L;

	private MenuFenetre menu;
	private CommBase communicateur;
	private FenetreFormes fenetreFormes;
	
	/**
	 * Constructeur
	 */
	public FenetrePrincipale(CommBase comm){
		
		communicateur = comm;
		menu = new MenuFenetre(comm);
		fenetreFormes = new FenetreFormes();
		
		this.setLayout(new BorderLayout());
		this.add(menu, BorderLayout.NORTH); 
		this.add(fenetreFormes, BorderLayout.CENTER); // Ajoute la fenêtre de forme à la fenêtre principale
		this.pack(); // Ajuste la dimension de la fenêtre principale selon celle de ses composants
		this.setVisible(true); // Rend la fenêtre principale visible.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //... à réviser selon le comportement que vous désirez ...
		this.addWindowListener(this);
	}
	
	// Appelé lorsque le sujet lance "firePropertyChanger"
	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		if(arg0.getPropertyName().equals("FORME-CREE"))	{
			String formeString = (String) arg0.getNewValue();
			menu.nettoyerMenuTrier();	// Enleve l'element selectionne de la liste de tri
			
			if(formeString != null){
				System.out.println("adding : " + formeString);
				//	Permet de creer la forme recu du serveur
				fenetreFormes.ajout(UsineFormes.genereForme(ParseurRegex.getDescription(formeString)));
			}
			
		}else if(arg0.getPropertyName().equals("CONNEXION")){
			String statusString = (String) arg0.getNewValue();
			if(statusString != null && statusString.equals("END")){
				JOptionPane.showMessageDialog(null, "Le serveur a d??connect?? de fa??on inattendue.");
			}
			
		}else if(arg0.getPropertyName().equals("TRI")){
			fenetreFormes.firePropertyChange(arg0.getOldValue().toString(), null, null);
		}
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		communicateur.stop();
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
