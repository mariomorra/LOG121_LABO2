package comparateur;

import formes.Forme;

public class ComparateurAireCroissant extends ComparateurForme {

	@Override
	public int compare(Forme o1, Forme o2) {
		if(o1.obtenirAire() < o2.obtenirAire())
			return -1;
		else if((o1.obtenirAire() > o2.obtenirAire()))
			return 1;
		return 0;
	}
}
