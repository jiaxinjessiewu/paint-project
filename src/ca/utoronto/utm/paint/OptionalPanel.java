package ca.utoronto.utm.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class OptionalPanel extends JPanel implements ActionListener {
	private View view; // So we can talk to our parent or other components of the view
	
	public OptionalPanel(View view) {	
		this.view=view;
		
		this.setPreferredSize(new Dimension(80, 200));
		this.setLayout(new GridLayout(7,1));
		this.setBackground(Color.white);
		Dimension d = new Dimension(50,50);
		
		JButton clear = new JButton("clear");
		clear.setSize(new Dimension(70,50));
		clear.setActionCommand("clear");
		this.add(clear);
		
		JButton undo = new JButton("undo");
		undo.setSize(new Dimension(70,50));
		undo.setActionCommand("undo");
		this.add(undo);
		
		JButton fill = new JButton();
		ImageIcon fillIcon = new ImageIcon("image/filled.png");
		Image image0 = fillIcon.getImage();
		Image newimg0 = image0.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		fillIcon  = new ImageIcon(newimg0);
		fill = new JButton(fillIcon );
		fill.setActionCommand("fill");
		this.add(fill);
		
		JButton outline = new JButton();
		ImageIcon outlineIcon = new ImageIcon("image/outline.png");
		Image image1= outlineIcon.getImage();
		Image newimg1 = image1.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		outlineIcon = new ImageIcon(newimg1);
		outline = new JButton(outlineIcon);
		outline.setActionCommand("outline");
		this.add(outline);
		
		JButton thick = new JButton();
		ImageIcon thickIcon = new ImageIcon("image/large.png");
		Image image2 = thickIcon.getImage();
		Image newimg2 = image2.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		thickIcon = new ImageIcon(newimg2);
		thick = new JButton(thickIcon);
		thick.setActionCommand("thick");
		this.add(thick);
		
		JButton medium = new JButton();
		ImageIcon mediumIcon = new ImageIcon("image/large.png");
		Image image3 = mediumIcon.getImage();
		Image newimg3 = image3.getScaledInstance(35, 35, java.awt.Image.SCALE_SMOOTH);
		mediumIcon = new ImageIcon(newimg3);
		medium = new JButton(mediumIcon);
		medium.setActionCommand("medium");
		this.add(medium);
		
		JButton bold = new JButton();
		ImageIcon boldIcon = new ImageIcon("image/large.png");
		Image image4 = boldIcon.getImage();
		Image newimg4 = image4.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		boldIcon = new ImageIcon(newimg4);
		bold = new JButton(boldIcon);
		bold.setActionCommand("bold");
		this.add(bold);
		
		outline.setSize(d);
		fill.setSize(d);
		bold.setSize(d);
		medium.setSize(d);
		thick.setSize(d);
		
		outline.addActionListener(this);
		fill.addActionListener(this);
		bold.addActionListener(this);
		medium.addActionListener(this);
		thick.addActionListener(this);
		undo.addActionListener(this);
		clear.addActionListener(this);
	}
	
	
	/**
	 * Controller aspect of this
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand()=="outline"|| e.getActionCommand()=="fill"){
			this.view.getPaintPanel().setOutLineFill(e.getActionCommand());
		}
		
		if(e.getActionCommand()=="bold"||e.getActionCommand()=="medium"||e.getActionCommand()=="thick"){
			this.view.getPaintPanel().setBoldThick(e.getActionCommand());
		}
		
		if(e.getActionCommand()=="undo"){
			this.view.getPaintModel().undo();
		}
		
		if(e.getActionCommand()=="clear"){
			this.view.getPaintModel().clear();
		}

	}
	
}



