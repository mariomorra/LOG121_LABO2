/*******************************************************
Cours : LOG121
Session : A2014
Groupe : 01
Projet : Laboratoire #1
???tudiant : Mario Morra
Code(s) perm. : MORM07039202 (AM54710)
Professeur : Ghizlane El boussaidi
Charg???s de labo : Alvine Boaye Belle et Michel Gagnon
Nom du fichier : TableauFormes.java
Date cr?????? : 2014-09-20
Date dern. modif. 2014-09-20
*******************************************************
Historique des modifications
*******************************************************
2014-09-20 Version initiale
*******************************************************/

package formes;

import java.awt.Graphics;

import comparateur.ComparateurForme;

public class TableauFormes {

	private static final int NB_MAX_FORMES = 10;

	private Forme teteListeOriginale;
	private Forme teteListeModifiee;

	private Forme queueListeOriginale;
	private Forme queueListeModifiee;

	private Boolean trie = false;

	public TableauFormes() {
		teteListeOriginale = null;
		teteListeModifiee = null;
		trie = false;
	}
	
	public void setTrie(boolean trie) {
		this.trie = trie;
	}

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

	private void decalerListe(){
		teteListeOriginale = teteListeOriginale.obtenirFormeSuivante();
		teteListeOriginale.assignerFormePrecedente(null);
	}


	public int trier(ComparateurForme comparator) {
	
		try {
			teteListeModifiee = (Forme) teteListeOriginale.clone();
			Forme indexClonage = teteListeModifiee;
			while(indexClonage.obtenirFormeSuivante() != null){
				Forme suiv = indexClonage.obtenirFormeSuivante().clone();
				indexClonage.assignerFormeSuivante(suiv);
				suiv.assignerFormePrecedente(indexClonage);
				indexClonage = suiv;
			}
		} catch (CloneNotSupportedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Forme teteDeTri = teteListeModifiee;
		boolean triTermine = false;

		try{
			while(!triTermine){
			 	triTermine = true;
				teteDeTri = teteListeModifiee;
				while(teteDeTri != null){
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
		 
	private void echangerAvecSuivant(Forme noeud){
		Forme suivant = noeud.obtenirFormeSuivante();
		if(suivant != null){
			
			if(!noeud.estTete()){
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

	public boolean estTrie() {
		return trie;
	}

	public void remettreANeuf() {
		trie = false;
	}

}
