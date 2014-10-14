package comparateur;

import formes.Forme;

public class ComparateurLargeurDecroissant extends ComparateurLargeurCroissant {
	@Override
	public int compare(Forme o1, Forme o2) {
		return super.compare(o1, o2)*-1;
	}
}
