package comparateur;

import formes.Forme;

public class ComparateurLargeurCroissant extends ComparateurForme {

	@Override
	public int compare(Forme o1, Forme o2) {
		if(o1.obtenirLargeur() < o1.obtenirLargeur())
			return -1;
		else if(o1.obtenirLargeur() > o1.obtenirLargeur())
			return 1;
		return 0;
	}

}
