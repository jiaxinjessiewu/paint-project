package ca.utoronto.utm.paint;

import java.awt.*; 
import ca.utoronto.utm.paint.Point;

public interface drawingCommand {
	
	public void drawmodier(Graphics2D g);
	public void draw(Graphics2D g);
	public void setStartPoint(Point startPoint);
	public void setEndPoint(Point endPoint);
	public void setOutLineFill(String outlinefill);
	public void setBasicStroke(String basicStroke);
	public void setColor(String color);
	public String getMode();
	public void setModel(PaintModel model);
	
}