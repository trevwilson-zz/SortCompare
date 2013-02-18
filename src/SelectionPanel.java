/**
*Class representing JPanel that displays a real-time representation of a
*selection sorting algorithm
*<p>
*Contains methods to immediately repaint the panel following each swap and
*swap elements in an array, allowing for a visual representation of a 
*selection sort
*
*@author Trevor Wilson
*@version 1.0, 10/18/2011
*/

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class SelectionPanel extends JPanel{

	int[] selectionArray;
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
	public SelectionPanel(boolean enabled, boolean randomCase){
		selectionArray = new int[300];
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.enabled = enabled;
		this.randomCase = randomCase;
	}
	
	/**
	*Generates and draws the initial state of the array and then sorts 
	*it while redrawing in real time.
	*/
	public void draw(){
		if(enabled){
		
			//Wraps the entire method in a Runnable to ensure it is redrawn correctly
			Runnable drawRunnable = new Runnable() {
				public void run() {
				
					//Generates a random case array
					if(randomCase){
						for(int i = 0; i < 300; i++){
							int randInt = (int)(Math.random() * 300);
							selectionArray[i] = randInt;
						}
					}
					
					//Generates a worst case array
					else{
						for(int i = 0; i < 300; i++){
							selectionArray[i] = 299-i;
						}
					}
					
					//Sorts the array, redrawing each time a swap is made
					int min;
					for(int i = 0; i < 299; i++){
						min = i;
						for(int j = i + 1; j < 300; j++){
							if(selectionArray[j] < selectionArray[min]){
								min = j;
							}
						}
						try{
							Thread.sleep(50);
						}catch(InterruptedException e){
							System.out.println("Interrupted Exception");
						}
						swap(min, i);
						
						paintImmediately(0, 0, 600, 400);
					}
				}
			};
			SwingUtilities.invokeLater(drawRunnable);
		}
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
				g.drawRect(i*2, 25 + (300 - selectionArray[i]), 2, selectionArray[i]);
				g.fillRect(i*2, 25 + (300 - selectionArray[i]), 2, selectionArray[i]);
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
		int temp = selectionArray[index1];
		selectionArray[index1] = selectionArray[index2];
		selectionArray[index2] = temp;
	}
}