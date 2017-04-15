package com.aarestu.valueobject;

public class CategoryPercentVO {
	private double vegetables;
	private double grocery;
	private double bakery;
	private double medecine;
	private double entertainment;
	private double bills;
	private double otherExpenses;

	public double getVegetables() {
		return vegetables;
	}

	public void setVegetables(double vegetables) {
		this.vegetables = vegetables;
	}

	public double getGrocery() {
		return grocery;
	}

	public void setGrocery(double grocery) {
		this.grocery = grocery;
	}

	public double getBakery() {
		return bakery;
	}

	public void setBakery(double bakery) {
		this.bakery = bakery;
	}

	public double getMedecine() {
		return medecine;
	}

	public void setMedecine(double medecine) {
		this.medecine = medecine;
	}

	public double getEntertainment() {
		return entertainment;
	}

	public void setEntertainment(double entertainment) {
		this.entertainment = entertainment;
	}

	public double getBills() {
		return bills;
	}

	public void setBills(double bills) {
		this.bills = bills;
	}

	public double getOtherExpenses() {
		return otherExpenses;
	}

	public void setOtherExpenses(double otherExpenses) {
		this.otherExpenses = otherExpenses;
	}

	@Override
	public String toString() {
		return "CategoryPercentVO [vegetables=" + vegetables + ", grocery="
				+ grocery + ", bakery=" + bakery + ", medecine=" + medecine
				+ ", entertainment=" + entertainment + ", bills=" + bills
				+ ", otherExpenses=" + otherExpenses + "]";
	}

}
