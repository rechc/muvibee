package de.muvibee.playground.cr;

import java.util.ArrayList;

public class TreeList {

	private String sortBy;
	private ArrayList<Compare> list;
	
	public TreeList(String sortBy, ArrayList<Compare> list) {
		this.sortBy = sortBy;
		this.list = list;
	}
	
	public ArrayList<Compare> getList() {
		return list;
	}
	
	public String getSortBy() {
		return sortBy;
	}
	
	public void setList(ArrayList<Compare> list) {
		this.list = list;
	}
	
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
}
