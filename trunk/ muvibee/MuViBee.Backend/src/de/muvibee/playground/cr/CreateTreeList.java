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

		
		
		sortedList = sortList(mediaList, sortedBy.get(0));
		greateTree();
		
	}
	
	private ArrayList<Compare> sortList(TreeList tree, int sortedBy){
		ArrayList<Compare> list = new ArrayList<Compare>();
		String sortString = null;
		
		for (Media m : tree.getMediaList()){
			switch (sortedBy){
				case 1:
					sortString = Integer.toString(m.getYear());
					break;
				case 2:
					break;
				default:
					;
			}
			list.add(new Compare(sortString ,m));
		}
		Collections.sort(list);
		return list;
	}
	
	private TreeList test(MediaList media){
		
	}
	
	private ArrayList<TreeList> buildStages(int n) {
		ArrayList<TreeList> tree = new ArrayList<TreeList>();
		if (n >= 0){
			tree.add(new TreeList(null, buildStages(n-1)));
		}
		return tree;
	}
	
	private void greateTree() {
		ArrayList<Compare> list = new ArrayList<Compare>();
		ArrayList<TreeList> nullList = new ArrayList<TreeList>();
		String preview = sortedList.get(0).getSortedBy();
		
		for (Compare c : sortedList){
			if(c.equals(preview)){
				
				nullList.add(new TreeList(c.getSortedBy(), null));
				preview = c.getSortedBy();
			}else {
				treeList.add(new TreeList(c.getSortedBy(),nullList));
				list.clear();
			}
		}
	}
		
}
