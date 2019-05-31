package ca.utoronto.utm.paint;

import javax.swing.*; 

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.*;
import java.awt.event.*;
/**
 * This is the top level View+Controller, it contains other aspects of the View+Controller.
 * @author arnold
 *
 */
public class View extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private PaintModel model;
	// The components that make this up
	private PaintPanel paintPanel;
	private ShapeChooserPanel shapeChooserPanel;
	private ColorChooserPanel colorChooserPanel;
	private OptionalPanel optionalchooserPanel;
	
	public View(PaintModel model) {
		super("Paint"); // set the title and do other JFrame init
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setJMenuBar(createMenuBar());
		
		Container c=this.getContentPane();
		this.shapeChooserPanel = new ShapeChooserPanel(this);
		this.shapeChooserPanel.setBackground(Color.white);
		this.shapeChooserPanel.setPreferredSize(new Dimension(60, 200));
		this.colorChooserPanel = new ColorChooserPanel(this);
		this.optionalchooserPanel = new OptionalPanel(this); //initialize a new JPanel using this view.
		c.add(this.shapeChooserPanel,BorderLayout.WEST);
		
		c.add(this.optionalchooserPanel,BorderLayout.EAST);
		c.add(this.colorChooserPanel,BorderLayout.SOUTH);
		
		this.model=model;
		
		this.paintPanel = new PaintPanel(model, this);
		c.add(this.paintPanel, BorderLayout.CENTER);
		
		this.pack();
		this.setSize(600,600);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public PaintPanel getPaintPanel(){
		return paintPanel;
	}
	public PaintModel getPaintModel(){
		return this.model;
	}
	
	public ShapeChooserPanel getShapeChooserPanel() {
		return shapeChooserPanel;
	}

	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu;
		JMenuItem menuItem;

		menu = new JMenu("File");

		// a group of JMenuItems
		menuItem = new JMenuItem("New");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Open");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Save");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menu.addSeparator();// -------------

		menuItem = new JMenuItem("Exit");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuBar.add(menu);

		menu = new JMenu("Edit");

		// a group of JMenuItems
		menuItem = new JMenuItem("Cut");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Copy");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Paste");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menu.addSeparator();// -------------

		menuItem = new JMenuItem("Undo");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Redo");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuBar.add(menu);

		return menuBar;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()=="Exit"){
			setVisible(false);
			dispose();
		}
		if(e.getActionCommand()=="New"){new Paint();}
		
	}
}

