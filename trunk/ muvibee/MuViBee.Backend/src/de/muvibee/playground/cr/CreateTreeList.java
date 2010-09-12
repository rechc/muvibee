package de.muvibee.playground.cr;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import de.muvibee.media.Media;

public class CreateTreeList{

	private ArrayList<Compare> sortedList;
	private ArrayList<TreeList> treeList;
	
	public CreateTreeList(ArrayList<Media> mediaList, ArrayList<Integer> sortedBy) {
		sortedList = new ArrayList<Compare>();
		treeList = new ArrayList<TreeList>();
		ArrayList<Compare> list = new ArrayList<Compare>();
		String sortString = null;
		String preview;
		int iCounter = 0;

		for (Media m : mediaList){
			switch (sortedBy.get(0)){
				case 1:
					sortString = Integer.toString(m.getYear());
					break;
				case 2:
					break;
				default:
					;
			}
			sortedList.add(new Compare(sortString ,m));
		}
		
		Collections.sort(sortedList);
		
		preview = sortedList.get(0).getSortedBy();
		
		for (Compare c : sortedList){
			if(c.equals(preview)){
				list.add(c);
				preview = c.getSortedBy();
			}else {
				treeList.add(new TreeList(c.getSortedBy(),list));
				list.clear();
			}
		}
		
	}
	
	private void greateTree(ArrayList<Media> mediaList, int sortBy) {
		ArrayList<Media> list = new ArrayList<Media>();
		String sortString;
		
			for (Media m : mediaList){
				switch (sortBy){
					case 1:
						sortString = Integer.toString(m.getYear());
						break;
					case 2:
						break;
					default:
						;
				}
//				if (sortString.equals(arg0))
			}
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
