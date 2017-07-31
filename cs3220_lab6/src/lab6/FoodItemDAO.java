package lab6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dao.DAO;
import dao.Database;

public class FoodItemDAO implements DAO<FoodItemEntry> {
	public List<FoodItemEntry> list() {
		List<FoodItemEntry> list = new ArrayList<>();
		Database db = new Database();
		try (Connection c = db.connection()) {
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM food_items");
			while (rs.next()) {
				list.add(new FoodItemEntry(rs.getInt("id"), rs.getString("food_name"), rs.getString("food_description"),
						rs.getString("food_url"), rs.getDouble("food_price"), rs.getString("created")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return list;
		}
		return list;
	}

	public Optional<FoodItemEntry> get(int id) {
		Optional<FoodItemEntry> upreturn = Optional.empty();

		return upreturn;

	}

	public void add(FoodItemEntry entry) {
		Database db = new Database();
		try (Connection c = db.connection()) {
			PreparedStatement pstmt = c.prepareStatement(
					"INSERT INTO food_items (food_name, food_description,food_url,food_price,created) VALUES (?,?,?,?,?)");
			pstmt.setString(1, entry.getName());
			pstmt.setString(2, entry.getDescription());
			pstmt.setString(3, entry.getUrl());
			pstmt.setDouble(4, entry.getPrice());
			pstmt.setString(5, entry.getDate());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(FoodItemEntry entry) {

	}

	public void delete(int id) {
		Database db = new Database();
		try (Connection c = db.connection()) {
			PreparedStatement pstmt = c.prepareStatement("DELETE FROM food_items WHERE food_items.id = ? ");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
