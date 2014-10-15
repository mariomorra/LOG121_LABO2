/******************************************************
Cours : LOG121
Session : A2014
Groupe : 01
Projet : Laboratoire #1
???tudiant : Mario Morra
Code(s) perm. : MORM07039202 (AM54710)
Professeur : Ghizlane El boussaidi
Charg???s de labo : Alvine Boaye Belle et Michel Gagnon
Nom du fichier : Ellipse.java
Date cr?????? : 2014-09-20
Date dern. modif. 2014-09-20
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
import java.awt.Stroke;

public class Ellipse extends Forme {

	protected int centreX;
	protected int centreY;
	protected int rayonV;
	protected int rayonH;

	public Ellipse(int nseq, int x, int y, int h, int l){
		super.nseq = nseq;
		super.couleur = new Color(0xA600FF00, true);
		this.centreX = x;
		this.centreY = y;
		this.rayonV = h;
		this.rayonH = l;
	}

	public int obtenirX(){
		return centreX;
	}

	public int obtenirY(){
		return centreY;
	}

	public int obtenirHauteur(){
		return rayonV;
	};

	public int obtenirLargeur(){
		return rayonH;
	}

	public void dessinerForme(Graphics g) {
		dessinerForme(g, centreX, centreY);
	};

	public void dessinerForme(Graphics g, int x, int y) {

		g.setColor(couleur);
		g.fillOval(x, y, rayonH, rayonV);
		g.setColor(Color.BLACK);
		g.drawOval(x, y, rayonH, rayonV);
		
		if(x != centreX && y != centreY)
			dessinerCadre(g, x, y);


	}

	public double obtenirDiagonale() {
		return Math.max(rayonV, rayonH)*2;
	}

	public double obtenirAire() {
		return (int) (Math.PI * rayonV * rayonH);
	}


}
