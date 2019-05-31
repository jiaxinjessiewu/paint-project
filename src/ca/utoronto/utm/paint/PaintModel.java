package ca.utoronto.utm.paint;

import java.util.ArrayList;
import java.util.Observable;

public class PaintModel extends Observable {
	private ArrayList<Point> points = new ArrayList<Point>();
	private ArrayList<drawingCommand>commands = new ArrayList<drawingCommand>();
	private ArrayList<drawingCommand>dragged = new ArrayList<drawingCommand>();

	public ArrayList<drawingCommand> getDragged(){
		return dragged;
	}
	public void addDragged(drawingCommand d){
		this.dragged.add(d);
		this.setChanged();
		this.notifyObservers();
	}
	public ArrayList<Point> getPoint(){
		return points;
	}
	public void addPoint(Point p){
		this.points.add(p);
	}
	public ArrayList<drawingCommand> getdrawingCommand(){
		return commands;
	}
	public void addCommand(drawingCommand command){
		this.commands.add(command);
		this.setChanged();
		this.notifyObservers();
	}
	
	public void undo(){
		int length = commands.size();
		int length2 = dragged.size();
		if (length2>0){
		dragged.remove(length2-1);}
		if(length>0){
		commands.remove(length-1);}
		this.setChanged();
		this.notifyObservers();

	}
	
	public void clear() {
		dragged.clear();
		commands.clear();
		this.setChanged();
		this.notifyObservers();
	}
}
