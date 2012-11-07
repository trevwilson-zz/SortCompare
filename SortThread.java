import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SortThread extends Thread{
	
	String type;
	SelectionPanel selectionPanel;
	InsertionPanel insertionPanel;
	BubblePanel bubblePanel;
	MergePanel mergePanel;
	
	
	public SortThread(SelectionPanel panel, String type){
		selectionPanel = panel;
		this.type = type;
	}
	
	public SortThread(InsertionPanel panel, String type){
		insertionPanel = panel;
		this.type = type;
	}
	
	public SortThread(BubblePanel panel, String type){
		bubblePanel = panel;
		this.type = type;
	}
	
	public SortThread(MergePanel panel, String type){
		mergePanel = panel;
		this.type = type;
	}
	
	public void run(){
		if(type.equals("selection")){
			System.out.println("Drawing selection Panel");
			selectionPanel.draw();
		}
		else if(type.equals("insertion")){
			insertionPanel.draw();
			System.out.println("Drawing insertion Panel");
		}
		else if(type.equals("bubble")){
			bubblePanel.draw();
			System.out.println("Drawing bubble Panel");
		}
		else if(type.equals("merge")){
			mergePanel.draw();
			System.out.println("Drawing merge Panel");
		}
	}
	
}