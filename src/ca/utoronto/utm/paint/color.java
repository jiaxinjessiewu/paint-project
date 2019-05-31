package ca.utoronto.utm.paint;

import java.awt.Color;

public class color {
	
	public color(){
		
	}
	
	public Color colorChoosing(String q){
		if(q=="Red"){
			return Color.RED;
		}else if(q=="Blue"){
			return Color.BLUE;
		}else if(q=="Cyan"){
			return Color.CYAN;
		}else if(q=="Green"){
			return Color.green;
		}else if(q=="Yellow"){
			return Color.YELLOW;
		}else if(q=="Black"){
			return Color.black;
		}else if(q=="Orange"){
			return Color.orange;
		}else if(q=="PINK"){
			return Color.PINK;
		}else if(q=="MAGENTA"){
			return Color.MAGENTA;
		}else if(q=="Gray"){
			return Color.GRAY;
		}else if(q=="LightGray"){
			return Color.lightGray;
		}
		return Color.black;
	}
}


