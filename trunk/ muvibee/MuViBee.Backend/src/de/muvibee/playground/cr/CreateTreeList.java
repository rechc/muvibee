package de.muvibee.playground.cr;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class CreateTreeList{

	private ArrayList<Compare> sortedList;
	
	public CreateTreeList(ArrayList objectList, ArrayList<Integer> sortedBy) {
		sortedList = new ArrayList<Compare>();
		
		for (Object o : objectList){
			for (int i : sortedBy){
				
			}
		}
		
		Collections.sort(sortedList);
	}
	
	public int compareCompanant(Object o, int componant){
		//1 = name		
		
		switch (componant){
		case 1:
			;
		default:
			return 0;
		}
	}
	
}
