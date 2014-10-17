/******************************************************
Cours :				LOG121
Session :			Automne 2014
Groupe :			01
Projet :			Laboratoire 2

�tudiant(e)(s) :	Kolytchev Dmitri, Morra Mario, Girard Alexandre.
Code(s) perm. :		KOLD15088804, MORM07039202, GIRA08059305

Professeur :		Ghizlane El boussaidi
Charg�s de labo.:	Alvine Boaye Belle et Michel Gagnon
Nom du fichier :	ComparateurAireCroissant.java
Date cr�e :			2013-05-03
Date dern. modif.	2014-10-16
*******************************************************
Historique des modifications
*******************************************************
*@author Dmitri Kolytchev
*2014-10-14 Cr�ation initiale de la classe
*******************************************************/
package comparateur;

import formes.AbstractForme;

public class ComparateurAireCroissant extends AbstractComparateurForme {

	@Override
	public int compare(final AbstractForme forme1, final AbstractForme forme2) {
		int flag = 0;
		if(forme1.obtenirAire() < forme2.obtenirAire()){
			flag = -1;
		} else if(forme1.obtenirAire() > forme2.obtenirAire()) {
			flag = 1;
		}
		else {
			flag = 0;
		}
		return flag;
	}
}
