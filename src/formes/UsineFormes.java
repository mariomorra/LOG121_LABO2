package formes;
/******************************************************
Cours :				LOG121
Session :			Automne 2014
Groupe :			01
Projet :			Exercice 1

Étudiant(e)(s) :	Kolytchev, Dmitri
Code(s) perm. :		KOLD15088804

Professeur :		Ghizlane El boussaidi
Chargés de labo.:	Alvine Boaye Belle et Michel Gagnon
Nom du fichier :	UsineFormes.java
Date crée :			2013-05-03
Date dern. modif.	2014-09-17
*******************************************************
Historique des modifications
*******************************************************
*@author Dmitri Kolytchev
*2014-09-26 Manipulations de Strings délégué au ParseurRegex
*2014-09-26 Changement de l'argument pour passer de "String[] forme" à "String forme"
*2014-09-17 Création initiale de la classe
*******************************************************/


import java.awt.Color;

import util.ParseurRegex;

public abstract class UsineFormes {

	/**
	 * @param forme: chaine de caracteres decrivant la forme à créer, exemple: CARRE 34 128 256 256
	 * @return: nouvelle forme selon les spécifications, ou null si la forme n'a pas pu être parsée
	 */
	public static Forme genereForme(String descriptionForme){
		
		Forme chose = null;
		int nseq = ParseurRegex.getUidFromString(descriptionForme);
		int[] mesures = ParseurRegex.getMeasurementsFromDescription(descriptionForme);
		
		switch(ParseurRegex.getShapeFromDescription(descriptionForme)){
			case "RECTANGLE":
				chose = new Rectangle(nseq, mesures[0], mesures[1], mesures[2], mesures[3]); break;
			case "CARRE":
				chose = new Carre(nseq, mesures[0], mesures[1], mesures[2], mesures[3]); break;
			case "OVALE":
				chose = new Ellipse(nseq, mesures[0], mesures[1], mesures[2], mesures[3]); break;
			case "CERCLE":
				chose = new Cercle(nseq, mesures[0], mesures[1], mesures[2]); break;
			case "LIGNE":
				chose = new Ligne(nseq, mesures[0], mesures[1], mesures[2], mesures[3]); break;
		}
		
		return chose;
	}

}
