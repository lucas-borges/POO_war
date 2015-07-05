package Game;

import java.util.ArrayList;
import java.util.List;

import controller.Territorio;
import etc.enumObjetivo.Objetivo;
import etc.enumTerritorio.nomePais;

public class CartaObjetivoDataBase {
	static private List<CartaObjetivo> lstObjetivos = new ArrayList<CartaObjetivo>();
	
	static{
		lstObjetivos.add(new CartaObjetivo(Objetivo.EU_OC_outro));
		lstObjetivos.add(new CartaObjetivo(Objetivo.AS_AmSul));
		lstObjetivos.add(new CartaObjetivo(Objetivo.EU_AmSul_outro));
		lstObjetivos.add(new CartaObjetivo(Objetivo.T18));
		lstObjetivos.add(new CartaObjetivo(Objetivo.AS_AFR));
		lstObjetivos.add(new CartaObjetivo(Objetivo.AmNor_AFR));
		lstObjetivos.add(new CartaObjetivo(Objetivo.T24));
		lstObjetivos.add(new CartaObjetivo(Objetivo.AmNor_OC));
		lstObjetivos.add(new CartaObjetivo(Objetivo.Blue));
		lstObjetivos.add(new CartaObjetivo(Objetivo.Yellow));
		lstObjetivos.add(new CartaObjetivo(Objetivo.Red));
		lstObjetivos.add(new CartaObjetivo(Objetivo.Black));
		lstObjetivos.add(new CartaObjetivo(Objetivo.White));
		lstObjetivos.add(new CartaObjetivo(Objetivo.Green));
		
	}
	
	static public ArrayList<CartaObjetivo> copyLstObjetivos (){
		ArrayList<CartaObjetivo> newList = new ArrayList<CartaObjetivo>(lstObjetivos);
		return newList;
	}
	static public List<CartaObjetivo> getListaObjetivos (){
		return lstObjetivos;
	}
	
	static public CartaObjetivo buscaObjetivo (Objetivo objetivo){
		
		for(CartaObjetivo o:lstObjetivos){			
			if(o.getNome()==objetivo)			
				return o;
		}
		return null;
	}

}
