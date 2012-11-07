/**
*Class representing the initial window that allows the user to make choices
*regarding which algorithms to show
*<p>
*Instantiates and sets action listeners and accelerators for all buttons
*contained in the menu bar.
*
*@author Trevor Wilson
*@version 1.0, 12/1/2011
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class FirstWindow{

	JFrame f;
	JMenuBar menuBar;
	JMenu fileMenu, helpMenu;
	JMenuItem exitButton, aboutButton;
	JCheckBox selectionEnable, insertionEnable, bubbleEnable, mergeEnable;
	JRadioButton selectionWorst, selectionRandom, insertionWorst, insertionRandom, bubbleWorst, bubbleRandom, mergeWorst, mergeRandom;
	ButtonGroup selectionGroup, insertionGroup, bubbleGroup, mergeGroup;
	JSeparator sep1, sep2, sep3, sep4;
	JButton okButton;
	
	/**
	*Instantiates and adds all necessary buttons, labels, and menus, and
	*lays them out using a group layout
	*/
	public FirstWindow(){
		f = new JFrame("Sorting - Options");
		GroupLayout layout = new GroupLayout(f.getContentPane());
		f.getContentPane().setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		helpMenu = new JMenu("Help");
		exitButton = new JMenuItem("Exit");
		aboutButton = new JMenuItem("About");
		okButton = new JButton("OK");
		exitButton.addActionListener(new exitListener());
		aboutButton.addActionListener(new aboutListener());
		fileMenu.add(exitButton);
		helpMenu.add(aboutButton);
		menuBar.add(fileMenu);
		menuBar.add(helpMenu);
		f.setJMenuBar(menuBar);
		selectionGroup = new ButtonGroup();
		insertionGroup = new ButtonGroup();
		bubbleGroup = new ButtonGroup();
		mergeGroup = new ButtonGroup();
		selectionEnable = new JCheckBox("Enable Selection Sort");
		insertionEnable = new JCheckBox("Enable Insertion Sort");
		bubbleEnable = new JCheckBox("Enable Bubble Sort");
		mergeEnable = new JCheckBox("Enable Merge Sort");
		selectionWorst = new JRadioButton("Worst Case");
		selectionRandom = new JRadioButton("Random Case", true);
		insertionWorst = new JRadioButton("Worst Case");
		insertionRandom = new JRadioButton("Random Case", true);
		bubbleWorst = new JRadioButton("Worst Case");
		bubbleRandom = new JRadioButton("Random Case", true);
		mergeWorst = new JRadioButton("Worst Case");
		mergeRandom = new JRadioButton("Random Case", true);
		selectionWorst.setEnabled(false);
		selectionRandom.setEnabled(false);
		insertionWorst.setEnabled(false);
		insertionRandom.setEnabled(false);
		bubbleWorst.setEnabled(false);
		bubbleRandom.setEnabled(false);
		mergeWorst.setEnabled(false);
		mergeRandom.setEnabled(false);
		selectionGroup.add(selectionWorst);
		selectionGroup.add(selectionRandom);
		insertionGroup.add(insertionWorst);
		insertionGroup.add(insertionRandom);
		bubbleGroup.add(bubbleWorst);
		bubbleGroup.add(bubbleRandom);
		mergeGroup.add(mergeWorst);
		mergeGroup.add(mergeRandom);
		sep1 = new JSeparator(SwingConstants.HORIZONTAL);
		sep2 = new JSeparator(SwingConstants.HORIZONTAL);
		sep3 = new JSeparator(SwingConstants.HORIZONTAL);
		sep4 = new JSeparator(SwingConstants.HORIZONTAL);
		selectionEnable.addActionListener(new enableListener());
		insertionEnable.addActionListener(new enableListener());
		bubbleEnable.addActionListener(new enableListener());
		mergeEnable.addActionListener(new enableListener());
		okButton.addActionListener(new okListener());
		layout.setHorizontalGroup(layout.createSequentialGroup()
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
				.addComponent(selectionEnable)
				.addComponent(selectionRandom)
				.addComponent(selectionWorst)
				.addComponent(sep1)
				.addComponent(insertionEnable)
				.addComponent(insertionRandom)
				.addComponent(insertionWorst)
				.addComponent(sep2)
				.addComponent(bubbleEnable)
				.addComponent(bubbleRandom)
				.addComponent(bubbleWorst)
				.addComponent(sep3)
				.addComponent(mergeEnable)
				.addComponent(mergeRandom)
				.addComponent(mergeWorst)
				.addComponent(sep4)
				.addComponent(okButton))
		);
		layout.setVerticalGroup(layout.createSequentialGroup()
			.addComponent(selectionEnable)
			.addComponent(selectionRandom)
			.addComponent(selectionWorst)
			.addComponent(sep1)
			.addComponent(insertionEnable)
			.addComponent(insertionRandom)
			.addComponent(insertionWorst)
			.addComponent(sep2)
			.addComponent(bubbleEnable)
			.addComponent(bubbleRandom)
			.addComponent(bubbleWorst)
			.addComponent(sep3)
			.addComponent(mergeEnable)
			.addComponent(mergeRandom)
			.addComponent(mergeWorst)
			.addComponent(sep4)
			.addComponent(okButton)
		);
			
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		
	}
	
	//Exits the program when the exit button in the menu is clicked
	private class exitListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.exit(0);
		}
	}
	
	//Shows a popup window with information about the program when the about button is clicked
	private class aboutListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "Trevor Wilson - Project 5 - Learning Sorting");
		}
	}
	
	
	//Sets radio buttons as inactive when the corresponding checkbox is deselected, and vice versa
	private class enableListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource().equals(selectionEnable) && selectionEnable.isSelected() == false){
				selectionWorst.setEnabled(false);
				selectionRandom.setEnabled(false);
			}
			else if(e.getSource().equals(selectionEnable) && selectionEnable.isSelected() == true){
				selectionWorst.setEnabled(true);
				selectionRandom.setEnabled(true);
			}
			else if(e.getSource().equals(insertionEnable) && insertionEnable.isSelected() == false){
				insertionWorst.setEnabled(false);
				insertionRandom.setEnabled(false);
			}
			else if(e.getSource().equals(insertionEnable) && insertionEnable.isSelected() == true){
				insertionWorst.setEnabled(true);
				insertionRandom.setEnabled(true);
			}
			else if(e.getSource().equals(bubbleEnable) && bubbleEnable.isSelected() == false){
				bubbleWorst.setEnabled(false);
				bubbleRandom.setEnabled(false);
			}
			else if(e.getSource().equals(bubbleEnable) && bubbleEnable.isSelected() == true){
				bubbleWorst.setEnabled(true);
				bubbleRandom.setEnabled(true);
			}
			else if(e.getSource().equals(mergeEnable) && mergeEnable.isSelected() == false){
				mergeWorst.setEnabled(false);
				mergeRandom.setEnabled(false);
			}
			else if(e.getSource().equals(mergeEnable) && mergeEnable.isSelected() == true){
				mergeWorst.setEnabled(true);
				mergeRandom.setEnabled(true);
			}
		}
	}
	
	//Shows the sorting window when the ok button is clicked
	public class okListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			f.setVisible(false);	
			new SortWindow(selectionEnable.isSelected(), selectionRandom.isSelected(),insertionEnable.isSelected(),insertionRandom.isSelected(),bubbleEnable.isSelected(),bubbleRandom.isSelected(),mergeEnable.isSelected(),mergeRandom.isSelected());
		}
	}
	
}