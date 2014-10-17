/******************************************************
Cours :				LOG121
Session :			Automne 2014
Groupe :			01
Projet :			Laboratoire 2

Étudiant(e)(s) :	Kolytchev Dmitri, Morra Mario, Girard Alexandre.
Code(s) perm. :		KOLD15088804, MORM07039202, GIRA08059305

Professeur :		Ghizlane El boussaidi
Chargés de labo.:	Alvine Boaye Belle et Michel Gagnon
Nom du fichier :	Forme.java
Date crée :			2013-05-03
Date dern. modif.	2014-10-16
*******************************************************
Historique des modifications
*******************************************************
2014-09-20 Version initiale
*******************************************************/

package formes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public abstract class Forme implements Cloneable, FormeChainee, Dessinable{

	protected int nseq;
	protected Color couleur;
	protected int coordA;
	protected int coordB;
	protected int coordC;
	protected int coordD;

	protected Forme formePrecedente;
	protected Forme formeSuivante;

	public int obtenirNseq() {return nseq;}

	public Color obtenirCouleur() {return couleur;}


	public abstract int obtenirX();
	public abstract int obtenirY();
	public abstract int obtenirHauteur();
	public abstract int obtenirLargeur();
	public abstract double obtenirDiagonale();
	public abstract double obtenirAire();
	
	public abstract void dessinerForme(Graphics g);
	public abstract void dessinerForme(Graphics g, int x, int y);
	
	// Fonctione permettant de dessiner le cardre pointille autour des formes
	public void dessinerCadre(Graphics g, int x, int y){

		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10, new float[]{3}, 0));
		g2d.drawRect(x,  y,  obtenirLargeur(), obtenirHauteur());
		g2d.dispose();
		
	};
	
	public Forme obtenirFormePrecedente(){
		return formePrecedente;
	}

	public Forme obtenirFormeSuivante(){
		return formeSuivante;
	}

	public boolean estTete(){
		return formePrecedente == null;
	}

	public void assignerFormeSuivante(Forme nouvelleForme) {
		formeSuivante = nouvelleForme;
	}

	public void assignerFormePrecedente(Forme nouvelleForme) {
		formePrecedente = nouvelleForme;
	}

	@Override
	public Forme clone() throws CloneNotSupportedException{
		return (Forme) super.clone();
	}


}
