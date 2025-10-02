package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.User;

public class UserDAO {
	public boolean registerUser(User user)
	{
		String sql = "INSERT INTO users(name,age, email, password,phone, role) VALUES(?, ?, ?, ?,?,?)";
		try (Connection con = DBConnection.getConnection();
	             PreparedStatement ps = con.prepareStatement(sql)) {
	            ps.setString(1, user.getName());
	            ps.setInt(2, user.getAge());
	            ps.setString(3, user.getEmail());
	            
	            ps.setString(4, user.getPassword());
	            ps.setString(5, user.getPhone());
	            ps.setString(6, user.getRole());
	            return ps.executeUpdate() > 0;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		return false;
	}
}
