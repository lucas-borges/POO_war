package Game;

import etc.enumObjetivo.Objetivo;

public class CartaObjetivo {
	private Objetivo nome;
	
	public CartaObjetivo(Objetivo o){
		nome=o;
	}
	public Objetivo getNome(){
		return nome;
	}

}
