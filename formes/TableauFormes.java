/******************************************************
Cours :				LOG121
Session :			Automne 2014
Groupe :			01
Projet :			Laboratoire 2

Étudiant(e)(s) :	Kolytchev Dmitri, Morra Mario, Girard Alexandre.
Code(s) perm. :		KOLD15088804, MORM07039202, GIRA08059305

Professeur :		Ghizlane El boussaidi
Chargés de labo.:	Alvine Boaye Belle et Michel Gagnon
Nom du fichier :	TableauFormes.java
Date crée :			2013-05-03
Date dern. modif.	2014-10-16
*******************************************************
Historique des modifications
*******************************************************
*@author Dmitri Kolytchev
*2014-09-17 Adaptation initiale du squelette
*@author Patrice Boucher
*2013-05-03 Version initiale
*******************************************************/
package formes;


import comparateur.ComparateurForme;

public class TableauFormes {

	private static final int NB_MAX_FORMES = 10;

	private Forme teteListeOriginale;
	private Forme teteListeModifiee;

	private Forme queueListeOriginale;

	private Boolean trie = false;

	// Constructeur publique sans parametre..
	public TableauFormes() {
		teteListeOriginale = null;
		teteListeModifiee = null;
	}
	
	// Setteur de trie
	public void setTrie(boolean trie) {
		this.trie = trie;
	}

	// Fonction permettant d'obtenir le nombre de forme de la liste
	private int nbFormes(){
		int nbFormes = 0;
		Forme f = teteListeOriginale;
		if(f == null) return 0;

		while(f.obtenirFormeSuivante() != null){
			nbFormes++;
			f = f.obtenirFormeSuivante();
		}
		return nbFormes;
	}

	// Permet d'ajouter une forme a la liste (FIFO)
	public void ajouterForme(Forme nouvelleForme){
		if(nbFormes() == NB_MAX_FORMES-1){
			decalerListe();
		}
		if(queueListeOriginale != null)
			queueListeOriginale.assignerFormeSuivante(nouvelleForme);
		if(teteListeOriginale == null)
			teteListeOriginale = nouvelleForme;
		queueListeOriginale = nouvelleForme;
	}

	// Fonction permettant d'ajouter des formes et de decaler la liste
	private void decalerListe(){
		teteListeOriginale = teteListeOriginale.obtenirFormeSuivante();
		teteListeOriginale.assignerFormePrecedente(null);
	}

	/*
	 * CODE EMPRUNTÉ
	 * 
	 * l'algorythme de tri qui suit, ainsi que la fonction echangerAvecSuivant (lignes 91 à 170),
	 * ont été basé sur le tutoriel suivant:
	 * 
	 * http://javarevisited.blogspot.ca/2014/08/bubble-sort-algorithm-in-java-with.html
	 * par Javin Paul
	 * 
	 */
	
	public int trier(ComparateurForme comparator) {
	
		try {
			// cree une copie de la liste
			teteListeModifiee = (Forme) teteListeOriginale.clone();
			Forme indexClonage = teteListeModifiee;
			while(indexClonage.obtenirFormeSuivante() != null){
				Forme suiv = indexClonage.obtenirFormeSuivante().clone();
				indexClonage.assignerFormeSuivante(suiv);
				suiv.assignerFormePrecedente(indexClonage);
				indexClonage = suiv;
			}
		} catch (CloneNotSupportedException e1) {
			e1.printStackTrace();
		}
		
		Forme teteDeTri = teteListeModifiee;
		boolean triTermine = false;
		
		// Tri la liste jusqu'a ce que TOUS les elements soient tries
		// inspire du Bubble Sort
		try{
			while(!triTermine){
			 	triTermine = true;
				teteDeTri = teteListeModifiee;
				while(teteDeTri.obtenirFormePrecedente()!=null){
					teteDeTri = teteDeTri.obtenirFormePrecedente();
				}
				while(teteDeTri != null){
					// Permet d'etablir la tete de tri
					if(teteDeTri.obtenirFormeSuivante() !=null && comparator.compare(teteDeTri, teteDeTri.obtenirFormeSuivante()) > 0){
						echangerAvecSuivant(teteDeTri);
						triTermine = false;
					}else teteDeTri = teteDeTri.obtenirFormeSuivante();
				}
			}
		} catch(Exception e){
			e.printStackTrace();
			return -1;
		}
		
		//retrouver la tete de la liste
		teteDeTri = teteListeModifiee;
		while(teteDeTri.obtenirFormePrecedente() != null){
			teteDeTri = teteDeTri.obtenirFormePrecedente();
		}
		
		teteListeModifiee = teteDeTri;
		trie = true;
		return 1;
	}
		 
	// L'equivalent du "swap" du bubble sort
	private void echangerAvecSuivant(Forme noeud){
		Forme suivant = noeud.obtenirFormeSuivante();
		if(suivant != null){
			if(!noeud.estTete()){
				// Permet d'interchanger 
				Forme prec = noeud.obtenirFormePrecedente();
				prec.assignerFormeSuivante(suivant);
				suivant.assignerFormePrecedente(prec);
			}else{
				suivant.assignerFormePrecedente(null);
		 	}
			
			Forme apresSuivant = suivant.obtenirFormeSuivante();
			
			if(apresSuivant != null){
				noeud.assignerFormeSuivante(apresSuivant);
				apresSuivant.assignerFormePrecedente(noeud);
			}else{
				noeud.assignerFormeSuivante(null);
		 	}
			
 			noeud.assignerFormePrecedente(suivant);
 			suivant.assignerFormeSuivante(noeud);
	
 		}
	}


	public Forme debut(){
		return trie?teteListeModifiee:teteListeOriginale;
	}
//  http://javarevisited.blogspot.ca/2014/08/bubble-sort-algorithm-in-java-with.html
	
	// Utilise lors de l'impression des formes afin de dessiner a coordonnes speciales
	public boolean estTrie() {
		return trie;
	}

	public void remettreANeuf() {
		trie = false;
	}

}
