/**
*Class representing JPanel that displays a real-time representation of a
*merge sorting algorithm
*<p>
*Contains methods to immediately repaint the panel following each swap and
*swap elements in an array, allowing for a visual representation of a 
*merge sort
*
*@author Trevor Wilson
*@version 1.0, 10/18/2011
*/
import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class MergePanel extends JPanel{

	int[] mergeArray;
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
	public MergePanel(boolean enabled, boolean randomCase){
		mergeArray = new int[300];
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.enabled = enabled;
		this.randomCase = randomCase;
	}
	
	/**
	*Generates and draws the initial state of the array and then calls 
	*on a helper method to sort the array.
	*/
	public void draw(){
		
		//Wraps the method in a runnable to ensure it is repainted correctly
		Runnable drawRunnable = new Runnable(){
			public void run(){
				if(enabled){
				
					//Generates random case array
					if(randomCase){
						for(int i = 0; i < 300; i++){
							int randInt = (int)(Math.random() * 300);
							mergeArray[i] = randInt;
						}
					}
					
					//Generates worst case array
					else{
						for(int i = 0; i < 300; i++){
							mergeArray[i] = 299-i;
						}
					}
					
					//Sorts the array
					mergeSort(mergeArray, 0, 299);
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
				g.drawRect(i*2, 25 + (300 - mergeArray[i]), 2, mergeArray[i]);
				g.fillRect(i*2, 25 + (300 - mergeArray[i]), 2, mergeArray[i]);
			}
		}
	}
	
	/**
	*Recursively sorts an array, with a helper method to combine
	*two smaller arrays
	*
	*@param data The array to sort
	*@param min The beginning of the array
	*@param max The end of the array
	*/
	public void mergeSort (int[] data, int min, int max)
	{
	
		//Splits the array into two smaller arrays, then sorts
		//each and combines them back into one
		if (min < max)
		{
			int mid = (min + max) / 2;
			mergeSort (data, min, mid);
			mergeSort (data, mid+1, max);
			merge (data, min, mid, max);
		}
	}
	
	/**
	*Method to repaint all values in the array
	*
	*@param data The array in which the smaller arrays will be combined
	*@param first The beginning of the array
	*@param mid The middle of the array
	*@param last The end of the array
	*/
	public void merge (int[] data, int first, int mid, int last){
		int[] temp = new int[data.length];
		
		int first1 = first, last1 = mid;
		int first2 = mid+1, last2 = last; 
		int index = first1;
		
		//Looks through each smaller array, taking the smallest
		//values until one array is empty and putting them into
		//a temporary array
		while (first1 <= last1 && first2 <= last2){
			
			if (data[first1] < data[first2]){
				temp[index] = data[first1];
				first1++;
			}
			else{
				temp[index] = data[first2];
				first2++;
			}
			index++;
		}
		
		//Copy remaining elements from first subarray
		while (first1 <= last1){

			temp[index] = data[first1];
			first1++;
			index++;
		}
		
		//Copy remaining elements from second subarray
		while (first2 <= last2){
			
			temp[index] = data[first2];
			first2++;
			index++;
		}
		
		//Copy all changed data from temporary array into original array
		for (index = first; index <= last; index++){
			data[index] = temp[index];
		}
		
		//Repaints each time data is merged, and then pauses so the action
		//can be seen
		paintImmediately(0, 0, 600, 400);
		try{
			Thread.sleep(50);
		}catch(InterruptedException e){
			System.out.println("Interrupted Exception");
		}
	}
	
}