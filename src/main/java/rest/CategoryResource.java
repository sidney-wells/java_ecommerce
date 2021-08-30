package rest;

import data.entity.Category;
import data.service.CategoryService;
import jakarta.ejb.Stateless;
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

@Path("/categories")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Stateless
public class CategoryResource {

  @Inject
  CategoryService categoryService;

  @Path("new")
  @POST
  public Response createCategory(Category category) throws SQLException {
    categoryService.createCategory(category);
    return Response.ok(category).build();
  }

  @GET
  @Path("{id}")
  public Category getCategoryById(@PathParam("id") Long id) throws SQLException {
    return categoryService.findCategoryById(id);
  }

  @GET
  @Path("list")
  public List<Category> getCategories() throws SQLException {
    return categoryService.getAllCategories();
  }


  @PUT
  @Path("update")
  public Category updateCategory(Category category) throws SQLException {
    return categoryService.updateCategory(category);
  }

  @DELETE
  @Path("delete/{id}")
  public Response deleteCategory(@PathParam("id") Long id) throws SQLException {
    categoryService.deleteCategory(id);
    return Response.ok().build();
  }
}
