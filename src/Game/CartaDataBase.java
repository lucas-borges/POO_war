package Game;

import etc.enumTerritorio.nomePais;
import etc.Figura;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;



public class CartaDataBase {
	private static List<Carta>listaCartas = new ArrayList<Carta>();
	static{
		//Coringa
		listaCartas.add(new Carta(Figura.coringa,"coringa",null));
		//Africa
		listaCartas.add(new Carta(Figura.triangulo,"africadosul",nomePais.AfricaDoSul));
		listaCartas.add(new Carta(Figura.quadrado,"angola",nomePais.Angola));
		listaCartas.add(new Carta(Figura.circulo,"argelia",nomePais.Argelia));
		listaCartas.add(new Carta(Figura.triangulo,"egito",nomePais.Egito));
		listaCartas.add(new Carta(Figura.circulo,"nigeria",nomePais.Nigeria));
		listaCartas.add(new Carta(Figura.quadrado,"somalia",nomePais.Somalia));
		//America do Norte
		listaCartas.add(new Carta(Figura.triangulo,"alasca",nomePais.Alasca));
		listaCartas.add(new Carta(Figura.circulo,"calgary",nomePais.Calgary));
		listaCartas.add(new Carta(Figura.quadrado,"california",nomePais.California));
		listaCartas.add(new Carta(Figura.circulo,"groelandia",nomePais.Groelandia));
		listaCartas.add(new Carta(Figura.quadrado,"mexico",nomePais.Mexico));
		listaCartas.add(new Carta(Figura.quadrado,"novayork",nomePais.NovaYork));
		listaCartas.add(new Carta(Figura.circulo,"quebec",nomePais.Quebec));
		listaCartas.add(new Carta(Figura.triangulo,"texas",nomePais.Texas));
		listaCartas.add(new Carta(Figura.circulo,"vancouver",nomePais.Vancouver));
		//Asia
		listaCartas.add(new Carta(Figura.circulo,"arabiasaudita",nomePais.ArabiaSaudita));
		listaCartas.add(new Carta(Figura.circulo,"bangladesh",nomePais.Bangladesh));
		listaCartas.add(new Carta(Figura.circulo,"cazaquistao",nomePais.Cazaquistao));
		listaCartas.add(new Carta(Figura.quadrado,"china",nomePais.China));
		listaCartas.add(new Carta(Figura.quadrado,"coreiadonorte",nomePais.CoreiaDoNorte));
		listaCartas.add(new Carta(Figura.triangulo,"coreiadosul",nomePais.CoreiaDoSul));
		listaCartas.add(new Carta(Figura.circulo,"estonia",nomePais.Estonia));
		listaCartas.add(new Carta(Figura.triangulo,"india",nomePais.India));
		listaCartas.add(new Carta(Figura.quadrado,"ira",nomePais.Ira));
		listaCartas.add(new Carta(Figura.triangulo,"iraque",nomePais.Iraque));
		listaCartas.add(new Carta(Figura.circulo,"japao",nomePais.Japao));
		listaCartas.add(new Carta(Figura.quadrado,"jordania",nomePais.Jordania));
		listaCartas.add(new Carta(Figura.quadrado,"letonia",nomePais.Letonia));
		listaCartas.add(new Carta(Figura.triangulo,"mongolia",nomePais.Mongolia));
		listaCartas.add(new Carta(Figura.circulo,"paquistao",nomePais.Paquistao));
		listaCartas.add(new Carta(Figura.triangulo,"russia",nomePais.Russia));
		listaCartas.add(new Carta(Figura.quadrado,"siberia",nomePais.Siberia));
		listaCartas.add(new Carta(Figura.quadrado,"siria",nomePais.Siria));
		listaCartas.add(new Carta(Figura.triangulo,"tailandia",nomePais.Tailandia));
		listaCartas.add(new Carta(Figura.triangulo,"turquia",nomePais.Turquia));
		//America do Sul
		listaCartas.add(new Carta(Figura.quadrado,"argentina",nomePais.Argentina));
		listaCartas.add(new Carta(Figura.circulo,"brasil",nomePais.Brasil));
		listaCartas.add(new Carta(Figura.triangulo,"peru",nomePais.Peru));
		listaCartas.add(new Carta(Figura.triangulo,"venezuela",nomePais.Venezuela));
		//Europa
		listaCartas.add(new Carta(Figura.circulo,"espanha",nomePais.Espanha));
		listaCartas.add(new Carta(Figura.triangulo,"franca",nomePais.Franca));
		listaCartas.add(new Carta(Figura.quadrado,"italia",nomePais.Italia));
		listaCartas.add(new Carta(Figura.triangulo,"polonia",nomePais.Polonia));
		listaCartas.add(new Carta(Figura.circulo,"reinounido",nomePais.ReinoUnido));
		listaCartas.add(new Carta(Figura.triangulo,"romenia",nomePais.Romenia));
		listaCartas.add(new Carta(Figura.quadrado,"suecia",nomePais.Suecia));
		listaCartas.add(new Carta(Figura.circulo,"ucrania",nomePais.Ucrania));
		//Oceania
		listaCartas.add(new Carta(Figura.triangulo,"australia",nomePais.Australia));
		listaCartas.add(new Carta(Figura.triangulo,"indonesia",nomePais.Indonesia));
		listaCartas.add(new Carta(Figura.quadrado,"novazelandia",nomePais.NovaZelandia));
		listaCartas.add(new Carta(Figura.circulo,"perth",nomePais.Perth));
		
	}
	public static Carta puxaCarta(){
		return listaCartas.remove((new Random()).nextInt(listaCartas.size()));
	}
	public static void insereCarta(Carta c){
		listaCartas.add(c);
	}

	public static Carta getCarta (String fileTerritorio){
		for(Carta c:listaCartas){
			//System.out.println(c.getFileTerritorio());
			if(c.getFileTerritorio().equals(fileTerritorio)){
				//System.out.println(c.getFileTerritorio());
				return c;
			}
		}
		return null;
	}
}
