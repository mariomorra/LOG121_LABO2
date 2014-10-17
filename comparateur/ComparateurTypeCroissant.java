/******************************************************
Cours :				LOG121
Session :			Automne 2014
Groupe :			01
Projet :			Laboratoire 2

Étudiant(e)(s) :	Kolytchev Dmitri, Morra Mario, Girard Alexandre.
Code(s) perm. :		KOLD15088804, MORM07039202, GIRA08059305

Professeur :		Ghizlane El boussaidi
Chargés de labo.:	Alvine Boaye Belle et Michel Gagnon
Nom du fichier :	ComparateurTypeCroissant.java
Date crée :			2013-05-03
Date dern. modif.	2014-10-16
*******************************************************
Historique des modifications
*******************************************************
*@author Dmitri Kolytchev
*2014-10-14 Création initiale de la classe
*******************************************************/
package comparateur;

import formes.Carre;
import formes.Cercle;
import formes.Ellipse;
import formes.Forme;
import formes.Ligne;
import formes.Rectangle;

public class ComparateurTypeCroissant extends ComparateurForme {

	@Override
	public int compare(Forme o1, Forme o2) {
		int a = getTypeOrder(o1);
		int b = getTypeOrder(o2);
		
		if(a<b) return  -1;
		else if (a>b) return 1;
		return 0;
	}
	
	private int getTypeOrder(Forme o){
		
		if(o.getClass() == Carre.class){
			return 1;
		}else if(o.getClass() == Rectangle.class){
			return 2;			
		}else if(o.getClass() == Cercle.class){
			return 3;
		}else if(o.getClass() == Ellipse.class){
			return 4;
		}else if(o.getClass() == Ligne.class){
			return 5;
		}
		
		return 0;
	}

}
