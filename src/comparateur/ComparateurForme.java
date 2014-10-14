package comparateur;

import java.util.Comparator;

import formes.Forme;

public abstract class ComparateurForme implements Comparator<Forme>{

	@Override
	public abstract int compare(Forme o1, Forme o2);

}
