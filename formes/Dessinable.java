package formes;
/******************************************************
Cours :				LOG121
Session :			Automne 2014
Groupe :			01
Projet :			Laboratoire 2

Étudiant(e)(s) :	Kolytchev Dmitri, Morra Mario, Girard Alexandre.
Code(s) perm. :		KOLD15088804, MORM07039202, GIRA08059305

Professeur :		Ghizlane El boussaidi
Chargés de labo.:	Alvine Boaye Belle et Michel Gagnon
Nom du fichier :	Dessinable.java
Date crée :			2013-05-03
Date dern. modif.	2014-10-16
*******************************************************
Historique des modifications
*******************************************************
*@author Dmitri Kolytchev
*2014-09-18 Création de l'interface Dessinable
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
