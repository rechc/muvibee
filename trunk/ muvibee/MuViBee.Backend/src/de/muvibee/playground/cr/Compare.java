package de.muvibee.playground.cr;

import java.util.ArrayList;

import de.muvibee.media.Media;

public class Compare implements Comparable{

	private String sortedBy;
	private Media childList;
	
	public Compare(String sortedBy, Media childList) {
		this.sortedBy = sortedBy;
		this.childList = childList;
	}

	
	@Override
	public int compareTo(Object o) {
		String string = (String) o;
		return sortedBy.compareTo(string);
	}
	
	
//-----------( Static Methode )------>
	
	public static int compareString(String a, String b){
		return a.compareTo(b);
	}
	
	public static int compareInt(int a, int b){
		if (a == b)
			return 0;
		else if (a > b)
			return 1;
		else
			return -1;
	}

	
//------( Getter & Setter )-------->
	public String getSortedBy() {
		return sortedBy;
	}

	public void setSortedBy(String sortedBy) {
		this.sortedBy = sortedBy;
	}
}