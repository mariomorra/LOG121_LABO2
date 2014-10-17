/******************************************************
Cours :				LOG121
Session :			Automne 2014
Groupe :			01
Projet :			Laboratoire 2

�tudiant(e)(s) :	Kolytchev Dmitri, Morra Mario, Girard Alexandre.
Code(s) perm. :		KOLD15088804, MORM07039202, GIRA08059305

Professeur :		Ghizlane El boussaidi
Charg�s de labo.:	Alvine Boaye Belle et Michel Gagnon
Nom du fichier :	TableauFormes.java
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

public class Ligne extends AbstractForme {

	private final transient int xCoord1;
	private final transient int yCoord1;
	private final transient int xCoord2;
	private final transient int yCoord2;

	public Ligne(final int noSequence, final int xCoord1, final int yCoord1, final int xCoord2, final int yCoord2){
		super();
		super.noSequence = noSequence;
		super.couleur = Color.BLACK;
		this.xCoord1 = xCoord1;
		this.yCoord1 = yCoord1;
		this.xCoord2 = xCoord2;
		this.yCoord2 = yCoord2;
	}

	public int obtenirX(){
		return xCoord1;
	}

	public int obtenirY(){
		return yCoord1;
	}

	public int obtenirX2(){
		return xCoord2;
	}

	public int obtenirY2(){
		return yCoord2;
	}

	public int obtenirHauteur() {
		return Math.abs(yCoord2-yCoord1);
	}

	public int obtenirLargeur() {
		return Math.abs(xCoord2-xCoord1);
	}

	public void dessinerForme(final Graphics graphique) {
		dessinerForme(graphique, xCoord1, yCoord1);
	}

	public void dessinerForme(final Graphics graphique, final int xCoord, final int yCoord) {
		graphique.setColor(couleur);
		graphique.drawLine(xCoord, yCoord, xCoord+obtenirLargeur(), yCoord+obtenirHauteur());
		if(xCoord != xCoord1 && yCoord != yCoord1) {
			dessinerCadre(graphique, xCoord, yCoord);
		}
	}

	public double obtenirDiagonale() {
		return Math.sqrt(Math.pow(xCoord2-xCoord1, 2) + Math.pow(yCoord2-yCoord1, 2));
	}

	public double obtenirAire() {
		// si on compte l'aire que ca occupe en pixels...
		return Math.max(obtenirLargeur(), obtenirHauteur());
		//return obtenirDiagonale();
	}
}
