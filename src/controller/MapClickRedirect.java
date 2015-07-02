package controller;

import java.util.Observable;

public class MapClickRedirect extends Observable {
	private int x,y;
	public void click(int x,int y){
		this.x=x;
		this.y=y;
		setChanged();
		notifyObservers(new String("MapClickRedirect_click"));
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
}
