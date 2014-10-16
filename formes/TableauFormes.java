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
				indexClonage.assignerFormeSuivante(indexClonage.obtenirFormeSuivante().clone());
				indexClonage = indexClonage.obtenirFormeSuivante();
			}
		} catch (CloneNotSupportedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Forme teteDeTri = teteListeModifiee;
		boolean triTermine = false;

		try{
			System.out.println("Starting bubble sort");
			while(!triTermine){
			 	triTermine = true;
				System.out.println("--- starting another pass");
				while(teteDeTri != null){
					System.out.println("--- --- checking " + teteDeTri.obtenirNseq() + " and " + teteDeTri.obtenirFormeSuivante().obtenirNseq());
					if(teteDeTri.obtenirFormeSuivante() !=null && comparator.compare(teteDeTri, teteDeTri.obtenirFormeSuivante()) > 0){
						System.out.println("--- --- --- Swapping");
						echangerAvecSuivant(teteDeTri);
						triTermine = false;
					}else teteDeTri = teteDeTri.obtenirFormeSuivante();
				}
				teteDeTri = teteListeModifiee;
			}
		} catch(Exception e){
			trie = true;
			return -1;
		}
		
		//retrouver la tete de la liste
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

}
