package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class SquiggleStrategy implements drawingCommand{
	private ArrayList<Point> points = new ArrayList<Point>();
	private String basicStroke,mode,color;
	private BasicStroke b;
	private Color c;
	
	public SquiggleStrategy(String mode,Point startPoint,Point endPoint,String outlineFill,String basicStroke,String color){
		this.mode = mode;
		this.basicStroke=basicStroke;
		this.color=color;
	}
	
	@Override
	public void draw(Graphics2D g){
		int length = points.size();
		int [] xPoints = new int[length];
		int [] yPoints = new int[length];
		int i =0;
		
		for (Point p:points){
			if (i<length){
				xPoints[i]=p.getX();
				yPoints[i]=p.getY();
				i++;}
			}
		
		g.drawPolyline(xPoints, yPoints, length);
	}
	
	@Override
	public void drawmodier(Graphics2D g) {
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
		points.add(startPoint);
	}

	@Override
	public void setEndPoint(Point endPoint) {
		// TODO Auto-generated method stub
		points.add(endPoint);
	}

	@Override
	public void setOutLineFill(String outlinefill) {
		// TODO Auto-generated method stub

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
		
	}
}


