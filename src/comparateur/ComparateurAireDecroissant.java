package comparateur;

import formes.Forme;

public class ComparateurAireDecroissant extends ComparateurAireCroissant {
	@Override
	public int compare(Forme o1, Forme o2) {
		return super.compare(o1, o2)*-1;
	}
}
