package umb.fpv.ki.bookLibrary;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final List<Book> books = new ArrayList<>();

    public List<Book> getBook(String name){
        return books.stream().filter(book -> book.name.contains(name)).collect(Collectors.toList());
    }
    public Book addBook(Book book){
        books.add(book);
        return book;
    }
    public Book getBookById(long bookId){
        return books.stream().filter(book -> book.id == bookId).findFirst().get();
    }
    public Book updateBookById(long bookId, Book book){
        for(Book b: books){
            if(b.id == bookId){
                b.id = book.id;
                b.name = book.name;
                b.isbn = book.isbn;
                b.authorFirstname = book.authorFirstname;
                b.authorLastname = book.authorLastname;
                b.bookCount = book.bookCount;
            }
        }
        return book;
    }
    public void deleteBookById(long bookId){
        books.removeIf(book -> book.id == bookId);
    }
}
