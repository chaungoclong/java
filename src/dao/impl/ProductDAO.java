package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Product;
import connection.Connector;
import dao.IProductDAO;

public class ProductDAO implements IProductDAO {

	@Override
	public List<Product> getAll() {
		List<Product> results = new ArrayList<Product>();
		
		try (Connection conn = Connector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM products")) {
			
				try (ResultSet resultSet = pstmt.executeQuery()) {
					while (resultSet.next()) {
						Product product = new Product();
						
						product.setId(resultSet.getInt("id"));
						product.setName(resultSet.getString("name"));
						product.setPrice(resultSet.getInt("price"));
						product.setAmount(resultSet.getInt("amount"));
						
						results.add(product);
					}
				}
		} catch (Exception e) {
			return null;
		}

		return results;
	}
	
	public static void main(String[] args) {
		ProductDAO dao = new ProductDAO();
		
		List<Product> list = dao.getAll();
		
		for (Product product : list) {
			System.out.println(product);
		}
	}

}
