package etc;

public class enumObjetivo {
	public enum Objetivo{
		EU_OC_outro (" Conquistar na totalidade a EUROPA, a OCEANIA e mais um terceiro."),
		AS_AmSul(" Conquistar na totalidade a ASIA e a AM�RICA DO SUL."),
		EU_AmSul_outro(" Conquistar na totalidade a EUROPA, a AM�RICA DO SUL e mais um terceiro."),
		T18(" Conquistar 18 TERRIT�RIOS e ocupar cada um deles com pelo menos dois ex�rcitos."),
		AS_AFR("Conquistar na totalidade a ASIA e a �FRICA."),
		AmNor_AFR("Conquistar na totalidade a AM�RICA DO NORTE e a �FRICA."),
		T24("Conquistar 24 TERRIT�RIOS � sua escolha."),
		AmNor_OC(" Conquistar na totalidade a AM�RICA DO NORTE e a OCEANIA."),
		AZ(" Destruir totalmente OS EX�RCITOS AZUIS."),
		AM(" Destruir totalmente OS EX�RCITOS AMARELOS."),
		VERM(" Destruir totalmente OS EX�RCITOS VERMELHOS."),
		PR(" Destruir totalmente OS EX�RCITOS PRETOS."),
		BR(" Destruir totalmente OS EX�RCITOS BRANCO."),
		VERD(" Destruir totalmente OS EX�RCITOS VERDES.");
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
