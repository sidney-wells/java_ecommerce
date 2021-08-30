package rest;

import data.service.ProductService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import data.entity.Product;
import java.sql.SQLException;
import java.util.List;

@Path("products")
@Produces("application/json")
@Consumes("application/json")
public class ProductResource {

  @Inject
  ProductService productService;

  @GET
  @Path("list")
  public List<Product> getProducts() throws SQLException {
    return productService.getProducts();
  }

  @GET
  @Path("{id}")
  public Product findProductById(@PathParam("id") Long id) throws SQLException {
    return productService.findProductById(id);
  }

  @POST
  @Path("new")
  public Response createProduct(Product product) throws SQLException {
    productService.createProduct(product);
    return Response.ok(product).build();
  }

  @PUT
  @Path("update")
  public Product updateProduct(Product product) throws SQLException {
    return productService.updateProduct(product);
  }

  @DELETE
  @Path("delete/{id}")
  public Response deleteProduct(@PathParam("id") Long id) throws SQLException {
    productService.deleteProduct(id);
    return Response.ok().build();
  }
}
