package cogent.infotech.controller;

import cogent.infotech.dao.ProductDaoImpl;
import helper.Parser;

public class ProductController {
	private final ProductDaoImpl dao = new ProductDaoImpl();
	
	public void accept(int choice) {
		switch(choice) {
			case 1:
				create();
				break;
			case 2:
				findById();
				break;
			case 3:
				findByCat();
				break;
			case 4:
				updateById();
				break;
			case 5:
				deleteById();
				break;
			case 6: 
				deleteByCat();
				break;
			case 7:
				findExpiredProduct();
				break;
			case 8:
				findCheapestProductInCat();
				break;
		}
	}
	
	private void create() {
		create(Parser.readInt("Enter Product ID:"),
				Parser.readString("Enter Product Name:").toLowerCase(),
				Parser.readString("Enter Product Category:").toLowerCase(),
				Parser.readDate("Enter Manufecutre Date:").toString(),
				Parser.readDate("Enter Expiry Date:").toString(),
				Parser.readInt("Enter Price:")
				);
	}
	
	private void create(int pID, String pName, String pCat, String manufecture_date, String expiry_date, int price) {
		dao.addProduct(pID, pName, pCat, manufecture_date, expiry_date, price);
	}
	
	private void findById() {
		findById(Parser.readInt("Enter Product ID:"));
	}
	
	private void findById(int pID) {
		dao.findProductById(pID);
	}
	
	private void findByCat() {
		findByCat(Parser.readString("Enter Product Category:").toLowerCase());
	}
	
	private void findByCat(String pCat) {
		dao.findProductByCat(pCat);	
	}

	private void updateById() {
		updateByID(Parser.readInt("Enter Product ID:"),
				Parser.readString("Enter Product ID's new Name:").toLowerCase(),
				Parser.readString("Enter Product ID's new Category:").toLowerCase(),
				Parser.readDate("Enter ID's new Manufecutre Date:").toString(),
				Parser.readDate("Enter ID's Expiry Date:").toString(),
				Parser.readInt("Enter ID's new Price:")
				);
	}
	
	private void updateByID(int pID, String pName, String pCat, String manufecture_date, String expiry_date, int price) {
		dao.updateProduct(pID, pName, pCat, manufecture_date, expiry_date, price);
	}
	

	private void deleteById() {
		deleteById(Parser.readInt("Enter Product ID:"));
		
	}
	
	private void deleteById(int pID) {
		dao.deleteProductById(pID);
	}
	
	private void deleteByCat() {
		deleteByCat(Parser.readString("Enter Product Category:").toLowerCase());
		
	}
	
	private void deleteByCat(String pCat) {
		dao.deleteProductByCat(pCat);
	}

	private void findExpiredProduct() {
		dao.findExpiredProducts();
	}
	
	private void findCheapestProductInCat() {
		findCheapestProductInCat(Parser.readString("Enter Category:").toLowerCase());
		
	}

	private void findCheapestProductInCat(String pCat) {
		dao.findCheapestProductInCat(pCat);
	}


		
}
