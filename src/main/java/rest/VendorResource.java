package rest;

import data.entity.Vendor;
import data.service.VendorService;
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

@Path("/vendors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VendorResource {

  @Inject
  VendorService vendorService;

  @Path("new")
  @POST
  public Response createVendor(Vendor vendor) throws SQLException {
    vendorService.createVendor(vendor);
    return Response.ok(vendor).build();
  }

  @GET
  @Path("list")
  public List<Vendor> getVendors() throws SQLException {
    return vendorService.getAllVendors();
  }

  @GET
  @Path("{id}")
  public Vendor getVendorById(@PathParam("id") Long id) throws SQLException {
    return vendorService.findVendorById(id);
  }

  @PUT
  @Path("update")
  public Vendor updateVendor(Vendor vendor) throws SQLException {
    return vendorService.updateVendor(vendor);
  }

  @DELETE
  @Path("delete/{id}")
  public Response deleteVendor(@PathParam("id") Long id) throws SQLException {
    vendorService.deleteVendor(id);
    return Response.ok().build();
  }
}
