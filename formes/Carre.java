/******************************************************
Cours :				LOG121
Session :			Automne 2014
Groupe :			01
Projet :			Laboratoire 2

�tudiant(e)(s) :	Kolytchev Dmitri, Morra Mario, Girard Alexandre.
Code(s) perm. :		KOLD15088804, MORM07039202, GIRA08059305

Professeur :		Ghizlane El boussaidi
Charg�s de labo.:	Alvine Boaye Belle et Michel Gagnon
Nom du fichier :	Carre.java
Date cr�e :			2013-05-03
Date dern. modif.	2014-10-16
*******************************************************
Historique des modifications
*******************************************************
*@author Dmitri Kolytchev
*2014-09-17 Adaptation initiale du squelette
*@author Patrice Boucher
*2013-05-03 Version initiale
*******************************************************/


package formes;

import java.awt.Color;

public class Carre extends Rectangle {

	public Carre(final int noSequence, final int xCoord1, final int yCoord1, final int xCoord2, final int yCoord2) {
		super(noSequence, xCoord1, yCoord1, xCoord2, yCoord2);
		super.couleur = new Color(0xA6FF8000, true);
	}

}
