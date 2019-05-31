package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;

public class RectangleStrategy implements drawingCommand {
	
	private Point startPoint,endPoint;
	private String outLineFill,basicStroke,mode,color;
	private BasicStroke b;
	private Color c;
	
	public RectangleStrategy(String mode,Point startPoint,Point endPoint,String outlineFill,String basicStroke,String color) {
		this.mode = mode;
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.outLineFill=outlineFill;
		this.basicStroke=basicStroke;
		this.color=color;
	}
	
	public void draw(Graphics2D g){
		int x = this.startPoint.getX();
		int y = this.startPoint.getY();
		int x1 = this.endPoint.getX();
		int y1 = this.endPoint.getY();
		
		if (y>y1){
			y = y1;
			y1 = this.startPoint.getY();
		}
		if (x>x1){
			x=x1;
			x1=this.startPoint.getX();
		}
		if (x>x1 && y>y1){
			y = y1;
			y1 = this.startPoint.getY();
			x=x1;
			x1=this.startPoint.getX();
		}
		if (this.outLineFill=="outline"|| this.outLineFill ==null){
			g.drawRect(x, y, x1-x, y1-y);
		}
		if(this.outLineFill=="fill"){g.fillRect(x, y, x1-x, y1-y);}
		
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

