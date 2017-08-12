package edu.csula.jaxrs;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.inject.Singleton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.csula.jaxrs.models.FoodItemEntry;
import edu.csula.jaxrs.dao.FoodItemDAO;

@Path("")
@Singleton
public class FoodResource {

	FoodItemDAO dao = new FoodItemDAO();

// return a list of food_items
	@GET
	@Path("fooditems")
	@Produces(MediaType.APPLICATION_JSON)
	public List<FoodItemEntry> getMenu() {
		return dao.list();
	}
// return a single food items given by id

	@GET
    @Path("fooditem/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public FoodItemEntry getFoodItem(@PathParam("id") int id) {
        return dao.get(id).get();
    }

// create a new food item and add in database
	@POST
    @Path("fooditems")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean addFoodItem(FoodItemEntry food) {
        dao.add(food);
        System.out.println(dao.list());
        return true;
    }

//update a certain food item
	@PUT
    @Path("fooditem/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean updateFoodItem(FoodItemEntry food, @PathParam("id") int id) {
        if (id == food.getId()) {
            dao.update(food);
            return true;
        } else {
            return false;
        }
    }

// delete food item given by ID
	@DELETE
    @Path("fooditem/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean delete(@PathParam("id") int id) {
        dao.delete(id);
        System.out.println(dao.list());
        return true;
    }

}
