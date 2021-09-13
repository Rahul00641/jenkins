package org.acme.service;

import org.acme.Model.Book;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/user")
@RegisterRestClient
public interface BookClient {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getall();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Book getbook(@PathParam("id")Integer id);

}
