package controller;

import java.util.Observable;

public class MapClickRedirect extends Observable {
	private Territorio t;
	public void click(Territorio t){
		this.t=t;
		setChanged();
		notifyObservers(new String("click"));
	}
	public Territorio getTerritorio(){
		return t;
	}
}
