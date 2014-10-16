package affichage;
/******************************************************
Cours :				LOG121
Session :			Automne 2014
Groupe :			01
Projet :			Exercice 1

??tudiant(e)(s) :	Kolytchev, Dmitri
Code(s) perm. :		KOLD15088804

Professeur :		Ghizlane El boussaidi
Charg??s de labo.:	Alvine Boaye Belle et Michel Gagnon
Nom du fichier:		FenetrePrincipale.java
Date cr??e :			2013-05-03
Date dern. modif.	2014-09-17
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
import ca.etsmtl.log.util.IDLogger;
import formes.UsineFormes;

/**
 * Cette classe repr??sente la fen??tre principale de l'application 
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
		this.add(fenetreFormes, BorderLayout.CENTER); // Ajoute la fen??tre de forme ?? la fen??tre principale
		this.pack(); // Ajuste la dimension de la fen??tre principale selon celle de ses composants
		this.setVisible(true); // Rend la fen??tre principale visible.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //... ?? r??viser selon le comportement que vous d??sirez ...
		this.addWindowListener(this);
	}
	
	// Appel?? lorsque le sujet lance "firePropertyChanger"
	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		if(arg0.getPropertyName().equals("FORME-CREE")){
			String formeString = (String) arg0.getNewValue();
			
			if(formeString != null){
				System.out.println("adding: "+ formeString);
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
