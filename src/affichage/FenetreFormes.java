/******************************************************
Cours : LOG121
Session : A2014
Groupe : 01
Projet : Laboratoire #1
�tudiant : Mario Morra
Code(s) perm. : MORM07039202 (AM54710)
Professeur : Ghizlane El boussaidi
Charg�s de labo : Alvine Boaye Belle et Michel Gagnon
Nom du fichier : FenetreFormes.java
Date cr�� : 2014-09-20
Date dern. modif. 2014-09-20
*******************************************************
Historique des modifications
*******************************************************
2014-09-20 Version initiale
2014-09-26 Ajout de la m�thode afficherForme
2014-09-29 Suppression de la m�thode afficherForme
           et modification de paintComponent
*******************************************************/

package affichage;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;

import formes.Carre;
import formes.Cercle;
import formes.Ellipse;
import formes.Forme;
import formes.Ligne;
import formes.Rectangle;
import formes.TableauFormes;

public class FenetreFormes extends JComponent {
	
	private static final long serialVersionUID = -2262235643903749505L;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	public static final Dimension dimension = new Dimension(500,500);
	
	TableauFormes formes;

	public FenetreFormes(){
		formes = new TableauFormes();
	}
	
	
	@Override 
	public void paintComponent(Graphics g){	
//		repaint();
//		for(Forme f : formes.tableau()){
//			if(f != null){
//				g.setColor(f.obtenirCouleur());
//				Class<? extends Forme> c = f.getClass();
//				//if(c == Rectangle.class){
//				if(c == Rectangle.class || c == Carre.class){	
//					g.fillRect(f.obtenirX(), f.obtenirY(), f.obtenirLargeur(), f.obtenirHauteur());
//				}
//				if(c == Ligne.class){
//					Ligne l = (Ligne)f; //Pour �viter la confusion on offre des m�thodes sp�cifiques por la ligne
//					g.drawLine(l.obtenirX(), l.obtenirY(), l.obtenirX2(), l.obtenirY2());
//				}
//				if(c == Ellipse.class || c == Cercle.class){
//					g.fillOval(f.obtenirX(), f.obtenirY(), f.obtenirLargeur(), f.obtenirHauteur());
//				}
//			}
//		}	 	
	}

	@Override 
	public Dimension getPreferredSize(){
		return dimension;
	}
	
	public void ajouterForme(Forme f){
		if(f != null){
			formes.ajouterForme(f);
			paintComponent(this.getGraphics());	
		}
	}
	
}

