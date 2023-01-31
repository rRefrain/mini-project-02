package cogent.infotech.model;

import java.time.LocalDate;

import helper.Parser;

public class Product {
	private int pID;
	private String pName;
	private String pCat;
	private LocalDate manufecture_date;
	private LocalDate expiry_date;
	private int price;
	
	public Product(int pID, String pName, String pCat, LocalDate manufecture_date, LocalDate expiry_date, int price) {
		super();
		this.pID = pID;
		this.pName = pName;
		this.pCat = pCat;
		this.manufecture_date = manufecture_date;
		this.expiry_date = expiry_date;
		this.price = price;
	}

	public Product() {
		this(Parser.readInt("Enter Product ID:"),
				Parser.readString("Enter Product Name:"),
				Parser.readString("Enter Product Category:"),
				Parser.readDate("Enter Manufecutre Date:"),
				Parser.readDate("Enter Expiry Date:"),
				Parser.readInt("Enter  Price:")
				);
	}
	
	public int getpID() {
		return pID;
	}

	public void setpID(int pID) {
		this.pID = pID;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpCat() {
		return pCat;
	}

	public void setpCat(String pCat) {
		this.pCat = pCat;
	}

	public LocalDate getManufecture_date() {
		return manufecture_date;
	}

	public void setManufecture_date(LocalDate manufecture_date) {
		this.manufecture_date = manufecture_date;
	}

	public LocalDate getExpiry_date() {
		return expiry_date;
	}

	public void setExpiry_date(LocalDate expiry_date) {
		this.expiry_date = expiry_date;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductID: " + pID + "\tProduct Name: " + pName + 
				"\nPrice" + price + "\tCatetory: " + pCat + 
				"\nmanufecture date: " + manufecture_date + "\texpiry date: " + expiry_date;
	}
}
