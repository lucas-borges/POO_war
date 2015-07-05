package etc;

public class enumTerritorio {
	public enum nomePais {
		Alasca("Alasca"),
		Calgary("Calgary"),
		Groelandia("Groelandia"),
		Vancouver("Vancouver"),
		Quebec("Quebec"),
		California("California"),
		Texas("Texas"),
		NovaYork("Nova York"),
		Mexico("Mexico"),
		Venezuela("Venezuela"),
		Peru("Peru"),
		Brasil("Brasil"),
		Argentina("Argentina"),
		AfricaDoSul("Africa do Sul"),
		Angola("Angola"),
		Argelia("Argelia"),
		Egito("Egito"),
		Nigeria("Nigeria"),
		Somalia("Somalia"),
		Espanha("Espanha"),
		Franca("Franca"),
		Italia("Italia"),
		Polonia("Polonia"),
		ReinoUnido("Reino Unido"),
		Romenia("Romenia"),
		Suecia("Suecia"),
		Ucrania("Ucrania"),
		ArabiaSaudita("Arabia Saudita"),
		Bangladesh("Bangladesh"),
		Cazaquistao("Cazaquistao"),
		Mongolia("Mongolia"),
		China("China"),
		CoreiaDoNorte("Coreia do Norte"),
		CoreiaDoSul("Coreia do Sul"),
		Estonia("Estonia"),
		India("India"),
		Ira("Ira"),
		Iraque("Iraque"),
		Japao("Japao"),
		Jordania("Jordania"),
		Letonia("Letonia"),
		Paquistao("Paquistao"),
		Russia("Russia"),
		Siberia("Siberia"),
		Siria("Siria"),
		Tailandia("Tailandia"),
		Turquia("Turquia"),
		Australia("Australia"),
		Indonesia("Indonesia"),
		NovaZelandia("Nova Zelandia"),
		Perth("Perth");
		;
		private final String nome;
		nomePais(final String nome){
			this.nome=nome;
		}
		public String getNome(){
			return nome;
		}
	}
	public static nomePais toNomePais(String nome){
		for(nomePais pais : nomePais.values()){
			if(nome.equals(pais.getNome())){
				return pais;
			}
		}
		return null;
	}

}
