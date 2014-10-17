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
Nom du fichier :	UsineFormes.java
Date cr�e :			2013-05-03
Date dern. modif.	2014-10-16
*******************************************************
Historique des modifications
*******************************************************
*@author Dmitri Kolytchev
*2014-09-26 Manipulations de Strings d�l�gu� au ParseurRegex
*2014-09-26 Changement de l'argument pour passer de "String[] forme" � "String forme"
*2014-09-17 Cr�ation initiale de la classe
*******************************************************/



import util.ParseurRegex;

public abstract class AbstractUsineFormes {

	/**
	 * @param forme: chaine de caracteres decrivant la forme � cr�er, exemple: CARRE 34 128 256 256
	 * @return: nouvelle forme selon les sp??cifications, ou null si la forme n'a pas pu �tre pars�e
	 */
	public static AbstractForme genereForme(final String descriptionForme){
		AbstractForme chose = null;
		final int nseq = ParseurRegex.getUidFromString(descriptionForme);
		final int[] mesures = ParseurRegex.getMeasurementsFromDescription(descriptionForme);
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
			default:
				break;
		}

		return chose;
	}

}
