package comparateur;

import formes.Forme;

public class ComparateurNumSeqCroissant extends ComparateurForme {

	@Override
	public int compare(Forme o1, Forme o2) {
		if(o1.obtenirNseq() < o2.obtenirNseq()) {
			return -1;
		}
		else if((o1.obtenirNseq() > o2.obtenirNseq())) {
			return 1;
		}
		return 0;
	}

}
