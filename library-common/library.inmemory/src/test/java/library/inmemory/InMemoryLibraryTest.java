package library.inmemory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import library.api.Book;

public class InMemoryLibraryTest {

    private List<Book> books;
    private InMemoryLibrary library;

    @Before
    public void before() {
        this.books = Arrays.asList(
                Book.of("Shakespeare, W.", "Hamlet"),
                Book.of("Shakespeare, W.", "Romeo And Juliet"),
                Book.of("Darwin, C.", "Origin of Species"));

        this.library = new InMemoryLibrary();
        for (Book book : this.books) {
            this.library.addBook(book);
        }
    }

    @Test
    public void testGetBooks() {
        assertThat(this.library.getBooks(), containsInAnyOrder(this.books.toArray()));
    }

    @Test
    public void testGetAuthorInitals() {
        assertThat(this.library.getAuthorInitials(), contains("CD", "WS"));
    }

}
