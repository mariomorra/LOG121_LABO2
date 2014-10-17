/******************************************************
Cours :				LOG121
Session :			Automne 2014
Groupe :			01
Projet :			Laboratoire 2

�tudiant(e)(s) :	Kolytchev Dmitri, Morra Mario, Girard Alexandre.
Code(s) perm. :		KOLD15088804, MORM07039202, GIRA08059305

Professeur :		Ghizlane El boussaidi
Charg�s de labo.:	Alvine Boaye Belle et Michel Gagnon
Nom du fichier :	LangueConfig.java
Date cr�e :			2013-05-03
Date dern. modif.	2014-10-16
*******************************************************
Historique des modifications
*******************************************************
2014-09-20 Version initiale
*******************************************************/

package util;

import java.util.Locale;
import java.util.ResourceBundle;	

public abstract class AbstractLangueConfig {
	
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
	         System.err.println("ERROR: cannot find properties file for " + BUNDLE_BASENAME); // NOPMD by Alex on 16/10/14 10:01 PM
	      }
	   };

	   public static String getResource(final String key) {
		      return (resources == null) ? null : resources.getString(key);
	   }
}