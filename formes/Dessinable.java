package formes;
/******************************************************
Cours :				LOG121
Session :			Automne 2014
Groupe :			01
Projet :			Exercice 1

??tudiant(e)(s) :	Kolytchev, Dmitri
Code(s) perm. :		KOLD15088804

Professeur :		Ghizlane El boussaidi
Charg??s de labo.:	Alvine Boaye Belle et Michel Gagnon
Nom du fichier:		Dessinable.java
Date cr??e :			2013-05-03
Date dern. modif.	2014-09-18
*******************************************************
Historique des modifications
*******************************************************
*@author Dmitri Kolytchev
*2014-09-18 Cr??ation de l'interface Dessinable
*******************************************************/

import java.awt.Graphics;

public interface Dessinable {
	/**
	 * @param g objet graphique sur lequel le Dessinable se dessinera
	 **/


	public void dessinerForme(Graphics g);
	public void dessinerForme(Graphics g, int x, int y);
	public void dessinerCadre(Graphics g, int x, int y);
}
