/**
*Class representing JPanel that displays a real-time representation of a
*bubble sorting algorithm
*<p>
*Contains methods to immediately repaint the panel following each swap and
*swap elements in an array, allowing for a visual representation of a 
*bubble sort
*
*@author Trevor Wilson
*@version 1.0, 10/18/2011
*/

import java.awt.*;
import javax.swing.*;

public class BubblePanel extends JPanel{

	boolean enabled, randomCase;
	int[] bubbleArray;
	

	/**
	*Takes in arguments to indicate whether the sort should be performed
	*and whether the initial array should be sorted randomly or set up
	*for a worst case.
	*
	*@param enabled If true, an array will be generated and sorted
	*@param randomCase If true, and random array is generated. If false,
	*a worst-case array is generate with values in descending order
	*/
	public BubblePanel(boolean enabled, boolean randomCase){
		bubbleArray = new int[300];
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
				
					//Generates a random array
					if(randomCase){
						for(int i = 0; i < 300; i++){
							int randInt = (int)(Math.random() * 300);
							bubbleArray[i] = randInt;
						}
					}
					
					//Generates a worst-case array
					else{
						for(int i = 0; i < 300; i++){
							bubbleArray[i] = 299-i;
						}
					}
					
					//Sorts the array, redrawing after each swap
					int position, scan;
					for (position = bubbleArray.length - 1; position >= 0; position--){
						for (scan = 0; scan <= position - 1; scan++){
							if (bubbleArray[scan] > bubbleArray[scan+1]){
								swap(scan, scan+1);
								paintImmediately(0, 0, 600, 400);
							}
						}
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
			//For each value in the array, draws a rectangle with a height equal to the value
			for(int i = 0; i < 300; i++){
				g.drawRect(i*2, 25 + (300 - bubbleArray[i]), 2, bubbleArray[i]);
				g.fillRect(i*2, 25 + (300 - bubbleArray[i]), 2, bubbleArray[i]);
			}
		}
	}
	
	/**
	*Swaps two values in an array, using a temporary variable
	*
	*@param index1 The position of the first value in the array
	*to be swapped
	*@param index2 The position of the second value in the array
	*to be swapped
	*/
	public void swap(int index1, int index2){
		int temp = bubbleArray[index1];
		bubbleArray[index1] = bubbleArray[index2];
		bubbleArray[index2] = temp;
	}
	
}