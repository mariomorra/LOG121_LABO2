package comparateur;

import formes.Carre;
import formes.Cercle;
import formes.Ellipse;
import formes.Forme;
import formes.Ligne;
import formes.Rectangle;

public class CompareType extends ComparateurForme {

	@Override
	public int compare(Forme o1, Forme o2) {
		int a = getTypeOrder(o1);
		int b = getTypeOrder(o2);
		
		if(a<b) return  -1;
		else if (a>b) return 1;
		return 0;
	}
	
	private int getTypeOrder(Object o){
		
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
