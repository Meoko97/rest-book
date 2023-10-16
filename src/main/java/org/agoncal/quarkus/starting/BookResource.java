package org.agoncal.quarkus.starting;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import org.agoncal.quarkus.starting.model.Book;

@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    private List<Book> listOfBooks = List.of(
        new Book(1, "Understanding Quarkus", "Antonio", 2020, "IT"),
        new Book(2, "Practising Quarkus", "Antonio", 2020, "IT"),
        new Book(3, "Effective Java", "Josh Bloch", 2001, "IT"),
        new Book(4, "Thinking in Java", "Bruce Eckel", 1998, "IT")
    );

    @GET
    public List<Book> getAllBooks() {
        return listOfBooks;
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public int countAllBooks() {
        return listOfBooks.size();
    }


}
