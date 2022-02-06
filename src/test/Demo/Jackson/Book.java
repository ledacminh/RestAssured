package Jackson;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {
    @JsonProperty("book name")
    private String bookName;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @JsonProperty("author Name")
    private String authorName;
}
