package library.util;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import library.api.Book;

public final class LibraryUtils {

    private LibraryUtils() {
    }

    public static String prettyPrintBook(Book book) {
        return String.format("\"%s\" by %s", book.getTitle(), book.getAuthor());
    }

    public static Book getTopPick() {
        // this is just here to pull in some dependency for bnd to pick up
        @SuppressWarnings("unused")
        Client client = ClientBuilder.newClient();

        return Book.of("Tolkien, J.R.R.", "Lord of the Rings");
    }

}
