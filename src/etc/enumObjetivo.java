package etc;

public class enumObjetivo {
	public enum Objetivo{
		EU_OC_outro (" Conquistar na totalidade a EUROPA, a OCEANIA e mais um terceiro."),
		AS_AmSul(" Conquistar na totalidade a ASIA e a AMERICA DO SUL."),
		EU_AmSul_outro(" Conquistar na totalidade a EUROPA, a AMERICA DO SUL e mais um terceiro."),
		T18(" Conquistar 18 TERRITORIOS e ocupar cada um deles com pelo menos dois exercitos."),
		AS_AFR("Conquistar na totalidade a ASIA e a AFRICA."),
		AmNor_AFR("Conquistar na totalidade a AMERICA DO NORTE e a AFRICA."),
		T24("Conquistar 24 TERRITORIOS a sua escolha."),
		AmNor_OC(" Conquistar na totalidade a AMERICA DO NORTE e a OCEANIA."),
		Blue("Destruir totalmente OS EXERCITOS AZUIS."),
		Yellow("Destruir totalmente OS EXERCITOS AMARELOS."),
		Red("Destruir totalmente OS EXERCITOS VERMELHOS."),
		Black("Destruir totalmente OS EXERCITOS PRETOS."),
		White("Destruir totalmente OS EXERCITOS BRANCOS."),
		Green("Destruir totalmente OS EXERCITOS VERDES.");
		;
		
		private final String nome;
		Objetivo(final String nome){
			this.nome=nome;
		}
		public String getNome(){
			return nome;
		}
		
	}

}
