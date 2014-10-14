package comparateur;

import formes.Forme;

public class ComparateurDiagonaleCroissant extends ComparateurForme {

	@Override
	public int compare(Forme o1, Forme o2) {
		if(o1.obtenirDiagonale() < o2.obtenirDiagonale())
			return -1;
		else if(o1.obtenirDiagonale() > o2.obtenirDiagonale())
			return 1;
		return 0;
	}

}
