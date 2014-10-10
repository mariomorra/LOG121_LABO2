/******************************************************
Cours : LOG121
Session : A2014
Groupe : 01
Projet : Laboratoire #1
Étudiant : Mario Morra
Code(s) perm. : MORM07039202 (AM54710)
Professeur : Ghizlane El boussaidi
Chargés de labo : Alvine Boaye Belle et Michel Gagnon
Nom du fichier : LangueConfig.java
Date créé : 2014-09-20
Date dern. modif. 2014-09-20
*******************************************************
Historique des modifications
*******************************************************
2014-09-20 Version initiale
*******************************************************/

package util;

import java.util.Locale;
import java.util.ResourceBundle;	

public abstract class LangueConfig {
	
	static private final String PREFS_BUNDLE_BASENAME = "prefs";
	static private final String BUNDLE_BASENAME = "app", PREFERRED_LOCALE_KEY = "locale";
	private static ResourceBundle preferences, resources;
	static private Locale locale;
	
	static {
	      try {
	         preferences = ResourceBundle.getBundle(PREFS_BUNDLE_BASENAME);
	         locale = new Locale(preferences.getString(PREFERRED_LOCALE_KEY));
	      }
	      catch(java.util.MissingResourceException ex) {
	         System.err.println("ERROR: cannot find preferences properties file " + 
	                            BUNDLE_BASENAME);
	      }
	      try {
	         resources = ResourceBundle.getBundle(BUNDLE_BASENAME, locale);
	      }
	      catch(java.util.MissingResourceException ex) {
	         System.err.println("ERROR: cannot find properties file for " + BUNDLE_BASENAME);
	      }
	   };

	   public static String getResource(String key) {
		      return (resources == null) ? null : resources.getString(key);
	   }
}