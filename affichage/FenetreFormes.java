package affichage;
/******************************************************
Cours :				LOG121
Session :			Automne 2014
Groupe :			01
Projet :			Laboratoire 2

�tudiant(e)(s) :	Kolytchev Dmitri, Morra Mario, Girard Alexandre.
Code(s) perm. :		KOLD15088804, MORM07039202, GIRA08059305

Professeur :		Ghizlane El boussaidi
Charg�s de labo.:	Alvine Boaye Belle et Michel Gagnon
Nom du fichier :	ComparateurTypeDecroissant.java
Date cr�e :			2013-05-03
Date dern. modif.	2014-10-16
*******************************************************
Historique des modifications
*******************************************************
*@author Dmitri Kolytchev
*2014-09-26 Am??lioration de la documentation
*2014-09-17 Adaptation initiale du squelette
*@author Patrice Boucher
*2013-05-03 Version initiale
*******************************************************/



import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;

import comparateur.ComparateurAireCroissant;
import comparateur.ComparateurAireDecroissant;
import comparateur.ComparateurDiagonaleCroissant;
import comparateur.AbstractComparateurForme;
import comparateur.ComparateurHauteurCroissant;
import comparateur.ComparateurHauteurDecroissant;
import comparateur.ComparateurLargeurCroissant;
import comparateur.ComparateurLargeurDecroissant;
import comparateur.ComparateurNumSeqCroissant;
import comparateur.ComparateurNumSeqDecroissant;
import comparateur.ComparateurTypeCroissant;
import comparateur.ComparateurTypeDecroissant;
import formes.AbstractForme;
import formes.TableauFormes;

/**
 * Cette fen�tre g�n�re l'affichage des formes 
 * @author Patrice Boucher
 * @date 2013/05/04
 */
public class FenetreFormes extends JComponent{
	
	private static final long serialVersionUID = -2262235643903749505L;
	// Variable finale pour la largeur de la fenetre
	public static final int WIDTH = 500;
	// Variable finale pour la hauteur de la fenetre
	public static final int HEIGHT = 500;
	// Dimension de la fenetre
	public static final Dimension DIMENSION = new Dimension(500,500);
	
	private final static int OFFSETX = 40;
	private final static int OFFSETY = 40;
	
	// Liste des formes
	private final TableauFormes formesList;
	
	/**
	 * Constructeur
	 */
	public FenetreFormes(){
		super();
		formesList = new TableauFormes();
	}
	
	/**
	 * Affiche la liste de formes 
	 */
	@Override 
	public void paintComponent(Graphics graphique){
		int i = 0;
		AbstractForme formeActuelle = formesList.debut();
		while(formeActuelle != null){
		// Si la liste a ete trie, on affiche selon la position x * 40	
			if(formesList.estTrie()) {
				formeActuelle.dessinerForme(graphique, i*OFFSETX, i*OFFSETY);
			} else {
				// Sinon on affiche la forme
				formeActuelle.dessinerForme(graphique); 
			}
			// Permet d'avoir un index pour la liste triee (i * 40)
			i++;
			formeActuelle = formeActuelle.obtenirFormeSuivante();
		}
		// Reinitialise la variable trie a false afin de pouvoir retrier
		formesList.setTrie(false);
	}
	
	/**
	 * Le Layout qui utilise (contient) FenetreFormes doit r??server 
	 * l'espace necessaire et son affichage
	 */
	@Override 
	public Dimension getPreferredSize(){
		return DIMENSION;
	}
	
	/**
	 * @param f prend une Forme et l'ajoute a la fin de la liste des formes a dessiner. Si la liste depasserait 10, les elements les plus vieux (les premiers de la liste) se font enlever.
	 */
	public void ajout(final AbstractForme nouvelleForme){
		formesList.ajouterForme(nouvelleForme);
		repaint();
	}
	
	// Fonction permettant la communication entre FenetreFormes et CommBase
	public void firePropertyChange(final String type, final Object nouveau, final Object vieux){
		AbstractComparateurForme comparator = null;
		// Permet de creer le bon comparateur selon la valeur selectionne dans la liste
		switch(type){
			case "NseqCroissant":
				comparator = new ComparateurNumSeqCroissant();
				break;
			
			case "NseqDecroissant" :
				comparator = new ComparateurNumSeqDecroissant();
				break;
			
			case "AireCroissant":
				comparator = new ComparateurAireCroissant();
				break;
			
			case "AireDecroissant" :
				comparator = new ComparateurAireDecroissant();
				break;
			
			case "FormeCroissant" :
				comparator = new ComparateurTypeCroissant();
				break;
				
			case "FormeDecroissant" :
				comparator = new ComparateurTypeDecroissant();
				break;
				
			case "DiagonaleCroissant" :
				comparator = new ComparateurDiagonaleCroissant();
				break;
				
			case "HauteurCroissant" :
				comparator = new ComparateurHauteurCroissant();
				break;
				
			case "HauteurDecroissant" :
				comparator = new ComparateurHauteurDecroissant();
				break;
				
			case "LargeurCroissant" :
				comparator = new ComparateurLargeurCroissant();
				break;
				
			case "LargeurDecroissant" :
				comparator = new ComparateurLargeurDecroissant();
				break;
				
			case "Normal" :
				formesList.remettreANeuf();
				break;
			default : return;
		}
		// Si le comparateur a une valeur, on tri les formes selon la demande et on repeinture le graphique
		if(comparator != null) {
			formesList.trier(comparator);
		}
		repaint();
	}
}
