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
Nom du fichier :	UsineFormes.java
Date cr??e :			2013-05-03
Date dern. modif.	2014-09-17
*******************************************************
Historique des modifications
*******************************************************
*@author Dmitri Kolytchev
*2014-09-26 Manipulations de Strings d??l??gu?? au ParseurRegex
*2014-09-26 Changement de l'argument pour passer de "String[] forme" ?? "String forme"
*2014-09-17 Cr??ation initiale de la classe
*******************************************************/



import util.ParseurRegex;

public abstract class UsineFormes {

	/**
	 * @param forme: chaine de caracteres decrivant la forme ?? cr??er, exemple: CARRE 34 128 256 256
	 * @return: nouvelle forme selon les sp??cifications, ou null si la forme n'a pas pu ??tre pars??e
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
