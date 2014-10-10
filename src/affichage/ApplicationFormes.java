/******************************************************
Cours : LOG121
Session : A2014
Groupe : 01
Projet : Laboratoire #1
Étudiant : Mario Morra
Code(s) perm. : MORM07039202 (AM54710)
Professeur : Ghizlane El boussaidi
Chargés de labo : Alvine Boaye Belle et Michel Gagnon
Nom du fichier : ApplicationFormes.java
Date créé : 2014-09-20
Date dern. modif. 2014-09-20
*******************************************************
Historique des modifications
*******************************************************
2014-09-20 Version initiale
*******************************************************/

package affichage;

import ca.etsmtl.log.util.IDLogger;
import formes.TableauFormes;
import util.CommBase;

public class ApplicationFormes {
	
	private CommBase comm;
	private FenetrePrincipale fenetre;
	private static IDLogger logger;

	public static void main(String[] args) {
		new ApplicationFormes();	
		ApplicationFormes.setLogger(IDLogger.getInstance());
	}
	
	public ApplicationFormes(){
		comm = new CommBase();		
		String host = "localhost";
		int port = 10000;
		comm.connect(host, port);	
		fenetre = new FenetrePrincipale(comm);
		comm.setPropertyChangeListener(fenetre);
	}

	public static IDLogger getLogger() {
		return logger;
	}

	public static void setLogger(IDLogger logger) {
		ApplicationFormes.logger = logger;
	}
}
