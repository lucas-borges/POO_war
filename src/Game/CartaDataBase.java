package Game;

import etc.enumTerritorio.nomePais;
import etc.Figura;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class CartaDataBase {
	private static List<Carta>listaCartas = new ArrayList<Carta>();
	static{
		//Coringa
		listaCartas.add(new Carta(Figura.coringa,"","coringa",null));
		//Africa
		listaCartas.add(new Carta(Figura.triangulo,"af","africadosul",nomePais.AfricaDoSul));
		listaCartas.add(new Carta(Figura.quadrado,"af","angola",nomePais.Angola));
		listaCartas.add(new Carta(Figura.circulo,"af","argelia",nomePais.Argelia));
		listaCartas.add(new Carta(Figura.triangulo,"af","egito",nomePais.Egito));
		listaCartas.add(new Carta(Figura.circulo,"af","nigeria",nomePais.Nigeria));
		listaCartas.add(new Carta(Figura.quadrado,"af","somalia",nomePais.Somalia));
		//America do Norte
		listaCartas.add(new Carta(Figura.triangulo,"an","alasca",nomePais.Alasca));
		listaCartas.add(new Carta(Figura.circulo,"an","calgary",nomePais.Calgary));
		listaCartas.add(new Carta(Figura.quadrado,"an","california",nomePais.California));
		listaCartas.add(new Carta(Figura.circulo,"an","groelandia",nomePais.Groelandia));
		listaCartas.add(new Carta(Figura.quadrado,"an","mexico",nomePais.Mexico));
		listaCartas.add(new Carta(Figura.quadrado,"an","novayork",nomePais.NovaYork));
		listaCartas.add(new Carta(Figura.circulo,"an","quebec",nomePais.Quebec));
		listaCartas.add(new Carta(Figura.triangulo,"an","texas",nomePais.Texas));
		listaCartas.add(new Carta(Figura.circulo,"an","vancouver",nomePais.Vancouver));
		//Asia
		listaCartas.add(new Carta(Figura.circulo,"as","arabiasaudita",nomePais.ArabiaSaudita));
		listaCartas.add(new Carta(Figura.circulo,"as","bangladesh",nomePais.Bangladesh));
		listaCartas.add(new Carta(Figura.circulo,"as","cazaquistao",nomePais.Cazaquistao));
		listaCartas.add(new Carta(Figura.quadrado,"as","china",nomePais.China));
		listaCartas.add(new Carta(Figura.quadrado,"as","coreiadonorte",nomePais.CoreiaDoNorte));
		listaCartas.add(new Carta(Figura.triangulo,"as","coreiadosul",nomePais.CoreiaDoSul));
		listaCartas.add(new Carta(Figura.circulo,"as","estonia",nomePais.Estonia));
		listaCartas.add(new Carta(Figura.triangulo,"as","india",nomePais.India));
		listaCartas.add(new Carta(Figura.quadrado,"as","ira",nomePais.Ira));
		listaCartas.add(new Carta(Figura.triangulo,"as","iraque",nomePais.Iraque));
		listaCartas.add(new Carta(Figura.circulo,"as","japao",nomePais.Japao));
		listaCartas.add(new Carta(Figura.quadrado,"as","jordania",nomePais.Jordania));
		listaCartas.add(new Carta(Figura.quadrado,"as","letonia",nomePais.Letonia));
		listaCartas.add(new Carta(Figura.triangulo,"as","mongolia",nomePais.Mongolia));
		listaCartas.add(new Carta(Figura.circulo,"as","paquistao",nomePais.Paquistao));
		listaCartas.add(new Carta(Figura.triangulo,"as","russia",nomePais.Russia));
		listaCartas.add(new Carta(Figura.quadrado,"as","siberia",nomePais.Siberia));
		listaCartas.add(new Carta(Figura.quadrado,"as","siria",nomePais.Siria));
		listaCartas.add(new Carta(Figura.triangulo,"as","tailandia",nomePais.Tailandia));
		listaCartas.add(new Carta(Figura.triangulo,"as","turquia",nomePais.Turquia));
		//America do Sul
		listaCartas.add(new Carta(Figura.quadrado,"asl","argentina",nomePais.Argentina));
		listaCartas.add(new Carta(Figura.circulo,"asl","brasil",nomePais.Brasil));
		listaCartas.add(new Carta(Figura.triangulo,"asl","peru",nomePais.Peru));
		listaCartas.add(new Carta(Figura.triangulo,"asl","venezuela",nomePais.Venezuela));
		//Europa
		listaCartas.add(new Carta(Figura.circulo,"eu","espanha",nomePais.Espanha));
		listaCartas.add(new Carta(Figura.triangulo,"eu","franca",nomePais.Franca));
		listaCartas.add(new Carta(Figura.quadrado,"eu","italia",nomePais.Italia));
		listaCartas.add(new Carta(Figura.triangulo,"eu","polonia",nomePais.Polonia));
		listaCartas.add(new Carta(Figura.circulo,"eu","reinounido",nomePais.ReinoUnido));
		listaCartas.add(new Carta(Figura.triangulo,"eu","romenia",nomePais.Romenia));
		listaCartas.add(new Carta(Figura.quadrado,"eu","suecia",nomePais.Suecia));
		listaCartas.add(new Carta(Figura.circulo,"eu","ucrania",nomePais.Ucrania));
		//Oceania
		listaCartas.add(new Carta(Figura.triangulo,"oc","australia",nomePais.Australia));
		listaCartas.add(new Carta(Figura.triangulo,"oc","indonesia",nomePais.Indonesia));
		listaCartas.add(new Carta(Figura.quadrado,"oc","novazelandia",nomePais.NovaZelandia));
		listaCartas.add(new Carta(Figura.circulo,"oc","perth",nomePais.Perth));
		
	}
	
	public Carta getCarta (nomePais territorio){
		if(territorio==null){
			//retorna o coringa
			return listaCartas.get(0);
		}
		
		for(Carta c : listaCartas){
			if(c.getTerritorio()==territorio){
				return c;
			}
		}
		
		return null;
	}
	

}
