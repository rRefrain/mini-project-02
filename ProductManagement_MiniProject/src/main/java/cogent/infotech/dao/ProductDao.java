package cogent.infotech.dao;

public interface ProductDao {
	
	public void addProduct(int pID, String pName, 
			String pCat, String manufecture_date, String expiry_date, int price);
	
	public void findProductById(int pID);
	
	public void findProductByCat(String pCat);
	
	public void updateProduct(int pID, String pName, 
			String pCat, String manufecture_date, String expiry_date, int price);
	
	public void deleteProductById(int pID);
	
	public void deleteProductByCat(String pCat);
	
	public void findExpiredProducts();
	
	public void findCheapestProductInCat(String pCat);
	
}
