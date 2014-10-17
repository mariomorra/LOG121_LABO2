/******************************************************
Cours :				LOG121
Session :			Automne 2014
Groupe :			01
Projet :			Laboratoire 2

�tudiant(e)(s) :	Kolytchev Dmitri, Morra Mario, Girard Alexandre.
Code(s) perm. :		KOLD15088804, MORM07039202, GIRA08059305

Professeur :		Ghizlane El boussaidi
Charg�s de labo.:	Alvine Boaye Belle et Michel Gagnon
Nom du fichier :	TableauFormes.java
Date cr�e :			2013-05-03
Date dern. modif.	2014-10-16
*******************************************************
Historique des modifications
*******************************************************
2014-09-20 Version initiale
*******************************************************/



package formes;

public interface FormeChainee {
	
	// Interface permettant d'ajouter et recueillir les formes de la liste chainee
	public Forme obtenirFormeSuivante();
	public void assignerFormeSuivante(Forme nouvelleForme);

	public Forme obtenirFormePrecedente();
	public void assignerFormePrecedente(Forme nouvelleForme);
}
