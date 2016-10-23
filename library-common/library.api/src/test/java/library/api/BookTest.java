package library.api;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BookTest {

    @Test
    public void testToString() {
        Book book = new Book("Shakespeare, W.", "Hamlet");
        assertEquals("Shakespeare, W. - Hamlet", book.toString());
    }

    @Test
    public void testCompareEqual() {
        Book book1 = new Book("Shakespeare, W.", "Hamlet");
        Book book2 = new Book("Shakespeare, W.", "Hamlet");
        assertEquals(0, book1.compareTo(book2));
        assertEquals(0, book2.compareTo(book1));
    }

    @Test
    public void testCompareEqualAuthor() {
        Book book1 = new Book("Shakespeare, W.", "Hamlet");
        Book book2 = new Book("Shakespeare, W.", "Romeo And Juliet");
        assertThat(book1.compareTo(book2), lessThan(0));
        assertThat(book2.compareTo(book1), greaterThan(0));
    }

    @Test
    public void testCompareDifferent() {
        Book book1 = new Book("Darwin, C.", "Origin of Species");
        Book book2 = new Book("Shakespeare, W.", "Romeo And Juliet");
        assertThat(book1.compareTo(book2), lessThan(0));
        assertThat(book2.compareTo(book1), greaterThan(0));
    }

}
