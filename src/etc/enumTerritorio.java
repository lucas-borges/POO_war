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
		Franca("França"),
		Italia("Italia"),
		Polonia("Polônia"),
		ReinoUnido("Reino Unido"),
		Romenia("Romênia"),
		Suecia("Suecia"),
		Ucrania("Urânia"),
		ArabiaSaudita("Arábia Saudita"),
		Bangladesh("Bangladesh"),
		Cazaquistao("Cazaquistão"),
		Mongolia("Mongolia"),
		China("China"),
		CoreiaDoNorte("Coréia do Norte"),
		CoreiaDoSul("Coréia do Sul"),
		Estonia("Estônia"),
		India("Índia"),
		Ira("Irã"),
		Iraque("Iraque"),
		Japao("Japão"),
		Jordania("Jordânia"),
		Letonia("Letônia"),
		Paquistao("Paquistão"),
		Russia("Rússia"),
		Siberia("Sibéria"),
		Siria("Síria"),
		Tailandia("Tailândia"),
		Turquia("Turquia"),
		Australia("Austrália"),
		Indonesia("Indonésia"),
		NovaZelandia("Nova Zelândia"),
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

}
