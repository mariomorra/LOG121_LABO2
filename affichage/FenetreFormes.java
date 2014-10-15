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
Nom du fichier: 	FenetreFormes.java
Date cr??e :			2013-05-03
Date dern. modif.	2014-09-17
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

import formes.Forme;
import formes.TableauFormes;

/**
 * Cette fen??tre g??n??re l'affichage des formes 
 * @author Patrice Boucher
 * @date 2013/05/04
 */
public class FenetreFormes extends JComponent{
	
	private static final long serialVersionUID = -2262235643903749505L;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	public static final Dimension dimension = new Dimension(500,500);
	
	private final int offsetX = 80;
	private final int offsetY = 50;
	
	private TableauFormes formesList;
	
	/**
	 * Constructeur
	 */
	public FenetreFormes(){
		formesList = new TableauFormes();
	}
	
	/**
	 * Affiche la liste de formes 
	 */
	@Override 
	public void paintComponent(Graphics g){
		int i = 0;
		Forme formeActuelle = formesList.debut();
		while(formeActuelle != null){
			if(formesList.estTrie())
				formeActuelle.dessinerForme(g, i*offsetX, i*offsetY);
			else
				formeActuelle.dessinerForme(g);
			formeActuelle = formeActuelle.obtenirFormeSuivante();
			i++;
		}
		
	}
	
	/**
	 * Le Layout qui utilise (contient) FenetreFormes doit r??server 
	 * l'espace n??cessaire ?? son affichage
	 */
	@Override 
	public Dimension getPreferredSize(){
		return dimension;
	}
	
	/**
	 * @param f prend une Forme et l'ajoute ?? la fin de la liste des formes ?? dessiner. Si la liste d??passerait 10, les ??l??ments les plus vieux (les premiers de la liste) se font enlever.
	 */
	public void ajout(Forme nouvelleForme){
		formesList.ajouterForme(nouvelleForme);
		repaint();
	}
}
