package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.List;
import java.util.ArrayList;

public class PolylineStrategy implements drawingCommand{
	private String outLineFill,basicStroke,mode,color;
	private BasicStroke b;
	private Color c;
	private PaintModel model;
	
	public PolylineStrategy(PaintModel model,String mode,Point startPoint,Point endPoint,String outlineFill,String basicStroke,String color){
		this.mode = mode;
		this.basicStroke=basicStroke;
		this.color=color;
		this.model=model;
	}
	
	public void draw(Graphics2D g){
		int length = this.model.getPoint().size();
		int [] xPoints = new int[length];
		int [] yPoints = new int[length];
		int i =0;
		
		for (Point p:this.model.getPoint()){
			if (i<length){
				xPoints[i]=p.getX();
				yPoints[i]=p.getY();
				i++;}
		}
		g.drawPolyline(xPoints, yPoints, length);
	}
	
	@Override
	public void drawmodier(Graphics2D g) {
		// TODO Auto-generated method stub
		
		color judgeColor = new color();
		this.c = judgeColor.colorChoosing((this.color));
		g.setColor(this.c);
		setBasicStroke setbs = new setBasicStroke();
		this.b= setbs.chooseBasicStroke(this.basicStroke);
		g.setStroke(this.b);
		
	}
	
	@Override
	public void setStartPoint(Point startPoint) {
		// TODO Auto-generated method stub
		this.model.addPoint(startPoint);
	}
	
	@Override
	public void setEndPoint(Point endPoint) {
		// TODO Auto-generated method stub
		this.model.addPoint(endPoint);
	}
	@Override
	public void setOutLineFill(String outlinefill) {
		// TODO Auto-generated method stub
		this.outLineFill=outlinefill;
	}

	@Override
	public void setBasicStroke(String basicStroke) {
		// TODO Auto-generated method stub
		this.basicStroke=basicStroke;
	}

	@Override
	public void setColor(String color) {
		// TODO Auto-generated method stub
		this.color=color;
	}
	@Override
	public String getMode() {
		// TODO Auto-generated method stub
		return this.mode;
	}
	@Override
	public void setModel(PaintModel model) {
		// TODO Auto-generated method stub
		this.model=model;
	}
}

