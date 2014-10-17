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


public class Rectangle extends AbstractForme {

	protected transient int xCoord1;
	protected transient int yCoord1;
	protected transient int xCoord2;
	protected transient int yCoord2;

	public Rectangle(final int noSequence, final int xCoord1, final int yCoord1, final int xCoord2, final int yCoord2){
		super();
		super.noSequence = noSequence;
		super.couleur = new Color(0xA6FF0000, true);
		this.xCoord1 = Math.min(xCoord1, xCoord2);
		this.yCoord1 = Math.min(yCoord1, yCoord2);
		this.xCoord2 = Math.max(xCoord1, xCoord2);
		this.yCoord2 = Math.max(yCoord1, yCoord2);
	}

	public int obtenirX(){
		return xCoord1;
	}

	public int obtenirY(){
		return yCoord1;
	}

	public int obtenirHauteur(){
		return yCoord2-yCoord1;
	};

	public int obtenirLargeur(){
		return xCoord2-xCoord1;
	};

	public void dessinerForme(final Graphics graphique) {
		dessinerForme(graphique, xCoord1, yCoord1);
	};

	public void dessinerForme(final Graphics graphique, final int xCoord, final int yCoord) {
		graphique.setColor(Color.BLACK);
		graphique.drawRect(xCoord, yCoord, obtenirLargeur(), obtenirHauteur());
		graphique.setColor(couleur);
		graphique.fillRect(xCoord, yCoord, obtenirLargeur(), obtenirHauteur());
		if(xCoord != xCoord1 && yCoord != yCoord1) {
			dessinerCadre(graphique, xCoord, yCoord);
		}
	}

	public double obtenirDiagonale() {
		return Math.sqrt(Math.pow(obtenirLargeur(), 2) + Math.pow(obtenirHauteur(), 2));
	}

	public double obtenirAire() {
		return obtenirLargeur() * obtenirHauteur();
	}

}
