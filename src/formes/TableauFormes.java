/*******************************************************
Cours : LOG121
Session : A2014
Groupe : 01
Projet : Laboratoire #1
�tudiant : Mario Morra
Code(s) perm. : MORM07039202 (AM54710)
Professeur : Ghizlane El boussaidi
Charg�s de labo : Alvine Boaye Belle et Michel Gagnon
Nom du fichier : TableauFormes.java
Date cr�� : 2014-09-20
Date dern. modif. 2014-09-20
*******************************************************
Historique des modifications
*******************************************************
2014-09-20 Version initiale
*******************************************************/

package formes;

import tri.ComparateurForme;

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
		if(nbFormes() == NB_MAX_FORMES){
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
		
		boolean triTermine;
		
		try {
			teteListeModifiee = (Forme) teteListeOriginale.clone();
		} catch (CloneNotSupportedException e) {
			
		}

		Forme f = teteListeModifiee;
		
		try{
			do{
				triTermine = true;
				for(int i = 0; i < NB_MAX_FORMES; i++){
					if(comparator.compare(f, f.obtenirFormeSuivante()) > 0){
						triTermine = false;
						echangerAvecSuivant(f);
						f = f.obtenirFormeSuivante();
					}
				}	
			} while (triTermine == false);
		} catch(Exception e){return -1;}
		
		if(triTermine = true){return 1;}
		trie = true;
		return 0;
		
	}
	
	private void echangerAvecSuivant(Forme f){
		Forme noeud = f;
		Forme suivant = f.obtenirFormeSuivante();
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
			}
			noeud.assignerFormePrecedente(suivant);
			suivant.assignerFormeSuivante(noeud);
		}
	}
	
	public Forme debut(){
		return teteListeOriginale;
	}
//  http://javarevisited.blogspot.ca/2014/08/bubble-sort-algorithm-in-java-with.html

	public boolean estTrie() {
		return trie;
	}
	
	


}
