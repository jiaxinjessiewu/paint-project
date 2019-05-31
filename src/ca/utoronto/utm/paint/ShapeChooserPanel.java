package ca.utoronto.utm.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ShapeChooserPanel extends JPanel implements ActionListener {
	private View view; // So we can talk to our parent or other components of the view
	
	public ShapeChooserPanel(View view) {	
		this.view=view;
		String[] buttonLabels = { "Circle", "Rectangle", "Square", "Squiggle", "Polyline" };
		this.setLayout(new GridLayout(buttonLabels.length, 1));
		for (String label : buttonLabels) {
			ImageIcon icon = new ImageIcon("");
			if(label=="Circle"){
				icon = new ImageIcon("image/circle.png");
				
			}else if(label=="Rectangle"){
				icon = new ImageIcon("image/rectangle.png");
				
			}else if(label=="Square"){
				icon = new ImageIcon("image/square.png");
				
			}else if(label=="Squiggle"){
				icon = new ImageIcon("image/squiggle.jpg");
				
			}else if(label=="Polyline"){
				icon = new ImageIcon("image/polyline.png");
			}
			Image image = icon.getImage();
			Image newimg = image.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			JButton button = new JButton(icon);
			button.setActionCommand(label);
			this.add(button);
			button.addActionListener(this);
		}
	}
	
	/**
	 * Controller aspect of this
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		shapeFactory factory = new shapeFactory();
		drawingCommand command =factory.createCommand(e.getActionCommand(),this.view.getPaintModel());
		this.view.getPaintPanel().setCommand(command);
	}

	
}



