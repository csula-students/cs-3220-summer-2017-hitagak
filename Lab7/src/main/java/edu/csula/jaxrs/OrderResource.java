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

import edu.csula.jaxrs.models.Order;
import edu.csula.jaxrs.dao.OrderDAO;

@Path("")
public class OrderResource {
    OrderDAO dao = new OrderDAO();

//return a list of orders in the database
    @GET
    @Path("orders")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Order> getOrders() {
        return dao.list();
    }

    
//return a single order given by id
    @GET
    @Path("order/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Order getOrder(@PathParam("id") int id) {
        return dao.get(id).get();
    }

// Create a new order and add it in database
    @POST
    @Path("orders")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
  
   public boolean addOrder(Order order) {
        dao.add(order);
        return true;
    }

// update a certain order given its id
    @PUT
    @Path("order/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean update(Order order, @PathParam("id") int id) {
        if (id == order.getId()) {
            dao.update(order);
            return true;
        } else {
            return false;
        }
    }

// delete food item given by ID
	@DELETE
    @Path("order/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean delete(@PathParam("id") int id) {
        dao.delete(id);
        return true;
    }


}
