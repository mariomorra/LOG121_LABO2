/******************************************************
Cours :				LOG121
Session :			Automne 2014
Groupe :			01
Projet :			Laboratoire 2

�tudiant(e)(s) :	Kolytchev Dmitri, Morra Mario, Girard Alexandre.
Code(s) perm. :		KOLD15088804, MORM07039202, GIRA08059305

Professeur :		Ghizlane El boussaidi
Charg�s de labo.:	Alvine Boaye Belle et Michel Gagnon
Nom du fichier :	ComparateurHauteurDecroissant.java
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

public class ComparateurHauteurDecroissant extends ComparateurHauteurCroissant {
	@Override
	public int compare(final AbstractForme forme1, final AbstractForme forme2) {
		return super.compare(forme1, forme2)*-1;
	}
}
