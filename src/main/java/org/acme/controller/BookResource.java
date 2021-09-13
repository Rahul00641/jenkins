package org.acme.controller;

import org.acme.Model.Book;
import org.acme.service.BookClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/book")
public class BookResource {

    @Inject
    @RestClient
    BookClient bookClient;

    @GET
    @Path("/getall")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getall(){
        return bookClient.getall();
    }

}
