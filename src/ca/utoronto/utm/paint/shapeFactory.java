package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.*;

public class shapeFactory {
	
	private Point startPoint=null;
	private Point endPoint=null;
	private String outLineFill=null;
	private String basicStroke=null;
	private String color=null;
	
	public shapeFactory(){
		
	}
	
	public drawingCommand createCommand(String mode,PaintModel model){
		if(mode=="Circle")return new CircleStrategy(mode, this.startPoint, this.endPoint, this.outLineFill, this.basicStroke, this.color);
		if(mode=="Rectangle")return new RectangleStrategy(mode, this.startPoint, this.endPoint, this.outLineFill, this.basicStroke, this.color);
		if(mode=="Square")return new SquareStrategy(mode, this.startPoint, this.endPoint, this.outLineFill, this.basicStroke, this.color);
		if(mode=="Squiggle")return new SquiggleStrategy(mode, this.startPoint, this.endPoint, this.outLineFill, this.basicStroke, this.color);
		if(mode=="Polyline")return new PolylineStrategy(model,mode, this.startPoint, this.endPoint, this.outLineFill, this.basicStroke, this.color);
		return null;
	}
			
}
