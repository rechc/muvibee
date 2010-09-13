package de.muvibee.playground.cr;

import java.util.ArrayList;

public class TreeList {

	private String sortBy;
	private ArrayList<TreeList> list;
	private ArrayList<Compare> medialist;
	
	public TreeList(String sortBy, ArrayList<TreeList> list, ArrayList<Compare> medialist) {
		this.sortBy = sortBy;
		this.list = list;
		this.medialist = medialist;
	}
	
	public ArrayList<Compare> getMedialist() {
		return medialist;
	}
	
	public void setMedialist(ArrayList<Compare> medialist) {
		this.medialist = medialist;
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
