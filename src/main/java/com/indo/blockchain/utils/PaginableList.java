package com.indo.blockchain.utils;

import java.util.List;

public class PaginableList<T> {
	
	private int count; // total
	private int fromIndex;
	private List<T> items;
	
	public PaginableList(){}
	
	public PaginableList(List<T> items,int count,int fromIndex){
		this.count = count;
		this.fromIndex = fromIndex;
		this.items = items;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getFromIndex() {
		return fromIndex;
	}

	public void setFromIndex(int fromIndex) {
		this.fromIndex = fromIndex;
	}

	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}
}
