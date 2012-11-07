/**
*Class representing JPanel that displays a real-time representation of an
*insertion sorting algorithm
*<p>
*Contains methods to immediately repaint the panel following each swap and
*swap elements in an array, allowing for a visual representation of an
*insertion sort
*
*@author Trevor Wilson
*@version 1.0, 10/18/2011
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class InsertionPanel extends JPanel{

	int[] insertionArray;
	boolean enabled, randomCase;

	/**
	*Takes in arguments to indicate whether the sort should be performed
	*and whether the initial array should be sorted randomly or set up
	*for a worst case.
	*
	*@param enabled If true, an array will be generated and sorted
	*@param randomCase If true, and random array is generated. If false,
	*a worst-case array is generate with values in descending order
	*/
	public InsertionPanel(boolean enabled, boolean randomCase){
		insertionArray = new int[300];
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.enabled = enabled;
		this.randomCase = randomCase;
	}
	
	/**
	*Generates and draws the initial state of the array and then sorts 
	*it while redrawing in real time.
	*/
	public void draw(){

		//Wraps the entire method in a Runnable to ensure it is redrawn correctly
		Runnable drawRunnable = new Runnable(){
			public void run(){
				if(enabled){
					
					//Generates a random case array
					if(randomCase){
						for(int i = 0; i < 300; i++){
							int randInt = (int)(Math.random() * 300);
							insertionArray[i] = randInt;
						}
					}
					
					//Generates a worst case array
					else{
						for(int i = 0; i < 300; i++){
							insertionArray[i] = 299-i;
						}
					}
					
					//Sorts the array, repainting each time a value is changed
					for (int index = 1; index < 300; index++)
					{
						try{
							Thread.sleep(50);
						}catch(InterruptedException e){
							System.out.println("Interrupted Exception");
						}
						int key = insertionArray[index];
						int position = index;
						
						while (position > 0 && insertionArray[position-1] > key)
						{
							insertionArray[position] = insertionArray[position-1];
							position--;
						}
						insertionArray[position] = key;
						paintImmediately(0, 0, 600, 400);
					}
					
				}
			}
			
		};
		SwingUtilities.invokeLater(drawRunnable);
	}
	
	/**
	*Method to repaint all values in the array
	*
	*@param g The Graphics context to redraw on
	*/
	public void paintComponent(Graphics g){
		if(enabled){
			super.paintComponent(g);
			for(int i = 0; i < 300; i++){
				g.drawRect(i*2, 25 + (300 - insertionArray[i]), 2, insertionArray[i]);
				g.fillRect(i*2, 25 + (300 - insertionArray[i]), 2, insertionArray[i]);
			}
		}
	}
}