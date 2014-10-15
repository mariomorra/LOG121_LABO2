package formes;

public interface FormeChainee {

	public Forme obtenirFormeSuivante();
	public void assignerFormeSuivante(Forme nouvelleForme);

	public Forme obtenirFormePrecedente();
	public void assignerFormePrecedente(Forme nouvelleForme);
}
