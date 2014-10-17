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
Nom du fichier :	MenuFenetre.java
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



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;
import util.CommBase;

/**
 * Crée le menu de la fenêtre de l'application
 */
public class MenuFenetre extends JMenuBar{

	private static final long serialVersionUID = 1536336192561843187L;
	private static final int  MENU_DESSIN_DEMARRER_TOUCHE_MASK = ActionEvent.CTRL_MASK;
	private static final char MENU_DESSIN_DEMARRER_TOUCHE_RACC = KeyEvent.VK_D;
	private static final int  MENU_FICHIER_QUITTER_TOUCHE_MASK = ActionEvent.CTRL_MASK;
	private static final char MENU_FICHIER_QUITTER_TOUCHE_RACC = KeyEvent.VK_Q;
	private static final String
			MENU_FICHIER_TITRE = "app.frame.menus.file.title",
			MENU_FICHIER_QUITTER = "app.frame.menus.file.exit",
			MENU_DESSIN_TITRE = "app.frame.menus.draw.title",
			MENU_DESSIN_DEMARRER = "app.frame.menus.draw.start",
			MENU_AIDE_TITRE = "app.frame.menus.help.title",
			MENU_AIDE_PROPOS = "app.frame.menus.help.about";

	private JMenuItem demarrerMenuItem;
	private ButtonGroup groupTri = new ButtonGroup();
			
	private static final String MESSAGE_DIALOGUE_A_PROPOS = "app.frame.dialog.about";  
	private static final int DELAI_QUITTER_MSEC = 200;

	CommBase comm; // Pour activer/désactiver la communication avec le serveur

	/**
	 * Constructeur
	 */
	public MenuFenetre(CommBase comm) {
		this.comm = comm;
		addMenuDessiner();
		addMenuTrier();
		addMenuFichier();
		addMenuAide();
	}

	/**
	 *  Créer le menu "Draw".
	 */
	protected void addMenuDessiner() {
		JMenu menu = creerMenu(MENU_DESSIN_TITRE, new String[] { MENU_DESSIN_DEMARRER });

		demarrerMenuItem = menu.getItem(0);
		demarrerMenuItem.addActionListener(new ActionListener(){
		  public void actionPerformed(ActionEvent arg0) {
			comm.start();
		  }
		});
		demarrerMenuItem.setAccelerator(KeyStroke.getKeyStroke(
				MENU_DESSIN_DEMARRER_TOUCHE_RACC,
				MENU_DESSIN_DEMARRER_TOUCHE_MASK));
		
		add(menu);
	}

