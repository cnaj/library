package library.api;

public final class Book implements Comparable<Book> {

    public static Book of(String author, String title) {
        return new Book(author, title);
    }

    private final String author;
    private final String title;

    public Book(String author, String title) {
        if (author == null) {
            throw new IllegalArgumentException("author is null");
        }
        if (title == null) {
            throw new IllegalArgumentException("title is null");
        }

        this.author = author;
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getTitle() {
        return this.title;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", this.author, this.title);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.author.hashCode();
        result = prime * result + this.title.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Book)) {
            return false;
        }
        Book other = (Book) obj;
        if (!this.author.equals(other.author)) {
            return false;
        }
        if (!this.title.equals(other.title)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Book other) {
        int result;
        result = this.author.compareTo(other.author);
        if (result != 0) {
            return result;
        }
        result = this.title.compareTo(other.title);
        return result;
    }

}
