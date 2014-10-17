package util;
/******************************************************
Cours :				LOG121
Session :			Automne 2014
Groupe :			01
Projet :			Laboratoire 2

Étudiant(e)(s) :	Kolytchev Dmitri, Morra Mario, Girard Alexandre.
Code(s) perm. :		KOLD15088804, MORM07039202, GIRA08059305

Professeur :		Ghizlane El boussaidi
Chargés de labo.:	Alvine Boaye Belle et Michel Gagnon
Nom du fichier :	ParseurRegex.java
Date crée :			2013-05-03
Date dern. modif.	2014-10-16
*******************************************************
Historique des modifications
*******************************************************
*@author Dmitri Kolytchev
*2014-09-19 Refactoring, creation de genericMatch
*2014-09-19 Ajout des methodes splitAddress et detecteForme
*2014-09-17 Création initiale de la classe
*******************************************************/

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public abstract class ParseurRegex {
	/**
	 * Sépare l'adresse d'un serveur du port de connexion.
	 * @param adresse d'un serveur (ip ou DNS) sous la forme de "adresse:port"
	 * @return un Array contenant l'adresse du serveur en [0] et le port en [1].
	 */
	public static String[] splitAddress(String adresse){
		return genericMatch("^([a-zA-Z0-9.\\-\\_]+):([0-9]+)$", adresse);
	}
	
	/**
	 * Transforme la commande du serveur en une chaine standardisée.
	 * @param in commande texte provenant du serveur de formes
	 * @return chaine standardisée décrivant une forme
	 */
	public static String getDescription(String in){
		String descriptionForme = in.split("\\ ")[0];
		String[] trouvailles = genericMatch("^\\d+ <([a-zA-Z]+)> ([0-9\\ \\.]+) ?</[a-zA-Z]+>", in);
		for(int i = 0; i<trouvailles.length; i++){
			descriptionForme += " " + trouvailles[i];

		}
		
		return descriptionForme; 
	}
	
	/**
	 * Extrait l'identifiant unique d'une forme de la commande du serveur.
	 * @param in commande texte provenant du serveur de formes
	 * @return numéro identifiant, e.g. pour IDLogger
	 */
	public static int getUidFromString(String in){
		return Integer.parseInt(in.split("\\ ")[0]);
	}
	
	/**
	 * Transforme la chaine de description standardisée en valeures numériques. 
	 * @param in chaine standardisée décrivant une forme
	 * @return int[3] ou int[4] contenant les mesures de la forme (e.g. [x, y, largeur, hauteur]) 
	 */
	public static int[] getMeasurementsFromDescription(String in){
		
		String[] temp = genericMatch("^\\d+ [a-zA-Z]+ ([\\d\\ \\.]+)\\ $", in)[0].split("\\ ");
		int[] mesurements = new int[temp.length];
		
		for(int i = 0; i<temp.length; i++){
			if(temp[i] != null && temp[i].length() > 0)
				mesurements[i] = Integer.parseInt(temp[i]);
		}
		
		return mesurements;
	}
	
	/**
	 * Fonction générique de transformation regex. Utilisable en soi, ou comme fonction aide pour d'autres fonctionnalités
	 * @param regex: l'expression réégulière à utiliser
	 * @param in: la chaine de caractères à manipuler
	 * @return un String[] contenant les groupes de l'expression régulière.
	 */
	public static String[] genericMatch(String regex, String in){
		Pattern forme = Pattern.compile(regex);
		
		Matcher results = forme.matcher(in);

		String[] result = new String[results.groupCount()];
		if(results.matches()){
			for(int i = 0; i<results.groupCount(); i++){
				result[i] = results.group(i+1);
			}
		}
		
		return result;
	}

	public static String getShapeFromDescription(String descriptionForme) {
		return descriptionForme.split("\\ ")[1];
	}
}
