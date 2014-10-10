/******************************************************
Cours : LOG121
Session : A2014
Groupe : 01
Projet : Laboratoire #1
�tudiant : Mario Morra
Code(s) perm. : MORM07039202 (AM54710)
Professeur : Ghizlane El boussaidi
Charg�s de labo : Alvine Boaye Belle et Michel Gagnon
Nom du fichier : Cercle.java
Date cr�� : 2014-09-20
Date dern. modif. 2014-09-20
*******************************************************
Historique des modifications
*******************************************************
2014-09-20 Version initiale
*******************************************************/


package formes;

import java.awt.Color;

public class Carre extends Rectangle {

	public Carre(int nseq, int x1, int y1, int x2, int y2) {
		super(nseq, x1, y1, x2, y2);
		super.couleur = Color.ORANGE;
	}

}
