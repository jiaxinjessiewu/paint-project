package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class CircleStrategy implements drawingCommand {
	
	private Point centre,startPoint,endPoint;
	private int radius;
	private String outLineFill,basicStroke,mode,color;
	private BasicStroke b;
	private Color c;
	
	public CircleStrategy(String mode,Point startPoint,Point endPoint,String outlineFill,String basicStroke,String color){
		this.mode = mode;
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.outLineFill=outlineFill;
		this.basicStroke=basicStroke;
		this.color=color;
		
	}
	
	@Override
	public void draw(Graphics2D g){
		
		int x0 = this.startPoint.getX();
		int y0 = this.startPoint.getY();
		
		int x1 = this.endPoint.getX();
		int y1 = this.endPoint.getY();
		
		this.radius = (int) Math.sqrt((x1-x0) * (x1-x0) +(y1-y0) * (y1-y0));
		this.centre = new Point(Math.abs(x0-radius/2),Math.abs(y0-radius/2));
		if (this.outLineFill=="outline"||this.outLineFill==null){
			g.drawOval(this.centre.getX(), this.centre.getY(), this.radius,this.radius);
		}
		if(this.outLineFill=="fill"){g.fillOval(this.centre.getX(), this.centre.getY(), this.radius,this.radius);}
		
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
		this.startPoint=startPoint;
	}
	
	@Override
	public void setEndPoint(Point endPoint) {
		// TODO Auto-generated method stub
		this.endPoint=endPoint;
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
		
	}
}

