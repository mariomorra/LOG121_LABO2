/******************************************************
Cours : LOG121
Session : A2014
Groupe : 01
Projet : Laboratoire #1
Étudiant : Mario Morra
Code(s) perm. : MORM07039202 (AM54710)
Professeur : Ghizlane El boussaidi
Chargés de labo : Alvine Boaye Belle et Michel Gagnon
Nom du fichier : ParseurRegex.java
Date créé : 2014-09-20
Date dern. modif. 2014-09-20
*******************************************************
Historique des modifications
*******************************************************
2014-09-20 Version initiale
2014-10-01 Ajout de la méthode parserChaine
*******************************************************/

package util;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public abstract class ParseurRegex {
	
	public static String parserChaine(String chaineOriginale){
		
		Pattern regex = Pattern.compile("(.*?)<(.*?)>(.*?)</.*?>", Pattern.CASE_INSENSITIVE);
		Matcher matcher = regex.matcher(chaineOriginale);
		matcher.find();	
		
		String nseq = matcher.group(1);
		String typeForme = matcher.group(2);
		String dimensions = matcher.group(3);	
		
		return typeForme.trim() + "," + nseq.trim() + "," + dimensions.trim().replace(" ", ",");
	}

}






