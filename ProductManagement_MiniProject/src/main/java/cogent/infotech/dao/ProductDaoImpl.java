package cogent.infotech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import cogent.infotech.jdbc.JDBCUtils;

public class ProductDaoImpl implements ProductDao {
	
	private final static String Insert_Product_SQL = "insert into product" + 
			"(pID, pName, category, manufecture_date, expiry_date, price) values" + 
			"(?,?,?,?,?,?);";
	
	private final static String Find_Product_ID_SQL = "select * from product where pID=?";
	private final static String Find_Product_CAT_SQL = "select * from product where category=?";
	private final static String Update_EMPLOYESS_SQL = "update product set pName=?, category=?, "
							+ "manufecture_date=?, expiry_date=?, price=? where pID=?";
	
	private final static String	Delete_Product_ID_SQL = "delete from product where pID=?";
	private final static String Delete_Product_CAT_SQL = "delete from product where category=?";
	
	private final static String Find_Product_EXPIRY_SQL = "select * from product where expiry_date <= ?";
	private final static String Find_Product_CHEAPEST_CAT_SQL = "select * from product where category=? order by price limit 1";
	
	@Override
	public void addProduct(int pID, String pName, String pCat, String manufecture_date, String expiry_date, int price) {
		// TODO Auto-generated method stub
		
		try (Connection connection = JDBCUtils.getConnection())  {
			PreparedStatement ps = connection.prepareStatement(Insert_Product_SQL);
			ps.setInt(1, pID);
			ps.setString(2, pName);
			ps.setString(3, pCat);
			ps.setString(4, manufecture_date);
			ps.setString(5, expiry_date);
			ps.setInt(6, price);
			
			int count = ps.executeUpdate();
			if (count > 0) {
				System.out.println("Updated Table!");
			} else {
				System.out.println("Failed to Update Table!");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}

	@Override
	public void findProductById(int pID) {
		try (Connection connection = JDBCUtils.getConnection()){
			PreparedStatement ps = connection.prepareStatement(Find_Product_ID_SQL);
			ps.setInt(1, pID);
			printProduct(ps.executeQuery());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void findProductByCat(String pCat) {
		try (Connection connection = JDBCUtils.getConnection()){
			PreparedStatement ps = connection.prepareStatement(Find_Product_CAT_SQL);
			ps.setString(1, pCat);
			printProduct(ps.executeQuery());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void updateProduct(int pID, String pName, String pCat, String manufecture_date, String expiry_date, int price) {
		
		try (Connection connection = JDBCUtils.getConnection()){
			PreparedStatement ps = connection.prepareStatement(Update_EMPLOYESS_SQL);
			ps.setString(1, pName);
			ps.setString(2, pCat);
			ps.setString(3, manufecture_date);
			ps.setString(4, expiry_date);
			ps.setInt(5, price);
			
			ps.setInt(6, pID);
			
			
			int count = ps.executeUpdate();
			
			if (count > 0) {
				System.out.println("New record Updated successfully");
			} else {
				System.out.println("Failed Updated");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteProductById(int pID) {
		try (Connection connection = JDBCUtils.getConnection()){
			PreparedStatement ps = connection.prepareStatement(Delete_Product_ID_SQL);
			ps.setInt(1, pID);
			int count = ps.executeUpdate();
			
			if (count > 0) {
				System.out.println("New record Updated successfully");
			} else {
				System.out.println("Failed Updated");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteProductByCat(String pCat) {
		try (Connection connection = JDBCUtils.getConnection()){
			PreparedStatement ps = connection.prepareStatement(Delete_Product_CAT_SQL);
			ps.setString(1, pCat);
			int count = ps.executeUpdate();
			
			if (count > 0) {
				System.out.println("New record Updated successfully");
			} else {
				System.out.println("Failed Updated");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void findExpiredProducts() {
		try (Connection connection = JDBCUtils.getConnection()){
			PreparedStatement ps = connection.prepareStatement(Find_Product_EXPIRY_SQL);
			ps.setString(1, LocalDate.now().toString() );
			printProduct(ps.executeQuery());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void findCheapestProductInCat(String pCat) {
		try (Connection connection = JDBCUtils.getConnection()){
			PreparedStatement ps = connection.prepareStatement(Find_Product_CHEAPEST_CAT_SQL);
			ps.setString(1, pCat );
			printProduct(ps.executeQuery());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
		
	private void printProduct(ResultSet rs ) throws SQLException {
		if (rs == null ) {
			System.out.println("Not Found");
		} else {
			while (rs.next()) {
				System.out.println("Product id is: " + rs.getInt("pID")
									+ "\nProduct name is: " + rs.getString("pName") 
									+ "\nProduct category is: " + rs.getString("category") 
									+ "\nManufecture Date is: " + rs.getString("manufecture_date")
									+ "\nExpiry Date is: " + rs.getString("expiry_date")
									+ "\nProduct price  is: " + rs.getInt("price"));
			}
		}
	}
}
