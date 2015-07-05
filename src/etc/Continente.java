package etc;

public enum Continente {

	Africa("af"), 
	AmericaDoNorte("an"), 
	Asia("as"), 
	AmericaDoSul("asl"), 
	Europa("eu"), 
	Oceania("oc");

	private final String nome;

	Continente(final String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
}
