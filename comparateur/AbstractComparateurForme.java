package comparateur;

import java.util.Comparator;

import formes.AbstractForme;

public abstract class AbstractComparateurForme implements Comparator<AbstractForme>{

	@Override
	public abstract int compare(final AbstractForme forme1, final AbstractForme forme2);

}
