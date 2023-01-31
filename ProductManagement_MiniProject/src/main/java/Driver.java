import cogent.infotech.controller.ProductController;
import helper.Parser;

/**
 * Main Method for Product Management Mini-Project
 * 
 * @author : michaelmiranda
 * @date   : Jan 30, 2023
 */
public class Driver {
	
	/**
	 * Main Method
	 * 
	 * @param args unused command line arguements
	 * @see Parser#readInt(String)
	 * @see Parser#close
	 * @see ProductController#accept(int)
	 */
	public static void main(String[] args) {
		/** String to output whenever user is doing something with the CustomerBase */
		String menu = "\n\n"
				+ "1-Add Product\n"
				+ "2-Display Product by ID\n3-Display Products by Category\n"
				+ "4-Update Product\n"
				+ "5-Delete Product by ID\n6-Delete Product by Category\n"
				+ "7-Find Expired Product\n8-Find Cheapest Product in Category\n"
				+ "9-Exit\n "
				+ "Please enter your choice:";
				
		try {
			int choice = 0;
			ProductController pc = new ProductController();
			System.out.println("Welcome to Product Management Application");
			
			/* Infinite loop until client enters the input '9' */
			do  {
				choice = Parser.readInt(menu);
				pc.accept(choice);
				
			} while(choice != 9);
		}
		
		/* Closing the Static Parser */
		finally {
			System.out.println("\n\n-----End-----");
			Parser.close();
		}
	}

}
