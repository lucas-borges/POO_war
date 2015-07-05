package Game;

import etc.enumTerritorio.nomePais;
import etc.Figura;
import controller.Territorio;
public class Carta {
	private final Figura figura;
	private final String file_territorio;
	private final nomePais territorio;
	
	public Carta (Figura figura, String file_territorio, nomePais territorio){
		this.figura=figura;
		this.file_territorio=file_territorio;
		this.territorio=territorio;
	}	
	public Figura getFigura(){
		return figura;
	}	
	public String getFileTerritorio(){
		return file_territorio;
	}
	public nomePais getTerritorio(){
		return territorio;
	}
	public String getFileName(){
		System.out.println(file_territorio);
		if(file_territorio.equals("coringa")){
			return "war_carta_coringa.png";
		}
		Territorio t=TerritorioDataBase.buscaTerritorio(territorio);
		return ("Cartas/war_carta_"+t.getContinente().getNome()+"_"+getFileTerritorio()+".png");
	}
}
