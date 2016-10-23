package library.api;

import java.util.Collection;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public interface Library {

    Spliterator<Book> getBooksSpliterator();

    default Collection<Book> getBooks() {
        return StreamSupport.stream(getBooksSpliterator(), false)
                .collect(Collectors.toList());
    }

}