	/**
	 * Créer le menu "File".
	 */
	protected void addMenuFichier() {
		JMenu menu = creerMenu(MENU_FICHIER_TITRE, new String[] { MENU_FICHIER_QUITTER });

		// Quitter
		menu.getItem(0).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(arg0.toString());
				comm.stop();

			    try {
						Thread.sleep(DELAI_QUITTER_MSEC);
				} catch (InterruptedException e) {
						e.printStackTrace();
				}
				System.exit(0);
			}
		});

		// Quitter
		menu.getItem(0).setAccelerator(
				KeyStroke.getKeyStroke(MENU_FICHIER_QUITTER_TOUCHE_RACC,
						MENU_FICHIER_QUITTER_TOUCHE_MASK));
		add(menu);
	}

	/**
	 *  Créer le menu "Help".
	 */
	private void addMenuAide() {
		JMenu menu = creerMenu(MENU_AIDE_TITRE, new String[] { MENU_AIDE_PROPOS });
		menu.getItem(0).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,  LangueConfig.getResource(MESSAGE_DIALOGUE_A_PROPOS),
						LangueConfig.getResource(MENU_AIDE_PROPOS), JOptionPane.INFORMATION_MESSAGE);
			}
		});
		add(menu);
	}

	/**
	 * Créer un élément de menu à partir d'un champs principal et ses éléments
	 * @param titleKey champs principal
	 * @param itemKeys éléments
	 * @return le menu
	 */
	private static JMenu creerMenu(String titleKey,String[] itemKeys) {
        JMenu menu = new JMenu(LangueConfig.getResource(titleKey));
        for(int i=0; i < itemKeys.length; ++i) {
           menu.add(new JMenuItem(LangueConfig.getResource(itemKeys[i])));
        }
        return menu;
   }
	
	public void nettoyerMenuTrier() {
		groupTri.clearSelection();
	}
	
	// Cree le menu de Tri
	private void addMenuTrier() {
		JMenu menu = new JMenu("Trier");
		
		// Creation de tous les boutons necessaires
		JRadioButtonMenuItem MENU_TRI_NUMSEQCROISSANT = new JRadioButtonMenuItem("Numero Sequence (Croissant)");
		JRadioButtonMenuItem MENU_TRI_NUMSEQDECROISSANT = new JRadioButtonMenuItem("Numero de sequence (decroissant)");
		JRadioButtonMenuItem MENU_TRI_AIRCROISSANT = new JRadioButtonMenuItem("Aire de forme (croissant)");
		JRadioButtonMenuItem MENU_TRI_AIRDECROISSANT = new JRadioButtonMenuItem("Aire de forme (decroissant)");
		JRadioButtonMenuItem MENU_TRI_TYPEFORMEA = new JRadioButtonMenuItem("Type de forme (Carre, Rectangle, Cercle, Ovale, Ligne)");
		JRadioButtonMenuItem MENU_TRI_TYPEFORMEB = new JRadioButtonMenuItem("Type de forme (Ligne, Ovale, Cercle, Rectangle, Carre)");
		JRadioButtonMenuItem MENU_TRI_DISTANCE = new JRadioButtonMenuItem("Distance (croissante)");
		JRadioButtonMenuItem MENU_TRI_HAUTEURA = new JRadioButtonMenuItem("Hauteur (croissante)");
		JRadioButtonMenuItem MENU_TRI_HAUTEURB = new JRadioButtonMenuItem("Hauteur (decroissante)");
		JRadioButtonMenuItem MENU_TRI_LARGEURA = new JRadioButtonMenuItem("Largeur (croissante)");
		JRadioButtonMenuItem MENU_TRI_LARGEURB = new JRadioButtonMenuItem("Largeur (decroissante)");
		JRadioButtonMenuItem MENU_TRI_NORMAL = new JRadioButtonMenuItem("Normal");
		
		// Ajout au groupe de bouton afin d'avoir une selection possible
		groupTri.add(MENU_TRI_NUMSEQCROISSANT);
		groupTri.add(MENU_TRI_NUMSEQDECROISSANT);
		groupTri.add(MENU_TRI_AIRCROISSANT);
		groupTri.add(MENU_TRI_AIRDECROISSANT);
		groupTri.add(MENU_TRI_TYPEFORMEA);
		groupTri.add(MENU_TRI_TYPEFORMEB);
		groupTri.add(MENU_TRI_DISTANCE);
		groupTri.add(MENU_TRI_HAUTEURA);
		groupTri.add(MENU_TRI_HAUTEURB);
		groupTri.add(MENU_TRI_LARGEURA);
		groupTri.add(MENU_TRI_LARGEURB);
		groupTri.add(MENU_TRI_NORMAL);
		
		// Ajout au menu
		menu.add(MENU_TRI_NUMSEQCROISSANT);
		menu.add(MENU_TRI_NUMSEQDECROISSANT);
		menu.add(MENU_TRI_AIRCROISSANT);
		menu.add(MENU_TRI_AIRDECROISSANT);
		menu.add(MENU_TRI_TYPEFORMEA);
		menu.add(MENU_TRI_TYPEFORMEB);
		menu.add(MENU_TRI_DISTANCE);
		menu.add(MENU_TRI_HAUTEURA);
		menu.add(MENU_TRI_HAUTEURB);
		menu.add(MENU_TRI_LARGEURA);
		menu.add(MENU_TRI_LARGEURB);
		menu.add(MENU_TRI_NORMAL);
		
		// Ajout des actions pour chacun des boutons cree + communication avec CommBase
		
		// Tri Numero Sequence Croissant
		menu.getItem(0).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comm.firePropertyChange("TRI", "NseqCroissant");
			}
		});

		// Tri Numero Sequence Decroissant
		menu.getItem(1).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comm.firePropertyChange("TRI", "NseqDecroissant");
			}
		});

		// Tri Air Croissant
		menu.getItem(2).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comm.firePropertyChange("TRI", "AireCroissant");
			}
		});

		// Tri Air Decroissant
		menu.getItem(3).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comm.firePropertyChange("TRI", "AireDecroissant");
			}
		});

		// Tri Type forme A
		menu.getItem(4).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comm.firePropertyChange("TRI", "FormeCroissant");
			}
		});

		// Tri Type Forme B
		menu.getItem(5).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comm.firePropertyChange("TRI", "FormeDecroissant");
			}
		});

		// Tri Diagonale Croissant
		menu.getItem(6).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comm.firePropertyChange("TRI", "DiagonaleCroissant");
			}
		});

		// Tri Hauteur Croissant
		menu.getItem(7).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comm.firePropertyChange("TRI", "HauteurCroissant");
			}
		});

		// Tri Hauteur Decroissant
		menu.getItem(8).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comm.firePropertyChange("TRI", "HauteurDecroissant");
			}
		});

		// Tri Largeur croissant
		menu.getItem(9).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comm.firePropertyChange("TRI", "LargeurCroissant");
			}
		});

		// Tri Largeur decroissant
		menu.getItem(10).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comm.firePropertyChange("TRI", "LargeurDecroissant");
			}
		});

		// Remise au normal
		menu.getItem(11).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comm.firePropertyChange("TRI", "Normal");
			}
		});

		add(menu);
	}
}

