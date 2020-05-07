package auctionclient;

public class Item {
	
	public String name;
	public String description;
	public double minPrice;
	
	public Item() {
		this.name = "";
		this.description = "";
		this.minPrice = 0.00;
	}
	public Item(String name, String description, double minPrice) {
		
		this.name = name;
		this.description = description;
		this.minPrice = minPrice;

	}
	

}
