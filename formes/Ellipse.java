/******************************************************
Cours :				LOG121
Session :			Automne 2014
Groupe :			01
Projet :			Laboratoire 2

�tudiant(e)(s) :	Kolytchev Dmitri, Morra Mario, Girard Alexandre.
Code(s) perm. :		KOLD15088804, MORM07039202, GIRA08059305

Professeur :		Ghizlane El boussaidi
Charg�s de labo.:	Alvine Boaye Belle et Michel Gagnon
Nom du fichier :	Ellipse.java
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

public class Ellipse extends AbstractForme {

	protected transient int centreX;
	protected transient int centreY;
	protected transient int rayonV;
	protected transient int rayonH;

	public Ellipse(final int noSequence, final int xCoord, final int yCoord, final int hauteur, final int largeur){
		super();
		super.noSequence = noSequence;
		super.couleur = new Color(0xA600FF00, true);
		this.centreX = xCoord;
		this.centreY = yCoord;
		this.rayonV = hauteur;
		this.rayonH = largeur;
	}

	public int obtenirX(){
		return centreX;
	}

	public int obtenirY(){
		return centreY;
	}

	public int obtenirHauteur(){
		return rayonV*2;
	};

	public int obtenirLargeur(){
		return rayonH*2;
	}

	public void dessinerForme(final Graphics graphique) {
		dessinerForme(graphique, centreX, centreY);
	};

	public void dessinerForme(final Graphics graphique, final int xCoord, final int yCoord) {

		graphique.setColor(couleur);
		graphique.fillOval(xCoord, yCoord, obtenirLargeur(), obtenirHauteur());
		graphique.setColor(Color.BLACK);
		graphique.drawOval(xCoord, yCoord, obtenirLargeur(), obtenirHauteur());
		
		if(xCoord != centreX && yCoord != centreY) {
			dessinerCadre(graphique, xCoord, yCoord);
		}

	}

	public double obtenirDiagonale() {
		return Math.max(rayonV, rayonH);
	}

	public double obtenirAire() {
		return Math.PI * rayonV * rayonH;
	}


}
