/******************************************************
Cours :				LOG121
Session :			Automne 2014
Groupe :			01
Projet :			Laboratoire 2

�tudiant(e)(s) :	Kolytchev Dmitri, Morra Mario, Girard Alexandre.
Code(s) perm. :		KOLD15088804, MORM07039202, GIRA08059305

Professeur :		Ghizlane El boussaidi
Charg�s de labo.:	Alvine Boaye Belle et Michel Gagnon
Nom du fichier :	Rectangle.java
Date cr�e :			2013-05-03
Date dern. modif.	2014-10-16
*******************************************************
Historique des modifications
*******************************************************
2014-09-20 Version initiale
*******************************************************/

package formes;


import java.awt.Color;
import java.awt.Graphics;


public class Rectangle extends Forme {

	protected int x1;
	protected int y1;
	protected int x2;
	protected int y2;

	public Rectangle(int nseq, int x1, int y1, int x2, int y2){
		super.nseq = nseq;
		super.couleur = new Color(0xA6FF0000, true);
		this.x1 = Math.min(x1, x2);
		this.y1 = Math.min(y1, y2);
		this.x2 = Math.max(x1, x2);
		this.y2 = Math.max(y1, y2);
	}

	public int obtenirX(){
		return x1;
	}

	public int obtenirY(){
		return y1;
	}

	public int obtenirHauteur(){
		return y2-y1;
	};

	public int obtenirLargeur(){
		return x2-x1;
	};

	public void dessinerForme(Graphics g) {
		dessinerForme(g, x1, y1);
	};

	public void dessinerForme(Graphics g, int x, int y) {
		g.setColor(Color.BLACK);
		g.drawRect(x, y, obtenirLargeur(), obtenirHauteur());
		g.setColor(couleur);
		g.fillRect(x, y, obtenirLargeur(), obtenirHauteur());
		if(x != x1 && y != y1)
			dessinerCadre(g, x, y);
	}

	public void dessinerCadre(Graphics g, int x, int y) {

	}

	public double obtenirDiagonale() {
		return Math.sqrt(Math.pow(obtenirLargeur(), 2) + Math.pow(obtenirHauteur(), 2));
	}

	public double obtenirAire() {
		return obtenirLargeur() * obtenirHauteur();
	}

}
