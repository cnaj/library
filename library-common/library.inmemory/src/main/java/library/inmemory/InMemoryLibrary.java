package library.inmemory;

import java.util.Collection;
import java.util.NavigableSet;
import java.util.Spliterator;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.apache.commons.lang3.text.WordUtils;

import library.api.Book;
import library.api.Library;
import library.util.LibraryUtils;

public class InMemoryLibrary implements Library {

    private NavigableSet<Book> books = new ConcurrentSkipListSet<>();

    @Override
    public Spliterator<Book> getBooksSpliterator() {
        return this.books.spliterator();
    }

    public void addBook(Book book) {
        this.books.add(book);
        System.out.println("Added " + LibraryUtils.prettyPrintBook(book) + " to library.");
    }

    public Collection<String> getAuthorInitials() {
        return StreamSupport.stream(getBooksSpliterator(), false)
                .map(b -> b.getAuthor())
                .map(this::getCommonName)
                .map(a -> WordUtils.initials(a))
                .sorted()
                .collect(Collectors.toSet());
    }

    private String getCommonName(String name) {
        String[] parts = name.split(", ", 2);
        if (parts.length == 2) {
            return parts[1] + " " + parts[0];
        }
        return parts[0];
    }

}
