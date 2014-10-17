/******************************************************
Cours :				LOG121
Session :			Automne 2014
Groupe :			01
Projet :			Laboratoire 2

Étudiant(e)(s) :	Kolytchev Dmitri, Morra Mario, Girard Alexandre.
Code(s) perm. :		KOLD15088804, MORM07039202, GIRA08059305

Professeur :		Ghizlane El boussaidi
Chargés de labo.:	Alvine Boaye Belle et Michel Gagnon
Nom du fichier :	ComparateurLargeurCroissant.java
Date crée :			2013-05-03
Date dern. modif.	2014-10-16
*******************************************************
Historique des modifications
*******************************************************
*@author Dmitri Kolytchev
*2014-10-14 Création initiale de la classe
*******************************************************/
package comparateur;

import formes.Forme;

public class ComparateurLargeurCroissant extends ComparateurForme {

	@Override
	public int compare(Forme o1, Forme o2) {
		if(o1.obtenirLargeur() < o2.obtenirLargeur())
			return -1;
		else if(o1.obtenirLargeur() > o2.obtenirLargeur())
			return 1;
		return 0;
	}

}
