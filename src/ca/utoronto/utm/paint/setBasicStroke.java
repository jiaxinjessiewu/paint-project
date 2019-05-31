package ca.utoronto.utm.paint;

import java.awt.BasicStroke;

public class setBasicStroke {
	public setBasicStroke(){
		
	}
	public BasicStroke chooseBasicStroke(String boldThick){
		if(boldThick=="bold"){
			return new BasicStroke(9);
		}else if(boldThick=="medium"){
			return new BasicStroke(5);
		}else if(boldThick=="thick"){
			return new BasicStroke(1);
		}
		return new BasicStroke(1);
	}
}
