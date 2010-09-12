package de.muvibee.playground.cr;

import java.util.ArrayList;

public class TreeList {

	private String sortBy;
	private ArrayList<TreeList> list;
	
	public TreeList(String sortBy, ArrayList<TreeList> list) {
		this.sortBy = sortBy;
		this.list = list;
	}
	
	public ArrayList<TreeList> getList() {
		return list;
	}
	
	public String getSortBy() {
		return sortBy;
	}
	
	public void setList(ArrayList<TreeList> list) {
		this.list = list;
	}
	
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
}
