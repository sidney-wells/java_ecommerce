package com.ecommerce_web.ecommerce_web;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("/hello-world")
public class HelloResource {

  @GET
  @Produces("text/plain")
  public String hello() {
    return "Hello, World!";
  }

  @Path("{name}")
  public Response sayHello(@PathParam("name") String name) {
    String greeting = "Hello " + name;
    return Response.ok(greeting).build();
  }
}