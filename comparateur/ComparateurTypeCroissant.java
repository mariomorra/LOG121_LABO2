/******************************************************
Cours :				LOG121
Session :			Automne 2014
Groupe :			01
Projet :			Laboratoire 2

�tudiant(e)(s) :	Kolytchev Dmitri, Morra Mario, Girard Alexandre.
Code(s) perm. :		KOLD15088804, MORM07039202, GIRA08059305

Professeur :		Ghizlane El boussaidi
Charg�s de labo.:	Alvine Boaye Belle et Michel Gagnon
Nom du fichier :	ComparateurTypeCroissant.java
Date cr�e :			2013-05-03
Date dern. modif.	2014-10-16
*******************************************************
Historique des modifications
*******************************************************
*@author Dmitri Kolytchev
*2014-10-14 Cr�ation initiale de la classe
*******************************************************/
package comparateur;

import formes.Carre;
import formes.Cercle;
import formes.Ellipse;
import formes.AbstractForme;
import formes.Ligne;
import formes.Rectangle;

public class ComparateurTypeCroissant extends AbstractComparateurForme {

	private transient int flagOrder;
	private transient int flagCompare;
	@Override
	public int compare(final AbstractForme forme1, final AbstractForme forme2) {
		final int typeOrderA = getTypeOrder(forme1);
		final int typeOrderB = getTypeOrder(forme2);
		
		if(typeOrderA<typeOrderB) {
			flagCompare = -1;
		} else if (typeOrderA>typeOrderB) {
			flagCompare = 1;
		} else{
			flagCompare = 0;
		}
		return flagCompare;
	}
	
	private int getTypeOrder(final AbstractForme forme){
		
		if(forme.getClass() == Carre.class){
			flagOrder = 1;
		}else if(forme.getClass() == Rectangle.class){
			flagOrder = 2;			
		}else if(forme.getClass() == Cercle.class){
			flagOrder = 3;
		}else if(forme.getClass() == Ellipse.class){
			flagOrder = 4;
		}else if(forme.getClass() == Ligne.class){
			flagOrder = 5;
		} else {
			flagOrder = 0;
		}
		
		return flagOrder;
	}

}
