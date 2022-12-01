package com.glarimy.is.app;

public class Item {
	public int id;
	public int available;
	public int reserved;
	public String units;

	@Override
	public String toString() {
		return "Item [id=" + id + ", available=" + available + ", reserved=" + reserved + ", units=" + units + "]";
	}

}
