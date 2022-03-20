package umb.fpv.ki.bookLibrary;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final List<Book> books = new ArrayList();

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> listBooks() {
        return bookRepository.findAll();
    }

    public Book addBook(String name, String isbn, String authorFirstName, String authorLastName, int bookCount) {
        Book book = new Book();
        book.name = name;
        book.isbn = isbn;
        book.authorFirstname = authorFirstName;
        book.authorLastname = authorLastName;
        book.bookCount = bookCount;
        return bookRepository.save(book);
    }

    public Book getBookById(long bookId) {
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        return optionalBook.orElse(null);
    }

    public Book updateBookById(long bookId, Book book) {
        Book b = this.getBookById(bookId);
        if(b != null) {
            b.name = book.name;
            b.isbn = book.isbn;
            b.authorFirstname = book.authorFirstname;
            b.authorLastname = book.authorLastname;
            b.bookCount = book.bookCount;
            return bookRepository.save(b);
        }
        return null;
    }

    public void deleteBookById(long bookId) {
        bookRepository.deleteById(bookId);
    }
}
