package com.aarestu.valueobject;

import java.util.Date;

public class HelloVO {
	private String name;
	private Double price;
	private String category;
	private boolean checkIndicator;
	private boolean errIndicator;
	private Date purchaseDate;

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public boolean isErrIndicator() {
		return errIndicator;
	}

	public void setErrIndicator(boolean errIndicator) {
		this.errIndicator = errIndicator;
	}

	public boolean isCheckIndicator() {
		return checkIndicator;
	}

	public void setCheckIndicator(boolean checkIndicator) {
		this.checkIndicator = checkIndicator;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HelloVO [name=");
		builder.append(name);
		builder.append(", price=");
		builder.append(price);
		builder.append(", category=");
		builder.append(category);
		builder.append(", checkIndicator=");
		builder.append(checkIndicator);
		builder.append(", errIndicator=");
		builder.append(errIndicator);
		builder.append(", purchaseDate=");
		builder.append(purchaseDate);
		builder.append("]");
		return builder.toString();
	}

}
