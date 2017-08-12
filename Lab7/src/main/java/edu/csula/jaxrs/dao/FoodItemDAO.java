package edu.csula.jaxrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import edu.csula.jaxrs.models.FoodItemEntry;

public class FoodItemDAO implements DAO<FoodItemEntry> {
	public List<FoodItemEntry> list() {
		List<FoodItemEntry> list = new ArrayList<>();
		Database db = new Database();
		try (Connection c = db.connection()) {
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM food_items_lab7");
			while (rs.next()) {
				list.add(new FoodItemEntry(rs.getInt("id"), rs.getString("food_name"), rs.getString("food_description"),
						rs.getString("food_url"), rs.getDouble("food_price")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return list;
		}
		return list;
	}

	public Optional<FoodItemEntry> get(int id) {
		Optional<FoodItemEntry> upreturn = Optional.empty();
		Database db = new Database();

		try (Connection c = db.connection()) {
			PreparedStatement pstmt = c.prepareStatement("SELECT * FROM food_items_lab7 WHERE food_items_lab7.id = ? ");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				FoodItemEntry updatedFood = new FoodItemEntry(rs.getInt("id"), rs.getString("food_name"),
						rs.getString("food_description"), rs.getString("food_url"), rs.getDouble("food_price"));
				upreturn = Optional.of(updatedFood);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return upreturn;

	}

	public void add(FoodItemEntry entry) {
		Database db = new Database();
		try (Connection c = db.connection()) {
			PreparedStatement pstmt = c.prepareStatement(
					"INSERT INTO food_items_lab7 (food_name, food_description,food_url,food_price) VALUES (?,?,?,?)");
			pstmt.setString(1, entry.getName());
			pstmt.setString(2, entry.getDescription());
			pstmt.setString(3, entry.getUrl());
			pstmt.setDouble(4, entry.getPrice());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(FoodItemEntry entry) {
		Database db = new Database();
		try (Connection c = db.connection()) {
			PreparedStatement pstmt = c.prepareStatement(
					"UPDATE food_items_lab7 SET  food_name = ?, food_description = ?, food_url = ?, food_price = ? WHERE food_items_lab7.id = ?");
			pstmt.setString(1, entry.getName());
			pstmt.setString(2, entry.getDescription());
			pstmt.setString(3, entry.getUrl());
			pstmt.setDouble(4, entry.getPrice());	
			pstmt.setInt(5, entry.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void delete(int id) {
		Database db = new Database();
		try (Connection c = db.connection()) {
			PreparedStatement pstmt = c.prepareStatement("DELETE FROM food_items_lab7 WHERE food_items_lab7.id = ? ");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
