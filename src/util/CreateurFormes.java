/******************************************************
Cours : LOG121
Session : A2014
Groupe : 01
Projet : Laboratoire #1
Étudiant : Mario Morra
Code(s) perm. : MORM07039202 (AM54710)
Professeur : Ghizlane El boussaidi
Chargés de labo : Alvine Boaye Belle et Michel Gagnon
Nom du fichier : CreateurFormes.java
Date créé : 2014-10-01
Date dern. modif. 2014-10-01
*******************************************************
Historique des modifications
*******************************************************
2014-10-01 Version initiale
2014-10-02 Petites corrections
*******************************************************/

package util;

import affichage.ApplicationFormes;
import formes.Carre;
import formes.Cercle;
import formes.Ellipse;
import formes.Forme;
import formes.Ligne;
import formes.Rectangle;

public abstract class CreateurFormes {
	
	
	public static Forme creerForme(String chaineForme){
		
		String chaineParsee = "";
		String[] elements = null;
		
		String type = "";
		int nseq = 0;
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		
		try {
			chaineParsee = ParseurRegex.parserChaine(chaineForme);
			elements = chaineParsee.split(",");
			type = elements[0].toUpperCase();
			nseq = Integer.parseInt(elements[1]);
			a = Integer.parseInt(elements[2]);
			b = Integer.parseInt(elements[3]);
			c = Integer.parseInt(elements[4]);
			if(elements.length > 5){
				d = Integer.parseInt(elements[5]);
			}
		} catch (Exception e){
			return null;
		}

		Forme nouvelleForme = null;
		
		if(type.equals("RECTANGLE")){
			nouvelleForme = new Rectangle(nseq, a, b, c, d);
		}
		if(type.equals("CARRE")){
			nouvelleForme = new Carre(nseq, a, b, c, d);
		}
		if(type.equals("OVALE")){
			nouvelleForme = new Ellipse(nseq, a, b, c, d);
		}
		if(type.equals("CERCLE")){
			nouvelleForme = new Cercle(nseq, a, b, c, c);
		}
		if(type.equals("LIGNE")){
			nouvelleForme = new Ligne(nseq, a, b, c, d);
		}
		
		ApplicationFormes.getLogger().logID(nseq);

		return nouvelleForme;
	}

}
