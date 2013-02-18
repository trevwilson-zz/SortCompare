/**
*Class representing the main sorting window that shows sorting algorithms
*side by side.
*
*<p>
*Contains four panels, one for each algorithm, arranged in a 2x2 grid
*layout, as well as a menu bar allowing the user to quit the program,
*show about information, and start a new sort.
*
*@author Trevor Wilson
*@version 1.0, 12/1/2011
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class SortWindow extends JPanel{

	boolean selectionEnable, selectionRandom, insertionEnable, insertionRandom, bubbleEnable, bubbleRandom, mergeEnable, mergeRandom;
	JFrame f;
	SelectionPanel selectionPanel;
	InsertionPanel insertionPanel;
	BubblePanel bubblePanel;
	MergePanel mergePanel;
	JLabel selectionLabel, insertionLabel, bubbleLabel, mergeLabel;
	int[] selectionArray, insertionArray, bubbleArray, mergeArray;
	ImageIcon circle = new ImageIcon("circle.png");
	JMenuBar menuBar;
	JMenu fileMenu, helpMenu, newMenu;
	JMenuItem exitButton, aboutButton, newButton;
	
	
	/**
	*Takes in arguments to see which algorithms to show and what the initial
	*cases of each should be, and sets up panels appropriately.
	*
	*@param selectionEnable Whether selection sort should be shown
	*@param selectionRandom Whether selection sort should be worst-case or
	*random case
	*@param insertion Whether insertion sort should be shown
	*@param insertionRandom Whether insertion sort should be worst-case or
	*random case
	*@param bubbleEnable Whether bubble sort should be shown
	*@param bubbleRandom Whether bubble sort should be worst-case or
	*random case
	*@param mergeEnable Whether merge sort should be shown
	*@param mergeRandom Whether merge sort should be worst-case or
	*random case
	*/
	public SortWindow(boolean selectionEnable, boolean selectionRandom, boolean insertionEnable, boolean insertionRandom, boolean bubbleEnable, boolean bubbleRandom, boolean mergeEnable, boolean mergeRandom){
		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		helpMenu = new JMenu("Help");
		exitButton = new JMenuItem("Exit");
		aboutButton = new JMenuItem("About");
		newButton = new JMenuItem("New sort");
		exitButton.addActionListener(new exitListener());
		aboutButton.addActionListener(new aboutListener());
		newButton.addActionListener(new newListener());
		fileMenu.add(exitButton);
		fileMenu.add(newButton);
		helpMenu.add(aboutButton);
		menuBar.add(fileMenu);
		menuBar.add(helpMenu);
		selectionPanel = new SelectionPanel(selectionEnable, selectionRandom);
		insertionPanel = new InsertionPanel(insertionEnable, insertionRandom);
		bubblePanel = new BubblePanel(bubbleEnable, bubbleRandom);
		mergePanel = new MergePanel(mergeEnable, mergeRandom);
		f = new JFrame("Sorting");
		f.setJMenuBar(menuBar);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		selectionLabel = new JLabel("Selection Sort");
		selectionLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		insertionLabel = new JLabel("Insertion Sort");
		insertionLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		bubbleLabel = new JLabel("Bubble Sort");
		bubbleLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		mergeLabel = new JLabel("Merge Sort");
		mergeLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		selectionPanel.add(selectionLabel);
		insertionPanel.add(insertionLabel);
		bubblePanel.add(bubbleLabel);
		mergePanel.add(mergeLabel);
		f.getContentPane().setLayout(new GridLayout(2,2));
		f.add(selectionPanel);
		f.add(insertionPanel);
		f.add(bubblePanel);
		f.add(mergePanel);
		f.setSize(1220,720);
		f.setVisible(true);
		selectionPanel.draw();
		insertionPanel.draw();
		bubblePanel.draw();
		mergePanel.draw();
		
	}
	
	//Quits the program when the exit button is pressed
	private class exitListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.exit(0);
		}
	}
	
	//Displays program information when the about button is pressed
	private class aboutListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "Trevor Wilson - Project 5 - Learning Sorting");
		}
	}
	
	//Provides the user a chance to reselect which sorting algorithms to show
	private class newListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			f.setVisible(false);
			new FirstWindow();
		}
	}
	

}