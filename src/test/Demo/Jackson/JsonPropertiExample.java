package Jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonPropertiExample {
    public static void main(String[] args) throws JsonProcessingException {
        Book book = new Book();
        book.setBookName("Data Structre");
        book.setAuthorName("LeeMinh");
        ObjectMapper objectMapper = new ObjectMapper();
        String bookJsonObject = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(book);
        System.out.println(bookJsonObject);

    }
}
