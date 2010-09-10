package de.muvibee.playground.cr;

public class Compare implements Comparable{

	private String sortedBy;
	private Object object;
	
	public Compare(Object sortedBy, Object o) {
		this.sortedBy = (String) sortedBy;
		this.object = o;
	}

	
	@Override
	public int compareTo(Object o) {
		String string = (String) o;
		sortedBy.compareTo(string);
		return 0;
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

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

}