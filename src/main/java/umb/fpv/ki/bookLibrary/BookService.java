package umb.fpv.ki.bookLibrary;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private final List<Book> books = new ArrayList();
    private BookService bookService;
    private BookRepository bookRepository;

    public BookService(BookService bookService, BookRepository bookRepository) {
        this.bookService = bookService;
        this.bookRepository = bookRepository;
    }

    public List<Book> listBooks() {
        return books;
    }

    public Book addBook(long id, String name, String isbn, String authorFirstName, String authorLastName, int bookCount) {
        Book book = new Book();
        book.id = id;
        book.name = name;
        book.isbn = isbn;
        book.authorFirstname = authorFirstName;
        book.authorLastname = authorLastName;
        book.bookCount = bookCount;
        return book;
    }

    public Book getBookById(long bookId) {
        Book bo = new Book();
        Book book = bookService.getBookById(bo.id);
        return bo;
    }

    public Book updateBookById(long bookId, Book book) {
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

    public void deleteBookById(long bookId) {
        books.removeIf(book -> book.id == bookId);
    }
}
