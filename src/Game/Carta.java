package Game;

import etc.enumTerritorio.nomePais;
import etc.Figura;

public class Carta {
	private final Figura figura;
	private final String continente;
	private final String file_territorio;
	private final nomePais territorio;
	
	public Carta (Figura figura, String continente, String file_territorio, nomePais territorio){
		this.figura=figura;
		this.continente=continente;
		this.file_territorio=file_territorio;
		this.territorio=territorio;
	}	
	public Figura getFigura(){
		return figura;
	}
	public String getContinente(){
		return continente;
	}
	public String getFileTerritorio(){
		return file_territorio;
	}
	public nomePais getTerritorio(){
		return territorio;
	}
	public String getFileName(){
		return ("Cartas/war_carta_"+getContinente()+"_"+getFileTerritorio()+".png");
	}
}
