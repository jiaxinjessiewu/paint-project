package ca.utoronto.utm.paint;

import javax.swing.*;  
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;


class PaintPanel extends JPanel implements Observer, MouseMotionListener, MouseListener  {

	private PaintModel model; // slight departure from MVC, because of the way painting works
	private View view; // So we can talk to our parent or other components of the view
	private String mode,color,outlinefill="outline",basicStroke="thick"; 
	private drawingCommand strategy;
	private Point startPoint;

	public PaintPanel(PaintModel model, View view){
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(300,300));
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.model = model;
		this.model.addObserver(this);
		
		this.view=view;
	}
	
	/**
	 *  View aspect of this
	 */
	public void paintComponent(Graphics g) {

        super.paintComponent(g); //paint background
        Graphics2D g2d = (Graphics2D) g;
		ArrayList<drawingCommand> command = this.model.getdrawingCommand();
		for(drawingCommand s:command){
			s.drawmodier(g2d);
			s.draw(g2d);
		}
		
		// Draw Circles
		ArrayList<drawingCommand> dragged = this.model.getDragged();
		for(drawingCommand r:dragged){
			r.drawmodier(g2d);
			r.draw(g2d);
		}
		g2d.dispose();
	}

	@Override
	public void update(Observable o, Object arg) {
		this.repaint(); // Schedule a call to paintComponent
	}
	
	public void setOutLineFill(String outlinefill){
		this.outlinefill=outlinefill;
	}
	
	public void setBoldThick(String basicStroke){
		this.basicStroke=basicStroke;
	}
	
	/**
	 *  Controller aspect of this
	 */
	public void setCommand(drawingCommand strategy){
		this.strategy=strategy;
		this.mode=this.strategy.getMode();

	}
	public void reSetCommand(){
		shapeFactory factory= new shapeFactory();
		this.strategy=factory.createCommand(this.mode,this.model);

	}
	
	public void setColor(String string){
		this.color=string;
	}
	
	// MouseMotionListener below
	@Override
	public void mouseMoved(MouseEvent e) {
		if(this.mode=="Squiggle"){
			
		} else if(this.mode=="Circle"){
			
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if(strategy!=null){
			if (this.mode!="Polyline"){
			Point endPoint = new Point(e.getX(),e.getY());
			this.strategy.setEndPoint(endPoint);
			this.model.addDragged(this.strategy);
			this.model.getDragged().clear();
			this.model.addDragged(this.strategy);}
		}
		
	}
		
	// MouseListener below
	@Override
	public void mouseClicked(MouseEvent e) {
		if(this.mode=="Squiggle"){
			
		} else if(this.mode=="Circle"){
			
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(strategy!=null){
			this.startPoint = new Point(e.getX(),e.getY());
			//Point startPoint = new Point(e.getX(),e.getY());
			this.strategy.setStartPoint(this.startPoint);
			this.strategy.setBasicStroke(this.basicStroke);
			this.strategy.setOutLineFill(this.outlinefill);
			this.strategy.setColor(this.color);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(strategy!=null){
			Point endPoint = new Point(e.getX(),e.getY());
			this.strategy.setEndPoint(endPoint);
			this.model.addCommand(this.strategy);
			this.reSetCommand();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(this.mode=="Squiggle"){
			
		} else if(this.mode=="Circle"){
			
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(this.mode=="Squiggle"){
			
		} else if(this.mode=="Circle"){
			
		}
	}
}


