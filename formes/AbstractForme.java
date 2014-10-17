/******************************************************
Cours :				LOG121
Session :			Automne 2014
Groupe :			01
Projet :			Laboratoire 2

�tudiant(e)(s) :	Kolytchev Dmitri, Morra Mario, Girard Alexandre.
Code(s) perm. :		KOLD15088804, MORM07039202, GIRA08059305

Professeur :		Ghizlane El boussaidi
Charg�s de labo.:	Alvine Boaye Belle et Michel Gagnon
Nom du fichier :	Forme.java
Date cr�e :			2013-05-03
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

public abstract class AbstractForme implements Cloneable, FormeChainee, Dessinable{

	protected transient int noSequence;
	protected transient Color couleur;
	protected transient int coordA;
	protected transient int coordB;
	protected transient int coordC;
	protected transient int coordD;

	protected transient AbstractForme formePrecedente;
	protected transient AbstractForme formeSuivante;

	public int obtenirNseq() {return noSequence;}

	public Color obtenirCouleur() {return couleur;}


	public abstract int obtenirX();
	public abstract int obtenirY();
	public abstract int obtenirHauteur();
	public abstract int obtenirLargeur();
	public abstract double obtenirDiagonale();
	public abstract double obtenirAire();
	
	public abstract void dessinerForme(final Graphics graphique);
	public abstract void dessinerForme(final Graphics graphique, final int xCoord, final int yCoord);
	
	// Fonctione permettant de dessiner le cardre pointille autour des formes
	public void dessinerCadre(final Graphics graphique, final int xCoord, final int yCoord){

		Graphics2D g2d = (Graphics2D) graphique.create();
		g2d.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10, new float[]{3}, 0));
		g2d.drawRect(xCoord,  yCoord,  obtenirLargeur(), obtenirHauteur());
		g2d.dispose();
		
	};
	
	public AbstractForme obtenirFormePrecedente(){
		return formePrecedente;
	}

	public AbstractForme obtenirFormeSuivante(){
		return formeSuivante;
	}

	public boolean estTete(){
		return formePrecedente == null;
	}

	public void assignerFormeSuivante(AbstractForme nouvelleForme) {
		formeSuivante = nouvelleForme;
	}

	public void assignerFormePrecedente(AbstractForme nouvelleForme) {
		formePrecedente = nouvelleForme;
	}

	@Override
	public AbstractForme clone() throws CloneNotSupportedException{
		return (AbstractForme) super.clone();
	}


}
