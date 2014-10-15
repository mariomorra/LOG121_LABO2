package comparateur;

import formes.Forme;

public class ComparateurHauteurCroissant extends ComparateurForme {

	@Override
	public int compare(Forme o1, Forme o2) {
		if(o1.obtenirHauteur() < o1.obtenirHauteur())
			return -1;
		else if(o1.obtenirHauteur() > o1.obtenirHauteur())
			return 1;
		return 0;
	}

}
