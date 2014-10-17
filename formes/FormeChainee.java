package formes;

public interface FormeChainee {
	
	// Interface permettant d'ajouter et recueillir les formes de la liste chainee
	public Forme obtenirFormeSuivante();
	public void assignerFormeSuivante(Forme nouvelleForme);

	public Forme obtenirFormePrecedente();
	public void assignerFormePrecedente(Forme nouvelleForme);
}
