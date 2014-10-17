package formes;
/******************************************************
Cours :				LOG121
Session :			Automne 2014
Groupe :			01
Projet :			Laboratoire 2

�tudiant(e)(s) :	Kolytchev Dmitri, Morra Mario, Girard Alexandre.
Code(s) perm. :		KOLD15088804, MORM07039202, GIRA08059305

Professeur :		Ghizlane El boussaidi
Charg�s de labo.:	Alvine Boaye Belle et Michel Gagnon
Nom du fichier :	Dessinable.java
Date cr�e :			2013-05-03
Date dern. modif.	2014-10-16
*******************************************************
Historique des modifications
*******************************************************
*@author Dmitri Kolytchev
*2014-09-18 Cr�ation de l'interface Dessinable
*******************************************************/

import java.awt.Graphics;

public interface Dessinable {
	/**
	 * @param graphique objet graphique sur lequel le Dessinable se dessinera
	 **/


	public void dessinerForme(Graphics graphique);
	public void dessinerForme(Graphics graphique, int xCoord, int yCoord);
	public void dessinerCadre(Graphics graphique, int xCoord, int yCoord);
}
