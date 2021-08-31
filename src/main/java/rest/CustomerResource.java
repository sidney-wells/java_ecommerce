package rest;

import data.entity.Customer;
import data.service.CustomerService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {

  @Inject
  CustomerService customerService;

  @Path("new")
  @POST
  public Response createCustomer(Customer customer) throws SQLException {
    customerService.createCustomer(customer);
    return Response.ok(customer).build();
  }

  @GET
  @Path("{id}")
  public Customer getCustomerById(@PathParam("id") Long id) throws SQLException {
    return customerService.findCustomerById(id);
  }

  @GET
  @Path("list")
  public List<Customer> getCustomers() throws SQLException {
    return customerService.getAllCustomers();
  }


  @PUT
  @Path("update")
  public Customer updateCustomer(Customer customer) throws SQLException {
    return customerService.updateCustomer(customer);
  }

  @DELETE
  @Path("delete/{id}")
  public Response deleteCustomer(@PathParam("id") Long id) throws SQLException {
    customerService.deleteCustomer(id);
    return Response.ok().build();
  }
}
