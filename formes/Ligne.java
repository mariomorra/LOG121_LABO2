/******************************************************
Cours :				LOG121
Session :			Automne 2014
Groupe :			01
Projet :			Laboratoire 2

Étudiant(e)(s) :	Kolytchev Dmitri, Morra Mario, Girard Alexandre.
Code(s) perm. :		KOLD15088804, MORM07039202, GIRA08059305

Professeur :		Ghizlane El boussaidi
Chargés de labo.:	Alvine Boaye Belle et Michel Gagnon
Nom du fichier :	TableauFormes.java
Date crée :			2013-05-03
Date dern. modif.	2014-10-16
*******************************************************
Historique des modifications
*******************************************************
2014-09-20 Version initiale
*******************************************************/

package formes;

import java.awt.Color;
import java.awt.Graphics;

public class Ligne extends Forme {

	private int x1;
	private int y1;
	private int x2;
	private int y2;

	public Ligne(int nseq, int x1, int y1, int x2, int y2){
		super.nseq = nseq;
		super.couleur = Color.BLACK;
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	public int obtenirX(){
		return x1;
	}

	public int obtenirY(){
		return y1;
	}

	public int obtenirX2(){
		return x2;
	}

	public int obtenirY2(){
		return y2;
	}

	public int obtenirHauteur() {
		return Math.abs(y2-y1);
	}

	public int obtenirLargeur() {
		return Math.abs(x2-x1);
	}

	public void dessinerForme(Graphics g) {
		dessinerForme(g, x1, y1);
	}

	public void dessinerForme(Graphics g, int x, int y) {
		g.setColor(couleur);
		g.drawLine(x, y, x+obtenirLargeur(), y+obtenirHauteur());
		if(x != x1 && y != y1)
			dessinerCadre(g, x, y);
	}

	public double obtenirDiagonale() {
		return Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
	}

	public double obtenirAire() {
		// si on compte l'aire que ca occupe en pixels...
		return Math.max(obtenirLargeur(), obtenirHauteur());
		//return obtenirDiagonale();
	}
}
