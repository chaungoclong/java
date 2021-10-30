package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.User;
import connection.Connector;
import dao.IUserDAO;

public class UserDAO implements IUserDAO {

	@Override
	public User login(String email, String password) {
		User user = null;

		try (Connection conn = Connector.getConnection();
				PreparedStatement pstmt = conn
						.prepareStatement("SELECT * FROM users WHERE email = ? AND password = ?");) {

			System.out.println("conn:" + conn);

			pstmt.setString(1, email);
			pstmt.setString(2, password);

			try (ResultSet resultSet = pstmt.executeQuery()) {
				if (resultSet.next()) {
					user = new User();

					user.setId(resultSet.getInt("id"));
					user.setUsername(resultSet.getString("username"));
					user.setEmail(resultSet.getString("email"));
					user.setPassword(resultSet.getString("password"));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return user;
	}

	public static void main(String[] args) {
		UserDAO dao = new UserDAO();

		User user = dao.login("demo@gmail.com", "111");

		System.out.println(user);
	}

}
