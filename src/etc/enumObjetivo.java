package etc;

public class enumObjetivo {
	public enum Objetivo{
		EU_OC_outro (" Conquistar na totalidade a EUROPA, a OCEANIA e mais um terceiro."),
		AS_AmSul(" Conquistar na totalidade a ASIA e a AMÉRICA DO SUL."),
		EU_AmSul_outro(" Conquistar na totalidade a EUROPA, a AMÉRICA DO SUL e mais um terceiro."),
		T18(" Conquistar 18 TERRITÓRIOS e ocupar cada um deles com pelo menos dois exércitos."),
		AS_AFR("Conquistar na totalidade a ASIA e a ÁFRICA."),
		AmNor_AFR("Conquistar na totalidade a AMÉRICA DO NORTE e a ÁFRICA."),
		T24("Conquistar 24 TERRITÓRIOS à sua escolha."),
		AmNor_OC(" Conquistar na totalidade a AMÉRICA DO NORTE e a OCEANIA."),
		AZ(" Destruir totalmente OS EXÉRCITOS AZUIS."),
		AM(" Destruir totalmente OS EXÉRCITOS AMARELOS."),
		VERM(" Destruir totalmente OS EXÉRCITOS VERMELHOS."),
		PR(" Destruir totalmente OS EXÉRCITOS PRETOS."),
		BR(" Destruir totalmente OS EXÉRCITOS BRANCO."),
		VERD(" Destruir totalmente OS EXÉRCITOS VERDES.");
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
