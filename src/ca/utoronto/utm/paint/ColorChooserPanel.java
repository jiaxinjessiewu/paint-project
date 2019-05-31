package ca.utoronto.utm.paint;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class ColorChooserPanel extends JPanel implements ActionListener {
	private View view; // So we can talk to our parent or other components of the view
	
	public ColorChooserPanel(View view) {	
		this.view=view;
		
		String[] buttonLabels = { "Red", "Blue", "Green", "Yellow", "Black", "Orange" ,"Gray","MAGENTA","PINK","LightGray"};
		this.setLayout(new GridLayout(2, buttonLabels.length));
		for (String label : buttonLabels) {
			Color color = null;
			if(label=="Red"){
				color = Color.RED;
			}else if(label=="Blue"){
				color=Color.BLUE;
			}else if(label=="Cyan"){
				color=Color.CYAN;
			}else if(label=="Green"){
				color=Color.green;
			}else if(label=="Yellow"){
				color=Color.YELLOW;
			}else if(label=="Black"){
				color=Color.black;
			}else if(label=="Orange"){
				color=Color.orange;
			}else if(label=="PINK"){
				color=Color.PINK;
			}else if(label=="MAGENTA"){
				color=Color.MAGENTA;
			}else if(label=="Gray"){
				color=Color.GRAY;
			}else if(label=="LightGray"){
				color=Color.lightGray;
			}
			
			JButton button = new JButton();
			button.setBackground(color);
			button.setBorderPainted(false);
			button.setActionCommand(label);
			button.setOpaque(true);
			this.add(button);
			button.addActionListener(this);
		}
	}
		
		/**
		 * Controller aspect of this
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			this.view.getPaintPanel().setColor(e.getActionCommand());
		}

		
	}



