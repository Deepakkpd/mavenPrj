package com.aarestu.valueobject;

public class CategoryVO {
	private String name;
	private double totPrice;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getTotPrice() {
		return totPrice;
	}

	public void setTotPrice(double totPrice) {
		this.totPrice = totPrice;
	}

	@Override
	public String toString() {
		return "CategoryVO [name=" + name + ", totPrice=" + totPrice + "]";
	}

}
