package edu.csula.jaxrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import edu.csula.jaxrs.models.Order;

public class OrderDAO implements DAO<Order> {
	public List<Order> list() {
		List<Order> list_order = new ArrayList<>();
		Database db = new Database();
		try (Connection c = db.connection()) {
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM orders_lab7");
			while (rs.next()) {
				list_order.add(new Order(rs.getInt("id"), rs.getString("food_name"), rs.getString("food_url"),
						rs.getDouble("food_price"), rs.getString("customer"), rs.getString("status")));

			}
		} catch (SQLException e) {
			e.printStackTrace();
			return list_order;
		}
		return list_order;
	}

	public Optional<Order> get(int id) {
		Optional<Order> upreturn = Optional.empty();
		Database db = new Database();

		try (Connection c = db.connection()) {
			PreparedStatement pstmt = c.prepareStatement("SELECT * FROM orders_lab7 WHERE orders_lab7.id = ? ");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				Order updatedorder = new Order(rs.getInt("id"), rs.getString("food_name"), rs.getString("food_url"),
						rs.getDouble("food_price"), rs.getString("customer"), rs.getString("status"));
				upreturn = Optional.of(updatedorder);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return upreturn;

	}

	public void add(Order entry) {
		Database db = new Database();
		try (Connection c = db.connection()) {
			PreparedStatement pstmt = c.prepareStatement(
					"INSERT INTO orders_lab7 (food_name, food_url,food_price,customer,status) VALUES (?,?,?,?,?)");
			pstmt.setString(1, entry.getFood_name());
			pstmt.setString(2, entry.getFood_url());
			pstmt.setDouble(3, entry.getFood_price());
			pstmt.setString(4, entry.getCustomer());
			pstmt.setString(5, entry.getStatus());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Order entry) {
		Database db = new Database();
		try (Connection c = db.connection()) {
			PreparedStatement pstmt = c.prepareStatement(
					"UPDATE orders_lab7 SET  food_name = ?, food_url = ?, food_price = ?, customer = ?, status = ? WHERE id = ?");
			pstmt.setString(1, entry.getFood_name());
			pstmt.setString(2, entry.getFood_url());
			pstmt.setDouble(3, entry.getFood_price());
			pstmt.setString(4, entry.getCustomer());
			pstmt.setString(5, entry.getStatus());
		
			pstmt.setInt(6, entry.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void delete(int id) {
		Database db = new Database();
		try (Connection c = db.connection()) {
			PreparedStatement pstmt = c.prepareStatement("DELETE FROM orders_lab7 WHERE orders_lab7.id = ? ");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
